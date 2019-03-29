package ChessPack;
import java.util.*;

public class TileNode implements Comparable<TileNode> {
	private List<Edge> neighbors;
	private boolean occupied;
	private String teamOnTile;
	
	private int xCoord;
	private int yCoord;
	
	
	/**
	 * Constructs a new tile node and an empty list of its neighbors
	 * @param name - a unique name for a tile
	 */
	public TileNode(int x, int y){
		neighbors = new ArrayList<Edge>();
		xCoord = x;
		yCoord = y;
	}
	
	
	/**
	 * Gives a list of the neighbors of the node
	 * 
	 * @return the neighbors of this TileNode
	 */
	public List<Edge> getNeighbors(){
		return neighbors;
	}
	
	
	/**
	 * Sets the tile to its occupation state and team
	 * 
	 */
	public void setOccupied(boolean occupy, String team){
		occupied = occupy;
		teamOnTile = team;
	}
	
	/**
	 * Gives the occupation state of this tile
	 * 
	 * @return boolean value
	 */
	public boolean isOccupied(){
		return occupied;
	}
	
	public void setTeamOnTile(String team){
		teamOnTile = team;
	}
	/*
	 * Returns what team is occupying the tile
	 */
	public String getTeamOnTile(){
		return teamOnTile;
	}
	
	public void setX(int x){
		this.xCoord = x;
	}
	
	public int getX(){
		return xCoord;
	}
	
	public void setY(int y){
		this.yCoord = y;
	}
	
	public int getY(){
		return yCoord;
	}
	
	/**
	 * Adds a new neighbor
	 * 
	 * @param neighbor neighbor an adjacent node
	 */
	public void addEdge(TileNode neighbor){
		//Creates a new edge from this vertex to another vertex
		Edge thisEdge = new Edge(neighbor);
		
		//Adds edge to vertex's list of neighbors
		neighbors.add(thisEdge);
	}


	public int compareTo(TileNode arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
