mport com.sun.rowset.internal.Row;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Cognizant
 * @see
 * @since 12-Mar-24
 **/
public class ErrorAssistApplication extends Application {

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
        Label headingLabel = new Label("Guidewire Error Assist");

        headingLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        GridPane.setConstraints(headingLabel, 0, 0);

        GridPane.setColumnSpan(headingLabel, 3);

        GridPane.setHalignment(headingLabel, HPos.CENTER);
        gridPane.getChildren().add(headingLabel);

        Separator separator = new Separator();
        gridPane.add(separator, 0, 1, 3, 1);


        Label searchLabel = new Label("Enter error message ");
        TextField searchField = new TextField();

        searchField.setPromptText("Enter search text");

        Button submitButton = new Button("Submit");
        GridPane.setHalignment(submitButton, HPos.RIGHT);
        Button clearButton = new Button("Clear");
        GridPane.setHalignment(clearButton, HPos.CENTER);

        gridPane.add(searchLabel, 0, 2);
        gridPane.add(searchField, 1, 2);
        gridPane.add(submitButton, 1, 3, 2, 1);
        gridPane.add(clearButton, 1, 3);
        GridPane.setMargin(searchLabel, new Insets(0, 10, 0, 50)); // Add left-side margin to search label

        gridPane.setPadding(new Insets(0, 20, 0, 20)); // 20 pixels left and right margins
        resultLayout.getChildren().add(resultLabel);
        resultLayout.getChildren().add(resultListView);
        resultLayout.getChildren().add(noResultLabel);
        noResultLabel.setVisible(false);


        gridPane.add(resultLayout, 0, 4, 3, 1);
        Scene scene = new Scene(gridPane, 600, 400);

