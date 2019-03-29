package ChessPack;
import java.util.ArrayList;

public class Knight extends Piece {

	public Knight(int x, int y, Board ourBoard) {
		super(x, y, ourBoard);
	}
	
	public ArrayList<TileNode> moveSet(){
		ArrayList<TileNode> moves = new ArrayList<TileNode>();
		
		int x = getX();
		int y = getY();
		
		String thisTeam = ourBoard.getNodeFromCoords(x, y).getTeamOnTile();
		
		
		//==================================================================//
		
		//Checks by moving one left, then 2 up
		if (ourBoard.getNodeFromCoords(x - 1, y) != null){
			TileNode xm1yp2 = ourBoard.getNodeFromCoords(x - 1, y + 2);
			
			if (xm1yp2 != null){
				if (!xm1yp2.getTeamOnTile().equals(thisTeam)
						|| !xm1yp2.isOccupied()){
					moves.add(xm1yp2);
				}
			}
		}
		
		
		//==============//
		if (ourBoard.getNodeFromCoords(x - 2, y) != null){
			TileNode xm2yp1 = ourBoard.getNodeFromCoords(x - 2, y + 1);
			
			if (xm2yp1 != null){
				if (!xm2yp1.getTeamOnTile().equals(thisTeam)
						|| !xm2yp1.isOccupied()){
					moves.add(xm2yp1);
				}
			}
		}
		
		
		//==============//
		if (ourBoard.getNodeFromCoords(x - 2, y) != null){
			TileNode xm2ym1 = ourBoard.getNodeFromCoords(x - 2, y - 1);
			
			if (xm2ym1 != null){
				if (!xm2ym1.getTeamOnTile().equals(thisTeam)
						|| !xm2ym1.isOccupied()){
					moves.add(xm2ym1);
				}
			}
		}
		
		
		//==============//
		if (ourBoard.getNodeFromCoords(x - 1, y) != null){
			TileNode xm1ym2 = ourBoard.getNodeFromCoords(x - 1, y - 2);
			
			if (xm1ym2 != null){
				if (!xm1ym2.getTeamOnTile().equals(thisTeam)
						|| !xm1ym2.isOccupied()){
					moves.add(xm1ym2);
				}
			}
		}
		
		
		//==============//
		if (ourBoard.getNodeFromCoords(x + 1, y) != null){
			TileNode xp1yp2 = ourBoard.getNodeFromCoords(x + 1, y + 2);
			
			if (xp1yp2 != null){
				if (!xp1yp2.getTeamOnTile().equals(thisTeam)
						|| !xp1yp2.isOccupied()){
					moves.add(xp1yp2);
				}
			}
		}
		
		
		//==============//
		if (ourBoard.getNodeFromCoords(x + 2, y) != null){
			TileNode xp2yp1 = ourBoard.getNodeFromCoords(x + 2, y + 1);
			
			if (xp2yp1 != null){
				if (!xp2yp1.getTeamOnTile().equals(thisTeam)
						|| !xp2yp1.isOccupied()){
					moves.add(xp2yp1);
				}
			}
		}
		
		
		//==============//
		if (ourBoard.getNodeFromCoords(x + 2, y) != null){
			TileNode xp2ym1 = ourBoard.getNodeFromCoords(x + 2, y - 1);
			
			if (xp2ym1 != null){
				if (!xp2ym1.getTeamOnTile().equals(thisTeam)
						|| !xp2ym1.isOccupied()){
					moves.add(xp2ym1);
				}
			}
		}
		
		
		//==============//
		if (ourBoard.getNodeFromCoords(x + 1, y) != null){
			TileNode xp1ym2 = ourBoard.getNodeFromCoords(x + 1, y - 2);
			
			if (xp1ym2 != null){
				if (!xp1ym2.getTeamOnTile().equals(thisTeam)
						|| !xp1ym2.isOccupied()){
					moves.add(xp1ym2);
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
