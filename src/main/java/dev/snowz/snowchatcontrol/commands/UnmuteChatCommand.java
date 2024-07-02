package dev.snowz.snowchatcontrol.commands;

import dev.snowz.snowchatcontrol.SnowChatControl;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnmuteChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        SnowChatControl.setChatMuted(false);
        sender.sendMessage(SnowChatControl.getPrefix() + "§aChat is now unmuted!");
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("snowchatcontrol.notify.unmutechat")) {
                player.sendMessage(SnowChatControl.getPrefix() + "§aChat has been unmuted by §e" + sender.getName() + "§a!");
            }
        }
        return true;
    }
}
