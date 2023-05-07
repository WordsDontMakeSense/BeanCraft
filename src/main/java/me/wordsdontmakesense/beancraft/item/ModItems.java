package me.wordsdontmakesense.beancraft.item;

import me.wordsdontmakesense.beancraft.BeanCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, BeanCraft.MOD_ID);

    public static final RegistryObject<Item> BEAN = ITEMS.register("bean", () -> new Item(new Item.Properties().stacksTo(64).food(new FoodProperties.Builder().fast().nutrition(1).build())));
    public static final RegistryObject<Item> LASER_BEAN = ITEMS.register("laser_bean", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BEAN_OF_FLIGHT = ITEMS.register("bean_of_flight", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> WALL_BEAN = ITEMS.register("wall_bean", () -> new Item(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
