package pycraft;

import net.minecraft.registry.Registries;

public class BlockRegistry extends Registry<net.minecraft.block.Block> {
    public BlockRegistry(String modId){
        super(modId, Registries.BLOCK);
    }

    @Override
    public void register(String id) {
        register(id, new Block());
    }

    public void registerWithItem(String id) {
        registerWithItem(id, new Block());
    }

    public void registerWithItem(String id, Block block) {
        register(id, block);
        ItemRegistry itemRegistry = new ItemRegistry(modId);
        itemRegistry.register(id, new BlockItem(block));
    }
}