        primaryStage.setTitle("Guidewire Error Assist");
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
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });


    }

    private String[] performSearch(String query) {
        List<String> results = new ArrayList<>();
        errorDetailMap.clear();

        
        try( FileInputStream fis = new FileInputStream("C:\\Users\\2114779\\IdeaProjects\\JavaP\\Errors1.xlsx")){
          //  Workbook wb = XSSFWorkbook.create(fis);
//Sheet sheet = wb.getSheetAt(0);

            String line;
            boolean isHeader = true;
            while ((line = fis.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] columns = line.split(",", 4);

                if (columns.length >= 4 && columns[0].equalsIgnoreCase(query)) {
                    String exceptionType = columns[0].trim();
                    String description = columns[1].trim();
                    String possibleSolution = columns[2].trim();
                    String referenceMaterial = columns[3].trim();

                    System.out.println("Possible Solution: " + possibleSolution);

                    results.add(exceptionType);
                    errorDetailMap.put(exceptionType, new ErrorDetails(description, possibleSolution, referenceMaterial));

                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println("Searched results: " + results);
        //System.out.println("Error detail : " + errorDetailMap);
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


        Stage detailStage = new Stage();
        detailStage.setTitle("Result Details");

        VBox detailLayout = new VBox(10);
        detailLayout.setPadding(new Insets(10));
        detailLayout.getChildren().addAll(detailLabel, detailTextArea, solutionLink);
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
        Hyperlink referenceLink = new Hyperlink(details.referenceMaterial);

        try {
            URI uri = new URI(details.referenceMaterial);
            referenceLink.setOnAction(e -> {
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(uri);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }catch (URISyntaxException e){
            referenceLink.setText("Invalid URL");
            referenceLink.setOnAction(null);
        }

        VBox solutionLayout = new VBox(10);
        solutionLayout.setPadding(new Insets(10));
        solutionLayout.getChildren().addAll(new Label("Possible Solution:"), solutionTextArea, referenceLabel,referenceLink);

        Scene solutionScene = new Scene(solutionLayout, 400, 300);
        solutionStage.setScene(solutionScene);
        solutionStage.show();
    }

    private static class ErrorDetails {
        String description;
        String possibleSolution;
        String referenceMaterial;
       // String exceptionType;

        ErrorDetails(String description, String possibleSolution, String referenceMaterial) {
          //  this.exceptionType = exceptionType;
            this.description = description;
            this.possibleSolution = possibleSolution;
            this.referenceMaterial = referenceMaterial;

        }
    }
}


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Cognizant
 * @see
 * @since 12-Mar-24
 **/

/****
 *
 *  TO BE USED FOR INITIAL SETUP ONLY. DO NOT ATTEMPT TO RERUN.
 *
 */
public class SqliteUtil {
    private static com.cognizant.bluebolt.gw.errorassist.app.AppConstants AppConstants;
    static final String DB_URL = AppConstants.JDBC_URL;

    public static void main(String args[]) {
        createNewDatabase();
    }

public static void createNewDatabase() {
    Connection conn = null;
    try {

        conn = DriverManager.getConnection(DB_URL);
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



public class LuceneSearchUtil {
    private static final String DB_URL = AppConstants.JDBC_URL;
    private static final String INDEX_DIR = "D:/MyWorks/IdeaWS/GWErrorAssist/res/";
    private static final String SEARCH_SQL = "SELECT * FROM TABL";

    public LuceneSearchUtil() throws IOException {
        Path indexPath = FileSystems.getDefault().getPath(INDEX_DIR);

    }


    public void addDocument(int id, String content) throws IOException {
    }

    public List<String> search(String queryString) throws Exception {
        List<String> results = new ArrayList<>();
        return results;
    }

    public void close() throws IOException {
    }

    public static void main(String[] args) throws Exception {
        LuceneSearchUtil luceneSearch = new LuceneSearchUtil();
        Connection conn = DriverManager.getConnection(DB_URL);
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SEARCH_SQL)) {
            while (rs.next()) {
                int id = rs.getInt("id");

                String description = rs.getString("Description");

                luceneSearch.addDocument(id, description);
            }
        }
        List<String> searchResults = luceneSearch.search("TEST search query");

        for (String result : searchResults) {
            System.out.println(result);

        }
        luceneSearch.close();

        conn.close();

    }
}


package com.cognizant.bluebolt.gw.errorassist.service;

import com.cognizant.bluebolt.gw.errorassist.db.DBManager;
import com.cognizant.bluebolt.gw.errorassist.entity.ErrorAssistTO;
import com.cognizant.bluebolt.gw.errorassist.entity.ErrorAssistTranformer;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cognizant
 * @see
 * @since 12-Mar-24
 **/

public class ErrorAssistService {


//    public static List<ErrorAssistTO> execute(String searchStr) {
        public static List<ErrorAssistTO> execute(String searchStr, Object LuceneSearchService) {

        try {
           return searchAndRetrieve(searchStr, LuceneSearchService);
        }
        catch(Exception e)
        {

        }
        return null;
    }

    private static List<ErrorAssistTO> searchAndRetrieve(String searchStr, Object luceneSearchService) {
        return null;

    }


    private static List<ErrorAssistTO> searchAndRetrieve(String searchStr)
    //private static List<ErrorAssistTO> searchAndRetrieve(String searchStr, Object LuceneSearchService)
    {
        List resultList = new ArrayList<String[]>();

        try {

            //Step #1 : Search the key word in the Lucene search documents and get the table row ids
           List<String> rowIDList;
            rowIDList = LuceneSearchService.performSearch(searchStr);
            String dbUrl = DBManager.getDatabaseUrl();

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



public class LuceneSearchService {

    private static final String INDEX_FIELD_NAME = "content";
    private static final int MAX_RESULTS = 10;
    private static final String INDEX_DIR = "D:/MyWorks/IdeaWS/GWErrorAssist/res/";

    public static List<String> performSearch(String searchStr) {
        return null;
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

package com.cognizant.bluebolt.gw.errorassist.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Cognizant
 * @see
 * @since 12-Mar-24
 **/
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

package com.cognizant.bluebolt.gw.errorassist.db;

import com.cognizant.bluebolt.gw.errorassist.app.AppConstants;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.List;

/**
 * @author Cognizant
 * @see
 * @since 12-Mar-24
 **/
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


package com.cognizant.bluebolt.gw.errorassist.app;

/**
 * @author Cognizant
 * @see
 * @since 12-Mar-24
 **/
public class AppConstants {

    public static final String APPLICATION_TITLE = "Guidewire Error Assist";

    //public static final String DB_NAME = "gw_error_assist.db";
    public static final String DB_NAME = "C:\\Users\\2114779\\OneDrive - Cognizant\\Desktop";
    public static final String JDBC_URL = "jdbc:sqlite::resource:gw_error_assist.db";

   // public static final String JDBC_URL = "jdbc:sqlite:D:/MyWorks/IdeaWS/GWErrorAssist/res/" + DB_NAME;
    //public static final String IMAGE_URL = "C:\\Users\\2114779\\IdeaProjects\\JavaP\\src\\com\\cognizant\\bluebolt\\gw\\errorassist\\admin\\Cognizantlogo.png";
}


