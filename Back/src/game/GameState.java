package game;

import elements.*;
import game.rules.MoveNotAllowedException;
import utils.Tuple;


public class GameState {
	private static GameState INITIAL_STATE;
	
	static
	{
		INITIAL_STATE = new GameState();
		INITIAL_STATE.boardState = new Board();
		INITIAL_STATE.piecesPool = PiecesPool.initPool();
		INITIAL_STATE.lastMove = MoveType.INIT;
	}
	
	private Piece playerAStore;
	private Piece playerBStore;
	
	private PiecesPool piecesPool;
	
	private Board boardState;
	
	private MoveType lastMove;
		
	private GameState()
	{
		
	}
	
	
	public static GameState initialState()
	{
		return INITIAL_STATE;
	}
	
	public GameState givePiece(int pieceID) throws MoveNotAllowedException
	{
		GameState newState = new GameState();
		MoveType nextMove;
		PiecesPool newPool;
		Piece newPlayerAStore;
		Piece newPlayerBStore;
		Tuple<PiecesPool, Piece> pieceMove;
		
		pieceMove = piecesPool.takePiece(pieceID);
		newPool = pieceMove.getLeft();
		switch(lastMove)
		{
			case INIT:
			case PLAYERA_PLACE:
				nextMove = MoveType.PLAYERA_GIVE;
				newPlayerAStore = null;
				newPlayerBStore = pieceMove.getRight();
				break;
				
			case PLAYERB_PLACE:
				nextMove = MoveType.PLAYERB_GIVE;
				newPlayerAStore = pieceMove.getRight();
				newPlayerBStore = null;
				break;
			
			default:
					throw new MoveNotAllowedException("give piece", lastMove);
		}
		
		newState.playerAStore = newPlayerAStore;
		newState.playerBStore = newPlayerBStore;
		newState.piecesPool = newPool;
		newState.boardState = boardState;
		newState.lastMove = nextMove;
		return newState;
	}
	
	public GameState placePiece(int row, int column) throws MoveNotAllowedException
	{
		GameState newState = new GameState();
		MoveType nextMove;
		Board newBoard;
		
		switch(lastMove)
		{
			case PLAYERA_GIVE:
				nextMove =  MoveType.PLAYERB_PLACE;
				newBoard = boardState.placePiece(playerBStore, row, column);
				break;
			
			case PLAYERB_GIVE:
				nextMove =  MoveType.PLAYERA_PLACE;
				newBoard = boardState.placePiece(playerAStore, row, column);
				break;

			default:
				throw new MoveNotAllowedException("place piece", lastMove);
		}
		
		newState.playerAStore = null;
		newState.playerBStore = null;
		newState.piecesPool = piecesPool;
		newState.boardState = newBoard;
		newState.lastMove = nextMove;
		
		return newState;
	}
}
