class Animals{

public static void main(String a[]){

String animalName1="Elephant";
int lifeSpan1=70;
String animalName2="Cow";
int lifeSpan2=22;

System.out.println(animalName1);
System.out.println(lifeSpan1);
System.out.println(animalName2);
System.out.println(lifeSpan2);

}

}











package com.cognizant.bluebolt.gw.errorassist.app;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\2114779\\IdeaProjects\\JavaP\\Error.csv"))) {
            String line;
            boolean isHeader = true;
            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;continue;
                }
                String[] columns = line.split(",");

                if (columns.length >= 2 && columns[0].equalsIgnoreCase(query)) {
                    results.add(columns[0]);
                    results.add(columns[1]);
                }
            }
        } catch (IOException e) {
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
        resultListView.getItems().addAll(searchResults);

        noResultLabel.setVisible(false);
        resultListView.setOnMouseClicked(e -> {
            if (e.getClickCount() == 1) {
                String selectedResults = resultListView.getSelectionModel().getSelectedItem();
                String resultKey = selectedResults.split(":")[0];
                displayResultDetails(resultKey);
            }
        });
    }

    private void displayResultDetails(String result) {
        String detailText = errorDetailMap.get(result);

        Label detailLabel = new Label("Details for: " + result);

        Stage detailStage = new Stage();
        detailStage.setTitle("Result Details");
        
        VBox detailLayout = new VBox(10);
        detailLayout.getChildren().add(detailLabel);

        //String resultDetails = getresultDetails(result);

        Scene detailScene = new Scene(detailLayout, 300, 200);
        detailStage.setScene(detailScene);
        detailStage.show();
    }
/*
    private String getresultDetails(String result) {
        switch (result) {
            case "How to fix FileNotFoundError in Python":
                return "Details for Result: Error can't resolve";
            case "Result 2":
                return "Details for Result:";
            case "Result 3":
                return "Details for Result :";
            default:
                return "Details not available";
        }
    }

 */

}
/*
private String[] performSearch(String query) throws SQLException {

    String dbUrl = "jdbc:sqlite:path_to_your_database.db";
    try (Connection connection = DriverManager.getConnection(dbUrl);
         Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT details FROM errors WHERE message LIKE'%"+ query +"%'");

        List<String> results = new ArrayList<>();
        while (resultSet.next()) {

            results.add(resultSet.getString("details"));
        }
        return results.toArray(new String[0]);

    } catch (SQLException e) {
        e.printStackTrace();
        return new String[0];
    }

}
}



 /*
        resultsTableView = new TableView<>();
        TableColumn<LabelValuePair, String> labelColumn = new TableColumn<>("Label");
        labelColumn.setCellValueFactory(new PropertyValueFactory<>("label"));
        TableColumn<LabelValuePair, String> valueColumn = new TableColumn<>("Value");
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        resultsTableView.getColumns().addAll(labelColumn, valueColumn);

        resultsTableView.setFixedCellSize(25);

        gridPane.add(resultsTableView, 0, 3, 3, 1);
        GridPane.setHalignment(resultsTableView, HPos.CENTER); // Center-align the TableView


         */


/*

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


 */



/*



        public class LabelValuePair {
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


 */
