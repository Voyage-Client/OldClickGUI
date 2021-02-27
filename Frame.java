package dev.voyageclient.gui.clickgui.oldgui;


import java.awt.Color;
import java.util.ArrayList;

import dev.voyageclient.mods.Category;
import dev.voyageclient.mods.ModDraggable;
import dev.voyageclient.mods.ModInstances;
import dev.voyageclient.mods.Side;
import dev.voyageclient.util.ColorUtil;
import dev.voyageclient.util.DrawUtil;
import dev.voyageclient.util.font.VoyageFontFromAsset;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class Frame extends GuiScreen {
	
	int x, y, width, height;
	
	Minecraft mc = Minecraft.getMinecraft();
	Category category;
	ArrayList<ModButton> modButtons = new ArrayList<>();
	
	
	

	public Frame(Category category, int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 395;
		this.height = 300;
		this.category = category;
		
		int offsetY = 0;
		int rightoffsetY = 0;
		int count = 0;
		for(ModDraggable mod : ModInstances.getModsByCategory(category)) {
			modButtons.add(new ModButton(mod, 295, offsetY * 20 + 110 + 30, this, 191));
			offsetY += 1;
				
			count += 1;
		}
		
	}
	
	public void render(int MouseX, int MouseY) {
		mc.fontRendererObj.drawString("Mods", x + 2, y + 2, ColorUtil.getRGB(4, 0.9f, 1, 100));
		DrawUtil.drawRoundedRect(x, y, x + width, y + height, 10, new Color(0, 0, 0, 75).getRGB());
		for(ModButton modButton : modButtons) {
			modButton.draw(MouseX, MouseY);
		}
		
	}
	
	public void onClick(int x, int y, int button) {
		for(ModButton modButton : modButtons) {
			modButton.onClick(x, y, button);
		}
	}
}
