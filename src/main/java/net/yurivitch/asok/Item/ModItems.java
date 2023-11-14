package net.yurivitch.asok.Item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yurivitch.asok.mod;
import net.yurivitch.asok.Item.custom.SuperTestItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, mod.MOD_ID);

    public static final RegistryObject<Item> TEST = ITEMS.register("test",
        () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ASOK_TAB)));

    public static final RegistryObject<Item> SUPER_TEST = ITEMS.register("super_test",
        () -> new SuperTestItem(new Item.Properties().tab(ModCreativeModeTab.ASOK_TAB).stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
