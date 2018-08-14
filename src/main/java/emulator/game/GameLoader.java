package emulator.game;

import emulator.emulators.EmulatorType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class GameLoader {

    private static final String IMAGE_EXTENSION = ".png";
    private static final String GAME_EXTENSION = ".zip";

    public Game loadGame(String line) throws Exception {
        String[] items = line.split(",");

        String fileName = items[0];
        String displayName = items[1];
        String console = items[2];
        int year = Integer.parseInt(items[3]);
        String company = items[4];
        String description = items[5];

        return (new Game(new File(fileName + GAME_EXTENSION), displayName, new File(fileName + IMAGE_EXTENSION), year, company, description, EmulatorType.valueOf(console)));
    }

    public List<Game> loadGames(String filePath) throws Exception {
        List<Game> games = new ArrayList<Game>();
        File csvFile = new File(filePath);
        String line;

        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {
            games.add(loadGame(line));
        }

        return (games);
    }

}
