package ChessPack;
import java.io.*;
import java.util.*;

public class Chess {
	private Board thisBoard;

	/**
	 * Builds the Board from the area data file.
	 * 
	 * @param areaFilename The name of a file that contains info for creating
	 * an undirected graph. Vertex names and edge pairs.
	 * @return A Board constructed according to the file input
	 * @throws InvalidAreaFileException if the file does not correspond to a board
	 */
	public static Board createBoardFromAreaFile(String areaFilename) 
			throws InvalidAreaFileException{
		Board b = new Board();
		
		try{
			Scanner scan = new Scanner(new File("src/ChessPack/" + areaFilename));
			scan.nextLine();
			
			//Adding nodes
			while(scan.hasNextInt()){
				b.addTileNode(scan.nextInt(), scan.nextInt());
			}
			scan.next();
			//Adding edges (i.e. connecting the nodes)
			while(scan.hasNextInt()){
				b.addEdge(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
			}
			scan.next();
			//Adding pieces
			while(scan.hasNext()){
				b.addPiece(scan.next().toLowerCase(), scan.next().toLowerCase(),
						scan.nextInt(), scan.nextInt());
			}
			
			scan.close();
		} catch (FileNotFoundException e){
			System.out.println("AREA FILE: " + areaFilename + " was not found.");
			System.exit(1);
		}
		
		return b;
	}
	
	@SuppressWarnings("resource")
	public static Board createCustomBoard(){
		Chess chess = new Chess();
		
		Board b = new Board();
		
		Scanner scan = new Scanner(System.in);
		
		int x;
		int y;
		
		String team;
		String pieceName;
		
		while (true) {
			System.out.print("Input x, y coordinate for tile. \n");
			
			System.out.print("\nX value: ");
			
			x = scan.nextInt();
			
			System.out.print("\nY value: ");
			
			y = scan.nextInt();
			
			b.addTileNode(x, y);
			
			if (b.getHash().containsKey(chess.cantor(x-1,y))){
				b.addEdge(x, y, x-1, y);
			}
			if (b.getHash().containsKey(chess.cantor(x,y-1))){
				b.addEdge(x, y, x, y-1);
			}
			if (b.getHash().containsKey(chess.cantor(x+1,y))){
				b.addEdge(x, y, x+1, y);
			}
			if (b.getHash().containsKey(chess.cantor(x,y+1))){
				b.addEdge(x, y, x, y+1);
			}
			
			System.out.println("\nAdd more? [Y/N]");
			if (scan.next().equals("N")) {
				System.out.println();
				break;
			}
		}
		
		while(true) {
			System.out.println("Add Piece? [Y/N]");
			if (scan.next().equals("N"))
				break;
			
			System.out.print("Input x, y coordinates for piece.\nX value: ");
			
			x = scan.nextInt();
			
			System.out.print("\nY value: ");
			
			y = scan.nextInt();
			
			if (b.getBlackPieceFromCoords(x, y) == null 
					&& b.getWhitePieceFromCoords(x, y) == null) {
				System.out.print("\nTeam [B/W]: ");
				
				team = scan.next();
				
				if (team.equals("b") || team.equals("B"))
					team = "black";
				else if (team.equals("w") || team.equals("W"))
					team = "white";
				
				System.out.print("\nPiece type [Bishop/King/Knight/Pawn/Queen/Rook]: ");
				
				pieceName = scan.next();
				
				b.addPiece(team, pieceName, x, y);
				
				System.out.println();
			}
		}
		
		return b;
	}
	
	public Board getBoard(String areaFilename) throws InvalidAreaFileException{
		if (thisBoard == null){
			thisBoard = Chess.createBoardFromAreaFile(areaFilename);
		}
		return thisBoard;
	}
	
	
	public Board getBoard(){
		if (thisBoard == null){
			thisBoard = Chess.createCustomBoard();
		}
		return thisBoard;
	}
	
	private int cantor(int x, int y){
		int z = ((x+y)*(x+y+1))/2+y;
		
		return z;
	}
}