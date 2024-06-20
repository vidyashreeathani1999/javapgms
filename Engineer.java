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

        GridPane.setColumnSpan(headingLabel, Integer.valueOf(3));

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


/*
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
           // System.err.println("URISyntaxException: " +e.getMessage());
        }

 */



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
}
