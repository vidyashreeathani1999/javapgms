public class ErrorAssistApplication extends Application {

    ListView<String> resultListView = new ListView<>();
    Label resultLabel = new Label("Output Result");
    Label noResultLabel = new Label("No results found for the given query.");
    // private ObservableList<SearchResult> allResults = FXCollections.observableArrayList();
    private final VBox getResultLayout = new VBox(10);
    private final VBox getDetailLayout = new VBox(10);
    private final VBox getSolutionLayout = new VBox(10);
    private final Map<String, ErrorDetails> errorDetailMap = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {
        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.TOP_CENTER);

        ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("/image.png")));
        logo.setFitWidth(100);
        logo.setPreserveRatio(true);


        Label headingLabel = new Label("Guidewire Error Assist");
        headingLabel.getStyleClass().add("heading");
        // headingLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        HBox headerBox = new HBox(10);
        headerBox.setAlignment(Pos.TOP_LEFT);
        headerBox.getChildren().addAll(logo, headingLabel);

        //SearchBox
        HBox searchBox = new HBox(10);
        searchBox.setAlignment(Pos.CENTER);
        Label searchLabel = new Label("Enter error message ");

        TextField searchField = new TextField();
        searchField.setPromptText("Enter search text");
        searchField.setPrefWidth(400);

        Button submitButton = new Button("Submit");
        Button clearButton = new Button("Clear");

        searchBox.getChildren().addAll(searchLabel, searchField, submitButton, clearButton);

        //Result layout
        getResultLayout.setAlignment(Pos.CENTER_LEFT);
        resultLabel.getStyleClass().add("result-label");
        noResultLabel.setVisible(false);

        getResultLayout.getChildren().addAll(resultLabel, resultListView, noResultLabel);

        getDetailLayout.setAlignment(Pos.TOP_LEFT);
        getSolutionLayout.setAlignment(Pos.TOP_LEFT);

        mainLayout.getChildren().addAll(headerBox, searchBox, getResultLayout, getDetailLayout, getSolutionLayout);

        Scene scene = new Scene(mainLayout, 800, 600);

        String css = getClass().getClassLoader().getResource("styles.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setTitle("Guidewire Error Assist");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMaximized(true);

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
                getDetailLayout.getChildren().clear();
                getSolutionLayout.getChildren().clear();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        resultListView.setOnMouseClicked(e -> {
            if (e.getClickCount() == 1) {
                String selectedResult = resultListView.getSelectionModel().getSelectedItem();
                if (selectedResult != null) {
                    System.out.println("Selected Result:" + selectedResult);
                    displayResultDescription(String.valueOf(selectedResult));
                }
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
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


    private void displaySearchResultsNotFound(String query) {
        resultListView.getItems().clear();
        resultLabel.setText("Output Result");
        noResultLabel.setVisible(true);
        getDetailLayout.getChildren().clear();
        getSolutionLayout.getChildren().clear();
    }

    private void displaySearchResults(String query, String[] searchResults) {
        resultLabel.setText("Results for: " + query);
        resultListView.getItems().clear();

        for (String result : searchResults) {
            resultListView.getItems().add(result);
        }
        noResultLabel.setVisible(false);

    }

    private void displayResultDescription(String result) {
        ErrorDetails details = errorDetailMap.get(result);

        if (details != null) {
          //  System.out.println("Displaying details for:" + result);
           // System.out.println("Description: " + details.description);
           // System.out.println("Possible Solution: " + details.possibleSolution);
            //System.out.println("Reference Material: " + details.referenceMaterial);

        Label detailLabel = new Label("Description: ");
        TextArea detailTextArea = new TextArea(details.description);
        detailTextArea.setWrapText(true);
        detailTextArea.setEditable(false);
        detailTextArea.setPrefHeight(100);
        detailTextArea.setPrefWidth(400);

        Hyperlink solutionLink = new Hyperlink("Show Possible Solution");
        solutionLink.setOnAction(e -> displayPossibleSolution(result, details.possibleSolution));

        getDetailLayout.getChildren().clear();
        getDetailLayout.getChildren().addAll(detailLabel, detailTextArea, solutionLink);

        getSolutionLayout.getChildren().clear();

        }else{
            System.out.println("No details found for: "+result);
        }

    }


    private void displayPossibleSolution(String result, String possibleSolution) {
        ErrorDetails details = errorDetailMap.get(result);

        if (details != null) {
            TextArea solutionTextArea = new TextArea(possibleSolution);
            solutionTextArea.setWrapText(true);
            solutionTextArea.setEditable(false);
            solutionTextArea.setPrefHeight(100);
            solutionTextArea.setPrefWidth(400);

            // System.out.println("Display the possible solution: "+ possibleSolution);
            Label referenceLabel = new Label("Reference Material");
            Hyperlink referenceLink = createHyperlink(details.referenceMaterial);

            getSolutionLayout.getChildren().clear();
            getSolutionLayout.getChildren().addAll(new Label("Possible Solution"), solutionTextArea, referenceLabel, referenceLink);

        } else {
            System.out.println("No Solution details found for: " + result);
        }

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



.root {
-fx-background-color: #f0f0f0; /* Light gray background */
}

/* Heading label style */
.label.heading {
-fx-font-size: 24px;
-fx-font-weight: bold;
-fx-text-fill: #333333; /* Dark gray text */

}

/* Search box and components */
.hbox.search-box {
-fx-spacing: 10px;
-fx-alignment: center;

}


.label.search-label {
-fx-font-size: 14px;
-fx-text-fill: #333333;

}


.text-field.search-field {
-fx-pref-width: 400px;
-fx-background-color: white; /* White background */
-fx-border-color: #cccccc; /* Light gray border */
-fx-border-width: 1px;
-fx-border-radius: 3px;
-fx-padding: 5px;

}

.button.submit-button {
-fx-background-color: #007acc; /* Blue submit button */
-fx-text-fill: white;
-fx-padding: 8px 16px;
-fx-font-size: 14px;
-fx-border-radius: 3px;
}

.button.clear-button {
-fx-background-color: #cccccc; /* Light gray clear button */
-fx-text-fill: #333333;
-fx-padding: 8px 16px;
-fx-font-size: 14px;
-fx-border-radius: 3px;

}

.button.submit-button:hover {
-fx-background-color: #005f99; /* Darker blue on hover for submit button */
}

.button.clear-button:hover {
fx-background-color: #999999; /* Darker gray on hover for clear button */
}

/* Result layout styling */
.vbox.result-layout {
-fx-spacing: 10px;
-fx-alignment: center;
}

.label.result-label {
-fx-font-size: 18px;
-fx-font-weight: bold;
-fx-text-fill: #333333;
}

/* Output result text styling */
.text-area.output-result {
-fx-background-color: transparent;
-fx-border-color: transparent;
-fx-font-size: 14px;
-fx-padding: 10px;
}


/* Detail and solution layouts */
.vbox.detail-layout,
.vbox.solution-layout {
-fx-spacing: 10px;
-fx-alignment: top-left;
}

/* Clickable links for possible solutions and reference materials */
.label.clickable-link {
-fx-text-fill: blue;
-fx-underline: true;
-fx-cursor: hand;
}

.text-area.output-result {
fx-background-color: transparent;
-fx-border-color: transparent;
-fx-font-size: 14px;
-fx-padding: 10px;
}

.text-area.output-result:focused,
.text-area.output-result:selected {
-fx-background-color: blue; /* Blue background when focused/selected */
-fx-text-fill: white; /* White text when focused/selected */

}


