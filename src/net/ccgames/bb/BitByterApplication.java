/**
 * Bit Byter is a simple tower defense game to practice making and to polish and add more to later.
 */
package net.ccgames.bb;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

import net.ccgames.bb.ref.References;

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
		//Setting the display screen title
		Display.setTitle(References.TITLE);
		try
		{
			//Setting the display mode which is the size of the screen and actually creating it.
			Display.setDisplayMode(new DisplayMode(References.WIDTH, References.HEIGHT));
			Display.create();
		} catch (LWJGLException e)
		{
			e.printStackTrace();
		}
		
		//Boilerplate
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, References.WIDTH, References.HEIGHT, 0, 1, -1); // 2D game
		glMatrixMode(GL_MODELVIEW);
		
		float width = 50;
		float height = 50;
		float x = 100;
		float y = 100;
		
		while(!Display.isCloseRequested())
		{
//			Draws a line on the screen from 10, 10 to 100, 100 in a diagonal.
			glBegin(GL_LINES);
			glVertex2f(10, 10);
			glVertex2f(100, 100);
			glEnd();
			
			//Draws a quad on the screen. Points start in top left and go clockwise around the quad
			glBegin(GL_QUADS);
			glVertex2f(x, y);
			glVertex2f(x + width, y);
			glVertex2f(x + width, y + height);
			glVertex2f(x, y + height);
			glEnd();
			
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
