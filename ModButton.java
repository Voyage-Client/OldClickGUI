package dev.voyageclient.gui.clickgui.oldgui;

import java.awt.Color;

import org.lwjgl.input.Mouse;

import dev.voyageclient.gui.clickgui.oldgui.setting.SettingsGUI;
import dev.voyageclient.mods.ModDraggable;
import dev.voyageclient.mods.Side;
import dev.voyageclient.util.ColorUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;

public class ModButton extends GuiScreen {
	
	int x, y, width, height;
	int xRight;
	
	ModDraggable mod;
	
	Frame parent;
	
	Minecraft mc = Minecraft.getMinecraft();
	

	public ModButton(ModDraggable mod, int x, int y, Frame parent, int xRight) {
		this.mod = mod;
		this.x = x;
		this.y = y;
		this.parent = parent;
		this.width = parent.width;
		this.height = 14;
		this.xRight = xRight;
	}
	
	public void draw(int MouseX, int MouseY) {
		if(mod.isEnabled) {
			mc.fontRendererObj.drawString(mod.getName(), x + 2, y + 2, new Color(255, 255, 255, 255).getRGB());
		} else {
			mc.fontRendererObj.drawString(mod.getName(), x + 2, y + 2, new Color(255, 0, 0, 255).getRGB());
		}
		drawHollowRect(x - 4, y - 2, 189, mc.fontRendererObj.FONT_HEIGHT + 6, ColorUtil.getRGB(4, 0.9f, 1, 100));
	}
	
	int buttonRight = x + xRight;
	
	public void onClick(int mouseX, int mouseY, int button) {
			if(mouseX >= this.buttonRight && mouseX <= this.buttonRight + this.width && mouseY >= this.y && mouseY <= this.y + this.height) {
				if(button == 0) {
					mod.toggleSpecfific(mod);
					System.out.println(mod);
				}
				if(button == 1) {
					mc.displayGuiScreen(new SettingsGUI(mod));
				}
				Gui.drawRect(buttonRight + 2, mouseY + 2, buttonRight + 8, mouseY + 8, new Color(255, 0, 0, 255).getRGB());
			}
		}
		
	
	private void drawHollowRect(int x, int y, int w, int h, int color) {
		
		this.drawHorizontalLine(x, x + w, y, color);
		this.drawHorizontalLine(x, x + w, y + h, color);
		
		this.drawVerticalLine(x, y + h, y, color);
		this.drawVerticalLine(x + w, y + h, y, color);
	}
	
}
