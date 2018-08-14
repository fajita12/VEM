package emulator.gui;

import emulator.game.Game;
import emulator.game.LibraryEngine;

public class TextGUI {

    public static void main(String[] args) {
        System.out.println("--------------------");
        System.out.println(" Emulator Text GUI");
        System.out.println("--------------------");

        try {

            LibraryEngine le = new LibraryEngine();
            for (Game g : le.getGames()) {
                System.out.println(g.toString());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
