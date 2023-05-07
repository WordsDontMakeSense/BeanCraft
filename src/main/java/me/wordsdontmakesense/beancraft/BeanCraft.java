package me.wordsdontmakesense.beancraft;

import com.mojang.logging.LogUtils;
import me.wordsdontmakesense.beancraft.block.ModBlocks;
import me.wordsdontmakesense.beancraft.item.ModCreativeModeTabs;
import me.wordsdontmakesense.beancraft.item.ModItems;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(BeanCraft.MOD_ID)
public class BeanCraft
{
    public static final String MOD_ID = "beancraft";
    private static final Logger LOGGER = LogUtils.getLogger();

    public BeanCraft()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::onItemRightClick);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == ModCreativeModeTabs.TAB)
        {
            event.accept(ModItems.BEAN);
            event.accept(ModItems.BEAN_OF_FLIGHT);
            event.accept(ModItems.LASER_BEAN);
            event.accept(ModItems.WALL_BEAN);
            event.accept(ModBlocks.BEAN_ORE);
            event.accept(ModBlocks.BEAN_BLOCK);
        }

        if (event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS)
        {
            event.accept(ModItems.BEAN);
        }

        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS)
        {
            event.accept(ModBlocks.BEAN_ORE);
            event.accept(ModBlocks.BEAN_BLOCK);
        }
    }

    private void onItemRightClick(PlayerInteractEvent.RightClickItem event)
    {
        Player player = event.getEntity();
        ItemStack offhand = player.getOffhandItem();
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
