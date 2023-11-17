package org.theplaceholder.pml;

import com.google.common.base.Suppliers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.architectury.registry.registries.RegistrarManager;
import net.minecraft.client.Minecraft;
import org.python.util.PythonInterpreter;
import org.theplaceholder.pml.loader.PyMod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class PythonModLoader {
    public static final List<PyMod> MODS = new ArrayList<>();

    public static final String MOD_ID = "pml";
    public static final PythonInterpreter JYTHON = new PythonInterpreter();
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    public static final Supplier<RegistrarManager> REGISTRAR_MANAGER = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));

    public static final File P_MODS_FOLDER = new File(Minecraft.getInstance().gameDirectory, "python-mods");

    public static void init() {
        registerMods();
        runModsEntryPoints();
    }

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
}
