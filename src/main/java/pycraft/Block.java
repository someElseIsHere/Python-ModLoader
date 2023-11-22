package pycraft;

import net.minecraft.block.Blocks;
import pycraft.builder.BlockBuilder;
import pycraft.registry.Registry;

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

    public void register(Registry<Block> registry, String id) {
        registry.register(this, id);
    }
}
