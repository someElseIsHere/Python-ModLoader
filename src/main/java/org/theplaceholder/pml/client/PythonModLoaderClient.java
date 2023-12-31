package org.theplaceholder.pml.client;

import net.fabricmc.api.ClientModInitializer;
import org.theplaceholder.pml.loader.PyMod;

import java.io.IOException;

import static org.theplaceholder.pml.PythonModLoader.MODS;

public class PythonModLoaderClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
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