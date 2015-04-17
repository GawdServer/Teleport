package tk.coolv1994.plugins.tp.commands;

import tk.coolv1994.gawdapi.events.Command;
import tk.coolv1994.gawdapi.perms.Permissions;
import tk.coolv1994.gawdapi.utils.Chat;
import tk.coolv1994.plugins.tp.Teleport;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class Tpa implements Command {
    @Override
    public void onCommand(String player, String[] args) {
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
}
