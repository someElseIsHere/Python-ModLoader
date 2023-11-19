package mcpy;

public class BlockItem extends net.minecraft.item.BlockItem implements PyItem {
    public BlockItem(Block block) {
        super(block, new Settings());
    }

    public BlockItem(Block block, Settings settings) {
        super(block, settings);
    }
}
