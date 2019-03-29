package ChessPack;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	public static void main(String[] args) 
			throws FileNotFoundException, InvalidAreaFileException, InvalidMoveException {
		Scanner scan = new Scanner(System.in);
		Chess chessGame = new Chess();
		Board board;
		
		System.out.print("Load area file [0] or create custom board [1]: ");
		
		if (scan.nextInt() == 1){
			System.out.println();
			board = chessGame.getBoard();
		}
		
		else{
			//If incorrect number of arguments, exit
			if (args.length != 1){
				System.out.println("Usage: java main area.txt");
				System.exit(1);
			}
		
			//Board file is the text document in the 0th index command line argument
			String areaFilename = args[0];
		
			//Creates the board based on the file
			board = chessGame.getBoard(areaFilename);
		}
		
		System.out.println("Starting team is WHITE");
		
		String team = "white";
		
		int xStart = 0;
		int yStart = 0;
		int xEnd;
		int yEnd;
		
		int counter = 0;
		
		do {
			while(counter == 0){
				/*
				 * Choose a piece to move based on coordinates
				 */
				System.out.println("Choose a piece to move (coordinates)");
				
				System.out.print("X-Coordinate: ");
				if (scan.hasNextInt())
					xStart = scan.nextInt();
				System.out.println();
				
				System.out.print("Y-Coordinate: ");
				if (scan.hasNextInt())
					yStart = scan.nextInt();
				System.out.println();
				
				/*
				 * Lists the viable moves
				 */
				if (team.equals("white")){
					Piece whitePiece = board.getWhitePieceFromCoords(xStart, yStart);
					while (whitePiece.moveSet().isEmpty()) {
						System.out.println("No viable moves, pick a different piece!");
						
						System.out.print("X-Coordinate: ");
						xStart = scan.nextInt();
						System.out.println();
						
						System.out.print("Y-Coordinate: ");
						yStart = scan.nextInt();
						System.out.println();
						
						whitePiece = board.getWhitePieceFromCoords(xStart, yStart);
					}
					System.out.println("Selected Piece: " + whitePiece.toString()
						.split("@", 2)[0].replace("ChessPack.", "") + " ");
					System.out.println("Viable moves:");
					whitePiece.printMoves();
				}
				else{
					Piece blackPiece = board.getBlackPieceFromCoords(xStart, yStart);
					while (blackPiece.moveSet().isEmpty()) {
						System.out.println("No viable moves, pick a different piece!");
						
						System.out.print("X-Coordinate: ");
						xStart = scan.nextInt();
						System.out.println();
						
						System.out.print("Y-Coordinate: ");
						yStart = scan.nextInt();
						System.out.println();
						
						blackPiece = board.getBlackPieceFromCoords(xStart, yStart);
					}
					System.out.println("Selected Piece: " + blackPiece.toString()
						.split("@", 2)[0].replace("ChessPack.", "") + " ");
					System.out.println("Viable moves:");
					blackPiece.printMoves();
				}
				
				/*
				 * Choose a tile to move to based on coordinates
				 */
				System.out.println("\nChoose a place to move to (coordinates)");
				System.out.print("X-Coordinate: ");
				xEnd = scan.nextInt();
				System.out.println();
				
				System.out.print("Y-Coordinate: ");
				yEnd = scan.nextInt();
				System.out.println();
				
				/*
				 * Shows that the move is being made and consequently makes the move.
				 * If the move fails, it displays an error message and loops back.
				 */
				System.out.println("Moving Piece.");
				try{
					board.movePieceAtCoords(xStart, yStart, xEnd, yEnd, team);
					counter++;
				}
				catch (InvalidMoveException e){
					System.out.println("Move Failed");
				}
			}
			
			counter = 0;
			
			System.out.println("/==============/");
			/*
			 * Lists the white and black pieces still on the board
			 */
			System.out.print("Current White Pieces: ");
			for (Piece p : board.getWhitePieces())
				System.out.print(p.toString().split("@", 2)[0].replace("ChessPack.", "") + " ");
			
			System.out.println();
			
			System.out.print("Current Black Pieces: ");
			for (Piece p : board.getBlackPieces())
				System.out.print(p.toString().split("@", 2)[0].replace("ChessPack.", "") + " ");
			
			System.out.println();
			
			/*
			 * Lists the removed white and black pieces in reverse order
			 * that they were removed
			 */
			System.out.println("Removed White Pieces: ");
			if (!(board.getRemovedWhite() == null)){
				for (int i = 0; i < board.getRemovedWhite().size(); i++)
					if (board.getRemovedWhite().get(i) != null)
						System.out.print(board.getRemovedWhite().get(i).toString()
								.split("@", 2)[0] + " ");
			}
			
			System.out.println();
			
			System.out.println("Removed Black Pieces: ");
			if (!(board.getRemovedBlack() == null)){
				for (int i = 0; i < board.getRemovedBlack().size(); i++)
					if (board.getRemovedBlack().get(i) != null)
						System.out.print(board.getRemovedBlack().get(i).toString()
								.split("@", 2)[0] + " ");
			}
			
			System.out.println("\n/==============/\n");
			
			System.out.println("Changing teams.");
			
			if (team.equals("white"))
				team = "black";
			else if (team.equals("black"))
				team = "white";
			
			System.out.println("Type 'Y' to Continue");
		} while (!scan.next().equals("end"));
		
		scan.close();
	}
}