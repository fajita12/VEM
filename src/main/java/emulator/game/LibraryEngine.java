package emulator.game;

import java.io.File;
import java.util.List;

public class LibraryEngine {
    //general vars
    public static final File PLAYABLE_DIRECTORY = new File("roms/");
    public static final String gamesFile = "games.csv";

    //modules
    private GameLoader gameLoader;

    //library vars
    private List<Game> games;

    public LibraryEngine() throws Exception {
        gameLoader = new GameLoader();
        initializeEngine();
    }

    //load all games
    private void initializeEngine() throws Exception {
        this.games = gameLoader.loadGames(gamesFile);
    }

    public List<Game> getGames() {
        return (this.games);
    }
}