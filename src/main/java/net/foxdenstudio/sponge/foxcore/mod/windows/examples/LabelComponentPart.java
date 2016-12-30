package net.foxdenstudio.sponge.foxcore.mod.windows.examples;

import net.foxdenstudio.sponge.foxcore.mod.windows.Dependency;
import net.foxdenstudio.sponge.foxcore.mod.windows.Registry;
import net.foxdenstudio.sponge.foxcore.mod.windows.exceptions.PartAlreadyRegisteredException;
import net.foxdenstudio.sponge.foxcore.mod.windows.parts.IComponentPart;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class LabelComponentPart implements IComponentPart {

    static {
        try {
            Registry.getInstance().registerComponentPart("net.foxdenstudio.windowapi:label", LabelComponentPart.class);
        } catch (PartAlreadyRegisteredException e) {
            e.printStackTrace();
        }
    }

    @Nonnull
    private final String text;
    private int positionX, positionY, width, height;

    public LabelComponentPart() {
        this("");
    }

    public LabelComponentPart(@Nonnull final String text) {
        this.text = text;
    }

    @Nonnull
    public String getText() {
        return this.text;
    }

    @Nullable
    @Override
    public Dependency getDependencies() {
        return null;
    }

    @Override
    public void render() {

    }

    @Override
    public int getPositionX() {
        return this.positionX;
    }

    public LabelComponentPart setPositionX(int positionX) {
        this.positionX = positionX;
        return this;
    }

    @Override
    public int getPositionY() {
        return this.positionY;
    }

    public LabelComponentPart setPositionY(int positionY) {
        this.positionY = positionY;
        return this;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    public LabelComponentPart setWidth(int width) {
        this.width = width;
        return this;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public boolean isPinned() {
        return false;
    }

    @Override
    public void mouseClicked(int x, int y) {

    }

    @Override
    public void mouseReleased(int x, int y) {

    }

    public LabelComponentPart setHeight(int height) {
        this.height = height;
        return this;
    }
}
