package io.github.gawdserver.tp.commands;

import io.github.gawdserver.api.events.Command;
import io.github.gawdserver.api.perms.Permissions;
import io.github.gawdserver.api.player.Sender;
import io.github.gawdserver.api.utils.Chat;
import io.github.gawdserver.tp.Teleport;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class Tpa implements Command {

    @Override
    public void playerCommand(String player, String[] args) {
        if (!Permissions.hasPermission(player, "tp.tpa.to")) {
            Chat.sendMessage(player, "No permission.");
            return;
        }
        if (args.length > 0) {
            Teleport.addRequest(player, args[0]);
            Chat.sendMessage(player, "Teleport request sent to " + args[0]);
            Chat.sendMessage(args[0], player + " has requested to teleport to you. Type \"!tpaccept\" to accept.");
        } else {
            Chat.sendMessage(player, "Use: !tpa <username>");
        }
    }

    @Override
    public void serverCommand(Sender sender, String[] args) {
        Chat.sendMessage(Sender.CONSOLE.name(), "Use command as player.");
    }
}
