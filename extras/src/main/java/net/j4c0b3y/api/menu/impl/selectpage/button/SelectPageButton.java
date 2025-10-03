package net.j4c0b3y.api.menu.impl.selectpage.button;

import com.cryptomorin.xseries.XMaterial;
import lombok.RequiredArgsConstructor;
import net.j4c0b3y.api.menu.MenuExtras;
import net.j4c0b3y.api.menu.button.Button;
import net.j4c0b3y.api.menu.button.ButtonClick;
import net.j4c0b3y.api.menu.impl.selectpage.SelectPageMenu;
import net.j4c0b3y.api.menu.utils.Item;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

/**
 * @author J4C0B3Y
 * @version MenuAPI
 * @since 4/10/2025
 */
@RequiredArgsConstructor
public class SelectPageButton extends Button {
    private final int page;
    private final SelectPageMenu menu;

    @Override
    public ItemStack getIcon() {
        boolean current = this.page == this.menu.getPaginatedMenu().getPage();

        return new Item(current ? XMaterial.ENCHANTED_BOOK : XMaterial.BOOK)
            .setName(MenuExtras.THEME + "&lPage" + this.page + (current ? "&7(Selected)" : ""))
            .addLore("", MenuExtras.THEME + "Select Page " + this.page + " &7(Left Click)")
            .build();
    }

    @Override
    public void onClick(ButtonClick click) {
        if (click.getType() != ClickType.LEFT) return;

        this.menu.getPaginatedMenu().setPage(this.page);
        this.menu.back();
    }
}
