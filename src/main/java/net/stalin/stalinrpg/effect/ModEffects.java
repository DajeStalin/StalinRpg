package net.stalin.stalinrpg.effect;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.stalin.stalinrpg.StalinRpg;

public class ModEffects {
    public static final DeferredRegister<Effect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.POTIONS, StalinRpg.MOD_ID);

    public static final RegistryObject<Effect> FREEZE = MOB_EFFECTS.register("freeze",
            () -> new FreezeEffect(EffectType.HARMFUL, 3124687));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
