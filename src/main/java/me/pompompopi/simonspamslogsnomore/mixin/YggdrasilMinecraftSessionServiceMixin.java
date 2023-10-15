package me.pompompopi.simonspamslogsnomore.mixin;

import com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = YggdrasilMinecraftSessionService.class, remap = false)
public class YggdrasilMinecraftSessionServiceMixin {
  @Redirect(
      method = "getSecurePropertyValue",
      at =
          @At(
              value = "INVOKE",
              target = "Lorg/slf4j/Logger;error(Ljava/lang/String;Ljava/lang/Object;)V"))
  private void inject(Logger instance, String s, Object object) {}
}
