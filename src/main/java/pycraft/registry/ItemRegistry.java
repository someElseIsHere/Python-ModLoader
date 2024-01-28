package pycraft.registry;

import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import pycraft.Item;
import pycraft.RegistryManager;

import java.util.Map;

public class ItemRegistry extends Registry<Item> {
    public ItemRegistry(RegistryManager manager) {
        super(manager);
    }

    @Override
    public void register(String id) {
        register(new Item(), id);
    }

    @Override
    public void register() {
        for (Map.Entry<String, Item> id : registry.entrySet()) {
            Identifier identifier = new Identifier(manager.modId, id.getKey());
            net.minecraft.registry.Registry.register(Registries.ITEM, identifier, id.getValue());
        }
    }
}
