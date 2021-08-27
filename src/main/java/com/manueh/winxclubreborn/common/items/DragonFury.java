package com.manueh.winxclubreborn.common.items;

import com.manueh.winxclubreborn.common.entity.DragonFuryThrown;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class DragonFury extends Item {

    public DragonFury(Item.Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        ItemStack item = player.getItemInHand(hand);
        player.awardStat(Stats.ITEM_USED.get(this));
        if (!level.isClientSide) {
            DragonFuryThrown projectile = new DragonFuryThrown(player, level);
            projectile.setItem(item);
            projectile.shootFromRotation(player, player.getViewXRot(0), player.getViewYRot(0), 0.0F, 3F, 0F);
            level.addFreshEntity(projectile);
        }
        return ActionResult.sidedSuccess(item, level.isClientSide());
    }
}