package ChessPack;
import java.util.*;

public class King extends Piece{

	public King(int x, int y, Board ourBoard) {
		super(x, y, ourBoard);
	}
	
	/*
	 * @see Piece#moveSet()
	 */
	public ArrayList<TileNode> moveSet(){
		ArrayList<TileNode> moves = new ArrayList<TileNode>();
		
		int x = getX();
		int y = getY();
		
		String thisTeam = ourBoard.getNodeFromCoords(x, y).getTeamOnTile();
		
		TileNode right = ourBoard.getNodeFromCoords(x + 1, y);
		TileNode up = ourBoard.getNodeFromCoords(x, y + 1);
		TileNode left = ourBoard.getNodeFromCoords(x - 1, y);
		TileNode down = ourBoard.getNodeFromCoords(x, y - 1);
		TileNode upRight = ourBoard.getNodeFromCoords(x + 1, y + 1);
		TileNode upLeft = ourBoard.getNodeFromCoords(x - 1, y + 1);
		TileNode downRight = ourBoard.getNodeFromCoords(x + 1, y - 1);
		TileNode downLeft = ourBoard.getNodeFromCoords(x - 1, y - 1);
		
		//The king has 8 directions to check for possible moves, but only one 
		//tile of distance in those 8 directions
		if (right != null){
			if (!right.getTeamOnTile().equals(thisTeam) || !right.isOccupied())
				moves.add(right);
		}
		
		if (up != null){
			if (!up.getTeamOnTile().equals(thisTeam) || !up.isOccupied())
				moves.add(up);
		}
		
		if (left != null){
			if (!left.getTeamOnTile().equals(thisTeam) || !left.isOccupied())
				moves.add(left);
		}
		
		if (down != null){
			if (!down.getTeamOnTile().equals(thisTeam) || !down.isOccupied())
				moves.add(down);
		}
		
		if (upRight != null){
			if (!upRight.getTeamOnTile().equals(thisTeam) || !upRight.isOccupied())
				moves.add(upRight);
		}
	
		if (upLeft != null){
			if (!upLeft.getTeamOnTile().equals(thisTeam) || !upLeft.isOccupied())
				moves.add(upLeft);
		}
		
		if (downRight != null){
			if (!downRight.getTeamOnTile().equals(thisTeam) || !downRight.isOccupied())
				moves.add(downRight);
		}
		
		if (downLeft != null){
			if (!downLeft.getTeamOnTile().equals(thisTeam) || !downLeft.isOccupied())
				moves.add(downLeft);
		}
		
		return moves;
	}
	
	public void printMoves(){
		ArrayList<TileNode> moves = moveSet();
		if (moves.isEmpty())
			System.out.println("No Moves!");
		else {
			for (TileNode n : moves){
				System.out.println(n.getX() + " " + n.getY());
			}
		}
	}
}
