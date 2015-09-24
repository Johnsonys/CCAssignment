import java.util.*;

public class Solution06
{
	/**
	 *  Solution idea:
	 *
	 *  Implement the animanl class with rank variable that
	 *  the older animal has a smaller rank. When dequeue 
	 *  happens, we can return the first of the linkedlist
	 *  which has a smaller rank.
	**/
	public LinkedList<Animal> dog;
	public LinkedList<Animal> cat;
	public int count;

	public Solution06()
	{
		dog = new LinkedList<Animal>();
		cat = new LinkedList<Animal>();
		count = 0;
	}

	public void enqueue(Animal ani)
	{
		ani.setRank(count++);
		if(ani.type == 'd')
			dog.add(ani);
		else
			cat.add(ani);
	}

	public Animal dequeueAny()
	{
		int dogRank = dog.getFirst().getRank();
		int catRank = cat.getFirst().getRank();
		if(dogRank < catRank)
			return dog.removeFirst();
		else
			return cat.removeFirst();
	}

	public Animal dequeueDog()
	{
		return dog.removeFirst();
	}

	public Animal dequeueCat()
	{
		return cat.removeFirst();
	}

}

class Animal
{
	char type;
	int rank;

	public void setRank(int r)
	{
		this.rank = r;
	}

	public int getRank()
	{
		return this.rank;
	}
}

