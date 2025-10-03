package net.j4c0b3y.api.menu.template.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.j4c0b3y.api.menu.Menu;
import net.j4c0b3y.api.menu.button.Button;
import net.j4c0b3y.api.menu.button.impl.BackButton;
import net.j4c0b3y.api.menu.button.impl.PlaceholderButton;
import net.j4c0b3y.api.menu.layer.impl.BackgroundLayer;
import net.j4c0b3y.api.menu.layer.impl.ForegroundLayer;
import net.j4c0b3y.api.menu.template.Template;

/**
 * @author J4C0B3Y
 * @version MenuAPI
 * @since 4/10/2025
 */
@AllArgsConstructor
@RequiredArgsConstructor
public class FillTemplate implements Template {
    private final Menu menu;
    private Button background;

    @Override
    public void apply(BackgroundLayer background, ForegroundLayer foreground) {
        background.fill(this.background != null ? this.background : new PlaceholderButton());
        foreground.set(0, new BackButton(this.menu));
    }
}
