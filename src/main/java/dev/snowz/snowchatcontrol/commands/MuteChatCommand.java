package dev.snowz.mutechat.commands;

import dev.snowz.mutechat.MuteChat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MuteChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        MuteChat.setChatMuted(true);
        sender.sendMessage(MuteChat.getPrefix() + "§aChat is now muted.");
        return true;
    }
}
