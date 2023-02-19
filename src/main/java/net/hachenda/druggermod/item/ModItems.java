package net.hachenda.druggermod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hachenda.druggermod.DruggerMod;
import net.hachenda.druggermod.block.ModBlocks;
import net.hachenda.druggermod.item.custom.JointItem;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item WEED_SEEDS = registerItem("weed_seeds",
            new AliasedBlockItem(ModBlocks.WEED_CROP,
                    new FabricItemSettings()));

    public static final Item WEED = registerItem("weed",
            new Item(new FabricItemSettings()));

    public static final Item PROCESSED_WEED = registerItem("processed_weed",
            new Item(new FabricItemSettings()));

    public static final Item SPECIAL_BROWNIE = registerItem("special_brownie",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(10).saturationModifier(0f).alwaysEdible()
                    .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 500, 0), 0.8f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 500, 0), 0.8f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 1000, 3), 0.8f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 12000, 1), 0.7f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 12000, 0), 0.7f)
                    .build())
            )
    );

    public static final Item SPECIAL_COOKIE = registerItem("special_cookie",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0f).alwaysEdible().snack()
                    .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 100, 0), 0.8f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 100, 0), 0.8f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 250, 3), 0.8f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 3000, 1), 0.4f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 3000, 0), 0.4f)
                    .build())
            )
    );

    public static final Item JOINT = registerItem("joint",
            new JointItem(new FabricItemSettings().maxCount(8)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(DruggerMod.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.FUMETEO_REMIX, WEED_SEEDS);
        addToItemGroup(ModItemGroup.FUMETEO_REMIX, WEED);
        addToItemGroup(ModItemGroup.FUMETEO_REMIX, PROCESSED_WEED);
        addToItemGroup(ModItemGroup.FUMETEO_REMIX, SPECIAL_BROWNIE);
        addToItemGroup(ModItemGroup.FUMETEO_REMIX, SPECIAL_COOKIE);
        addToItemGroup(ModItemGroup.FUMETEO_REMIX, JOINT);


    }

    public static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModItems() {
        DruggerMod.LOGGER.info("Registering Mod Items for " + DruggerMod.MOD_ID);

        addItemsToItemGroup();
    }
}
