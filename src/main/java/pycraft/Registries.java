package pycraft;

import pycraft.registry.BlockRegistry;
import pycraft.registry.ItemRegistry;

public class Registries {
    public final String MODID;

    public final BlockRegistry BLOCK_REGISTRY;
    public final ItemRegistry ITEM_REGISTRY;

    public Registries(String modId) {
        MODID = modId;
        BLOCK_REGISTRY = new BlockRegistry(this);
        ITEM_REGISTRY = new ItemRegistry(this);
    }

    public void register() {
        BLOCK_REGISTRY.register();
        ITEM_REGISTRY.register();
    }
}
