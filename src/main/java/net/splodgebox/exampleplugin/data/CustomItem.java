package net.splodgebox.exampleplugin.data;

import de.tr7zw.changeme.nbtapi.NBTItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.splodgebox.exampleplugin.data.enums.ItemType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@RequiredArgsConstructor
public class CustomItem {

    @Getter
    private final ItemType itemType;

    public ItemStack create() {
        ItemStack itemStack = new ItemStack(Material.DIAMOND);

        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("Item: " + itemType.toString());
        itemStack.setItemMeta(itemMeta);

        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.setString("CustomItemType", itemType.toString());

        return nbtItem.getItem();
    }

}
