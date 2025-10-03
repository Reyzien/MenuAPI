package net.j4c0b3y.api.menu.template.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.j4c0b3y.api.menu.Menu;
import net.j4c0b3y.api.menu.button.Button;
import net.j4c0b3y.api.menu.button.impl.pagination.NextPageButton;
import net.j4c0b3y.api.menu.button.impl.pagination.PreviousPageButton;
import net.j4c0b3y.api.menu.layer.impl.BackgroundLayer;
import net.j4c0b3y.api.menu.layer.impl.ForegroundLayer;
import net.j4c0b3y.api.menu.pagination.PaginatedMenu;
import net.j4c0b3y.api.menu.pagination.PaginationSlot;
import net.j4c0b3y.api.menu.template.Template;

/**
 * @author J4C0B3Y
 * @version MenuAPI
 * @since 4/10/2025
 */
@AllArgsConstructor
@RequiredArgsConstructor
public class PaginationTemplate implements Template {
    private final PaginatedMenu menu;
    private Button background;

    @Override
    public void apply(BackgroundLayer background, ForegroundLayer foreground) {
        new BorderTemplate(this.menu, this.background).apply(background, foreground);

        foreground.center(new PaginationSlot(this.menu));

        foreground.set(0, this.menu.getRows() - 1, new PreviousPageButton(this.menu));
        foreground.set(Menu.COLUMNS, this.menu.getRows() - 1, new NextPageButton(this.menu));
    }
}
