package org.theplaceholder.pml.loader;

import com.google.gson.annotations.Expose;
import org.theplaceholder.pml.PythonModLoader;
import org.theplaceholder.pml.python.PythonModInterpreter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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

    public File modArchive;

    public static PyMod fromJson(String json){
        return PythonModLoader.GSON.fromJson(json, PyMod.class);
    }

    public File getPythonFolder(){
        return PythonModLoader.P_MODS_CACHE_FOLDER;
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
            PythonModInterpreter.runFile(fis);
            fis.close();
        }
    }

    public void runClientEntryPoints() throws IOException {
        for (File entryPoint : getClientEntryPoints()) {
            FileInputStream fis = new FileInputStream(entryPoint);
            PythonModInterpreter.runFile(fis);
            fis.close();
        }
    }
}
