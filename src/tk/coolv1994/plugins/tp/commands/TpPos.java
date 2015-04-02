package tk.coolv1994.plugins.tp.commands;

import tk.coolv1994.gawdserver.events.Command;
import tk.coolv1994.gawdserver.launcher.Launch;
import tk.coolv1994.gawdserver.perms.Permissions;
import tk.coolv1994.gawdserver.utils.Chat;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class TpPos implements Command {
    @Override
    public void onCommand(String player, String[] args) {
        if (Permissions.getPermManager().hasPermission(player, "tp.tppos")) {
            if (args.length >= 3) {
                // tppos Player X Y Z
                Launch.sendCommand(String.format("tp %s %s %s %s", player, args[0], args[1], args[2]));
            } else {
                Chat.sendMessage(player, "Use: !tppos <x> <y> <z>");
            }
        }
    }
}
