package emulator.game;

import java.io.File;
import java.io.FilenameFilter;

public class SaveManager{
	//general vars
	public static final int MIN_SAVE_INDEX = 0;
	public static final int MAX_SAVE_INDEX = 9;
	public static final String SAVE_EXTENSION = ".sav";
	public static final String INDEX_SEPERATOR = "_";
	/**
	* SAVES FOR GAMES ARE STORED IN THE FOLLOWING FORMAT:
	* USED IN THE FORMAT: [GAME_NAME][SAVE_EXTENSION]
	* STORED IN THE FORMAT: [GAME_NAME][INDEX_SEPERATOR]{INDEX}[SAVE_EXTENSION]
	**/

	//game vars
	private final String GAME_NAME;
	private final File SAVE_DIRECTORY;

	public SaveManager(String game_name, File save_directory){
        this.GAME_NAME = game_name;
        this.SAVE_DIRECTORY = save_directory;
    }

	//working vars
	private int workingSaveIndex;

	//modules
	private FileUpdateListener fileUpdateListener;
	
	public File[] getSaves(){
		return (SAVE_DIRECTORY.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".sgm") && name.contains(GAME_NAME);
			}
		}));
    }

	public void deleteSave(int saveIndex){

    }
	
	public void copySaveOut(int saveIndex){
		//copy save
		//set workingSaveIndex
	}

	public void copySaveIn(){}
}