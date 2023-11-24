package org.theplaceholder.pml.mixin.client.input;

import net.minecraft.client.input.KeyboardInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pycraft.InputUtils;

@Mixin(KeyboardInput.class)
public class KeyboardInputMixin {

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void tick(boolean slowDown, float slowDownFactor, CallbackInfo ci) {
        if (InputUtils.areInputBlocked) {
            ci.cancel();
        }
    }
}
