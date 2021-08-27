package com.manueh.winxclubreborn.common.items;

import com.manueh.winxclubreborn.common.entity.CompuExplosionThrown;
import com.manueh.winxclubreborn.common.entity.PowerBallThrown;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PowerBall extends Item {

    public PowerBall(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack item = player.getItemInHand(hand);
        player.awardStat(Stats.ITEM_USED.get(this));
        if (!level.isClientSide) {
            PowerBallThrown projectile = new PowerBallThrown(player, level);
            projectile.setItem(item);
            projectile.shootFromRotation(player, player.getViewXRot(0), player.getViewYRot(0), 0.0F, 3F, 0F);
            level.addFreshEntity(projectile);
        }
        return InteractionResultHolder.sidedSuccess(item, level.isClientSide());
    }
}