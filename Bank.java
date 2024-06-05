class Bank{
static String bankName="Corporation Bank";
static String name="Vidyashree Athani";
static int amount=58199;
static String ifscCode="IFSC0008877543";
static long account=45684321579L;

public static void main(String a[]){

System.out.println(bankName);
System.out.println(name);
System.out.println(amount);
System.out.println(ifscCode);
System.out.println(account);



}
}

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
import java.util.*;


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
    private final Map<String, String> errorDetailMap = new HashMap<>();

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

        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\2114779\\IdeaProjects\\JavaP\\Query.csv"))) {
            String line;
            boolean isHeader = true;
            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] columns = line.split(",", 4);

                if (columns.length >= 4 && columns[0].equalsIgnoreCase(query)) {
                    results.add(columns[0]);
                    errorDetailMap.put(columns[0], Arrays.toString(new String[]{columns[1].trim(), columns[2].trim(),columns[3].trim()}));
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
            String[] details = new String[]{errorDetailMap.get(result)};
            resultListView.getItems().add(result + ": " + details[0]);
        }

        noResultLabel.setVisible(false);
        resultListView.setOnMouseClicked(e -> {
            if (e.getClickCount() == 1) {
                String selectedResults = resultListView.getSelectionModel().getSelectedItem();
                String resultKey = selectedResults.split(":")[0].trim();
                displayResultDetails(resultKey);
            }
        });
    }

    private void displayResultDetails(String result) {
        String[] details = new String[]{errorDetailMap.get(result)};

        Label detailLabel = new Label("Description: " + result);
        TextArea detailTextArea = new TextArea(details[0]);
        detailTextArea.setWrapText(true);
        detailTextArea.setEditable(false);

        detailTextArea.setPrefHeight(400);
        detailTextArea.setPrefWidth(400);


        Hyperlink solutionLink = new Hyperlink("Show Possible Solution");

        solutionLink.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Possible Solution");
            alert.setHeaderText("Possible Solution for: " + result);
            alert.setContentText(details[0]);
            alert.showAndWait();
        });



        Stage detailStage = new Stage();
        detailStage.setTitle("Result Details");

        VBox detailLayout = new VBox(10);
        detailLayout.getChildren().addAll(detailLabel, detailTextArea,solutionLink);
        //String resultDetails = getresultDetails(result);

        Scene detailScene = new Scene(detailLayout, 400, 400);
        detailStage.setScene(detailScene);
        detailStage.show();
    }
}

