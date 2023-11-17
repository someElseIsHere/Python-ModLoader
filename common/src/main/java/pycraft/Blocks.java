package pycraft;

import net.minecraft.resources.ResourceLocation;
import org.theplaceholder.pml.loader.PRegistries;

import static org.theplaceholder.pml.PythonModLoader.MOD_ID;

public class Blocks {
    public static void register(String id, Block block, boolean addItem) {
        PRegistries.BLOCKS.register(new ResourceLocation(MOD_ID, id), () -> block);
        if (addItem) {
            //Items.register(id, new ItemBlock(block));
        }
    }

    public static void register(String id) {
        register(id, new Block(), true);
    }

    public static void register(String id, Block block) {
        register(id, block, true);
    }
}
