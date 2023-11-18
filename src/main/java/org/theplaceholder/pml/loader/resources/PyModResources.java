package org.theplaceholder.pml.loader.resources;

import net.minecraft.resource.DirectoryResourcePack;
import org.theplaceholder.pml.loader.PyMod;

public class PyModResources extends DirectoryResourcePack {
    public PyModResources(PyMod mod) {
        super(mod.id, mod.modFolder.toPath(), true);
    }
}
