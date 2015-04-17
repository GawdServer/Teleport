package tk.coolv1994.plugins.tp.commands;

import tk.coolv1994.gawdapi.Gawd;
import tk.coolv1994.gawdapi.events.Command;
import tk.coolv1994.gawdapi.perms.Permissions;
import tk.coolv1994.gawdapi.utils.Chat;
import tk.coolv1994.gawdapi.utils.ColorCodes;
import tk.coolv1994.plugins.tp.Teleport;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class TpAccept implements Command {
    @Override
    public void onCommand(String player, String[] args) {
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
            Gawd.sendCommand(String.format("tp %s %s", player, player2));
            Teleport.removeRequest(player);
        } else {
            //TPA
            Chat.sendMessage(player2, "Teleporting to" + player);
            Gawd.sendCommand(String.format("tp %s %s", player2, player));
            Teleport.removeRequest(player);
        }
    }
}
