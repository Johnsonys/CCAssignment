public class Solution01
{
	/**
	 *  Solution idea:
	 *  Use depth-first search to traverse and mark the graph.
	 *  
	 *  P.S. the implementation of directed graph is in "Digraph.java"
	**/

	private boolean[] marked;

	public Solution01(Digraph g)
	{
		marked = new boolean[g.V()];
	}

	public void dfs(Digraph g, int from)
	{
		marked[from] = true;
		for(int v : g.adj())
		{
			if(!marked[v])
				dfs(g, v);
		}
	}

	public boolean isRoute(Digraph g, int from, int to)
	{
		marked = new boolean[g.V()];
		dfs(g, from);
		return marked[to];
	}

	public boolean isMarked(int s)
	{
		return marked[s];
	}
}

