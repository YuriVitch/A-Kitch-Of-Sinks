package net.yurivitch.asok.Item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab ASOK_TAB = new CreativeModeTab("ASOK") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.TEST.get());
        }
    };
}
