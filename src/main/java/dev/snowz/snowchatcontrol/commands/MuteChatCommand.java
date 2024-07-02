package dev.snowz.snowchatcontrol.commands;

import dev.snowz.snowchatcontrol.SnowChatControl;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MuteChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        SnowChatControl.setChatMuted(true);
        sender.sendMessage(SnowChatControl.getPrefix() + "§aChat is now muted!");
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("snowchatcontrol.notify.mutechat")) {
                player.sendMessage(SnowChatControl.getPrefix() + "§cChat has been muted by §e" + sender.getName() + "§c!");
            }
        }
        return true;
    }
}
