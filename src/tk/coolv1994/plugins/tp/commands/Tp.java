package tk.coolv1994.plugins.tp.commands;

import tk.coolv1994.gawdserver.events.Command;
import tk.coolv1994.gawdserver.launcher.Launch;
import tk.coolv1994.gawdserver.perms.Permissions;
import tk.coolv1994.gawdserver.utils.Chat;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class Tp implements Command {
    @Override
    public void onCommand(String player, String[] args) {
        if (Permissions.getPermManager().hasPermission(player, "tp.tp")) {
            if (args.length >= 3) {
                // tp Player X Y Z
                Launch.sendCommand(String.format("tp %s %s %s %s", player, args[0], args[1], args[2]));
            } else if (args.length >= 1) {
                // tp Player Player2
                Launch.sendCommand(String.format("tp %s %s", player, args[0]));
            } else {
                Chat.sendMessage(player, "Use: !tp <username> or !tp <x> <y> <z>");
            }
        }
    }
}
