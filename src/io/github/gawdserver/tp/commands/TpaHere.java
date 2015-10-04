package io.github.gawdserver.tp.commands;

import io.github.gawdserver.api.events.Command;
import io.github.gawdserver.api.perms.Permissions;
import io.github.gawdserver.api.player.Sender;
import io.github.gawdserver.api.utils.Chat;
import io.github.gawdserver.api.utils.ColorCodes;
import io.github.gawdserver.tp.Teleport;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class TpaHere implements Command {

    @Override
    public void playerCommand(String player, String[] args) {
        if (!Permissions.hasPermission(player, "tp.tpa.here")) {
            Chat.sendMessage(player, "No permission.");
            return;
        }
        if (args.length > 0) {
            Teleport.addRequest(ColorCodes.selectionSymbol + player, args[0]);
            Chat.sendMessage(player, "Teleport request sent to " + args[0]);
            Chat.sendMessage(args[0], player + " has requested that you teleport to them. Type \"!tpaccept\" to accept.");
        } else {
            Chat.sendMessage(player, "Use: !tpahere <username>");
        }
    }

    @Override
    public void serverCommand(Sender sender, String[] args) {
        Chat.sendMessage(Sender.CONSOLE.name(), "Use command as player.");
    }
}
