package pycraft;

import pycraft.builder.ItemBuilder;
import pycraft.registry.Registry;

public class Item extends net.minecraft.item.Item {
    public Item() {
        this(new Settings());
    }

    public Item(Settings settings) {
        super(settings);
    }

    public static ItemBuilder builder() {
        return new ItemBuilder();
    }

    public void register(Registry<Item> registry, String id) {
        registry.register(this, id);
    }
}
