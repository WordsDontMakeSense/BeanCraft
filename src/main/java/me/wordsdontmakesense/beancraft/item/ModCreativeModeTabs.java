package me.wordsdontmakesense.beancraft.item;

import me.wordsdontmakesense.beancraft.BeanCraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BeanCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event)
    {
        TAB = event.registerCreativeModeTab(new ResourceLocation(BeanCraft.MOD_ID, "tab"), builder -> builder.icon(() -> new ItemStack(ModItems.BEAN.get())).title(Component.translatable("creativemodetab.tab")));
    }
}
