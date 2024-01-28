package pycraft;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import org.python.core.PyFunction;

public class Command {
    public static void register(String name, PyFunction function) {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated, environment) ->
                dispatcher.register(CommandManager.literal(name).executes(context -> {
                    function.__call__();
                    return 1;
                }))
        );
    }
}