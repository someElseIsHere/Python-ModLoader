package org.theplaceholder.pml.mixin;

import net.minecraft.resource.ResourcePackManager;
import net.minecraft.resource.ResourcePackProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.theplaceholder.pml.loader.PyRepositorySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(ResourcePackManager.class)
public class PackRepositoryMixin {
    @ModifyVariable(at = @At("HEAD"), method = "<init>", argsOnly = true)
    private static ResourcePackProvider[] init(ResourcePackProvider[] providers) {
        List<ResourcePackProvider> l = new ArrayList<>(Arrays.asList(providers));
        l.add(new PyRepositorySource());

        return l.toArray(new ResourcePackProvider[0]);
    }
}
