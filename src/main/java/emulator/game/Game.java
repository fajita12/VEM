package emulator.game;

import emulator.emulators.Emulator;
import emulator.emulators.EmulatorType;
import emulator.gui.GameGUIBuilder;
import emulator.gui.Window;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

import java.io.File;

import static emulator.gui.Window.*;

public class Game {
    //modules
    private SaveManager saveManager;
    private Emulator emulator;
    private GameGUIBuilder guiBuilder;

    //game vars
    private final File GAME;
    private final String GAME_NAME;
    private final String GAME_DISPLAY;
    private final File GAME_IMAGE;
    private final int GAME_YEAR;
    private final String GAME_COMPANY;
    private final String GAME_DESCRIPTION;
    private final EmulatorType TYPE;


    //constructor
    public Game(String game_name, File game, String game_display, File game_image, int game_year, String game_company, String game_description, EmulatorType type) throws Exception {
        this.GAME = game;
        this.GAME_DISPLAY = game_display;
        this.GAME_NAME = game_name;
        this.GAME_IMAGE = game_image;
        this.GAME_YEAR = game_year;
        this.GAME_COMPANY = game_company;
        this.GAME_DESCRIPTION = game_description;
        this.TYPE = type;

        this.saveManager = new SaveManager(GAME_NAME, LibraryEngine.PLAYABLE_DIRECTORY);
        this.emulator = Emulator.getEmulator(TYPE);
    }

    public void start(int saveIndex) {
        //determine whether new game or load game
        if (saveIndex != -1)
            //this.saveManager.copySave(saveIndex);

            //start game emulation
            this.emulator.start(this.GAME);
    }

    public String getName() {
        return this.GAME_NAME;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GAME_DISPLAY).append(" ")
                .append(GAME_YEAR).append(" ")
                .append(GAME_COMPANY).append(" ")
                .append(GAME_DESCRIPTION);

        return (sb.toString());
    }

    public Button getButton() {
        Button b = new Button();
        try {
            b.setStyle("-fx-background-image: url('covers/" + GAME_IMAGE.getName() + "'); " +
                    "   -fx-background-position: center center;" +
                    "   -fx-background-color: rgba(255, 255, 255, 0.5);" +
                    "	-fx-background-size: cover"
            );
            double length = Screen.getPrimary().getVisualBounds().getWidth();
            b.setMinSize(WINDOW_X / NUM_ITEMS_ROW, WINDOW_Y / NUM_ITEMS_ROW);
            b.setMaxSize(WINDOW_X / NUM_ITEMS_ROW, WINDOW_Y / NUM_ITEMS_ROW);

            b.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {
                    //load next screen
                    Window.window.setScene(new Scene(getSavePane(), WINDOW_X, WINDOW_Y));
                    Window.window.show();
                }
            });
        } catch (Exception c) {
        }

        return (b);
    }

    public Pane getSavePane() {
        GridPane main = new GridPane();
        GridPane about = new GridPane();
        GridPane saves = new GridPane();

        //configure save pane
        saves.setMinSize(WINDOW_X / 2, WINDOW_Y);
        saves.setMaxSize(WINDOW_X / 2, WINDOW_Y);
        saves.setHgap(0);
        saves.setVgap(0);
        saves.setPadding(new Insets(0, 0, 0, 0));

        for (int i = 0; i <= SaveManager.MAX_SAVE_INDEX; i++) {
            saves.add(getSaveButton(saveManager.getSaves().length > i ? saveManager.getSaves()[i] : null), i % 2, i / 2);
        }

        //configure about pane
        about.setMinSize(WINDOW_X / 2, WINDOW_Y);
        about.setMaxSize(WINDOW_X / 2, WINDOW_Y);
        about.setHgap(0);
        about.setVgap(0);
        about.setPadding(new Insets(0, 0, 0, 0));

        about.add(new ImageView("covers/" + GAME_IMAGE.getName()), 0, 0);

        //configure main pane
        main.setHgap(0);
        main.setVgap(0);
        main.setPadding(new Insets(0, 0, 0, 0));

        main.add(about, 1, 1);
        main.add(saves, 2, 1);

        return (main);
    }

    private Button getSaveButton(File save) {
        Button b = new Button();
        try {
            b.setStyle("-fx-background-image: url('img/saveBackground.png'); " +
                    "   -fx-background-position: center center;" +
                    "   -fx-background-color: rgba(255, 255, 255, 0.5);" +
                    "	-fx-background-size: cover"
            );

            if (save == null) {
                b.setText("NEW");
            } else {
                b.setText("Has Save");
            }
            double length = Screen.getPrimary().getVisualBounds().getWidth();
            b.setMinSize(WINDOW_X / (NUM_ITEMS_ROW * 2), WINDOW_Y / (5));
            b.setMaxSize(WINDOW_X / (NUM_ITEMS_ROW * 2), WINDOW_Y / (5));

            b.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {
                    //load next screen
                    emulator.start(GAME);
                    Window.resetPane();
                }
            });
        } catch (Exception c) {
        }

        return (b);
    }


}
