package pycraft;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.Input;

public class InputUtils {
    public static boolean areInputBlocked = false;
    public static void blockInput() {
        areInputBlocked = true;

        Input input = getInput();
        input.pressingForward = false;
        input.pressingBack = false;
        input.pressingLeft = false;
        input.pressingRight = false;
        input.jumping = false;
        input.sneaking = false;
    }
    public static void unblockInput() {
        areInputBlocked = false;
    }

    public static void setPressingForward(boolean pressingForward) {
        getInput().pressingForward = pressingForward;
    }

    public static void setPressingBack(boolean pressingBack) {
        getInput().pressingBack = pressingBack;
    }

    public static void setPressingLeft(boolean pressingLeft) {
        getInput().pressingLeft = pressingLeft;
    }

    public static void setPressingRight(boolean pressingRight) {
        getInput().pressingRight = pressingRight;
    }

    public static void setPressingShift(boolean pressingShift) {
        getInput().sneaking = pressingShift;
    }

    public static void setPressingJump(boolean pressingJump) {
        getInput().jumping = pressingJump;
    }


    public static Input getInput(){
        if (MinecraftClient.getInstance().player == null) return null;
        return MinecraftClient.getInstance().player.input;
    }
}
