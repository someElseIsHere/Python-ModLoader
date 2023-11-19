package mcpy;

public class Block extends net.minecraft.block.Block implements PyBlock {
    public Block() {
        super(Settings.copy(net.minecraft.block.Blocks.STONE));
    }

    public static Block create() {
        return new Block();
    }

    public static BlockBuilder builder() {
        return new BlockBuilder();
    }

    public void register(String id, BlockRegistry blockRegistry) {
        blockRegistry.register(id, this);
    }
}