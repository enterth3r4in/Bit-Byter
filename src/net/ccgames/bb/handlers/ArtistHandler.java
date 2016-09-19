package net.ccgames.bb.handlers;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import net.ccgames.bb.ref.References;

/**
 * Artist Handler class handles most of the drawing related to openGL and lwjgl. Condenses the code here for drawing
 * so the rest of the code is cleaner.
 * @author Cody
 * @version 0.1
 *
 */
public class ArtistHandler
{
	public static final int WIDTH = 800;
	public static final int HEIGHT= 600;
	
	public static void BeginSession()
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
	}
	
	/**
	 * Draws a quad on the screen with the given parameters. Draws out of a color, with no texture. 
	 * @param x - Top Left X
	 * @param y - Top Left Y
	 * @param width - Width of Quad
	 * @param height - Height of Quad
	 */
	public static void drawBlankQuad(float x, float y, float width, float height)
	{
		//Draws a quad on the screen. Points start in top left and go clockwise around the quad
		glBegin(GL_QUADS);
		glVertex2f(x, y);
		glVertex2f(x + width, y);
		glVertex2f(x + width, y + height);
		glVertex2f(x, y + height);
		glEnd();
	}
}
