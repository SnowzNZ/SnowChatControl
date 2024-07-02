package dev.snowz.snowchatcontrol;

import dev.snowz.snowchatcontrol.commands.MuteChatCommand;
import dev.snowz.snowchatcontrol.commands.SnowChatControlCommand;
import dev.snowz.snowchatcontrol.commands.UnmuteChatCommand;
import dev.snowz.snowchatcontrol.listeners.Chat;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public final class SnowChatControl extends JavaPlugin {

    private static SnowChatControl instance;
    private static String prefix;
    private static boolean chatMuted = false;

    public static boolean isChatMuted() {
        return chatMuted;
    }

    public static void setChatMuted(boolean chatMuted) {
        SnowChatControl.chatMuted = chatMuted;
    }

    public static SnowChatControl getInstance() {
        return instance;
    }

    public static String getPrefix() {
        return prefix;
    }

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        if (getConfig().getBoolean("metrics")) {
            new Metrics(this, 22489);
        }
        prefix = getConfig().getString("prefix") + " §r";

        getServer().getPluginManager().registerEvents(new Chat(), this);

        getCommand("snowchatcontrol").setExecutor(new SnowChatControlCommand());

        getCommand("mutechat").setExecutor(new MuteChatCommand());
        getCommand("unmutechat").setExecutor(new UnmuteChatCommand());
    }
}
