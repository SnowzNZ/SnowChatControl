package dev.snowz.mutechat.commands;

import dev.snowz.mutechat.MuteChat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UnmuteChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        MuteChat.setChatMuted(false);
        sender.sendMessage(MuteChat.getPrefix() + "§aChat is now unmuted.");
        return true;
    }
}
