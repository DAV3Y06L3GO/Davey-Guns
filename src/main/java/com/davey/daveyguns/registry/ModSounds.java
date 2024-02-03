package com.davey.daveyguns.registry;

import com.davey.daveyguns.DaveyGuns;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DaveyGuns.MOD_ID);

    public static final RegistryObject<SoundEvent> PEW = register("item.pew");

    public static  final RegistryObject<SoundEvent> RELOAD = register("item.reload");



    private static RegistryObject<SoundEvent> register(String key) {

        return SOUNDS.register(key, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DaveyGuns.MOD_ID, key)));

    }
}
