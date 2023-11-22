package pycraft;

import pycraft.registry.BlockRegistry;
import pycraft.registry.ItemRegistry;

public class RegistryManager {
    public final String modId;

    public final BlockRegistry BLOCK_REGISTRY;
    public final ItemRegistry ITEM_REGISTRY;

    public RegistryManager(String modId) {
        this.modId = modId;
        BLOCK_REGISTRY = new BlockRegistry(this);
        ITEM_REGISTRY = new ItemRegistry(this);
    }

    public void register() {
        BLOCK_REGISTRY.register();
        ITEM_REGISTRY.register();
    }
}
