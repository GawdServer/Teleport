package io.github.gawdserver.tp.commands;

import io.github.gawdserver.api.Server;
import io.github.gawdserver.api.events.Command;
import io.github.gawdserver.api.perms.Permissions;
import io.github.gawdserver.api.player.Sender;
import io.github.gawdserver.api.utils.Chat;
import io.github.gawdserver.api.utils.ColorCodes;
import io.github.gawdserver.tp.Teleport;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class TpAccept implements Command {

    @Override
    public void playerCommand(String player, String[] args) {
        if (!Permissions.hasPermission(player, "tp.tpa.accept")) {
            Chat.sendMessage(player, "No permission.");
            return;
        }
        if (!Teleport.hasRequest(player)) {
            Chat.sendMessage(player, "You do not have pending requests.");
            return;
        }
        String player2 = Teleport.getRequest(player);
        if (player2.startsWith(ColorCodes.selectionSymbol)) {
            player2 = player2.substring(1);
            //TPAHERE
            Chat.sendMessage(player, "Teleporting to " + player2);
            Server.sendCommand(String.format("tp %s %s", player, player2));
            Teleport.removeRequest(player);
        } else {
            //TPA
            Chat.sendMessage(player2, "Teleporting to" + player);
            Server.sendCommand(String.format("tp %s %s", player2, player));
            Teleport.removeRequest(player);
        }
    }

    @Override
    public void serverCommand(Sender sender, String[] args) {
        Chat.sendMessage(Sender.CONSOLE.name(), "Use command as player.");
    }
}
