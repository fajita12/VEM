package emulator.gui;

import emulator.game.Game;
import emulator.game.LibraryEngine;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Window extends Application {

    public static LibraryEngine engine;
    public static double WINDOW_X;
    public static double WINDOW_Y;
    public static int NUM_ITEMS_ROW = 2;

    public static Stage window;

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

    public static void resetPane(){
        window.setScene(new Scene(getMainPane(), WINDOW_X, WINDOW_Y));
        window.show();
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        primaryStage.setTitle("Visual Emulator: VEM");

        primaryStage.setScene(new Scene(getMainPane(), WINDOW_X, WINDOW_Y));
        primaryStage.show();
    }

    public static ScrollPane getMainPane(){
        ScrollPane pane = new ScrollPane();
        pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        GridPane grid = new GridPane();
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setPadding(new Insets(0, 0, 0, 0));

        int index = 0;
        for(final Game g: engine.getGames()){
            grid.add(g.getButton(), (index % NUM_ITEMS_ROW), index / NUM_ITEMS_ROW);
            index++;
        }

        pane.setContent(grid);
        return (pane);
    }
}