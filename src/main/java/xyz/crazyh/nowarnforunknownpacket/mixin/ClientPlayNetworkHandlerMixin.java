package xyz.crazyh.nowarnforunknownpacket.mixin;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.network.packet.s2c.play.EntityPassengersSetS2CPacket;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ClientPlayNetworkHandler.class, priority = 1111)
public abstract class ClientPlayNetworkHandlerMixin {
    @Shadow
    private ClientWorld world;

    @Redirect(
            method = "onScoreboardPlayerUpdate",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;Ljava/lang/Object;)V"
            )
    )
    private void unknownScoreBoard(Logger instance, String s, Object o) {
    }

/*    @Inject(
            method = "onScoreboardPlayerUpdate",
            at = @At("HEAD"),
            cancellable = true
    )
    private void doNothing(ScoreboardPlayerUpdateS2CPacket packet, CallbackInfo ci) {
        String objectiveName = packet.getObjectiveName();
        ScoreboardObjective scoreboardObjective = this.world.getScoreboard().getNullableObjective(objectiveName);
        if (packet.getUpdateMode() == ServerScoreboard.UpdateMode.CHANGE && scoreboardObjective == null) {
            ci.cancel();
        }
    }*/

/*    @Inject(
            method = "onEntityPassengersSet",
            at = @At("HEAD"),
            cancellable = true
    )
    private void unknownEntity(EntityPassengersSetS2CPacket packet, CallbackInfo ci) {
        Entity entity = this.world.getEntityById(packet.getId());
        if (entity == null) {
            ci.cancel();
        }
    }*/

/*    @Redirect(
            method = "onEntityPassengersSet",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;)V"
            )
    )
    private void unknownEntity(Logger instance, String s){

    }*/

/*    @Inject(
            method = "method_52801",
            at = @At("HEAD"),
            cancellable = true
    )
    private void unknownPayload(CustomPayload customPayload, CallbackInfo ci) {
        ci.cancel();
    }*/

    @Redirect(
            method = "method_52801",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;Ljava/lang/Object;)V"
            )
    )
    private void unknownPayload(Logger instance, String s, Object o) {

    }
}
