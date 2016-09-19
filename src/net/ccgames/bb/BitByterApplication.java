/**
 * Bit Byter is a simple tower defense game to practice making and to polish and add more to later.
 */
package net.ccgames.bb;

import static net.ccgames.bb.handlers.ArtistHandler.*;

import org.lwjgl.opengl.Display;

import net.ccgames.bb.tile.Tile;
import net.ccgames.bb.tile.TileType;

/**
 * The BitByterApplication class is used to create and manage the display and rendering. May move to other class
 * at a later date.
 * @author Cody
 * @version 0.1
 *
 */
public class BitByterApplication
{
	/**
	 * Currently, the constructor holds all the information, might change later.
	 */
	public BitByterApplication()
	{
		BeginSession();
		
		Tile grass = new Tile(0, 0, 32, 32, TileType.GRASS);
		Tile dirt = new Tile(32, 0, 32, 32, TileType.DIRT);

		while(!Display.isCloseRequested())
		{
			grass.draw();
			dirt.draw();
			
			
			//lwjgl methods to update and sync FPS
			Display.update();
			Display.sync(60);
		}
		
		//End game and destroy display
		Display.destroy();
	}
	
	/**
	 * Drop in point. Only used to call new class for constructor
	 * @param args
	 */
	public static void main(String[] args)
	{
		//New instance to launch everything
		new BitByterApplication();
	}
}
