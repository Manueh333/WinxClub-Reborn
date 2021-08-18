package com.manueh.winxclubreborn.common.items;

import com.manueh.winxclubreborn.common.entity.SoundWaveThrown;
import com.manueh.winxclubreborn.common.entity.WolfClawThrown;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class WolfClaw extends SwordItem {

    public WolfClaw(Tier tier, int valueInt, float valueFloat, Properties properties) {
        super(tier, valueInt, valueFloat, properties);

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack item = player.getItemInHand(hand);
        player.awardStat(Stats.ITEM_USED.get(this));
        if (!level.isClientSide) {
            WolfClawThrown projectile = new WolfClawThrown(player, level);
            projectile.setItem(item);
            projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3F, 0F);
            level.addFreshEntity(projectile);
        }
        return InteractionResultHolder.sidedSuccess(item, level.isClientSide());
    }
}