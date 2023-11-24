package org.theplaceholder.pml;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.apache.commons.io.FileUtils;
import org.theplaceholder.pml.loader.PyMod;
import org.theplaceholder.pml.utils.ZipUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PythonModLoader implements ModInitializer {
    public static final List<PyMod> MODS = new ArrayList<>();
    public static final String MOD_ID = "pml";
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    public static final File P_MODS_FOLDER = new File(MinecraftClient.getInstance().runDirectory, "python-mods");
    public static final File P_MODS_CACHE_FOLDER = new File(P_MODS_FOLDER, ".python-cache");

    public static void runModsEntryPoints(){
        for (PyMod mod : MODS) {
            try {
                mod.runEntryPoints();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void registerMods() {
        try {
            FileUtils.deleteDirectory(P_MODS_CACHE_FOLDER);

            P_MODS_CACHE_FOLDER.mkdirs();

            File[] modFolders = P_MODS_FOLDER.listFiles();
            if (modFolders == null)
                return;

            for (File modFolder : modFolders) {
                if (!modFolder.exists() || modFolder.isDirectory())
                    continue;

                String json = ZipUtils.readStringFromZip(modFolder.toPath(), "py.mod.json");
                PyMod mod = PyMod.fromJson(json);
                mod.modArchive = modFolder;
                MODS.add(mod);

                ZipUtils.unzipSubfolderToParent(modFolder.toPath(), P_MODS_CACHE_FOLDER.toPath(), "python");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onInitialize() {
        registerMods();
        runModsEntryPoints();
    }
}
