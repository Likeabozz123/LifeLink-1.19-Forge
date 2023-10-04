package xyz.gamars.lifelink;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import xyz.gamars.lifelink.events.DeathEventHandler;

@Mod(LifeLink.MOD_ID)
public class LifeLink {
    public static final String MOD_ID = "lifelink";
    private static final Logger LOGGER = LogUtils.getLogger();

    public LifeLink() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);
        // MinecraftForge.EVENT_BUS.register(DeathEventHandler.class);
    }

}
