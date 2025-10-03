package net.j4c0b3y.api.menu.button.impl;

import com.cryptomorin.xseries.XMaterial;
import net.j4c0b3y.api.menu.button.Button;
import net.j4c0b3y.api.menu.utils.Item;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

/**
 * @author J4C0B3Y
 * @version MenuAPI
 * @since 4/10/2025
 */
public class PlaceholderButton extends Button {
    private final ItemStack icon;

    public PlaceholderButton(XMaterial material) {
        this.icon = new Item(material)
            .setName(ChatColor.RESET.toString())
            .build();
    }

    public PlaceholderButton() {
        this(XMaterial.GRAY_STAINED_GLASS_PANE);
    }

    @Override
    public ItemStack getIcon() {
        return icon;
    }
}
