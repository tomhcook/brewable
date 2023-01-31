package com.err0rz.brewable.init;

import com.err0rz.brewable.BrewableMain;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Registration {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BrewableMain.MOD_ID);
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BrewableMain.MOD_ID);
    public static final RegistryObject<Item> tealeaf = ITEMS.register("tealeaf",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.instance)));
    public static final RegistryObject<Item> drytea = ITEMS.register("drytea",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.instance)));
    public static final RegistryObject<Item> emptyflask = ITEMS.register("emptyflask",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.instance)));
    public static final RegistryObject<Item> teaflask = ITEMS.register("teaflask",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.instance).food(new FoodProperties.Builder().nutrition(4).saturationMod(2).alwaysEat().effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0), 0.5F).build())));
    public static final RegistryObject<Item> glasspot = ITEMS.register("glasspot",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.instance).food(new FoodProperties.Builder().nutrition(4).saturationMod(2).alwaysEat().effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0), 0.5F).build())));
    public static final RegistryObject<Item> teaseed = ITEMS.register("teaseed",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.instance)));

    public static class ModCreativeTab extends CreativeModeTab {
        private ModCreativeTab(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(tealeaf.get());
        }
        public static final ModCreativeTab instance = new ModCreativeTab(CreativeModeTab.TABS.length, "brewable");
    }


}

