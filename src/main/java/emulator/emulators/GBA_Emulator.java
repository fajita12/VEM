package emulator.emulators;

import java.io.File;

public class GBA_Emulator extends Emulator {

    private static String executable = "C:\\visualboyemulator-m.exe";
    private static String args = "";

    public void start(File game) {
        Runtime rt = Runtime.getRuntime();
        //Process pr = rt.exec("cmd /c dir");
        try {
            Process pr = rt.exec("c:\\visualboyadvance-m.exe -f \"c:\\test.zip\"");
        }catch(Exception e){
            System.out.println("FAILED");
        }
    }

    private String buildcmd(File game){
        String gameString = game.getAbsolutePath() + game.getName();

        StringBuilder sb = new StringBuilder();
        sb.append(executable).append(" ")
                .append(args).append(" ")
                .append(gameString);

        return (sb.toString());
    }
}
