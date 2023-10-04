package xyz.gamars.lifelink.events;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.gamars.lifelink.LifeLink;

@Mod.EventBusSubscriber(modid = LifeLink.MOD_ID)
public class DeathEventHandler {

    @SubscribeEvent
    public static void damageEntityEvent(LivingDamageEvent event) {
        if (!event.getEntity().getLevel().isClientSide()) {
            if (event.getEntity() instanceof Player) {
                Player player = (Player) event.getEntity();
                if(event.getAmount() >= player.getHealth()) {
                    for (ServerPlayer onlinePlayer : event.getEntity().getLevel().getServer().getPlayerList().getPlayers()) {
                        onlinePlayer.setHealth(0);
                        onlinePlayer.displayClientMessage(Component.literal(String.format("%s died and ruined it for everyone else", player.getDisplayName().getString())), false);
                    }
                }
            }
        }
    }

}
