package net.stalin.stalinrpg.keybind;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.client.gui.OpenGUI;
import net.stalin.stalinrpg.network.networking.Networking;
import net.stalin.stalinrpg.network.networking.skills.Explode;
import net.stalin.stalinrpg.network.networking.skills.FireBall;
import net.stalin.stalinrpg.network.networking.skills.LightningBolt;
import net.stalin.stalinrpg.network.networking.stats.SendPackAddStrength;
import org.lwjgl.glfw.GLFW;


@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class KeyBoardInput {
    public static final KeyBinding OPEN_GUI_KEY = new KeyBinding("Open GUI",
            KeyConflictContext.IN_GAME,
            KeyModifier.NONE,
            InputMappings.Type.KEYSYM,
            GLFW.GLFW_KEY_H,
            "Other");
    public static final KeyBinding LIGHTNING_BOLD_KEY = new KeyBinding("Lightning bolt",
            KeyConflictContext.IN_GAME,
            KeyModifier.SHIFT,
            InputMappings.Type.KEYSYM,
            GLFW.GLFW_KEY_K,
            "Class Mage");
    public static final KeyBinding FIREBALL_KEY = new KeyBinding("Fireball",
            KeyConflictContext.IN_GAME,
            KeyModifier.SHIFT,
            InputMappings.Type.KEYSYM,
            GLFW.GLFW_KEY_L,
            "Class Mage");
    public static final KeyBinding EXPLODE_KEY = new KeyBinding("Explode",
            KeyConflictContext.IN_GAME,
            KeyModifier.SHIFT,
            InputMappings.Type.KEYSYM,
            GLFW.GLFW_KEY_O,
            "Class Mage");

    @SubscribeEvent
    public static void openMenu(InputEvent.KeyInputEvent event) {
        if (OPEN_GUI_KEY.isDown()) {
            assert Minecraft.getInstance().player != null;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenGUI::new);
        }
    }

    @SubscribeEvent
    public static void LightningBoltSkill(InputEvent.KeyInputEvent event) {
        if (LIGHTNING_BOLD_KEY.isDown()) {
            Minecraft mc = Minecraft.getInstance();
            World world = mc.level;
            PlayerEntity player = mc.player;

            //RAY END POINT - TO WHERE IT WILL TRAVEL TO
            Double rayLength = new Double(100);
            Vector3d playerRotation = player.getViewVector(0);
            Vector3d rayPath = playerRotation.scale(rayLength);

            //RAY START AND END POINTS
            Vector3d from = player.getEyePosition(0);
            Vector3d to = from.add(rayPath);

            //CREATE THE RAY
            RayTraceContext rayCtx = new RayTraceContext(from, to, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, null);
            //CAST THE RAY
            BlockRayTraceResult rayHit = world.clip(rayCtx);

            //CHECK THE RESULTS
            if (rayHit.getType() == RayTraceResult.Type.MISS){
                //IF RAY MISSED
            }
            else {
                //IF RAY HIT SOMETHING
                double x = rayHit.getLocation().x;
                double y = rayHit.getLocation().y;
                double z = rayHit.getLocation().z;
                Networking.INSTANCE.sendToServer(new LightningBolt(x, y, z));
            }
        }
    }

    @SubscribeEvent
    public static void fireBallSkill(InputEvent.KeyInputEvent event) {
        Minecraft mc = Minecraft.getInstance();
        PlayerEntity player = mc.player;
        if (FIREBALL_KEY.isDown()) {
            Vector3d vec3 = player.getEyePosition(0F);
            double x = vec3.x;
            double y = vec3.y;
            double z = vec3.z;
            Networking.INSTANCE.sendToServer(new FireBall(x, y, z));
        }
    }

    @SubscribeEvent
    public static void ExplodeSkill(InputEvent.KeyInputEvent event) {
        Minecraft mc = Minecraft.getInstance();
        PlayerEntity player = mc.player;
        if (EXPLODE_KEY.isDown()) {
            double x = player.getX();
            double y = player.getY();
            double z = player.getZ();
            Networking.INSTANCE.sendToServer(new Explode(x, y, z));
        }
    }
}

