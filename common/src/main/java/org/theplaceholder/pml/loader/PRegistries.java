package org.theplaceholder.pml.loader;

import dev.architectury.registry.registries.Registrar;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;

import static org.theplaceholder.pml.PythonModLoader.REGISTRAR_MANAGER;


public class PRegistries {
    public static final Registrar<Block> BLOCKS = REGISTRAR_MANAGER.get().get(Registries.BLOCK);
}
