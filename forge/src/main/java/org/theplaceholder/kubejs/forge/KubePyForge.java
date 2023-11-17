package org.theplaceholder.kubepy.forge;

import org.theplaceholder.kubepy.KubePy;

import dev.architectury.platform.forge.EventBuses;
import net.examplemod.ExampleMod;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(KubePy.MOD_ID)
public class KubePyForge {
    public KubePyForge() {
        EventBuses.registerModEventBus(ExampleMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        KubePy.init();
    }
}
