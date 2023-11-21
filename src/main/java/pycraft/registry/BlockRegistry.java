package pycraft.registry;

import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import pycraft.Block;
import pycraft.Item;

public class BlockRegistry extends Registry<Block> {
    public BlockRegistry(String modId) {
        super(modId);
    }

    @Override
    public void register(Block block, String id) {
        net.minecraft.registry.Registry.register(Registries.BLOCK, new Identifier(modId, id), block);
        if (block.hasItem) {
            net.minecraft.registry.Registry.register(Registries.ITEM, new Identifier(modId, id), new BlockItem(block, new Item.Settings()));
        }
    }

    @Override
    public void register(String id) {
        register(new Block(), id);
    }
}
