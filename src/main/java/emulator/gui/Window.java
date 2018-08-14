package emulator.gui;

import emulator.game.Game;
import emulator.game.LibraryEngine;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Window extends Application {

    public static LibraryEngine engine;
    public static double WINDOW_X;
    public static double WINDOW_Y;
    public static int NUM_ITEMS_ROW = 2;

    public static void main(String[] args) {
        WINDOW_X = Math.min(Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());
        WINDOW_Y = WINDOW_X;
        try {
            engine = new LibraryEngine();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Visual Emulator: VEM");

        primaryStage.setScene(new Scene(getMainPanel(), WINDOW_X, WINDOW_Y));
        primaryStage.show();
    }

    public GridPane getMainPanel(){
        GridPane pane = new GridPane();
        pane.setHgap(0);
        pane.setVgap(0);
        pane.setPadding(new Insets(0, 0, 0, 0));
        //pane.setStyle("-fx-background-image: url('covers/pokemon_emerald.png')");

        int index = 0;
        for(final Game g: engine.getGames()){
            pane.add(g.getButton(), (index % NUM_ITEMS_ROW), index / NUM_ITEMS_ROW);
            index++;
        }

        return (pane);
    }
}