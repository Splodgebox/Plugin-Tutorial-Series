package net.splodgebox.exampleplugin.controllers;

import lombok.Getter;
import net.splodgebox.exampleplugin.ExamplePlugin;
import net.splodgebox.exampleplugin.data.CustomItem;
import net.splodgebox.exampleplugin.data.enums.ItemType;
import org.bukkit.inventory.ItemStack;

public class ItemController {

    @Getter
    private final ExamplePlugin plugin;

    public ItemController(ExamplePlugin plugin) {
        this.plugin = plugin;
    }

    public ItemStack getItem(String itemType) {
        return new CustomItem(ItemType.valueOf(itemType)).create();
    }

    public ItemStack getItem(ItemType itemType) {
        return getItem(itemType.toString());
    }

}
