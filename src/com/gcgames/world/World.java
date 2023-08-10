package com.gcgames.world;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics;
import javax.imageio.ImageIO;

import com.gcgames.entities.Enemy;
import com.gcgames.entities.Entity;
import com.gcgames.main.Game;

public class World {
	
	private Tile[] tiles;
	public static  int WIDTH, HEIGHT;
	
	public World(String path) {
		try {
			BufferedImage map = ImageIO.read(getClass().getResource(path));
			int[] pixels = new int[map.getWidth() * map.getHeight()];
			WIDTH = map.getWidth();
			HEIGHT = map.getHeight();
			tiles = new Tile[map.getWidth() * map.getHeight()];
			map.getRGB(0, 0, map.getWidth(), map.getHeight(),pixels, 0 ,map.getWidth());
			for(int xx = 0; xx < map.getWidth(); xx++) {
				for(int yy = 0; yy < map.getHeight(); yy++) {
					int pixelAtual = pixels[xx + (yy*map.getWidth())];
					tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR);
					if( pixelAtual == 0xFF000000) {
						//Floor
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR);
					}else if(pixelAtual == 0xFFFFFFFF) {
						//Wall
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_WALL);
					}else if(pixelAtual == 0xFF0024ff) {
						//player
						Game.player.setX(xx*16);
						Game.player.setY(yy*16);
					}else if(pixelAtual == 0xFFFF0000){
						//enemy
						Game.entities.add(new Enemy(xx*16, yy*16,16,16,Entity.ENEMY_EN));
					}else if(pixelAtual == 0xFFd77bba){
						//Toast
					}else if(pixelAtual == 0xFFfbf236){
						//Duck
					}
					
					
				}
			}
			
		} catch (IOException e) {     
			e.printStackTrace();
		}
	}
		public void render(Graphics g) {
			for(int xx = 0; xx < WIDTH; xx++) {
				for(int yy = 0; yy < HEIGHT; yy++) {
					Tile tile = tiles[xx+(yy*WIDTH)];
					tile.render(g);
				}
			}
			
	}
}
