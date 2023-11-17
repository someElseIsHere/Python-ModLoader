package net.examplemod;

import org.python.util.PythonInterpreter;

public class ExampleMod {
    public static final String MOD_ID = "kubepy";
    
    public static void init() {}

    public static void main(String[] args){
        try(PythonInterpreter pyInterp = new PythonInterpreter()) {
            pyInterp.exec("print('Hello Python World!')");
        }
    }
}
