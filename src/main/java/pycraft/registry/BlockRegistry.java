package pycraft.registry;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class BlockRegistry extends Registry<Block> {
    public BlockRegistry(String modId) {
        super(modId);
    }

    @Override
    public void register(Block block, String id) {
        net.minecraft.registry.Registry.register(Registries.BLOCK, new Identifier(modId, id), block);
    }
}
