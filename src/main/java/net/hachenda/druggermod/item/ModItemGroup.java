package net.hachenda.druggermod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hachenda.druggermod.DruggerMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup FUMETEO_REMIX;

    public static void registerItemGroups() {
        FUMETEO_REMIX = FabricItemGroup.builder(new Identifier(DruggerMod.MOD_ID, "fumeteo_remix"))
                .displayName(Text.translatable("itemgroup.fumeteo_remix"))
                .icon(() -> new ItemStack(ModItems.WEED)).build();
    }
}
