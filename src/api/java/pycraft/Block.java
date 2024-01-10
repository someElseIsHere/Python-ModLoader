package pycraft;

import net.minecraft.block.Blocks;
import pycraft.builder.BlockBuilder;

public class Block extends net.minecraft.block.Block {
    public boolean hasItem = true;

    public Block() {
        this(Settings.copy(Blocks.STONE));
    }

    public Block(Settings settings) {
        super(settings);
    }

    public static BlockBuilder builder() {
        return new BlockBuilder();
    }
}
