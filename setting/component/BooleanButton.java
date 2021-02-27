package dev.voyageclient.gui.clickgui.oldgui.setting.component;

import java.awt.Color;

import org.lwjgl.input.Mouse;

import dev.voyageclient.mods.ModDraggable;
import dev.voyageclient.mods.ModInstances;
import dev.voyageclient.settings.BooleanSetting;
import dev.voyageclient.settings.ModeSetting;
import dev.voyageclient.settings.Setting;
import dev.voyageclient.util.font.VoyageFontFromAsset;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public class BooleanButton {
	
	
	private ModDraggable mod;
	
	private Minecraft mc = Minecraft.getMinecraft();
	
	private boolean pressed;
	private boolean hovered;
	private static boolean hovered2;
	
	public static int x;
	public static int y;
	private int width;
	private int height;
	
	private int pressColor = new Color(0, 255, 0 ,255).getRGB();
	private int neutralColor = new Color(255, 0, 0, 100).getRGB();
	
	public BooleanButton(int mouseX, int mouseY, int x, int y, int w, int h, BooleanSetting bool, ModDraggable mod, int buttonId) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.mod = mod;
		
		if(!mod.settings.isEmpty()) {	
			for(Setting setting : mod.settings) {
				if(setting instanceof BooleanSetting) {
					BooleanSetting boolsett = (BooleanSetting) setting;
					this.pressed = (Mouse.getEventButton() == 0) && (this.hovered2 == true) && (Mouse.getEventButtonState() == true);
					this.hovered = (mouseX > this.x) && (mouseX < this.width) && (mouseY > this.y) && (mouseY < this.height);
					this.hovered2 = (mouseX >= this.x) && (mouseX <= this.x + this.width && mouseY >= this.y) && (mouseY <= this.y + this.height);
					int color = new Color(0, 0, 0, 255).getRGB();
					Gui.drawRect(this.x, this.y, this.width, this.height, color);
					mc.fontRendererObj.drawString(boolsett.name, x + 23, y + 8, boolsett.isEnabled() ? new Color(0, 255, 0, 255).getRGB() : new Color(255, 0, 0, 255).getRGB());
				}
			}
		}
	}

	public boolean isHovered() {
		return hovered;
	}

	public static boolean isHovered2() {
		return hovered2;
	}
	
	
	
}
