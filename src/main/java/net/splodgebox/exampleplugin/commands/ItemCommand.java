package net.splodgebox.exampleplugin.commands;

import net.splodgebox.exampleplugin.ExamplePlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ItemCommand implements CommandExecutor {

    // /item give <player> <type>
    // /item

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 3) {
            sender.sendMessage("Invalid usage: /item give <player> <type>");
            return true;
        }

        if (!args[0].equalsIgnoreCase("give")) return true;

        if (Bukkit.getPlayer(args[1]) == null) {
            sender.sendMessage("Please input a valid player");
            return true;
        }

        Player player = Bukkit.getPlayer(args[1]);
        if (!player.isOnline()) {
            sender.sendMessage("Please input a online player");
            return true;
        }

        String type = args[2];

        player.getInventory().addItem(ExamplePlugin.getInstance().getItemController().getItem(type));
        sender.sendMessage("You have given " + player.getName() + " a " + type + " item!");
        return true;
    }
}
