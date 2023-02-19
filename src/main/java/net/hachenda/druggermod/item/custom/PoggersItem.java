package net.hachenda.druggermod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PoggersItem extends Item {

    public PoggersItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient() && hand == hand.MAIN_HAND){
            outputRandomNumber(user);
            user.getItemCooldownManager().set(this, 40);
        }
        return super.use(world, user, hand);
    }

    private void outputRandomNumber(PlayerEntity player){
        player.sendMessage(Text.literal(player.getEntityName() + " es un pepega"));
    }
}
