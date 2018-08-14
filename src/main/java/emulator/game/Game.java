package emulator.game;

import emulator.emulators.Emulator;
import emulator.emulators.EmulatorType;
import emulator.gui.GameGUIBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

import java.io.File;

import static emulator.gui.Window.NUM_ITEMS_ROW;
import static emulator.gui.Window.WINDOW_X;
import static emulator.gui.Window.WINDOW_Y;

public class Game{
	//modules
	private SaveManager saveManager;
	private Emulator emulator;
	private GameGUIBuilder guiBuilder;
	
	//game vars
	private final File GAME;
	private final String GAME_NAME;
	private final File GAME_IMAGE;
	private final int GAME_YEAR;
	private final String GAME_COMPANY;
	private final String GAME_DESCRIPTION;
	private final EmulatorType TYPE;
	
	
	//constructor
	public Game(File game, String game_name, File game_image, int game_year, String game_company, String game_description, EmulatorType type) throws Exception {
		this.GAME = game;
		this.GAME_NAME = game_name;
		this.GAME_IMAGE = game_image;
		this.GAME_YEAR = game_year;
		this.GAME_COMPANY = game_company;
		this.GAME_DESCRIPTION = game_description;
		this.TYPE = type;

		this.saveManager = new SaveManager(GAME_NAME, LibraryEngine.PLAYABLE_DIRECTORY);
		this.emulator = Emulator.getEmulator(TYPE);
	}

	public void start(int saveIndex){
		//determine whether new game or load game
		if(saveIndex != -1)
			//this.saveManager.copySave(saveIndex);
		
		//start game emulation		
		this.emulator.start(this.GAME);
	}

	public String getName(){
	    return this.GAME_NAME;
    }

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(GAME_NAME).append(" ")
				.append(GAME_YEAR).append(" ")
				.append(GAME_COMPANY).append(" ")
				.append(GAME_DESCRIPTION);

		return (sb.toString());
	}

	public Button getButton(){
        Button b = new Button();
	    try {
            System.out.println(GAME_IMAGE.getName());
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
                    System.out.println(GAME_NAME);
                    //load next screen

                }
            });
        }catch (Exception c){}

        return (b);
    }

    public Pane getSavePane(){

    }


}
