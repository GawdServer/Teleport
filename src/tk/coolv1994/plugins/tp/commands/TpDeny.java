package tk.coolv1994.plugins.tp.commands;

import tk.coolv1994.gawdserver.events.Command;
import tk.coolv1994.gawdserver.utils.Chat;
import tk.coolv1994.plugins.tp.Teleport;

/**
 * Created by Vinnie on 2/18/2015.
 */
public class TpDeny implements Command {
    @Override
    public void onCommand(String player, String[] args) {
        String deny = Teleport.requests.remove(player);
        if (deny != null) {
            Chat.sendMessage(player, "Teleport request denied.");
        } else {
            Chat.sendMessage(player, "You do not have pending requests.");
        }
    }
}
