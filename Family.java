public class ErrorAssistApplication extends Application {
    TableView<LabelValuePair> resultsTableView = null;

    ListView<String> resultListView = new ListView<>();
    Label resultLabel = new Label("Output Result");
    Label noResultLabel = new Label("No results found for the given query.");

    private ObservableList<LabelValuePair> tableData = FXCollections.observableArrayList();
    private ObservableList<LabelValuePair> filteredData = FXCollections.observableArrayList();
    //  private final Map<String> errorDetailMap = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {

        BorderPane borderPane= new BorderPane();
        borderPane.setPadding(new Insets(10));

        VBox topSection = new VBox(20);
        topSection.setPadding(new Insets(40,10,10,10));
        topSection.setAlignment(Pos.TOP_CENTER);
       /*
// Application logo

ImageView logoImageView = new ImageView(new Image("file:logo.png")); // Make sure you have a logo.png file in your project director
logoImageView.setFitHeight(100);
logoImageView.setFitWidth(100);
GridPane.setConstraints(logoImageView, 0, 0);
GridPane.setHalignment(logoImageView, HPos.CENTER);
gridPane.add(logoImageView, 0, 0, 3, 1);
 */

        HBox searchBox = new HBox(10);
       searchBox.setAlignment(Pos.CENTER_LEFT);
       searchBox.setPadding(new Insets(10,0,0,0));

        Label headingLabel = new Label("Guidewire Error Assist");
        headingLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

// Search bar with clear button
        TextField searchField = new TextField();
        searchField.setPromptText("Enter search text");
        searchField.setStyle("-fx-font-size: 18px; -fx-pref-height: 30px;-fx-pref-width:700px;");

        Button clearButton = new Button("X");
        clearButton.setStyle("-fx-font-size: 18px;");
        clearButton.setOnAction(e -> {
                    searchField.clear();
                    filterTable("");
                }
        );



// Submit button
        Button submitButton = new Button("Search");
        submitButton.setStyle("-fx-font-size: 18px;-fx-pref-height: 40px;");
       /* submitButton.setOnAction(e -> {
            try {
                String searchStr = searchField.getText();
                List<ErrorAssistTO> resultList = ErrorAssistService.execute(searchStr);
                setupTableView(resultList);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        */
        ContextMenu suggestionsMenu = new ContextMenu();
        suggestionsMenu.setStyle("-fx-font-size: 14px;");
        searchField.textProperty().addListener((observable, oldValue, newValue)->{
            clearButton.setVisible(!newValue.isEmpty());
           // showSuggestions(newValue,suggestionsMenu,searchField);
            filterTable(newValue);
        });

        searchBox.getChildren().addAll(headingLabel,searchField,clearButton,submitButton);



// Navigation buttons
        HBox navBox = new HBox(10);
        navBox.setAlignment(Pos.CENTER_LEFT);

        Button descriptionButton = new Button("Description");
        descriptionButton.setStyle("-fx-font-size: 14px;-fx-pref-height: 20px;");

        Button causeButton = new Button("Cause");
        causeButton.setStyle("-fx-font-size: 14px;-fx-pref-height: 20px;");

        Button solutionButton = new Button("Solution");
        solutionButton.setStyle("-fx-font-size: 14px;-fx-pref-height: 20px;");

        Button otherCommentsButton = new Button("OtherComments");
        otherCommentsButton.setStyle("-fx-font-size: 14px;-fx-pref-height: 20px;");

        navBox.getChildren().addAll(descriptionButton,causeButton,solutionButton,otherCommentsButton);
        topSection.getChildren().addAll(searchBox,navBox);

        borderPane.setTop(topSection);
        BorderPane.setAlignment(navBox,Pos.CENTER_LEFT);



// Set up the scene
        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setTitle("Guidewire Error Assist");
        primaryStage.setScene(scene);
        primaryStage.show();

        //setupTableView(getSampleData());
    }



private void filterTable(String keyword) {
    if (keyword.isEmpty()) {
        resultsTableView.setItems(tableData);
        return;
    }

    ObservableList<LabelValuePair> filteredList = FXCollections.observableArrayList();
    for (LabelValuePair item : tableData) {
        if (item.getLabel().toLowerCase().contains(keyword.toLowerCase()) ||
                item.getValue().toLowerCase().contains(keyword.toLowerCase())) {
            filteredList.add(item);
        }
    }

    if (filteredList.isEmpty()) {
        LabelValuePair lvp = new LabelValuePair("Application", "No results found");
        filteredList.add(lvp);
    }

    resultsTableView.setItems(filteredList);
}



    public static void main(String[] args) {
        launch(args);
    }


    private void displaySearchResultsNotFound(String query) {
        resultListView.getItems().clear();
        resultLabel.setText("Output Result");
        noResultLabel.setVisible(true);
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
