package net.eatheraii.mccourse;

import net.eatheraii.mccourse.block.ModBlocks;
import net.eatheraii.mccourse.effect.ModEffects;
import net.eatheraii.mccourse.item.ModItemGroup;
import net.eatheraii.mccourse.item.ModItems;
import net.eatheraii.mccourse.painting.ModPaintings;
import net.eatheraii.mccourse.particle.ModParticles;
import net.eatheraii.mccourse.potion.ModPotions;
import net.eatheraii.mccourse.sound.ModSounds;
import net.eatheraii.mccourse.util.ModLootTableModifiers;
import net.eatheraii.mccourse.util.ModRegistries;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCCourseMod implements ModInitializer {
	//we do however NEED the Mod ID here.
	public static final String MOD_ID = "mccourse";
	public static final Logger LOGGER = LoggerFactory.getLogger("mccourse");

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroup.registerItemGroups();

		ModRegistries.registerModStuffs();

		ModSounds.registerSounds();
		ModLootTableModifiers.modifyLootTables();

		ModPaintings.registerPaintings();

		ModEffects.registerEffects();

		ModPotions.registerPotions();

		ModParticles.registerParticles();
	}
}
