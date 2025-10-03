package net.j4c0b3y.api.menu.impl.selectpage;

import lombok.Getter;
import net.j4c0b3y.api.menu.MenuSize;
import net.j4c0b3y.api.menu.button.Button;
import net.j4c0b3y.api.menu.impl.selectpage.button.SelectPageButton;
import net.j4c0b3y.api.menu.layer.impl.BackgroundLayer;
import net.j4c0b3y.api.menu.layer.impl.ForegroundLayer;
import net.j4c0b3y.api.menu.pagination.PaginatedMenu;
import net.j4c0b3y.api.menu.template.impl.PaginationTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author J4C0B3Y
 * @version MenuAPI
 * @since 4/10/2025
 */
@Getter
public class SelectPageMenu extends PaginatedMenu {
    private final PaginatedMenu paginatedMenu;

    public SelectPageMenu(PaginatedMenu menu) {
        super("Select Page", MenuSize.FOUR, menu.getPlayer());
        this.paginatedMenu = menu;

        setPreviousMenu(menu);
    }

    @Override
    public void setup(BackgroundLayer background, ForegroundLayer foreground) {
        apply(new PaginationTemplate(this));
    }

    @Override
    public List<Button> getEntries() {
        List<Button> buttons = new ArrayList<>();

        for (int i = 0; i < this.paginatedMenu.getTotalPages(); i++) {
            buttons.add(new SelectPageButton(i + 1, this));
        }

        return buttons;
    }
}
