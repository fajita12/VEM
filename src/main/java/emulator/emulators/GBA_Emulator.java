package emulator.emulators;

import java.io.File;

public class GBA_Emulator extends Emulator {

    private static String executable = new File("emulators\\gba.exe").getAbsolutePath();
    private static String args = "";

    public void start(File game) {
        Runtime rt = Runtime.getRuntime();
        try {
            System.out.println(buildcmd(game));
            Process pr = rt.exec(buildcmd(game));
            int res = pr.waitFor();
        } catch (Exception e) {
            System.out.println("FAILED");
        }
    }

    public void start(File game, File save) {

    }

    private String buildcmd(File game, File save) {
        return null;
    }

    private String buildcmd(File game) {
        String gameString = game.getAbsolutePath();

        StringBuilder sb = new StringBuilder();
        sb.append(executable).append(" ")
                .append(args).append(" \"")
                .append(gameString).append("\"");

        return (sb.toString());
    }
}
