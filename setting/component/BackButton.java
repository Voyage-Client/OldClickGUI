package dev.voyageclient.gui.clickgui.oldgui.setting.component;

import java.awt.Color;

import org.lwjgl.input.Mouse;

import dev.voyageclient.gui.clickgui.oldgui.ClickGUI;
import dev.voyageclient.mods.ModDraggable;
import dev.voyageclient.settings.BooleanSetting;
import dev.voyageclient.settings.Setting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;

public class BackButton {
	
	private ModDraggable mod;
	
	private Minecraft mc = Minecraft.getMinecraft();
	
	
	private int x;
	private int y;
	private int width;
	private int height;

	private boolean pressed;
	private boolean hovered;
	
	public BackButton(int mouseX, int mouseY, int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.mod = mod;
		
		this.pressed = (Mouse.getEventButton() == 0) && (this.hovered == true) && (Mouse.getEventButtonState() == true);
		this.hovered = (mouseX > this.x) && (mouseX < this.width) && (mouseY > this.y) && (mouseY < this.height);
		int color = new Color(0, 0, 0, 255).getRGB();
		Gui.drawRect(this.x, this.y, this.width, this.height, new Color(0, 0, 0, 255).getRGB());
		mc.fontRendererObj.drawString("<", x + 23, y + 8, hovered ? new Color(245, 255, 245, 255).getRGB() : new Color(255, 255, 255, 255).getRGB());
		
		if(pressed) {
			mc.displayGuiScreen(new ClickGUI());
		}
	}
}
