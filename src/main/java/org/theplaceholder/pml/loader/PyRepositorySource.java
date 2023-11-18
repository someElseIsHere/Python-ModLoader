package org.theplaceholder.pml.loader;

import net.minecraft.resource.*;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.text.Text;
import org.theplaceholder.pml.PythonModLoader;

import java.util.List;
import java.util.function.Consumer;

public class PyRepositorySource implements ResourcePackProvider {
    @Override
    public void register(Consumer<ResourcePackProfile> consumer) {
        for (PyMod mod : PythonModLoader.MODS) {
            ZipResourcePack.ZipBackedFactory factory = new ZipResourcePack.ZipBackedFactory(mod.modArchive, true);
            ResourcePackProfile pack = createPack(factory, mod);
            consumer.accept(pack);
        }
    }

    public static ResourcePackProfile createPack(ResourcePackProfile.PackFactory resources, PyMod mod) {
        ResourcePackProfile.Metadata metadata = new ResourcePackProfile.Metadata(Text.literal(mod.name), ResourcePackCompatibility.COMPATIBLE, FeatureFlags.VANILLA_FEATURES, List.of());
        return ResourcePackProfile.of(mod.id, Text.literal(mod.name), true, resources, metadata, ResourcePackProfile.InsertionPosition.TOP, false, ResourcePackSource.BUILTIN);
    }
}
