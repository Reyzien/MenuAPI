package net.j4c0b3y.api.menu.button.impl.pagination;

import com.cryptomorin.xseries.XMaterial;
import lombok.RequiredArgsConstructor;
import net.j4c0b3y.api.menu.MenuExtras;
import net.j4c0b3y.api.menu.button.Button;
import net.j4c0b3y.api.menu.button.ButtonClick;
import net.j4c0b3y.api.menu.impl.selectpage.SelectPageMenu;
import net.j4c0b3y.api.menu.pagination.PaginatedMenu;
import net.j4c0b3y.api.menu.utils.Item;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.function.Supplier;

/**
 * @author J4C0B3Y
 * @version MenuAPI
 * @since 4/10/2025
 */
@RequiredArgsConstructor
public abstract class SwitchPageButton extends Button {

    private final String name;
    private final Supplier<Boolean> show;
    private final Runnable action;

    private final PaginatedMenu menu;

    @Override
    public ItemStack getIcon() {
        if (!show.get()) return null;

        return new Item(XMaterial.ARROW)
            .setName(MenuExtras.THEME + "&l" + this.name + " Page")
            .addLore(
                "",
                "&7Page: &f" + this.menu.getPage() + "&7/&f" + menu.getTotalPages(),
                ""
            )
            .addLore(this.menu instanceof SelectPageMenu ? "" :
                MenuExtras.THEME + "Select Page &7(Middle Click)"
            )
            .addLore(MenuExtras.THEME + this.name + " Page &f(Left Click)")
            .build();
    }

    @Override
    public void onClick(ButtonClick click) {
        boolean show = MenuExtras.PAGE_SELECT && !(this.menu instanceof SelectPageMenu);

        if (click.getType() == ClickType.MIDDLE && show) {
            new SelectPageMenu(this.menu).open();
            return;
        }

        if (click.getType() == ClickType.LEFT) {
            this.action.run();
        }
    }
}
