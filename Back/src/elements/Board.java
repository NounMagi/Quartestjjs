package elements;

import game.rules.MoveNotAllowedException;

public class Board {
	private static final int WIDTH = 4;
	private static final int HEIGHT = 4;
	
	private Piece[][] boardState;
	
	public Board()
	{
		this.boardState = new Piece[HEIGHT][WIDTH];
	}
	
	private Board(Piece[][] boardToCopy)
	{
		this.boardState = boardToCopy.clone();
	}
	
	public Board placePiece(Piece piece, int row, int column) throws MoveNotAllowedException
	{
		Board newBoard = new Board(boardState);
		if(newBoard.boardState[row][column] == null) {
			newBoard.boardState[row][column] = piece;
		} else {
			throw new MoveNotAllowedException(row, column);
		}
		
		return newBoard;
	}
}
