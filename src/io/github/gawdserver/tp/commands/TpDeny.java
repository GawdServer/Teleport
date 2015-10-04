package io.github.gawdserver.tp.commands;

import io.github.gawdserver.api.events.Command;
import io.github.gawdserver.api.perms.Permissions;
import io.github.gawdserver.api.player.Sender;
import io.github.gawdserver.api.utils.Chat;
import io.github.gawdserver.tp.Teleport;

/**
 * Created by Vinnie on 2/18/2015.
 */
public class TpDeny implements Command {

    @Override
    public void playerCommand(String player, String[] args) {
        if (!Permissions.hasPermission(player, "tp.tpa.deny")) {
            Chat.sendMessage(player, "No permission.");
            return;
        }
        if (Teleport.removeRequest(player)) {
            Chat.sendMessage(player, "Teleport request denied.");
        } else {
            Chat.sendMessage(player, "You do not have pending requests.");
        }
    }

    @Override
    public void serverCommand(Sender sender, String[] args) {
        Chat.sendMessage(Sender.CONSOLE.name(), "Use command as player.");
    }
}
