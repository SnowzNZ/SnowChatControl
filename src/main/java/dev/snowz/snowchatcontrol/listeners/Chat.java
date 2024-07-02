package dev.snowz.mutechat.listeners;

import dev.snowz.mutechat.MuteChat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if (MuteChat.isChatMuted() && !event.getPlayer().hasPermission("mutechat.bypass")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(MuteChat.getPrefix() + "§cChat is currently muted.");
        }
    }
}
