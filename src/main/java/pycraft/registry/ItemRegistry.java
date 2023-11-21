package pycraft.registry;

import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import pycraft.Item;

public class ItemRegistry extends Registry<Item> {
    public ItemRegistry(String modId) {
        super(modId);
    }

    @Override
    public void register(Item item, String id) {
        net.minecraft.registry.Registry.register(Registries.ITEM, new Identifier(modId, id), item);
    }

    @Override
    public void register(String id) {
        register(new Item(), id);
    }
}
