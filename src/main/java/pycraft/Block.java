package pycraft;

public class Block extends net.minecraft.block.Block {
    public Block() {
        super(Settings.copy(net.minecraft.block.Blocks.STONE));
    }
}