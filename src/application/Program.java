package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ChessMatch chessmatch = new ChessMatch();
		
		
		while(true) {
			try {
				UI.clearScreen();
				UI.printMatch(chessmatch);
			
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean [][] posssibleMoves = chessmatch.possibleMoves(source);
				
				UI.clearScreen();
				UI.printBoard(chessmatch.getPieces(), posssibleMoves);
			
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
			
				ChessPiece capturedPiece = chessmatch.performChessMove(source, target);
			}
			catch(ChessException e) {
				System.out.print(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.print(e.getMessage());
				sc.nextLine();
			}
			
		}
		
	}

}
