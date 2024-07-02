package dev.snowz.snowchatcontrol.listeners;

import dev.snowz.snowchatcontrol.SnowChatControl;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if (SnowChatControl.isChatMuted() && !event.getPlayer().hasPermission("snowchatcontrol.bypass.mutechat")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(SnowChatControl.getPrefix() + "§cChat is currently muted!");
        }
    }
}
