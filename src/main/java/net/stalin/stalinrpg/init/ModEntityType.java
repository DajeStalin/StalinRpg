//package net.stalin.stalinrpg.init;
//
//import net.minecraft.entity.EntityClassification;
//import net.minecraft.entity.EntityType;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.fml.RegistryObject;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.stalin.stalinrpg.StalinRpg;
//import net.stalin.stalinrpg.entities.HogEntity;
//
//public class ModEntityType {
//
//    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, StalinRpg.MOD_ID);
//
//    public static final RegistryObject<EntityType<HogEntity>> HOG = ENTITY_TYPES.register("hog",
//            () -> EntityType.Builder.of(HogEntity::new, EntityClassification.CREATURE)
//                    .sized(1.0f, 1.0f) // Hitbox Size
//                    .build(new ResourceLocation(StalinRpg.MOD_ID, "hog").toString()));
//}
