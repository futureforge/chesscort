package ChessPack;
import java.util.*;

public class Rook extends Piece {
	
	public Rook(int x, int y, Board ourBoard) {
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
		
		//Used so that if the rook encounters an obstacle (piece in the way or
		//edge of board) it will not look past the obstacle for potential moves
		int obstacleCounter1 = 0;
		int obstacleCounter2 = 0;
		int obstacleCounter3 = 0;
		int obstacleCounter4 = 0;
		
		//Loop up to 7 because that is the maximum distance a rook would ever
		//be able to travel on a standard 8x8 chess board
		for (int i = 1; i <= 8; i++){
			if (obstacleCounter1 == 0){
				TileNode right = ourBoard.getNodeFromCoords(x + i, y);
				
				//If it reaches the edge of the board or a friendly piece
				//it will not consider that a move and it will stop looking
				//in that direction
				if (right == null || right.getTeamOnTile().equals(thisTeam))
					obstacleCounter1++;
				
				//If the tile in question is unoccupied, it is a potential move
				else if (!right.isOccupied())
					moves.add(right);
				
				//If the tile has an enemy, it is a potential move, but tiles
				//after the enemy in the same direction are not
				else if (!right.getTeamOnTile().equals(thisTeam)){
					moves.add(right);
					obstacleCounter1++;
				}
				
			}
			
			if (obstacleCounter2 == 0){
				TileNode left = ourBoard.getNodeFromCoords(x - i, y);
				
				if (left == null || left.getTeamOnTile().equals(thisTeam))
					obstacleCounter2++;
				
				else if (!left.isOccupied())
					moves.add(left);
				
				else if (!left.getTeamOnTile().equals(thisTeam)){
					moves.add(left);
					obstacleCounter2++;
				}
			}
			
			if(obstacleCounter3 == 0){
				TileNode up = ourBoard.getNodeFromCoords(x, y + i);
				
				if (up == null || up.getTeamOnTile().equals(thisTeam))
					obstacleCounter3++;
				
				else if (!up.isOccupied())
					moves.add(up);
				
				else if (!up.getTeamOnTile().equals(thisTeam)){
					moves.add(up);
					obstacleCounter3++;
				}
			}
			
			if (obstacleCounter4 == 0){
				TileNode down = ourBoard.getNodeFromCoords(x, y - i);
				
				if (down == null || down.getTeamOnTile().equals(thisTeam))
					obstacleCounter4++;
				
				else if (!down.isOccupied())
					moves.add(down);
				
				else if (!down.getTeamOnTile().equals(thisTeam)){
					moves.add(down);
					obstacleCounter4++;
				}
			}
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
