package ChessPack;
import java.util.*;

public class Bishop extends Piece {
	
	public Bishop(int x, int y, Board ourBoard){
		super(x, y, ourBoard);
	}

	public ArrayList<TileNode> moveSet(){
		ArrayList<TileNode> moves = new ArrayList<TileNode>();
		
		int x = getX();
		int y = getY();
		
		String thisTeam = ourBoard.getNodeFromCoords(x, y).getTeamOnTile();
		
		//Used so that if the bishop encounters an obstacle (piece in the way or
		//edge of board) it will not look past the obstacle for potential moves
		int obstacleCounter1 = 0;
		int obstacleCounter2 = 0;
		int obstacleCounter3 = 0;
		int obstacleCounter4 = 0;
		
		//The bishop has 4 directions to check and can go until the end of the
		//board or until it hits an obstacle, much like the rook
		for (int i = 1; i <= 8; i++){
			if (obstacleCounter1 == 0){
				TileNode upRight = ourBoard.getNodeFromCoords(x + i, y + i);
				
				if (upRight == null || upRight.getTeamOnTile().equals(thisTeam))
					obstacleCounter1++;
				
				else{
					if (!upRight.getTeamOnTile().equals(thisTeam)
							|| !upRight.isOccupied())
						moves.add(upRight);
				}
			}
			if (obstacleCounter2 == 0){
				TileNode downLeft = ourBoard.getNodeFromCoords(x - i, y - i);
				
				if (downLeft == null || downLeft.getTeamOnTile().equals(thisTeam))
					obstacleCounter2++;
				
				else{
					if (!downLeft.getTeamOnTile().equals(thisTeam)
							|| !downLeft.isOccupied())
						moves.add(downLeft);
				}
			}
			if(obstacleCounter3 == 0){
				TileNode upLeft = ourBoard.getNodeFromCoords(x - i, y + i);
				
				if (upLeft == null || upLeft.getTeamOnTile().equals(thisTeam))
					obstacleCounter3++;
				
				else{
					if (!upLeft.getTeamOnTile().equals(thisTeam)
							|| !upLeft.isOccupied())
						moves.add(upLeft);
				}
			}
			if (obstacleCounter4 == 0){
				TileNode downRight = ourBoard.getNodeFromCoords(x + i, y - i);
				
				if (downRight == null || downRight.getTeamOnTile().equals(thisTeam))
					obstacleCounter4++;
				
				else{
					if (!downRight.getTeamOnTile().equals(thisTeam)
							|| !downRight.isOccupied())
						moves.add(downRight);
				}
			}
		}
		
		return moves;
	}
	
	public void printMoves() {
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
