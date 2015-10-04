package io.github.gawdserver.tp.commands;

import io.github.gawdserver.api.Server;
import io.github.gawdserver.api.events.Command;
import io.github.gawdserver.api.perms.Permissions;
import io.github.gawdserver.api.player.Sender;
import io.github.gawdserver.api.utils.Chat;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class TpHere implements Command {

    @Override
    public void playerCommand(String player, String[] args) {
        if (!Permissions.hasPermission(player, "tp.tphere")) {
            Chat.sendMessage(player, "No permission.");
            return;
        }
        if (args.length >= 1) {
            Server.sendCommand(String.format("tp %s %s", args[0], player));
        } else {
            Chat.sendMessage(player, "Use: !tphere <username>");
        }
    }

    @Override
    public void serverCommand(Sender sender, String[] args) {
        Chat.sendMessage(Sender.CONSOLE.name(), "Use command as player.");
    }
}
