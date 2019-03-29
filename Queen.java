package ChessPack;
import java.util.*;

public class Queen extends Piece{

	public Queen(int x, int y, Board ourBoard) {
		super(x, y, ourBoard);
	}
	
	public ArrayList<TileNode> moveSet(){
		ArrayList<TileNode> moves = new ArrayList<TileNode>();
		
		int x = getX();
		int y = getY();
		
		String thisTeam = ourBoard.getNodeFromCoords(x, y).getTeamOnTile();
		
		//Used so that if the queen encounters an obstacle (piece in the way or
		//edge of board) it will not look past the obstacle for potential moves
		int obstacleCounter1 = 0;
		int obstacleCounter2 = 0;
		int obstacleCounter3 = 0;
		int obstacleCounter4 = 0;
		int obstacleCounter5 = 0;
		int obstacleCounter6 = 0;
		int obstacleCounter7 = 0;
		int obstacleCounter8 = 0;
		
		//Like the king, the queen has 8 directions to check. However, the queen
		//checks until the edge of the board or until it hits an obstacle, like
		//the bishop or rook
		for (int i = 1; i <= 8; i++){
			//Checking to the right
			if (obstacleCounter1 == 0){
				TileNode right = ourBoard.getNodeFromCoords(x + i, y);
				
				if (right == null || right.getTeamOnTile().equals(thisTeam))
					obstacleCounter1++;
				
				else{
					if (!right.getTeamOnTile().equals(thisTeam)
							|| !right.isOccupied())
						moves.add(right);
				}
			}
			
			//Checking to the left
			if (obstacleCounter2 == 0){
				TileNode left = ourBoard.getNodeFromCoords(x - i, y);
				
				if (left == null || left.getTeamOnTile().equals(thisTeam))
					obstacleCounter2++;
				
				else{
					if (!left.getTeamOnTile().equals(thisTeam)
							|| !left.isOccupied())
						moves.add(left);
				}
			}
			
			//Checking "up" or forward
			if(obstacleCounter3 == 0){
				TileNode up = ourBoard.getNodeFromCoords(x, y + i);
				
				if (up == null || up.getTeamOnTile().equals(thisTeam))
					obstacleCounter3++;
				
				else{
					if (!up.getTeamOnTile().equals(thisTeam)
							|| !up.isOccupied())
						moves.add(up);
				}
			}
			
			//Checking "down" or backward
			if (obstacleCounter4 == 0){
				TileNode down = ourBoard.getNodeFromCoords(x, y - i);
				
				if (down == null || down.getTeamOnTile().equals(thisTeam))
					obstacleCounter4++;
				
				else{
					if (!down.getTeamOnTile().equals(thisTeam)
							|| !down.isOccupied())
						moves.add(down);
				}
			}
			
			//Checking diagonally forward and to the right
			if (obstacleCounter5 == 0){
				TileNode upRight = ourBoard.getNodeFromCoords(x + i, y + i);
				
				if (upRight == null || upRight.getTeamOnTile().equals(thisTeam))
					obstacleCounter5++;
				
				else{
					if (!upRight.getTeamOnTile().equals(thisTeam)
							|| !upRight.isOccupied())
						moves.add(upRight);
				}
			}
			
			//Checking diagonally backward and to the left
			if (obstacleCounter6 == 0){
				TileNode downLeft = ourBoard.getNodeFromCoords(x - i, y - i);
				
				if (downLeft == null || downLeft.getTeamOnTile().equals(thisTeam))
					obstacleCounter6++;
				
				else{
					if (!downLeft.getTeamOnTile().equals(thisTeam)
							|| !downLeft.isOccupied())
						moves.add(downLeft);
				}
			}
			
			//Checking diagonally forward and to the left
			if(obstacleCounter7 == 0){
				TileNode upLeft = ourBoard.getNodeFromCoords(x - i, y + i);
				
				if (upLeft == null || upLeft.getTeamOnTile().equals(thisTeam))
					obstacleCounter7++;
				
				else{
					if (!upLeft.getTeamOnTile().equals(thisTeam)
							|| !upLeft.isOccupied())
						moves.add(upLeft);
				}
			}
			
			//Checking diagonally backward and to the right
			if (obstacleCounter8 == 0){
				TileNode downRight = ourBoard.getNodeFromCoords(x + i, y - i);
				
				if (downRight == null || downRight.getTeamOnTile().equals(thisTeam))
					obstacleCounter8++;
				
				else{
					if (!downRight.getTeamOnTile().equals(thisTeam)
							|| !downRight.isOccupied())
						moves.add(downRight);
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
