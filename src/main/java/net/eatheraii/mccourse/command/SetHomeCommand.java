package net.eatheraii.mccourse.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.eatheraii.mccourse.util.IEntityDataSaver;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class SetHomeCommand {

    public static void register(CommandDispatcher<ServerCommandSource> serverCommandSourceDispatcher,
                                CommandRegistryAccess commandRegistryAccess,
                                CommandManager.RegistrationEnvironment registrationEnvironment){
        serverCommandSourceDispatcher.register(CommandManager.literal("home") //the command after the slash
                .then(CommandManager.literal("set").executes(SetHomeCommand::run))); //executes set home command run method
        //home set
    }

    public static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException{
        IEntityDataSaver player = (IEntityDataSaver) context.getSource().getPlayer();
        BlockPos playerPos = context.getSource().getPlayer().getBlockPos();
        //now going to turn this to a string which will be used for feed back.
        String positionString = "(" + playerPos.getX() + ", " + playerPos.getY() + ", " + playerPos.getZ() + ")";

        //players coords are saved in nbt data with this key as an array
        player.getPersistentData().putIntArray("homepos", new int[] {playerPos.getX(), playerPos.getY(), playerPos.getZ()});

        context.getSource().sendFeedback(() -> Text.literal("Set Home At: " + positionString), true);
        return 1;
    }
}
