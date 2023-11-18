package pycraft;

public class Item extends net.minecraft.item.Item implements PyItem{
    public Item() {
        super(new Settings());
    }

    public Item(Settings settings) {
        super(settings);
    }
}
