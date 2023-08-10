package com.gcgames.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.gcgames.main.Game;

public class Entity {
	
	public static BufferedImage TOAST_EN = Game.spritesheet.getSprite(0,16*4,16,16);
	public BufferedImage DUCK_EN = Game.spritesheet.getSprite(0,16*7,16,16);
	public BufferedImage POWER_EN = Game.spritesheet.getSprite(16*6, 0, 16, 16);
	public static BufferedImage ENEMY_EN = Game.spritesheet.getSprite(0, 16*5, 16, 16);
	
	protected double x;
	protected double y;
	protected int width;
	protected int height;
	
	private BufferedImage sprite;
	
	public Entity(int x, int y, int width, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
		
	}
	
	public void setX(int newX) {
		this.x = newX;
		
	}
	
	public void setY(int newY) {
		this.y = newY;
		
	}

	public int getX() {
		return (int)this.x;
	}
	
	public int getY() {
		return (int)this.y;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeigth() {
		return this.height;
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite, this.getX(), this.getY(), null);
		
	}


}
