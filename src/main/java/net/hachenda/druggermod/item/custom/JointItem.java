package net.hachenda.druggermod.item.custom;

import net.hachenda.druggermod.item.ModItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class JointItem extends PotionItem {

    public JointItem(Settings settings) {
        super(settings);
    }

    private void jointEffects(LivingEntity player){
        player.setStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 350, 0),player);
        player.setStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 350, 0),player);
        player.setStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 700, 3),player);
        player.setStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 8000, 1),player);
        player.setStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 8000, 0),player);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        PlayerEntity playerEntity;
        PlayerEntity playerEntity2 = playerEntity = user instanceof PlayerEntity ? (PlayerEntity)user : null;
        if (playerEntity instanceof ServerPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger((ServerPlayerEntity)playerEntity, stack);
        }
        if (playerEntity != null) {
            playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            if (!playerEntity.getAbilities().creativeMode) {
                stack.decrement(1);
            }
        }
        if (playerEntity == null || !playerEntity.getAbilities().creativeMode) {
            jointEffects(user);
        }
        //user.emitGameEvent(GameEvent.DRINK);
        return stack;
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        return ModItems.JOINT.getTranslationKey();
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }
}