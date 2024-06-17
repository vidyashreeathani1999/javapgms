import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

import java.util.List;

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
