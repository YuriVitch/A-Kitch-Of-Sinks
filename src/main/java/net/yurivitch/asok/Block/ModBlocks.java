package net.yurivitch.asok.Block;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yurivitch.asok.mod;
import net.yurivitch.asok.Block.custom.jumpytest;
import net.yurivitch.asok.Item.ModCreativeModeTab;
import net.yurivitch.asok.Item.ModItems;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, mod.MOD_ID);

    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block",
     () -> new Block(BlockBehaviour.Properties.of(Material.SAND).strength(6f).requiresCorrectToolForDrops().instabreak()), ModCreativeModeTab.ASOK_TAB);

    public static final RegistryObject<Block> JUMP_TEST_BLOCK = registerBlock("jump_test_block",
     () -> new jumpytest(BlockBehaviour.Properties.of(Material.SAND).strength(6f).requiresCorrectToolForDrops().instabreak()), ModCreativeModeTab.ASOK_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
