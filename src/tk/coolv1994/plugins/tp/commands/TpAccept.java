package tk.coolv1994.plugins.tp.commands;

import tk.coolv1994.gawdserver.events.Command;
import tk.coolv1994.gawdserver.launcher.Launch;
import tk.coolv1994.gawdserver.utils.Chat;
import tk.coolv1994.gawdserver.utils.ColorCodes;
import tk.coolv1994.plugins.tp.Teleport;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class TpAccept implements Command {
    @Override
    public void onCommand(String player, String[] args) {
        if (Teleport.requests.get(player) != null) {
            if (Teleport.requests.get(player).startsWith(ColorCodes.selectionSymbol)) {
                //TPAHERE
                Launch.sendCommand("tell " + player + " Teleporting to " + Teleport.requests.get(player).substring(1));
                Launch.sendCommand("tp " + player + " " + Teleport.requests.get(player).substring(1));
                Teleport.requests.remove(player);
            } else {
                //TPA
                Launch.sendCommand("tell " + Teleport.requests.get(player) + " Teleporting to " + player);
                Launch.sendCommand("tp " + Teleport.requests.get(player) + " " + player);
                Teleport.requests.remove(player);
            }
        } else {
            Chat.sendMessage(player, "You do not have pending requests.");
        }
    }
}
