package pycraft;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockRegistry {
    public String modId;
    public BlockRegistry(String modId){
        this.modId = modId;
    }

    public void register(String id, Block block) {
        Registry.register(Registries.BLOCK, new Identifier(modId, id), block);
    }

    public void register(String id) {
        register(id, new Block());
    }
}
