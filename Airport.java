public class ErrorAssistTranformer {

    public static ArrayList<ErrorAssistTO> transformResultToEntity(ResultSet resultSet)
    {
        ArrayList<ErrorAssistTO> errorAssitTOList = null;

        if (resultSet !=null) {
            errorAssitTOList = new ArrayList<ErrorAssistTO>();
            try {
                while (resultSet.next()) {
                    ErrorAssistTO thisErrorAssistTO = new ErrorAssistTO();
                    thisErrorAssistTO.rowID = Integer.toString(resultSet.getInt("RowID"));
                    thisErrorAssistTO.applicationName = resultSet.getString("Application");
                    thisErrorAssistTO.versions = resultSet.getString("Version");
                    thisErrorAssistTO.errorCode = resultSet.getString("ErrorCode");
                    thisErrorAssistTO.description = resultSet.getString("Description");
                    thisErrorAssistTO.cause = resultSet.getString("Casuse");
                    thisErrorAssistTO.solution = resultSet.getString("Solution");
                    thisErrorAssistTO.otherComments = resultSet.getString("OtherComments");
                    thisErrorAssistTO.source = resultSet.getString("Source");
                    thisErrorAssistTO.lastUpdated = resultSet.getString("LastUpdated");

                    errorAssitTOList.add(thisErrorAssistTO);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return errorAssitTOList;
    }
}

public class ErrorAssistService {
    public static List<ErrorAssistTO> execute(String searchStr) {

        try {
            return searchAndRetrieve(searchStr);
        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
        return null;
    }


    private static List<ErrorAssistTO> searchAndRetrieve(String searchStr)
    {
        List resultList = new ArrayList<String[]>();

        try {

            //Step #1 : Search the key word in the Lucene search documents and get the table row ids
            List<String> rowIDList = LuceneSearchService.performSearch(searchStr);
            //String dbUrl = DBManager.getDatabaseUrl();

            //Step #2 : Use the above result row ids and pull the complete record
            ResultSet resultSet = DBManager.createConAndExecuteQuery(rowIDList);

            //Step #3 : Transform the search result to application entity list
            ArrayList<ErrorAssistTO> errorAssitTOList = ErrorAssistTranformer.transformResultToEntity(resultSet);

        }
        catch(Exception e)
        {
            resultList = null;
        }
        return resultList;
    }
}

public class ErrorAssistTO 
{
     public String rowID = null;
     public String applicationName = null;
     public String versions = null;
     public String errorCode = null;
     public String description = null;
     public String cause = null;
     public String solution = null;
     public String otherComments = null;
     public String source = null;
     public String lastUpdated = null;

     public void reset()
     {
         this.applicationName = "";
         this.versions = "";
         this.errorCode = "";
         this.description = "";
         this.cause = "";
         this.solution = "";
         this.otherComments = "";
         this.source = "";
         this.lastUpdated = "";
     }
}

public class AppConstants {

    public static final String APPLICATION_TITLE = "Guidewire Error Assist";

    public static final String DB_NAME = "gw_error_assist.db";
    public static final String JDBC_URL = "jdbc:sqlite::resource:gw_error_assist.db";
}

public class LuceneSearchUtil {

    private static final String DB_URL = "jdbc:sqlite:D:/MyWorks/IdeaWS/GWErrorAssist/res/gw_error_assist.db";
    private static final String INDEX_DIR = "D:/MyWorks/IdeaWS/GWErrorAssist/res/";
    private static final String SEARCH_SQL = "SELECT * FROM project";

    private static final String INDEX_FIELD_NAME = "content";
    private static final int MAX_RESULTS = 10;

    private Directory index;
    private IndexWriter indexWriter;

    public LuceneSearchUtil() throws IOException {
        Path indexPath = FileSystems.getDefault().getPath(INDEX_DIR);
        index = FSDirectory.open(indexPath);

        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
        config.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);

        indexWriter = new IndexWriter(index, config);
    }

    public void addDocument(int id, String content) throws IOException {
        Document document = new Document();
        document.add(new TextField("id", String.valueOf(id), Field.Store.YES));
        document.add(new TextField(INDEX_FIELD_NAME, content, Field.Store.YES));
        indexWriter.addDocument(document);
    }

    public List<String> search(String queryString) throws Exception {
        List<String> results = new ArrayList<>();
        QueryParser parser = new QueryParser(INDEX_FIELD_NAME, new StandardAnalyzer());
        Query query = parser.parse(queryString);

        IndexReader indexReader = DirectoryReader.open(index);
        IndexSearcher searcher = new IndexSearcher(indexReader);

        TopDocs topDocs = searcher.search(query, MAX_RESULTS);

        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            Document doc = searcher.doc(scoreDoc.doc);
            results.add(doc.get(INDEX_FIELD_NAME));
        }
        return results;
    }

    public void close() throws IOException {
        indexWriter.close();
    }

    public static void main(String[] args) throws Exception {
        LuceneSearchUtil luceneSearch = new LuceneSearchUtil();

        // Establishing connection to SQLite database
        //String url = "jdbc:sqlite:/path/to/your/database.db";
        Connection conn = DriverManager.getConnection(DB_URL);

        // Creating Lucene index from SQLite database
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SEARCH_SQL)) {
            while (rs.next()) {
                luceneSearch.addDocument(rs.getInt("id"),rs.getString("Description"));
            }
        }

        // Committing changes to the Lucene index
        luceneSearch.indexWriter.commit();

        // Searching Lucene index
        List<String> searchResults = luceneSearch.search("TEST search query");

        // Displaying search results
        for (String result : searchResults) {
            System.out.println(result);
        }

        // Closing resources
        luceneSearch.close();
        conn.close();
    }
}




