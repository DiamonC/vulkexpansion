package io.github.diamonc.vulkexpansion;

import io.github.diamonc.vulkexpansion.entity.StalkerMob;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VulkExpansion implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Vulk Expansion");
	public static final Item VULK_CRYSTAL = new Item(new QuiltItemSettings().group(ItemGroup.MISC));
	public static final EntityType<StalkerMob> STALKER = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier("vulkexpansion", "stalker"),
			FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, StalkerMob::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
	);
	public static final Block VULK_STONE = new Block(QuiltBlockSettings.of(Material.STONE).strength(4.0f));
	@Override
	public void onInitialize(ModContainer mod) {
		//Vulk Crystal Item
		Registry.register(Registry.ITEM, new Identifier("vulkexpansion", "vulk_crystal"), VULK_CRYSTAL);
		//Vulk Stone Block
		Registry.register(Registry.BLOCK, new Identifier("vulkexpansion", "vulk_stone"), VULK_STONE);
		Registry.register(Registry.ITEM, new Identifier("vulkexpansion", "vulk_stone"), new BlockItem(VULK_STONE, new QuiltItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		LOGGER.info("Hello Quilt world from {}!", mod.metadata().name());

	}
}
