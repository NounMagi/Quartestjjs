package game;

import java.util.Stack;

import game.rules.BadPlayerTurnException;
import game.rules.MoveNotAllowedException;

public class Game {
	
	private Player expectedPlayerInput;
	private Stack<GameState> gamelog;
	
	public Game()
	{
		gamelog = new Stack<GameState>();
		GameState initialState = GameState.initialState();
		gamelog.push(initialState);
		expectedPlayerInput = Player.PlayerA;
	}
	
	public void givePiece(Player player, int pieceID) throws MoveNotAllowedException, BadPlayerTurnException
	{
		if(player == expectedPlayerInput) {
			GameState currentState = gamelog.peek();
			GameState nextState = currentState.givePiece(pieceID);
			gamelog.push(nextState);
			switch(player)
			{
				case PlayerA:
					expectedPlayerInput = Player.PlayerB;
					break;
				case PlayerB:
					expectedPlayerInput = Player.PlayerA;
					break;
			}
		} else {
			throw new BadPlayerTurnException(player);
		}
	}
	
	public void placePiece(Player player, int row, int column) throws MoveNotAllowedException, BadPlayerTurnException
	{
		if(player == expectedPlayerInput){
			GameState currentState = gamelog.peek();
			GameState nextState = currentState.placePiece(row, column);
			gamelog.push(nextState);
			expectedPlayerInput = player;
		} else {
			throw new BadPlayerTurnException(player);
		}
			
	}
}
