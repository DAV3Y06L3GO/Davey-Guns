package com.davey.daveyguns.client;

import com.davey.daveyguns.DaveyGuns;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.davey.daveyguns.DaveyGuns.MOD_ID;

@Mod.EventBusSubscriber(
        modid = MOD_ID,
        value = {Dist.CLIENT}
)
public enum SpecialModels {
    SANITY_CHECK("guns/banana"),
    BANANA("guns/banana");


    private final ResourceLocation modelLoc;
    private BakedModel cachedModel;

    SpecialModels(String modelName) {
        this.modelLoc = new ResourceLocation(DaveyGuns.MOD_ID, "special/" + modelName);
    }

    public BakedModel getModel() {
        if (this.cachedModel == null) {
            this.cachedModel = Minecraft.getInstance().getModelManager().getModel(this.modelLoc);
        }
        return this.cachedModel;
    }

    @SubscribeEvent
    public static void registerAdditional(final ModelEvent.RegisterAdditional event) {
        for (SpecialModels specialModel : values()) {
            event.register(specialModel.modelLoc);
        }
    }

    @SubscribeEvent
    public static void onBake(final ModelEvent.BakingCompleted event) {
        for (SpecialModels specialModel : values()) {
            specialModel.cachedModel = null;
        }
    }

}
