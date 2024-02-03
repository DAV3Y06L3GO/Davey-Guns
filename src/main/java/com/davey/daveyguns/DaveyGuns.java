package com.davey.daveyguns;

import com.davey.daveyguns.client.ClientHandler;
import com.davey.daveyguns.registry.ModItems;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.CreativeModeTabRegistry;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DaveyGuns.MOD_ID)
public class DaveyGuns
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "davey_guns";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();




    public DaveyGuns()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        modEventBus.register(this);

        ModItems.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::onClientSetup);

        // Register the item to a creative tab
        modEventBus.addListener(ClientHandler::onRegisterCreativeModeTab);
    }

    private void onClientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(ClientHandler::registerModelOverrides);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }



}
