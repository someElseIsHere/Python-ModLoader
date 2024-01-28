package pycraft.registry;

import net.minecraft.util.Identifier;
import pycraft.Block;
import pycraft.Registries;

import java.util.Map;

public class BlockRegistry extends Registry<Block> {

    public BlockRegistry(Registries manager) {
        super(manager);
    }

    @Override
    public void register(Block block, String id) {
        super.register(block, id);
        if (block.hasItem) {
            manager.ITEM_REGISTRY.register(id);
        }
    }

    @Override
    public void register(String id) {
        register(new Block(), id);
    }

    @Override
    public void register() {
        for (Map.Entry<String, Block> id : registry.entrySet()) {
            Identifier identifier = new Identifier(manager.MODID, id.getKey());
            net.minecraft.registry.Registry.register(net.minecraft.registry.Registries.BLOCK, identifier, id.getValue());
        }
    }
}
