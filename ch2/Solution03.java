public class Solution03
{
	/**
	 *  Solution idea:
	 *
	 *  We can copy the next node and delete it.
	**/
	public void delete(Node middle)
	{
		if(middle == null || middle.next == null)
			middle = null;
		else
		{
			middle.val = middle.next.val;
			middle.next = middle.next.next;
		}
	}

	//Test case
	public static void main(String[] args)
	{
		Solution03 solu = new Solution03();
		ListNode list = new ListNode(0);

		int[] arr1 = {1,2,3,4,5};

		Node head1 = list.creat(arr1);
		Node middle = head1.next.next;

		System.out.println("Linked List:");
		list.print(head1);
		solu.delete(middle);
		System.out.println("After delete middle node:");
		list.print(head1);
	}
}
