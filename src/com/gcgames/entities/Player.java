package com.gcgames.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcgames.main.Game;

public class Player extends Entity {
	
	public boolean right,up,left,down;
	public double speed = 1.3;
	public int right_dir = 0, left_dir = 1, up_dir = 2, down_dir = 0;
	public int dir = right_dir;
	
	private int frames = 0, maxFrames = 5, index = 0, maxIndex = 2;
	private boolean moved;
	private BufferedImage[] rightPlayer;
	private BufferedImage[] leftPlayer;
	private BufferedImage[] upPlayer;


	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		rightPlayer = new BufferedImage[3];
		leftPlayer = new BufferedImage[3];
		upPlayer = new BufferedImage[3];
		
		for(int i = 0; i < 3; i++) {
			rightPlayer[i] = Game.spritesheet.getSprite(0 + (i*16),0,16,16);
		}
		for(int i = 0; i < 3; i++) {
			leftPlayer[i] = Game.spritesheet.getSprite(0 + (i*16),32 ,16,16);
		}
		for(int i = 0; i < 3; i++) {
			upPlayer[i] = Game.spritesheet.getSprite(0 + (i*16),16 ,16,16);
		}
		
		
	}
	
	public void update() {
		moved = false;
		if(right) {
			moved = true;
			dir = right_dir;
			x += speed;
		}else if(left) {
			moved = true;
			dir = left_dir;
			x -= speed;
		}
		
		if(up) {
			moved = true;
			dir = up_dir;
			y -= speed;
		}else if(down) {
			dir = down_dir;
			moved = true;
			y += speed;
		}
		
		if(moved) {
			frames++;
			if(frames == maxFrames) {
				frames = 0;
				index++;
				if(index > maxIndex) {
					index = 0;
				}
			}
		}
		
		
	}
	
	public void render(Graphics g) {
		if(dir == right_dir || dir == down_dir) {
			g.drawImage(rightPlayer[index],this.getX(),this.getY(), null);
		}else if(dir == left_dir) {
			g.drawImage(leftPlayer[index], this.getX(), this.getY(), null);
		}else if(dir == up_dir) {
			g.drawImage(upPlayer[index], this.getX(), this.getY(), null);
		}
		
	}

}
