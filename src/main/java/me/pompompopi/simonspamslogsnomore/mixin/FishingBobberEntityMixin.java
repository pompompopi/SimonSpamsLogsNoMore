package me.pompompopi.simonspamslogsnomore.mixin;

import net.minecraft.entity.projectile.FishingBobberEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FishingBobberEntity.class)
public class FishingBobberEntityMixin {
  @Inject(
      method = "onSpawnPacket",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lorg/slf4j/Logger;error(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V",
              remap = false),
      cancellable = true)
  private void inject(CallbackInfo ci) {
    ci.cancel();
  }
}
