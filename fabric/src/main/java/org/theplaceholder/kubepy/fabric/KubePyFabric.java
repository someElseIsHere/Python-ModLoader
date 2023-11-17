package  org.theplaceholder.kubepy.fabric;

import org.theplaceholder.kubepy.KubePy;

import net.fabricmc.api.ModInitializer;

public class KubePyFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        KubePy.init();
    }
}
