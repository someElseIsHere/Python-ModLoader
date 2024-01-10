package pycraft.builder;

import pycraft.Item;

public class ItemBuilder implements Builder<Item> {
    public int maxCount = 64;
    public ItemBuilder maxCount(int maxCount) {
        this.maxCount = maxCount;
        return this;
    }

    @Override
    public Item build() {
        Item.Settings settings = new Item.Settings();
        settings.maxCount(maxCount);

        Item item = new Item(settings);
        return item;
    }
}
