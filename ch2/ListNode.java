public class ListNode
{
	Node head;
	ListNode(int x)
	{
		head = new Node(x);
	}
	ListNode(Node node)
	{
		head = node;
	}

	public Node creat(int[] arr)
	{
		head = new Node(arr[0]);
		Node dummy = head;
		for(int i = 1; i < arr.length; i++)
		{
			dummy.next = new Node(arr[i]);
			dummy = dummy.next;
		}
		return head;
	}

	public void print(Node head)
	{
		Node dummy = head;

		if(head == null)
			return;
		else
		{
			while(dummy.next != null)
			{
				System.out.print(dummy.val + "->");
				dummy = dummy.next;
			}
			System.out.println(dummy.val);
		}
	}

	public Node tail(Node head)
	{
		Node dummy = head;

		if(head == null)
			return head;
		else
		{
			while(dummy.next != null)
			{
				dummy = dummy.next;
			}
			return dummy;
		}
	}

	public void printLoop(Node head, Node tail)
	{
		Node dummy = head;

		if(head == null)
			return;
		else
		{
			while(dummy != null)
			{
				System.out.print(dummy.val + "->");
				dummy = dummy.next;
			}
			System.out.println(tail.val);
		}
	}
}

