import java.util.*;

public class Digraph
{
	public int V;
	public int E;
	public ArrayList<ArrayList<Integer>> adj;

	public Digraph(int v)
	{
		this.V = v;
		this.E = 0;
		adj = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < v; i++)
			adj.set(i, new ArrayList<Integer>());
	}

	public int V()
	{
		return V;
	}

	public int E()
	{
		return E;
	}

	public void add(int from, int to)
	{
		adj.get(from).add(to);
		E++;
	}

	public Iterable<Integer> adj()
	{
		return adj.get(V);
	}
}
	
	