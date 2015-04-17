package tk.coolv1994.plugins.tp.commands;

import tk.coolv1994.gawdapi.Gawd;
import tk.coolv1994.gawdapi.events.Command;
import tk.coolv1994.gawdapi.perms.Permissions;
import tk.coolv1994.gawdapi.utils.Chat;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class Tp implements Command {
    @Override
    public void onCommand(String player, String[] args) {
        if (!Permissions.hasPermission(player, "tp.tp")) {
            Chat.sendMessage(player, "No permission.");
            return;
        }
        if (args.length >= 3) {
            // tp Player X Y Z
            Gawd.sendCommand(String.format("tp %s %s %s %s", player, args[0], args[1], args[2]));
        } else if (args.length >= 1) {
            // tp Player Player2
            Gawd.sendCommand(String.format("tp %s %s", player, args[0]));
        } else {
            Chat.sendMessage(player, "Use: !tp <username> or !tp <x> <y> <z>");
        }
    }
}
