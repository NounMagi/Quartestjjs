package game.rules;

import game.Player;

public class BadPlayerTurnException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4933864598955163331L;
	private Player faultyPlayer;
	public BadPlayerTurnException(Player p)
	{
		super("It is not player '"+p+"' turn to play.");
		faultyPlayer = p;
	}
	
	public Player getFaultyPlayer()
	{
		return faultyPlayer;
	}
	
}
