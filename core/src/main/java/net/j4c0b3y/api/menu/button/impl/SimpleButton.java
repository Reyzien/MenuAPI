package net.j4c0b3y.api.menu.button.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.j4c0b3y.api.menu.button.Button;
import net.j4c0b3y.api.menu.button.ButtonClick;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * QoL button for one time use functionality.
 *
 * @author J4C0B3Y
 * @version MenuAPI
 * @since 4/10/2025
 */
@AllArgsConstructor
@RequiredArgsConstructor
@SuppressWarnings("unused")
public final class SimpleButton extends Button {
    private final Supplier<ItemStack> icon;
    private Consumer<ButtonClick> callback = click -> {};

    public SimpleButton(Supplier<ItemStack> icon, Runnable callback) {
        this(icon, click -> callback.run());
    }

    public SimpleButton(ItemStack icon, Consumer<ButtonClick> callback) {
        this(() -> icon, callback);
    }

    public SimpleButton(ItemStack icon, Runnable callback) {
        this(icon, click -> callback.run());
    }

    public SimpleButton(ItemStack icon) {
        this(() -> icon);
    }

    @Override
    public ItemStack getIcon() {
        return icon.get();
    }

    @Override
    public void onClick(ButtonClick click) {
        this.callback.accept(click);
    }
}
