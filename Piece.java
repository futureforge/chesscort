package ChessPack;
import java.util.*;

public abstract class Piece {
	public int coordX, coordY;
	Board ourBoard;
	
	public Piece(int x, int y, Board ourBoard){
		coordX = x;
		coordY = y;
		this.ourBoard = ourBoard;
	}
	
	public int getX(){
		return coordX;
	}
	
	public int getY(){
		return coordY;
	}
	
	public void setX(int x){
		coordX = x;
	}
	
	public void setY(int y){
		coordY = y;
	}
	
	/*
	 * Prints out the moves of the piece (mostly used for testing)
	 */
	public abstract void printMoves();
	
	/*
	 * Returns an ArrayList of TileNodes that the piece can move to
	 */
	public abstract ArrayList<TileNode> moveSet();
}
