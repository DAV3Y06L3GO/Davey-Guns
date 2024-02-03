package com.davey.daveyguns.registry;

import com.davey.daveyguns.DaveyGuns;
import com.davey.daveyguns.item.gun.BananaGun;
import com.mrcrayfish.guns.item.AmmoItem;
import com.mrcrayfish.guns.item.GunItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DaveyGuns.MOD_ID);

    // Gun test
    public static final RegistryObject<GunItem> SANITY_CHECK = ITEMS.register("sanity_check",
            () -> new GunItem(new Item.Properties().stacksTo(1)));

    // Gun Registry
    public static final RegistryObject<GunItem> BANANA = ITEMS.register("banana",
            () -> new BananaGun(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BANANA_PEEL = ITEMS.register("banana_peel",
            () -> new Item(new Item.Properties()));

    // Ammo Registry
    public static final RegistryObject<Item> BANANA_AMMO = ITEMS.register("banana_ammo",
            () -> new AmmoItem(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
