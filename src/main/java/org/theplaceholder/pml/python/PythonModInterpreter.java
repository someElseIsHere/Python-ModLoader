package org.theplaceholder.pml.python;

import org.python.util.PythonInterpreter;

import java.io.FileInputStream;

import static org.theplaceholder.pml.PythonModLoader.P_MODS_CACHE_FOLDER;

public class PythonModInterpreter extends PythonInterpreter {
    public static final PythonModInterpreter INSTANCE = new PythonModInterpreter();

    public PythonModInterpreter() {
        super();
        this.exec("import sys");
        this.exec("sys.path.append('" + P_MODS_CACHE_FOLDER.getAbsolutePath() + "')");
    }

    public static void runFile(FileInputStream fis) {
        INSTANCE.execfile(fis);
    }

}
