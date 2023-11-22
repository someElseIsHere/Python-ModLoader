package org.theplaceholder.pml.mixin.client;

import net.minecraft.client.gui.screen.pack.ResourcePackOrganizer;
import net.minecraft.resource.ResourcePackProfile;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

import static org.theplaceholder.pml.loader.PyRepositorySource.IDS;

@Mixin(ResourcePackOrganizer.class)
public class ResourcePackOrganizerMixin {
    @Shadow @Final
    List<ResourcePackProfile> enabledPacks;

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Ljava/util/Collections;reverse(Ljava/util/List;)V", shift = At.Shift.AFTER))
    private void init(CallbackInfo ci) {
        enabledPacks.removeIf(profile -> IDS.contains(profile.getName()));
    }
}
