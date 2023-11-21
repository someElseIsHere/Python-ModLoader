package pycraft;

import net.minecraft.block.Blocks;

public class Block extends net.minecraft.block.Block {
    public boolean hasItem = true;

    public Block() {
        this(Settings.copy(Blocks.AIR));
    }

    public Block(Settings settings) {
        super(settings);
    }
}
