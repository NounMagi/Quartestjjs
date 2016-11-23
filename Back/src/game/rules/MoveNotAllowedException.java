package game.rules;

import game.MoveType;

public class MoveNotAllowedException extends Exception{


	private static final long serialVersionUID = -6480001881818879351L;
	
	public MoveNotAllowedException(String desiredMove, MoveType lastMove)
	{
		super("Move '"+desiredMove+"' is not allowed after '"+lastMove+"'");
	}
	
	public MoveNotAllowedException(String message)
	{
		super(message);
	}
	
	public MoveNotAllowedException(int row, int column)
	{
		super( "Board at row '"+row+"',column '"+column+"' is already full." );
	}
}
