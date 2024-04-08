package net.eatheraii.mccourse.util;

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
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.potion.Potions;

public class ModRegistries {
    public static void registerModStuffs(){
        registerFuels();
        registerCommands();
        registerEvents();
        registerPotionRecipes();
    }

    private static void registerFuels(){
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.PEAT_BRICK, 200);

    }

    private static void registerCommands(){
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
    }

    private static void registerEvents(){
        AttackEntityCallback.EVENT.register(new AttackEntityHandler());
        ServerPlayerEvents.COPY_FROM.register(new PlayerCopyHandler());
    }

    private static void registerPotionRecipes(){
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.PINK_GARNET, ModPotions.SLIMEY_POTION);
    }
}
