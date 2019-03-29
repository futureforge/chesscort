package ChessPack;
import java.util.*;

public class Pawn extends Piece{

	//Important to know if it's the pawn's first move when it comes to
	//its move set
	private boolean firstMove;
	
	public Pawn(int x, int y, Board ourBoard) {
		super(x, y, ourBoard);
		firstMove = true;
	}
	
	public void setFirstMove(boolean moveYes){
		firstMove = moveYes;
	}
	
	public boolean getFirstMove(){
		return firstMove;
	}

	/*
	 * @see Piece#moveSet()
	 */
	public ArrayList<TileNode> moveSet(){
		ArrayList<TileNode> moves = new ArrayList<TileNode>();
		
		int x = getX();
		int y = getY();
		
		String thisTeam = ourBoard.getNodeFromCoords(x, y).getTeamOnTile();
		
		TileNode forwardOne = ourBoard.getNodeFromCoords(x, y+1);
		TileNode forwardTwo = ourBoard.getNodeFromCoords(x, y+2);
		TileNode backOne = ourBoard.getNodeFromCoords(x, y-1);
		TileNode backTwo = ourBoard.getNodeFromCoords(x, y-2);
		
		//Need to separate between teams because pawns only move "forward"
		//which is different, depending on the team
		if (thisTeam.equals("white")){
			
			//If tile in front is not occupied, it can move to it
			if (!forwardOne.isOccupied()){
				moves.add(forwardOne);
				
				//If it's the pawn's first move and the tile two spaces ahead
				//is unoccupied, it can move to it
				if (firstMove == true){
					if (!forwardTwo.isOccupied())
						moves.add(forwardTwo);
				}
			}
			
			//If an enemy is directly in front of the pawn, it can move
			//diagonally one space in either direction (forward)
			else if (!forwardOne.getTeamOnTile().equals(thisTeam)){
				moves.add(ourBoard.getNodeFromCoords(x-1, y+1));
				moves.add(ourBoard.getNodeFromCoords(x+1, y+1));
			}
		}
		else if (thisTeam.equals("black")){
			if (!backOne.isOccupied()){
				moves.add(backOne);
				
				if (firstMove == true){
					if (!backTwo.isOccupied())
						moves.add(backTwo);
				}
			}
			
			else if (!backOne.getTeamOnTile().equals(thisTeam)){
				moves.add(ourBoard.getNodeFromCoords(x-1, y-1));
				moves.add(ourBoard.getNodeFromCoords(x+1, y-1));
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
