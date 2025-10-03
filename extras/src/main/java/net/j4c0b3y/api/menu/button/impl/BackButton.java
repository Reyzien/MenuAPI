package net.j4c0b3y.api.menu.button.impl;

import com.cryptomorin.xseries.XMaterial;
import lombok.RequiredArgsConstructor;
import net.j4c0b3y.api.menu.Menu;
import net.j4c0b3y.api.menu.MenuExtras;
import net.j4c0b3y.api.menu.button.Button;
import net.j4c0b3y.api.menu.button.ButtonClick;
import net.j4c0b3y.api.menu.utils.Item;
import org.bukkit.inventory.ItemStack;

/**
 * @author J4C0B3Y
 * @version MenuAPI
 * @since 4/10/2025
 */
@RequiredArgsConstructor
public class BackButton extends Button {
    private final Menu menu;

    @Override
    public ItemStack getIcon() {
        if (!this.menu.hasPreviousMenu()) return null;

        return new Item(XMaterial.RED_BED)
            .setName(MenuExtras.THEME + "&lBack")
            .addLore(
                "",
                "&7Return to the previous menu",
                "",
                MenuExtras.THEME + "Go Back &7(Left Click)"
            ).build();
    }

    @Override
    public void onClick(ButtonClick click) {
        if (click.getType().isLeftClick()) {
            menu.back();
        }
    }
}