import com.cognizant.bluebolt.gw.errorassist.entity.ErrorAssistTO;
import com.cognizant.bluebolt.gw.errorassist.service.ErrorAssistService;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ErrorAssistApplication extends Application {
    TableView<LabelValuePair> resultsTableView = null;

    ListView<String> resultListView = new ListView<>();
    Label resultLabel = new Label("Output Result");
    Label noResultLabel = new Label("No results found for the given query.");
    VBox resultLayout = new VBox(10);
    private final Map<String, ErrorDetails> errorDetailMap = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {


        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Application heading
        Label headingLabel = new Label("Guidewire Error Assist");
        headingLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        GridPane.setConstraints(headingLabel, 0, 0,3,1);
        GridPane.setColumnSpan(headingLabel, Integer.valueOf(3));
        GridPane.setHalignment(headingLabel, HPos.CENTER);
        gridPane.getChildren().add(headingLabel);

        // Add a new horizontal separator below the title
        Separator separator = new Separator();
        gridPane.add(separator, 0, 1, 3, 1);

        // Search Label, TextField and Submit Button
        Label searchLabel = new Label("Enter error message ");
        TextField searchField = new TextField();
        searchField.setPromptText("Enter search text");

        Button submitButton = new Button("Submit");
        GridPane.setHalignment(submitButton, HPos.RIGHT);
        Button clearButton = new Button("Clear");
        GridPane.setHalignment(clearButton, HPos.CENTER);

        gridPane.add(searchLabel, 0, 2);
        gridPane.add(searchField, 1, 2);
        gridPane.add(submitButton, 1, 3,2,1);
        gridPane.add(clearButton, 1, 3);

        GridPane.setMargin(searchLabel, new Insets(0, 10, 0, 50)); // Add left-side margin to search label
        gridPane.setPadding(new Insets(20, 20, 20, 20)); // 20 pixels left and right margins



        resultsTableView = new TableView<>();
        TableColumn<LabelValuePair, String> labelColumn = new TableColumn<>("Label");
        labelColumn.setCellValueFactory(new PropertyValueFactory<>("label"));
        TableColumn<LabelValuePair, String> valueColumn = new TableColumn<>("Value");
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        resultsTableView.getColumns().addAll(labelColumn, valueColumn);

        resultsTableView.setFixedCellSize(25);

        gridPane.add(resultsTableView, 0, 4, 3, 1);
        GridPane.setHalignment(resultsTableView, HPos.CENTER); // Center-align the TableView

        resultLayout.getChildren().add(resultLabel);
        resultLayout.getChildren().add(resultListView);
        resultLayout.getChildren().add(noResultLabel);
        noResultLabel.setVisible(false);

        // Set left and right margins for the GridPane
       // gridPane.setPadding(new Insets(0, 20, 0, 20));

        gridPane.add(resultLayout, 0, 5, 3, 1);
        Scene scene = new Scene(gridPane, 600, 400);

        primaryStage.setTitle(AppConstants.APPLICATION_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();

        submitButton.setOnAction(e -> {
            try {
                String query = searchField.getText();
                String[] searchResults = performSearch(query);

                if (searchResults != null && searchResults.length > 0) {
                    displaySearchResults(query, searchResults);
                } else {
                    displaySearchResultsNotFound(query);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        clearButton.setOnAction(e -> {
            try {
                searchField.clear();
                resultListView.getItems().clear();
                resultLabel.setText("Output Result");
                noResultLabel.setVisible(false);
                resultsTableView.getItems().clear();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });



    }

    private void setupTableView(List<ErrorAssistTO> resultList)
    {
        if(resultList != null && resultList.size() > 0) {
            //For now take only the first row
            ErrorAssistTO errorAssistTO = resultList.get(0);
            if (errorAssistTO != null) {
                LabelValuePair lvp1 = new LabelValuePair("Application", errorAssistTO.applicationName);
                LabelValuePair lvp2 = new LabelValuePair("Applies To", errorAssistTO.versions);
                LabelValuePair lvp3 = new LabelValuePair("Error Code", errorAssistTO.errorCode);
                LabelValuePair lvp4 = new LabelValuePair("Description", errorAssistTO.description);
                LabelValuePair lvp5 = new LabelValuePair("Cause", errorAssistTO.cause);
                LabelValuePair lvp6 = new LabelValuePair("Solution", errorAssistTO.solution);
                LabelValuePair lvp7 = new LabelValuePair("Other Comments", errorAssistTO.otherComments);
                LabelValuePair lvp8 = new LabelValuePair("Source", errorAssistTO.source);
                LabelValuePair lvp9 = new LabelValuePair("Last Updated", errorAssistTO.lastUpdated);
                resultsTableView.getItems().addAll(lvp1, lvp2, lvp3, lvp4, lvp5, lvp6, lvp7, lvp8, lvp9);
            }
        }
        else
        {
            System.out.println("I am here");
            LabelValuePair lvp1 = new LabelValuePair("Application", "TEST_VALUE");
            resultsTableView.getItems().add(lvp1);
        }

    }

    private String[] performSearch(String query) throws SQLException {

        List<String> results = new ArrayList<>();
        errorDetailMap.clear();

        try (Connection conn = DriverManager.getConnection(AppConstants.JDBC_URL);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM project WHERE ExceptionType LIKE ?")) {
            pstmt.setString(1, "%" + query + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String exceptionType = rs.getString("ExceptionType");
                    String description = rs.getString("Description");
                    String possibleSolution = rs.getString("PossibleSolution");
                    String referenceMaterial = rs.getString("ReferenceMaterial");
                    results.add(exceptionType);

                    errorDetailMap.put(exceptionType, new ErrorDetails(description, possibleSolution, referenceMaterial));
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results.toArray(new String[0]);

    }


    public static void main(String[] args) {
        launch(args);
    }

    private void displaySearchResultsNotFound(String query) {
        resultListView.getItems().clear();
        resultLabel.setText("Output Result");
        noResultLabel.setVisible(true);
    }

    private void displaySearchResults(String query, String[] searchResults) {
        resultLabel.setText("Results for: " + query);
        resultListView.getItems().clear();

        for (String result : searchResults) {
            resultListView.getItems().add(result);
        }

        noResultLabel.setVisible(false);
        resultListView.setOnMouseClicked(e -> {
            if (e.getClickCount() == 1) {
                String selectedResults = resultListView.getSelectionModel().getSelectedItem();
                displayResultDetails(selectedResults);
            }
        });
    }

    private void displayResultDetails(String result) {
        ErrorDetails details = errorDetailMap.get(result);

        Label detailLabel = new Label("Description: ");
        TextArea detailTextArea = new TextArea(details.description);
        detailTextArea.setWrapText(true);
        detailTextArea.setEditable(false);

        detailTextArea.setPrefHeight(200);
        detailTextArea.setPrefWidth(400);

        Hyperlink solutionLink = new Hyperlink("Show Possible Solution");
        solutionLink.setOnAction(e -> {
            displayPossibleSolution(result,details.possibleSolution);
        });

        Button backButton = new Button("Back");
        backButton.setOnAction(e->{
            Stage stage=(Stage) backButton.getScene().getWindow();
            stage.close();
        });



        Stage detailStage = new Stage();
        detailStage.setTitle("Result Details");

        VBox detailLayout = new VBox(10);
        detailLayout.setPadding(new Insets(10));
        detailLayout.getChildren().addAll(detailLabel, detailTextArea, solutionLink,backButton);
        //String resultDetails = getresultDetails(result);

        Scene detailScene = new Scene(detailLayout, 400, 400);
        detailStage.setScene(detailScene);
        detailStage.show();
    }


    private void displayPossibleSolution(String result, String possibleSolution) {
        ErrorDetails details = errorDetailMap.get(result);
        Stage solutionStage = new Stage();

        solutionStage.setTitle("Possible Solution: "+ result);

        TextArea solutionTextArea = new TextArea(possibleSolution);

        solutionTextArea.setWrapText(true);
        solutionTextArea.setEditable(false);
        solutionTextArea.setPrefHeight(200);
        solutionTextArea.setPrefWidth(400);

        System.out.println("Display the possible solution: "+ possibleSolution);
        Label referenceLabel = new Label("Reference Material");

        Hyperlink referenceLink = createHyperlink(details.referenceMaterial);

        Button backButton = new Button("Back");
        backButton.setOnAction(e->{
            Stage stage=(Stage) backButton.getScene().getWindow();
            stage.close();
        });



        VBox solutionLayout = new VBox(10);
        solutionLayout.setPadding(new Insets(10));
        solutionLayout.getChildren().addAll(new Label("Possible Solution:"), solutionTextArea, referenceLabel,referenceLink,backButton);

        Scene solutionScene = new Scene(solutionLayout, 400, 300);
        solutionStage.setScene(solutionScene);
        solutionStage.show();
    }


    private Hyperlink createHyperlink(String url){
        // String correctUrl = correctUrl(url);
        Hyperlink link = new Hyperlink(url);
        link.setOnAction(e->{
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI(url.trim()));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }

        });
        return link;
    }



    private static class ErrorDetails {
        String description;
        String possibleSolution;
        String referenceMaterial;

        ErrorDetails(String description, String possibleSolution, String referenceMaterial) {
            this.description = description;
            this.possibleSolution = possibleSolution;
            this.referenceMaterial = referenceMaterial;

        }
    }

    public static class LabelValuePair {
        private final String label;
        private final String value;

        public LabelValuePair(String label, String value) {
            this.label = label;
            this.value = value;
        }

        public String getLabel() {
            return label;
        }

        public String getValue() {
            return value;
        }
    }
}

public class DBManager
{

    private static final String SEARCH_SQL_HQ = "SELECT * FROM Project WHERE id IN (";


    public static ResultSet createConAndExecuteQuery(List<String> rowIDList) throws SQLException {

        Connection connection = DriverManager.getConnection(AppConstants.JDBC_URL);
        System.out.println("DB connection established: " + connection.getClientInfo());

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < rowIDList.size(); i++) {
            sb.append(i == 0 ? "?" : ", ?");
        }
        sb.append(")");
        String thisSearchQuery = SEARCH_SQL_HQ + sb.toString();

        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(thisSearchQuery)) {
            for (int i = 0; i < rowIDList.size(); i++) {
                Integer thisID = Integer.valueOf(rowIDList.get(i));
                statement.setInt(i + 1, thisID);
            }

            resultSet = statement.executeQuery();

        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return resultSet;
    }



    //deprecated
    public static String getDatabaseUrl(){

        String dbUrl = null;

        // Load SQLite database file from resources directory
        String databaseName = AppConstants.DB_NAME;
        InputStream inputStream = DBManager.class.getResourceAsStream("./res/" + databaseName);

        // Retrieve the default Windows temporary directory
        String tempDirPath = System.getProperty("java.io.tmpdir");

        // Create a File object representing the temporary directory
        File tempDir = new File(tempDirPath);

        // Copy the database file to a temporary location
        try {
            File tempFile = File.createTempFile("temp_", "_" + databaseName, tempDir);
            tempFile.deleteOnExit();

            try (OutputStream outputStream = new FileOutputStream(tempFile)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
            }

            // Establish JDBC connection using the copied database file
            String url = "jdbc:sqlite:" + tempFile.getAbsolutePath();

        } catch (Exception e) {
            System.err.println("Error loading database file: " + e.getMessage());
        }

        return dbUrl;
    }

}

public class SqliteUtil {

    static final String DB_URL = "jdbc:sqlite:D:/MyWorks/IdeaWS/GWErrorAssist/res/gw_error_assist.db";

    public static void main(String args[]){
        createNewDatabase();
    }


    public static void createNewDatabase()
    {
        Connection conn = null;
        try {

            String url = null; //Override the url with DB_URL when running to create a new database

            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}

