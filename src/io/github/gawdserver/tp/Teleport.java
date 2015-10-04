package io.github.gawdserver.tp;

import io.github.gawdserver.api.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vinnie on 2/2/2015.
 */
public class Teleport implements Plugin {
    // Receiver - Sender
    private static Map<String, String> requests;

    public Teleport() {
        requests = new HashMap<>();
    }

    public static boolean hasRequest(String acceptor) {
        return requests.containsKey(acceptor);
    }

    public static String getRequest(String acceptor) {
        return requests.get(acceptor);
    }

    public static void addRequest(String requester, String acceptor) {
        requests.put(acceptor, requester);
    }

    public static boolean removeRequest(String acceptor) {
        return requests.remove(acceptor) != null;
    }

    @Override
    public void startup() {}

    @Override
    public void shutdown() {}
}
