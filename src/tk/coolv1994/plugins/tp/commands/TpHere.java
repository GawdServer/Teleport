package tk.coolv1994.plugins.tp.commands;

import tk.coolv1994.gawdapi.Gawd;
import tk.coolv1994.gawdapi.events.Command;
import tk.coolv1994.gawdapi.perms.Permissions;
import tk.coolv1994.gawdapi.utils.Chat;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class TpHere implements Command {
    @Override
    public void onCommand(String player, String[] args) {
        if (!Permissions.hasPermission(player, "tp.tphere")) {
            Chat.sendMessage(player, "No permission.");
            return;
        }
        if (args.length >= 1) {
            Gawd.sendCommand(String.format("tp %s %s", args[0], player));
        } else {
            Chat.sendMessage(player, "Use: !tphere <username>");
        }
    }
}
