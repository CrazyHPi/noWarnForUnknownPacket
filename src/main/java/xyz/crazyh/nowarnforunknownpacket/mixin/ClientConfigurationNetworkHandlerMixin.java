package xyz.crazyh.nowarnforunknownpacket.mixin;

import net.minecraft.client.network.ClientConfigurationNetworkHandler;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.CustomPayload;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConfigurationNetworkHandler.class)
public abstract class ClientConfigurationNetworkHandlerMixin {
    @Inject(
            method = "handleCustomPayload",
            at = @At("HEAD"),
            cancellable = true
    )
    private void unknownPayload(CustomPayload payload, CallbackInfo ci) {
        ci.cancel();
    }
}
