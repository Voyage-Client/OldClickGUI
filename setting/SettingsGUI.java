package dev.voyageclient.gui.clickgui.oldgui.setting;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;

import org.liquidengine.legui.*;
import org.liquidengine.legui.component.Button;

import dev.voyageclient.gui.clickgui.oldgui.ClickGUI;
import dev.voyageclient.gui.clickgui.oldgui.setting.component.BackButton;
import dev.voyageclient.gui.clickgui.oldgui.setting.component.BooleanButton;
import dev.voyageclient.gui.clickgui.oldgui.setting.component.ModeButton;
import dev.voyageclient.mods.Category;
import dev.voyageclient.mods.ModDraggable;
import dev.voyageclient.mods.ModInstances;
import dev.voyageclient.settings.BooleanSetting;
import dev.voyageclient.settings.ModeSetting;
import dev.voyageclient.settings.Setting;
import dev.voyageclient.util.ColorUtil;
import dev.voyageclient.util.DrawUtil;
import dev.voyageclient.util.font.VoyageFont;
import dev.voyageclient.util.font.VoyageFontFromAsset;

public class SettingsGUI extends GuiScreen {
	
	
	
	private static ModDraggable mod;
	
	int count = 1;
	
	ArrayList<SettingsFrame> frames;
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	public SettingsGUI(ModDraggable mod) {
		this.mod = mod;
		
		frames = new ArrayList<>();
		int offset = 0;
		 for(Category category : Category.values()) {
			 frames.add(new SettingsFrame(mod, 285, 100));
			 offset += 150;
		 }
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX,  mouseY, partialTicks);
		
		super.drawDefaultBackground();
		
		for(SettingsFrame frame : frames) {
			frame.render(mouseX, mouseY);
		}
		
		//new BackButton(mouseX, mouseY, 295, 115, 305, 105);
		DrawUtil.drawRoundedRect(285, 100, 680, 135, 10, new Color(255, 255, 255, 255).getRGB());
		mc.fontRendererObj.drawString(mod.getName(), 295, 115, ColorUtil.getRGB(4, 0.9f, 1, 100));
		//mc.getTextureManager().bindTexture(new ResourceLocation("Voyage/logo.png"));
    	//Gui.drawModalRectWithCustomSizedTexture(431, 29, 500, 0, 100, 100, 100, 100);
    	
    	mc.fontRendererObj.drawString("Voyage Client Copyright © 2021" ,0 + 3, this.height - 15, -1);
    	
    	if(!mod.settings.isEmpty()) {	
			for(Setting setting : mod.settings) {
				if(setting instanceof BooleanSetting) {
					new BooleanButton(mouseX, mouseY,  300, 150, 400, 175, (BooleanSetting) setting, mod, 1);
					count++;
				}
				if(setting instanceof ModeSetting) {
					new ModeButton(mouseX, mouseY,  420, 150, 520, 175, (ModeSetting) setting, mod, 2);
					count++;
				}
			}
		}
	}
	
	@Override
	public void mouseClicked(int x, int y, int button) {
		for(ModDraggable mod : ModInstances.modules) {
			if(!mod.settings.isEmpty()) {	
				for(Setting setting : mod.settings) {
					if(setting instanceof BooleanSetting) {
						if(BooleanButton.isHovered2()) {
							((BooleanSetting) setting).toggle();
						}
					}
				}
			}
		}
		for(ModDraggable mod : ModInstances.modules) {
			if(!mod.settings.isEmpty()) {	
				for(Setting setting : mod.settings) {
					if(setting instanceof ModeSetting) {
						if(ModeButton.isHovered()) {
							((ModeSetting) setting).cycle();
						}
					}
				}
			}
		}
	}

}
