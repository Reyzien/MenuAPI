package net.j4c0b3y.api.menu.button.impl.pagination;

import net.j4c0b3y.api.menu.pagination.PaginatedMenu;

/**
 * @author J4C0B3Y
 * @version MenuAPI
 * @since 4/10/2025
 */
public class PreviousPageButton extends SwitchPageButton {

    public PreviousPageButton(PaginatedMenu menu) {
        super("Previous", menu::hasPreviousPage, menu::nextPage, menu);
    }
}
