package org.theplaceholder.pml.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import org.theplaceholder.pml.client.PythonModLoaderClient;

public class PythonModLoaderClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PythonModLoaderClient.init();
    }
}
