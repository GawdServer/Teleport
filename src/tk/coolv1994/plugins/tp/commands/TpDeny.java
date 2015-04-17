package tk.coolv1994.plugins.tp.commands;

import tk.coolv1994.gawdapi.events.Command;
import tk.coolv1994.gawdapi.perms.Permissions;
import tk.coolv1994.gawdapi.utils.Chat;
import tk.coolv1994.plugins.tp.Teleport;

/**
 * Created by Vinnie on 2/18/2015.
 */
public class TpDeny implements Command {
    @Override
    public void onCommand(String player, String[] args) {
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
}
