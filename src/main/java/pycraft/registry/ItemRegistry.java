package pycraft.registry;

import net.minecraft.util.Identifier;
import pycraft.Item;
import pycraft.Registries;

import java.util.Map;

public class ItemRegistry extends Registry<Item> {
    public ItemRegistry(Registries manager) {
        super(manager);
    }

    @Override
    public void register(String id) {
        register(new Item(), id);
    }

    @Override
    public void register() {
        for (Map.Entry<String, Item> id : registry.entrySet()) {
            Identifier identifier = new Identifier(manager.MODID, id.getKey());
            net.minecraft.registry.Registry.register(net.minecraft.registry.Registries.ITEM, identifier, id.getValue());
        }
    }
}
