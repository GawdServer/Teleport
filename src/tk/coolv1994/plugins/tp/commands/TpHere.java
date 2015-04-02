package tk.coolv1994.plugins.tp.commands;

import tk.coolv1994.gawdserver.events.Command;
import tk.coolv1994.gawdserver.launcher.Launch;
import tk.coolv1994.gawdserver.perms.Permissions;
import tk.coolv1994.gawdserver.utils.Chat;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class TpHere implements Command {
    @Override
    public void onCommand(String player, String[] args) {
        if (Permissions.getPermManager().hasPermission(player, "tp.tphere")) {
            if (args.length >= 1) {
                Launch.sendCommand(String.format("tp %s %s", args[0], player));
            } else {
                Chat.sendMessage(player, "Use: !tphere <username>");
            }
        }
    }
}
