package com.davey.daveyguns.item.gun;

import com.mrcrayfish.guns.common.Gun;
import com.mrcrayfish.guns.item.GunItem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static com.davey.daveyguns.registry.ModItems.BANANA_PEEL;

public class BananaGun extends GunItem {

    public BananaGun(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        Gun modifiedGun = this.getModifiedGun(pStack);

        Player player = Minecraft.getInstance().player;

        if(!Gun.hasAmmo(pStack) && player != null && player.getItemInHand(InteractionHand.MAIN_HAND).equals(pStack)) {
            player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(BANANA_PEEL::get));
        }

        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }
}
