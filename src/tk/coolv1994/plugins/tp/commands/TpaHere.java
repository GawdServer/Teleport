package tk.coolv1994.plugins.tp.commands;

import tk.coolv1994.gawdserver.events.Command;
import tk.coolv1994.gawdserver.utils.Chat;
import tk.coolv1994.gawdserver.utils.ColorCodes;
import tk.coolv1994.plugins.tp.Teleport;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class TpaHere implements Command {
    @Override
    public void onCommand(String player, String[] args) {
        if (args.length > 0) {
            Teleport.requests.put(args[0], ColorCodes.selectionSymbol + player);
            Chat.sendMessage(player, "Teleport request sent to " + args[0]);
            Chat.sendMessage(args[0], player + " has requested that you teleport to them. Type \"!tpaccept\" to accept.");
        } else {
            Chat.sendMessage(player, "Use: !tpahere <username>");
        }
    }
}
