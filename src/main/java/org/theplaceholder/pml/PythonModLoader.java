package org.theplaceholder.pml;

import com.google.common.base.Suppliers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.python.util.PythonInterpreter;
import org.theplaceholder.pml.loader.PyMod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PythonModLoader implements ModInitializer {
    public static final List<PyMod> MODS = new ArrayList<>();
    public static boolean IS_CLIENT = false;
    public static final PythonInterpreter JYTHON = new PythonInterpreter();
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    public static final File P_MODS_FOLDER = new File(MinecraftClient.getInstance().runDirectory, "python-mods");

    public static void runModsEntryPoints(){
        for (PyMod mod : MODS) {
            try {
                mod.runEntryPoints();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void registerMods(){
        P_MODS_FOLDER.mkdirs();

        File[] modFolders = P_MODS_FOLDER.listFiles();
        if (modFolders == null)
            return;

        for (File modFolder : modFolders) {
            if (!modFolder.exists() || !modFolder.isDirectory())
                continue;

            File modJson = new File(modFolder, "py.mod.json");
            if (!modJson.exists() || !modJson.isFile())
                continue;
            PyMod mod = PyMod.fromFile(modJson);

            MODS.add(mod);
        }
    }

    public static void execfile(FileInputStream fis) {
        JYTHON.execfile(fis);
    }

    @Override
    public void onInitialize() {
        registerMods();
        runModsEntryPoints();
    }
}
