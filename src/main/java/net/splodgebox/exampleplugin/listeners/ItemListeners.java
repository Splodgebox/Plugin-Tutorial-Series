package net.splodgebox.exampleplugin.listeners;

import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemListeners implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        ItemStack itemStack = event.getItem();
        if (itemStack == null || itemStack.getType() == Material.AIR) return;

        NBTItem nbtItem = new NBTItem(itemStack);
        if (!nbtItem.hasKey("CustomItemType")) return;
        event.setCancelled(true);

        String types = nbtItem.getString("CustomItemType");

        switch (types) {
            case "REMOVE" -> player.setItemInHand(new ItemStack(Material.AIR));
            case "LIGHTNING" -> player.getLocation().getWorld().strikeLightning(player.getLocation());
            case "SOUND" -> player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 10);
        }
    }

}
