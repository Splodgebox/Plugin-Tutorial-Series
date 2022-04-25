package net.splodgebox.exampleplugin;

import lombok.Getter;
import net.splodgebox.exampleplugin.commands.ItemCommand;
import net.splodgebox.exampleplugin.controllers.ItemController;
import net.splodgebox.exampleplugin.listeners.ItemListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class ExamplePlugin extends JavaPlugin {

    @Getter
    private static ExamplePlugin instance;

    @Getter
    private ItemController itemController;

    @Override
    public void onEnable() {
        instance = this;
        itemController = new ItemController(this);

        getServer().getPluginManager().registerEvents(new ItemListeners(), this);
        getCommand("item").setExecutor(new ItemCommand());

    }
}
