package  org.theplaceholder.pml.fabric;

import org.theplaceholder.pml.PythonModLoader;

import net.fabricmc.api.ModInitializer;

public class PythonModLoaderFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        PythonModLoader.init();
    }
}
