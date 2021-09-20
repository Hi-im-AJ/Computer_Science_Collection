package app;

import component.RecipeData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        primaryStage.setTitle("Cook Book");
        primaryStage.setScene(new Scene(root, 600, 450));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        try {
            RecipeData.getInstance().saveRecipeItems();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
