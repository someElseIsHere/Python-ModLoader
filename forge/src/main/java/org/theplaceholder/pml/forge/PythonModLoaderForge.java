package org.theplaceholder.pml.forge;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import org.theplaceholder.pml.PythonModLoader;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.theplaceholder.pml.client.PythonModLoaderClient;

@Mod(PythonModLoader.MOD_ID)
public class PythonModLoaderForge {
    public PythonModLoaderForge() {
        EventBuses.registerModEventBus(PythonModLoader.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        PythonModLoader.init();
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> PythonModLoaderClient::init);
    }
}
