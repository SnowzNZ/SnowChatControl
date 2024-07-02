package dev.snowz.mutechat;

import dev.snowz.mutechat.commands.MuteChatCommand;
import dev.snowz.mutechat.listeners.Chat;
import org.bukkit.plugin.java.JavaPlugin;

public final class MuteChat extends JavaPlugin {

    private static MuteChat instance;
    private static boolean chatMuted = false;
    private static final String prefix = getInstance().getConfig().getString("prefix");

    public static boolean isChatMuted() {
        return chatMuted;
    }

    public static void setChatMuted(boolean chatMuted) {
        MuteChat.chatMuted = chatMuted;
    }

    public static MuteChat getInstance() {
        return instance;
    }

    public static String getPrefix() {
        return prefix;
    }

    @Override
    public void onEnable() {
        instance = this;

        getServer().getPluginManager().registerEvents(new Chat(), this);
        getCommand("mutechat").setExecutor(new MuteChatCommand());
    }
}
