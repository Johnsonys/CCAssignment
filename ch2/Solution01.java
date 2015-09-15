public class Solution01
{
	/**
	 *  Solution idea:
	 *
	 *  Use two pointers to traverse the linked list.
	 *  The fast node is used to find the duplicated 
	 *  node. The slow node serves as the template node.
	 *  This function works in O(1) space.
	**/
	public Node remove(Node head)
	{
		if(head == null || head.next == null)
			return head;

		Node slow = head;
		Node fast = head;
		
		while(slow != null)
		{
			fast = slow;
			while(fast.next != null)
			{
				if(fast.next.val == slow.val)
					fast.next = fast.next.next;
				else
					fast = fast.next;
			}
			slow = slow.next;
		}
		return head;
	}

	//Test case
	public static void main(String[] args)
	{
		Solution01 solu = new Solution01();
		ListNode list = new ListNode(0);

		int[] arr1 = {1,1,1,1,1,1,1,1,1,1};
		int[] arr2 = {1,2,3,4,5,1,2,3,4,5};

		Node head1 = list.creat(arr1);
		Node head2 = list.creat(arr2);

		System.out.println("Before remove:");
		list.print(head1);
		head1 = solu.remove(head1);
		System.out.println("After remove:");
		list.print(head1);
		
		System.out.println("Before remove:");
		list.print(head2);
		head2 = solu.remove(head2);
		System.out.println("After remove:");
		list.print(head2);
	}
}