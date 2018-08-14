package emulator.emulators;

import java.io.File;

public abstract class Emulator {

    //emulator descriptors
    private final EmulatorType TYPE = EmulatorType.GAMEBOY;

    //accessor methods
    public EmulatorType getEmulatorType() {
        return this.TYPE;
    }

    //abstract methods
    public abstract void start(File game);

    public abstract void start(File game, File save);

    //static emulator builder
    public static Emulator getEmulator(EmulatorType type) throws Exception {
        switch (type) {
            case GAMEBOY:
            case GAMEBOY_COLOR:
            case GAMEBOY_ADVANCE:
                return (new GBA_Emulator());
            case NINTENDO_DS:
            case NINTENDO_3DS:
                return (new DS_Emulator());
        }

        throw new Exception("Invalid Emulator Type");
    }
}