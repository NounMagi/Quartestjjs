package utils;

public class Tuple<A,B> {
	
	private A left;
	private B right;
	
	public Tuple(A left, B right)
	{
		this.left = left;
		this.right = right;
	}
	
	public A getLeft()
	{
		return this.left;
	}
	
	public B getRight()
	{
		return this.right;
	}
}
