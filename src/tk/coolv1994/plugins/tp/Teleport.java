package tk.coolv1994.plugins.tp;

import tk.coolv1994.gawdserver.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vinnie on 2/2/2015.
 */
public class Teleport implements Plugin {
    // Receiver - Sender
    public static final Map<String, String> requests = new HashMap<String, String>();

    @Override
    public void startup() {}

    @Override
    public void shutdown() {}
}
