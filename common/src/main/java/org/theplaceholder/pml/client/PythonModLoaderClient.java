package org.theplaceholder.pml.client;

import org.theplaceholder.pml.loader.PyMod;

import java.io.IOException;

import static org.theplaceholder.pml.PythonModLoader.MODS;

public class PythonModLoaderClient {
    public static void init() {
        runModsClientEntryPoints();
    }

    public static void runModsClientEntryPoints(){
        for (PyMod mod : MODS) {
            try {
                mod.runClientEntryPoints();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
