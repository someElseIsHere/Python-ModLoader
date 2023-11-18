package pycraft;

import net.minecraft.registry.Registries;

public class ItemRegistry extends Registry<net.minecraft.item.Item> {
    public ItemRegistry(String modId) {
        super(modId, Registries.ITEM);
    }

    @Override
    public void register(String id) {
        register(id, new Item());
    }
}
