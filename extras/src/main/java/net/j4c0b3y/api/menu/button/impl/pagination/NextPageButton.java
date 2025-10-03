package net.j4c0b3y.api.menu.button.impl.pagination;

import net.j4c0b3y.api.menu.pagination.PaginatedMenu;

/**
 * @author J4C0B3Y
 * @version MenuAPI
 * @since 4/10/2025
 */
public class NextPageButton extends SwitchPageButton {

    public NextPageButton(PaginatedMenu menu) {
        super("Next", menu::hasNextPage, menu::nextPage, menu);
    }
}
