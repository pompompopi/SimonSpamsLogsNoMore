package me.pompompopi.simonspamslogsnomore.mixin;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {
  @Inject(
      method = "onPlayerList",
      at =
          @At(
              value = "INVOKE",
              target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;Ljava/lang/Object;)V",
              remap = false),
      cancellable = true)
  private void inject1(CallbackInfo ci) {
    ci.cancel();
  }

  @Inject(
      method = "onEntityPassengersSet",
      at =
          @At(
              value = "INVOKE",
              target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;)V",
              remap = false),
      cancellable = true)
  private void inject2(CallbackInfo ci) {
    ci.cancel();
  }

  @Inject(
      method = "onCustomPayload",
      at =
          @At(
              value = "INVOKE",
              target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;Ljava/lang/Object;)V",
              remap = false),
      cancellable = true)
  private void inject3(CallbackInfo ci) {
    ci.cancel();
  }

  @Inject(
      method = "onTeam",
      at =
          @At(
              value = "INVOKE",
              target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;[Ljava/lang/Object;)V",
              remap = false),
      cancellable = true)
  private void inject4(CallbackInfo ci) {
    ci.cancel();
  }
}
