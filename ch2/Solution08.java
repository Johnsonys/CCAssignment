public class Solution08
{
	/**
	 *  Solution idea:
	 *
	 *  To find the beginning of the loop, we can cut the circular
	 *  list to a singly list. Then, the result is the end of the 
	 *  singly list.
	**/

	public Node loop(Node head)
	{
		Node front = head.next;
		Node end = head;

		while(front.next != null)
		{
			end.next = null;
			end = front;
			front = front.next;
		}

		return front;
	}
	
	//Test case
	public static void main(String[] args)
	{
		Solution08 solu = new Solution08();
		ListNode list = new ListNode(0);

		int[] arr1 = {1,2,3,4,5,6,7,8,9};

		Node head1 = list.creat(arr1);
		Node tail = list.tail(head1);
		list.printLoop(head1, head1.next.next.next.next);
		tail.next = head1.next.next.next.next;

		Node result = solu.loop(head1);	
				
		System.out.println("the beginning of the loop is: " + result.val);				
	}
}