package pycraft;

import pycraft.builder.ItemBuilder;

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
}
