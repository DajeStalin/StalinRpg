package net.stalin.stalinrpg.init;

import net.minecraftforge.common.capabilities.CapabilityManager;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.capability.GenericCapabilityStorage;
import net.stalin.stalinrpg.capability.experiance.IBaseExperienceCapability;
import net.stalin.stalinrpg.capability.experiance.PlayerExperienceCapabilityFactory;

public class ModCapability {
    public static final PlayerExperienceCapabilityFactory EXP_FACTORY = new PlayerExperienceCapabilityFactory();

    public static void register() {
        CapabilityManager.INSTANCE.register(IBaseExperienceCapability.class,
                new GenericCapabilityStorage<IBaseExperienceCapability>(),
                EXP_FACTORY);
        StalinRpg.LOGGER.info("-----> Capabilities registrados");

    }
}
