package pycraft;

public class Block extends net.minecraft.block.Block implements PyBlock {
    public Block() {
        super(Settings.copy(net.minecraft.block.Blocks.STONE));
    }

    public Block(Settings settings) {
        super(settings);
    }

    public void setCollidable(boolean collidable) {
        this.collidable = collidable;
    }

    public void setResistance(float resistance) {
        this.resistance = resistance;
    }

    public void setSlipperiness(float slipperiness) {
        this.slipperiness = slipperiness;
    }

    public void setVelocityMultiplier(float velocityMultiplier) {
        this.velocityMultiplier = velocityMultiplier;
    }

    public void setJumpVelocityMultiplier(float jumpVelocityMultiplier) {
        this.jumpVelocityMultiplier = jumpVelocityMultiplier;
    }


}