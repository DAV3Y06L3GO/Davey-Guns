package com.davey.daveyguns;

import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
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

    // Creative tab
public static final CreativeModeTab GROUP = new CreativeModeTab.Builder(CreativeModeTab.Row.TOP, 1)
            .title(Component.translatable("itemGroup.davey_guns.creativeTab"))
            .icon(() -> {  return new ItemStack(Items.POTATO);  })
            .displayItems((smth, tab) -> {
                tab.accept(Items.ACACIA_LOG);
            })
            .build();


    public DaveyGuns()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.register(this);



        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::ClientSetup);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void ClientSetup(final FMLClientSetupEvent event) {

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {

    }


}
