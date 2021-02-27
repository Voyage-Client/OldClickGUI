package dev.voyageclient.gui.clickgui.oldgui.setting;


import java.awt.Color;
import java.util.ArrayList;

import dev.voyageclient.gui.clickgui.oldgui.setting.component.BooleanButton;
import dev.voyageclient.gui.clickgui.oldgui.setting.component.ModeButton;
import dev.voyageclient.mods.Category;
import dev.voyageclient.mods.ModDraggable;
import dev.voyageclient.mods.ModInstances;
import dev.voyageclient.mods.Side;
import dev.voyageclient.settings.BooleanSetting;
import dev.voyageclient.settings.ModeSetting;
import dev.voyageclient.settings.Setting;
import dev.voyageclient.util.ColorUtil;
import dev.voyageclient.util.DrawUtil;
import dev.voyageclient.util.font.VoyageFontFromAsset;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class SettingsFrame extends GuiScreen {
	
	int x, y, width, height;
	int mouseX, mouseY;
	
	Minecraft mc = Minecraft.getMinecraft();
	Category category;
	public static VoyageFontFromAsset font = new VoyageFontFromAsset(new ResourceLocation("Voyage/font/AntipastoPro-DemiBold_trial.ttf"), 23.0F);
	

	public SettingsFrame(ModDraggable mod, int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 395;
		this.height = 300;
		this.category = category;
	}
		
	
	public void render(int mouseX, int mouseY) {
		DrawUtil.drawRoundedRect(x, y, x + width, y + height, 10, new Color(0, 0, 0, 75).getRGB());
	}
	
	/*public void onClick(int x, int y, int button) {
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
							System.out.println(setting.name + " " + x + " " + ModeButton.x + " " );
						}
					}
				}
			}
		}
	}*/
}