package pycraft.builder;

import net.minecraft.block.AbstractBlock;
import pycraft.Block;

public class BlockBuilder implements Builder<Block> {
    public boolean hasItem = true;
    public BlockBuilder no_item() {
        hasItem = false;
        return this;
    }
    
    @Override
    public Block build() {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create();

        Block block = new Block(settings);
        block.hasItem = hasItem;
        return block;
    }
}
