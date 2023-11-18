package org.theplaceholder.pml.loader.resources;

import net.minecraft.resource.*;
import net.minecraft.text.Text;
import org.theplaceholder.pml.PythonModLoader;
import org.theplaceholder.pml.loader.PyMod;

import java.util.function.Consumer;

public class PyRepositorySource implements ResourcePackProvider {
    @Override
    public void register(Consumer<ResourcePackProfile> consumer) {
        for (PyMod mod : PythonModLoader.MODS) {
            ResourcePackProfile pack = createServerPack(createSupplier(new PyModResources(mod)), mod);
            consumer.accept(pack);
        }

        if (!PythonModLoader.IS_CLIENT)
            return;

        for (PyMod mod : PythonModLoader.MODS) {
            ResourcePackProfile pack = createClientPack(createSupplier(new PyModResources(mod)), mod);
            consumer.accept(pack);
        }
    }

    public static ResourcePackProfile createClientPack(ResourcePackProfile.PackFactory resources, PyMod mod) {
        return ResourcePackProfile.create(mod.id, Text.literal(mod.name), true, resources, ResourceType.CLIENT_RESOURCES, ResourcePackProfile.InsertionPosition.TOP, ResourcePackSource.BUILTIN);
    }

    public static ResourcePackProfile createServerPack(ResourcePackProfile.PackFactory resources, PyMod mod) {
        return ResourcePackProfile.create(mod.id, Text.literal(mod.name), true, resources, ResourceType.SERVER_DATA, ResourcePackProfile.InsertionPosition.TOP, ResourcePackSource.BUILTIN);
    }

    protected ResourcePackProfile.PackFactory createSupplier(PyModResources resources) {
        return new ResourcePackProfile.PackFactory() {
            @Override
            public ResourcePack open(String name) {
                return resources;
            }

            @Override
            public ResourcePack openWithOverlays(String name, ResourcePackProfile.Metadata metadata) {
                return resources;
            }
        };
    }
}
