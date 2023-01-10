package net.stalin.stalinrpg.item.models3d.armor.renderer;

import net.stalin.stalinrpg.item.models3d.armor.items.VampireLeatherHeadItem;
import net.stalin.stalinrpg.item.models3d.armor.model.VampireLeatherHeadModel;
import net.stalin.stalinrpg.test.armor.GeckoTestArmorItem;
import net.stalin.stalinrpg.test.armor.GeckoTestArmorModel;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class VampireLeatherHeadRenderer extends GeoArmorRenderer<VampireLeatherHeadItem> {
    public VampireLeatherHeadRenderer() {
        super(new VampireLeatherHeadModel());

        // These values are what each bone name is in blockbench. So if your head bone
        // is named "bone545", make sure to do this.headBone = "bone545";
        // The default values are the ones that come with the default armor template in
        // the geckolib blockbench plugin.
        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";
    }
}
