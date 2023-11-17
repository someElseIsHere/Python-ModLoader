package org.theplaceholder.pml.loader;

import com.google.gson.annotations.Expose;
import org.theplaceholder.pml.PythonModLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class PyMod {
    @Expose
    public String id;
    @Expose
    public String version;
    @Expose
    public String name;
    @Expose
    public String description;
    @Expose
    public String[] authors;
    @Expose
    public String license;

    @Expose
    public String[] clientEntryPoints;
    @Expose
    public String[] entryPoints;

    public File modFolder;
    public static PyMod fromJson(String json){
        return PythonModLoader.GSON.fromJson(json, PyMod.class);
    }

    public static PyMod fromFile(File file){
        try {
            PyMod mod = fromJson(Files.readString(file.toPath()));
            mod.modFolder = file.getParentFile();
            return mod;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public File getPythonFolder(){
        return new File(modFolder, "python");
    }

    public File[] getEntryPoints(){
        File[] entryPoints = new File[0];
        if (this.entryPoints != null){
            entryPoints = new File[this.entryPoints.length];
            for (int i = 0; i < this.entryPoints.length; i++) {
                entryPoints[i] = new File(getPythonFolder(), this.entryPoints[i]);
            }
        }
        return entryPoints;
    }

    public File[] getClientEntryPoints(){
        File[] entryPoints = new File[0];
        if (this.clientEntryPoints != null){
            entryPoints = new File[this.clientEntryPoints.length];
            for (int i = 0; i < this.clientEntryPoints.length; i++) {
                entryPoints[i] = new File(getPythonFolder(), this.clientEntryPoints[i]);
            }
        }
        return entryPoints;
    }

    public void runEntryPoints() throws IOException {
        for (File entryPoint : getEntryPoints()) {
            FileInputStream fis = new FileInputStream(entryPoint);
            PythonModLoader.execfile(fis);
            fis.close();
        }
    }

    public void runClientEntryPoints() throws IOException {
        for (File entryPoint : getClientEntryPoints()) {
            FileInputStream fis = new FileInputStream(entryPoint);
            PythonModLoader.execfile(fis);
            fis.close();
        }
    }
}
