public class LuceneSearchUtil {

    private static final String DB_URL = "jdbc:sqlite:C:/Users/2114779/IdeaProjects/demo1/res/gw_error_assist.db";
    private static final String INDEX_DIR = "C:/Users/2114779/IdeaProjects/demo1/res/";
    private static final String SEARCH_SQL = "SELECT * FROM TABL";

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


public class SqliteUtil {

    static final String DB_URL = "jdbc:sqlite:C:/Users/2114779/IdeaProjects/demo1/res/gw_error_assist.db";

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

public class AppConstants {

    public static final String APPLICATION_TITLE = "Guidewire Error Assist";

    public static final String DB_NAME = "gw_error_assist.db";
    public static final String JDBC_URL = "jdbc:sqlite::res:gw_error_assist.db";
}

public class ErrorAssistApplication extends Application {

    TableView<LabelValuePair> resultsTableView = null;

    @Override
    public void start(Stage primaryStage) {

        // Set up the layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Application heading
        Label headingLabel = new Label("Guidewire Error Assist");
        headingLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        GridPane.setConstraints(headingLabel, 0, 0);
        GridPane.setColumnSpan(headingLabel, 3);
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
        GridPane.setHalignment(submitButton, HPos.CENTER);
        submitButton.setOnAction(e -> {
            try {
                String searchStr = searchField.getText();
                List<ErrorAssistTO> resultList = ErrorAssistService.execute(searchStr);
                setupTableView(resultList);


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        gridPane.add(searchLabel, 0,2);
        gridPane.add(searchField, 1, 2);
        gridPane.add(submitButton, 2, 2);
        GridPane.setMargin(searchLabel, new Insets(0, 10, 0, 50)); // Add left-side margin to search label

        resultsTableView = new TableView<>();
        TableColumn<LabelValuePair, String> labelColumn = new TableColumn<>("Label");
        labelColumn.setCellValueFactory(new PropertyValueFactory<>("label"));
        TableColumn<LabelValuePair, String> valueColumn = new TableColumn<>("Value");
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        resultsTableView.getColumns().addAll(labelColumn, valueColumn);

        resultsTableView.setFixedCellSize(25);

        gridPane.add(resultsTableView, 0, 3, 3, 1);
        GridPane.setHalignment(resultsTableView, HPos.CENTER); // Center-align the TableView

        // Set left and right margins for the GridPane
        gridPane.setPadding(new Insets(0, 20, 0, 20)); // 20 pixels left and right margins

        // Set up the scene
        Scene scene = new Scene(gridPane, 600, 400);
        primaryStage.setTitle(AppConstants.APPLICATION_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
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
public class LuceneSearchService {

    private static final String INDEX_FIELD_NAME = "content";
    private static final int MAX_RESULTS = 10;
    private static final String INDEX_DIR = "C:/Users/2114779/IdeaProjects/demo1/res/";

    public static List<String> performSearch(String searchStr) throws Exception {

        // Searching Lucene index
        List<String> searchResults = search(searchStr);

        return searchResults;

    }


    private static List<String> search(String queryString) throws Exception {
        List<String> results = new ArrayList<>();
        QueryParser parser = new QueryParser(INDEX_FIELD_NAME, new StandardAnalyzer());
        Query query = parser.parse(queryString);

        Path indexPath = FileSystems.getDefault().getPath(INDEX_DIR);
        Directory index = FSDirectory.open(indexPath);
        IndexReader indexReader = DirectoryReader.open(index);
        IndexSearcher searcher = new IndexSearcher(indexReader);

        TopDocs topDocs = searcher.search(query, MAX_RESULTS);

        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            Document doc = searcher.doc(scoreDoc.doc);
            String id = doc.get("id");
            //results.add(doc.get(INDEX_FIELD_NAME));
            results.add(id);
        }
        return results;
    }
}
