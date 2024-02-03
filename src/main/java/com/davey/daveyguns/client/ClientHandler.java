package com.davey.daveyguns.client;

import com.davey.daveyguns.registry.ModItems;
import com.mrcrayfish.guns.client.render.gun.ModelOverrides;
import com.mrcrayfish.guns.client.render.gun.model.SimpleModel;
import com.mrcrayfish.guns.item.GunItem;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.fml.common.Mod;

import static com.davey.daveyguns.DaveyGuns.MOD_ID;

@Mod.EventBusSubscriber(
        modid = MOD_ID,
        value = {Dist.CLIENT}
)

public class ClientHandler {

    public static void registerModelOverrides() {
        ModelOverrides.register(ModItems.BANANA.get(), new SimpleModel(SpecialModels.BANANA::getModel));

        ModelOverrides.register(ModItems.SANITY_CHECK.get(), new SimpleModel(SpecialModels.BANANA::getModel));
    }




    public static void onRegisterCreativeModeTab(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(MOD_ID, "creative_tab"), (builder) -> {
            builder.title(Component.translatable("itemGroup.davey_guns.creativeTab"));
            builder.icon(() -> new ItemStack(Items.POTATO));

            builder.displayItems((flag, tab) -> {
                tab.accept(modifyCreativeGunItem(tab, ModItems.SANITY_CHECK.get()));
                tab.accept(modifyCreativeGunItem(tab, ModItems.BANANA.get()));
                tab.accept(ModItems.BANANA_PEEL.get());
            });
        });


    }

    private static ItemStack modifyCreativeGunItem(CreativeModeTab.Output tab, GunItem item) {
        ItemStack stack = new ItemStack(item);
        stack.getOrCreateTag().putInt("AmmoCount", item.getGun().getGeneral().getMaxAmmo());
        return stack;
    }

}
