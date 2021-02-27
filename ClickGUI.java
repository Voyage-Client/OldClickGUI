package dev.voyageclient.gui.clickgui.oldgui;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;

import org.liquidengine.legui.*;
import org.liquidengine.legui.component.Button;

import dev.voyageclient.mods.Category;
import dev.voyageclient.mods.ModDraggable;
import dev.voyageclient.util.ColorUtil;
import dev.voyageclient.util.DrawUtil;
import dev.voyageclient.util.font.VoyageFont;
import dev.voyageclient.util.font.VoyageFontFromAsset;

public class ClickGUI extends GuiScreen {
	
	public static ClickGUI INSTANCE = new ClickGUI();
	
	
	ArrayList<Frame> frames;
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	public ClickGUI() {
		frames = new ArrayList<>();
		int offset = 0;
		 for(Category category : Category.values()) {
			 frames.add(new Frame(category, 285, 100));
			 offset += 150;
		 }
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX,  mouseY, partialTicks);
		
		super.drawDefaultBackground();
		
		for(Frame frame : frames) {
			frame.render(mouseX, mouseY);
		}
		
		DrawUtil.drawRoundedRect(285, 100, 680, 135, 10, new Color(255, 255, 255, 255).getRGB());
		mc.fontRendererObj.drawString("Mods", 469, 120, ColorUtil.getRGB(4, 0.9f, 1, 100));
		mc.getTextureManager().bindTexture(new ResourceLocation("Voyage/logo.png"));
    	Gui.drawModalRectWithCustomSizedTexture(431, 29, 500, 0, 100, 100, 100, 100);
    	
    	mc.fontRendererObj.drawString("Voyage Client Copyright © 2021" ,0 + 3, this.height - 15, -1);
	}
	
	@Override
	public void mouseClicked(int mouseX, int mouseY, int button) throws IOException {
		super.mouseClicked(mouseX, mouseY, button);
		for (Frame frame : frames) {
			frame.onClick(mouseX, mouseY, button);
		}
	}

}
