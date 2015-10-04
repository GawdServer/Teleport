package io.github.gawdserver.tp.commands;

import io.github.gawdserver.api.Server;
import io.github.gawdserver.api.events.Command;
import io.github.gawdserver.api.perms.Permissions;
import io.github.gawdserver.api.player.Sender;
import io.github.gawdserver.api.utils.Chat;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class Tp implements Command {

    @Override
    public void playerCommand(String player, String[] args) {
        if (!Permissions.hasPermission(player, "tp.tp")) {
            Chat.sendMessage(player, "No permission.");
            return;
        }
        if (args.length >= 3) {
            // tp Player X Y Z
            Server.sendCommand(String.format("tp %s %s %s %s", player, args[0], args[1], args[2]));
        } else if (args.length >= 1) {
            // tp Player Player2
            Server.sendCommand(String.format("tp %s %s", player, args[0]));
        } else {
            Chat.sendMessage(player, "Use: !tp <username> or !tp <x> <y> <z>");
        }
    }

    @Override
    public void serverCommand(Sender sender, String[] args) {
        Chat.sendMessage(Sender.CONSOLE.name(), "Use command as player.");
    }
}
