package tk.coolv1994.plugins.tp.commands;

import tk.coolv1994.gawdapi.Gawd;
import tk.coolv1994.gawdapi.events.Command;
import tk.coolv1994.gawdapi.perms.Permissions;
import tk.coolv1994.gawdapi.utils.Chat;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class TpPos implements Command {
    @Override
    public void onCommand(String player, String[] args) {
        if (!Permissions.hasPermission(player, "tp.tppos")) {
            Chat.sendMessage(player, "No permission.");
            return;
        }
        if (args.length >= 3) {
            // tppos Player X Y Z
            Gawd.sendCommand(String.format("tp %s %s %s %s", player, args[0], args[1], args[2]));
        } else {
            Chat.sendMessage(player, "Use: !tppos <x> <y> <z>");
        }
    }
}
