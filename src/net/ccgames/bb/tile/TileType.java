package net.ccgames.bb.tile;

public enum TileType
{
	GRASS("grass16x16", true),
	DIRT("dirt16x16", false),
	WATER("water16x16", false);
	
	String textureName;
	boolean buildable;
	
	TileType(String textureName, boolean buildable)
	{
		this.textureName = textureName;
		this.buildable = buildable;
	}
}
