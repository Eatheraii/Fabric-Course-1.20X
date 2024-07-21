package net.eatheraii.mccourse.util;

import net.eatheraii.mccourse.block.ModBlocks;
import net.eatheraii.mccourse.command.ReturnHomeCommand;
import net.eatheraii.mccourse.command.SetHomeCommand;
import net.eatheraii.mccourse.event.AttackEntityHandler;
import net.eatheraii.mccourse.event.PlayerCopyHandler;
import net.eatheraii.mccourse.item.ModItems;
import net.eatheraii.mccourse.mixin.BrewingRecipeRegistryMixin;
import net.eatheraii.mccourse.potion.ModPotions;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.potion.Potions;

public class ModRegistries {
    public static void registerModStuffs(){
        registerFuels();
        registerCommands();
        registerEvents();
        registerPotionRecipes();
        registerStrippables();
        registerFlammables();
    }

    private static void registerFuels(){
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.PEAT_BRICK, 200);

    }

    private static void registerCommands(){
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
    }

    private static void registerStrippables(){
        StrippableBlockRegistry.register(ModBlocks.DRIFTWOOD_LOG, ModBlocks.STRIPPED_DRIFTWOOD_LOG);
        StrippableBlockRegistry.register(ModBlocks.DRIFTWOOD_WOOD, ModBlocks.STRIPPED_DRIFTWOOD_WOOD);
    }

    private static void registerFlammables(){
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DRIFTWOOD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_LEAVES, 30, 60);
    }

    private static void registerEvents(){
        AttackEntityCallback.EVENT.register(new AttackEntityHandler());
        ServerPlayerEvents.COPY_FROM.register(new PlayerCopyHandler());
    }

    private static void registerPotionRecipes(){
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.PINK_GARNET, ModPotions.SLIMEY_POTION);
    }
}
