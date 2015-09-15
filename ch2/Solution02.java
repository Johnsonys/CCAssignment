public class Solution02
{
	/**
	 *  Solution idea:
	 *
	 *  Use two pointers to traverse the linked list.
	 *  The fast node is ahead of the slow node by k
	 *  distance. When the fast node come to the end 
	 *  of the linked list, the slow node is the answer.
	 *  This function works in O(1) space.
	**/
	public Node getKth(Node head, int k)
	{
		if(head == null || k < 0)
			return null;

		Node fast = head;
		Node slow = head;

		for(int i = 0; i < k; i++)
		{
			if(fast.next != null)
				fast = fast.next;
			else
				return null;
		}

		while(fast.next != null)
		{
			fast = fast.next;
			slow = slow.next;
		}

		return slow;
	}

	//Test case
	public static void main(String[] args)
	{
		Solution02 solu = new Solution02();
		ListNode list = new ListNode(0);

		int[] arr1 = {1,2,3,4,5,6,7,8,9,10};

		Node head1 = list.creat(arr1);

		System.out.println("Linked List:");
		list.print(head1);
		Node k = solu.getKth(head1, 5);
		System.out.println("The 5th to last element is " + k.val);
		
		k = solu.getKth(head1, 0);
		System.out.println("The 0th to last element is " + k.val);
	}
}