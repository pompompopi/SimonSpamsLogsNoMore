package me.pompompopi.simonspamslogsnomore.mixin;

import net.minecraft.client.sound.SoundSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SoundSystem.class)
public class SoundSystemMixin {
  @Inject(
      method = "play(Lnet/minecraft/client/sound/SoundInstance;)V",
      at =
          @At(
              value = "INVOKE",
              target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;)V",
              remap = false),
      cancellable = true)
  private void inject1(CallbackInfo ci) {
    ci.cancel();
  }

  @Inject(
      method = "play(Lnet/minecraft/client/sound/SoundInstance;)V",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lorg/slf4j/Logger;warn(Lorg/slf4j/Marker;Ljava/lang/String;Ljava/lang/Object;)V",
              remap = false),
      cancellable = true)
  private void inject2(CallbackInfo ci) {
    ci.cancel();
  }
}
