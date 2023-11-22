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
        Identifier identifier = new Identifier(modId, id);

        net.minecraft.registry.Registry.register(Registries.BLOCK, identifier, block);
        if (block.hasItem) {
            net.minecraft.registry.Registry.register(Registries.ITEM, identifier, new BlockItem(block, new Item.Settings()));
        }
    }

    @Override
    public void register(String id) {
        register(new Block(), id);
    }
}
