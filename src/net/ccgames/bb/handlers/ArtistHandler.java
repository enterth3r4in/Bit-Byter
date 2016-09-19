package net.ccgames.bb.handlers;

import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

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
	public static final int WIDTH = 640;
	public static final int HEIGHT= 480;
	
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
		glEnable(GL_TEXTURE_2D);
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
	
	/**
	 * Draws a quad on the screen with the given parameters. Draws with a texture on top of quad.
	 * @param texture - Texture to render over quad
	 * @param x - Top Left X
	 * @param y - Top Left Y
	 * @param width - Width of Quad
	 * @param height - Height of Quad
	 */
	public static void drawTexturedQuad(Texture texture, float x, float y, float width, float height)
	{
		texture.bind();
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f(width, 0);
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		glEnd();
		glLoadIdentity();
	}
	
	/**
	 * Loads texture with an input stream and using a path and file type (.png usually).
	 * @param path - Location of texture
	 * @param fileType - File Type of texture
	 * @return - the texture to load
	 */
	public static Texture loadTexture(String path, String fileType)
	{
		Texture texture = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try
		{
			texture = TextureLoader.getTexture(fileType, in);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return texture;
	}
	
	/**
	 * Uses the loadTexture(path, fileType) to load by default a tile as a png.
	 * @param name
	 * @return
	 */
	public static Texture loadTileTextureAsPNG(String name)
	{
		Texture texture = null;
		texture = loadTexture("assets/Tiles/" + name + ".png", "PNG");
		return texture;
	}
}
