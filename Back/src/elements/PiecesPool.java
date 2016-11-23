package elements;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import utils.Tuple;

public class PiecesPool {
	
	private Piece[] piecesInPool;
	
	private PiecesPool()
	{}
	
	private PiecesPool(PiecesPool poolToCopy)
	{
		piecesInPool = poolToCopy.piecesInPool.clone();
	}
	
	public static PiecesPool initPool()
	{
		PiecesPool newPool = new PiecesPool();
		newPool.piecesInPool = new Piece[16];
		IntStream.range(0, 16).forEach(i -> newPool.piecesInPool[i] = new Piece(i));
		return newPool;
	}
	
	public Tuple<PiecesPool, Piece> takePiece(int id)
	{
		PiecesPool newPool = new PiecesPool(this);
		Piece piece = newPool.piecesInPool[id];
		newPool.piecesInPool[id] = null;
		return new Tuple<PiecesPool, Piece>(newPool, piece);
	}
	
	public Stream<Piece> availablePiecesStream()
	{
		return Stream.of(piecesInPool).filter(p -> p != null);
	}
	
	public boolean poolContainsPiece(int id)
	{
		return piecesInPool[id] != null;
	}
}
