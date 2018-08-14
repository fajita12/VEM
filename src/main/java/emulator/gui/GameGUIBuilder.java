package emulator.gui;

import emulator.game.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Screen;

import static emulator.gui.Window.NUM_ITEMS_ROW;
import static emulator.gui.Window.WINDOW_X;
import static emulator.gui.Window.WINDOW_Y;

public class GameGUIBuilder{
	private Game game;

	//on game selection screen
	public void drawMainPanel(){

	}

	//full screen
	public void drawAboutPanel(){
		//image vertical center on left
		//game title across top
		//game info vertical center on right 
	}

	//full screen
	public void drawSavePanel(){
		//image top left small
		//2xN saves displayed on right/center
		//on-click; shows options (load, delete| start (if new))
	}
}