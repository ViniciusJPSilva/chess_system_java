package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner scanf = new Scanner(System.in);
		
		ChessMatch chessMatch = new ChessMatch();
		
		while(true) {
			try {	
				UI.clearScreen();
				UI.printMatch(chessMatch);
				System.out.println();
				System.out.println("Source: ");
				ChessPosition source = UI.readChessPosition(scanf);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.println("Target: ");
				ChessPosition target = UI.readChessPosition(scanf);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			}
			catch(ChessException e) {
				System.out.print(e.getMessage());
				scanf.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				scanf.nextLine();
			}
		}
	}

}
