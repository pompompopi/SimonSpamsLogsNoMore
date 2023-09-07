package me.pompompopi.simonspamslogsnomore.mixin;

import net.fabricmc.fabric.impl.networking.AbstractChanneledNetworkAddon;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AbstractChanneledNetworkAddon.class, remap = false)
public class AbstractChanneledNetworkAddonMixin {
    @Inject(method = "addId", at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V"), cancellable = true)
    private void inject(CallbackInfo ci) {
      ci.cancel();
    }
}
