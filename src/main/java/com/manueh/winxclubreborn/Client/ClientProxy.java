package com.manueh.winxclubreborn.Client;

import com.manueh.winxclubreborn.common.models.WingsModel;
import com.manueh.winxclubreborn.core.IProxy;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.eventbus.api.IEventBus;

public class ClientProxy implements IProxy {

    private HumanoidModel<LivingEntity> wingModel = new HumanoidModel(WingsModel.createModel());

    @Override
    public void setup(IEventBus paramIEventBus1, IEventBus paramIEventBus2) {

    }


    public HumanoidModel<LivingEntity> getWingModel() {
        return wingModel;
    }
}
