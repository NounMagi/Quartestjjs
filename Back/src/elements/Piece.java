package elements;

import elements.properties.*;

public class Piece {
	private int id;
	private PieceColor color;
	private PieceHeight height;
	private PieceHole hole;
	private PieceShape shape;
	
	
	public Piece(PieceColor color, PieceHeight height, PieceHole hole, PieceShape shape)
	{
		this.color = color;
		this.height = height;
		this.hole = hole;
		this.shape = shape;
	}
	
	public Piece(int id)
	{
		this.color = (id & 1) == 0 ? PieceColor.WHITE: PieceColor.BLACK;
		this.height = (id & 2) == 0 ? PieceHeight.SMALL: PieceHeight.BIG;
		this.hole = (id & 4) == 0 ? PieceHole.NO_HOLE: PieceHole.WITH_HOLE;
		this.shape = (id & 8) == 0 ? PieceShape.ROUND: PieceShape.SQUARE;	
	}
	
}
