package dev.resent.module.base;

import dev.resent.annotation.RenderModule;
import dev.resent.util.render.RenderUtils;
import net.lax1dude.eaglercraft.v1_8.Mouse;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;

public abstract class RenderMod extends Mod {

    public int x, y, width, height;
    public int lastX;
    public int lastY;
    private boolean dragging;

    public RenderMod(){
        super();
        RenderModule modInfo;
        if(getClass().isAnnotationPresent(RenderModule.class)){
            modInfo = getClass().getAnnotation(RenderModule.class);
            this.name = modInfo.name();
            this.category = modInfo.category();
            this.hasSetting = modInfo.hasSetting();
            this.x = modInfo.x();
            this.y = modInfo.y();
        }
    }
    
    public RenderMod(String name, Category cat, int x, int y) {
        super(name, cat);
        this.x = x;
        this.y = y;
    }

    public RenderMod(String name, Category cat, int x, int y, boolean hasSetting) {
        super(name, cat, hasSetting);
        this.x = x;
        this.y = y;
        this.hasSetting = hasSetting;
    }

    public void draw() {}

    public void resize() {
        if ((getX() + getWidth()) > GuiScreen.width) {
            this.x = GuiScreen.width - getWidth();
            dragging = false;
        } else if ((getY() + getHeight()) > GuiScreen.height) {
            this.y = GuiScreen.height - getHeight();
            dragging = false;
        } else if ((getX()) < 0) {
            this.x = 0;
            dragging = false;
        } else if ((getY()) < 0) {
            this.y = 0;
            dragging = false;
        }
    }

    public void renderLayout(int mouseX, int mouseY) {

        resize();
        draw();

        if (this.dragging) {
            this.x = mouseX + this.lastX;
            this.y = mouseY + this.lastY;
            if (!Mouse.isButtonDown(0)) this.dragging = false;
        }

        boolean hovered = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + getWidth() && mouseY < getY() + this.getHeight();

        Gui.drawRect(this.x, this.y, this.x + this.getWidth(), this.y + this.getHeight(), hovered ? 0x50FFFFFF : 0x40FFFFFF);
        RenderUtils.drawRectOutline(this.x, this.y, this.x+this.getWidth(), this.y+this.getHeight(), -1);

        boolean mouseOverX = (mouseX >= this.getX() && mouseX <= this.getX() + this.getWidth());
        boolean mouseOverY = (mouseY >= this.getY() && mouseY <= this.getY() + this.getHeight());

        if (mouseOverX && mouseOverY && Mouse.isButtonDown(0) && !this.dragging) {
            this.lastX = x - mouseX;
            this.lastY = y - mouseY;
            this.dragging = true;
        }
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}