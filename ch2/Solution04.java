public class Solution04
{
	/**
	 *  Solution idea:
	 *
	 *  We can start a new list with a dummy node and insert node
	 *  with following principles:
	 *  1) Nodes before the dummy node are less than the target value
	 *  2) Dummy node is the last node less than the target value
	 *  3) Nodes after the dummy node are greater than the target value
	**/
	public Node partition(Node head, int val)
	{
		if(head == null || head.next == null)
			return head;

		Node front = new Node(0);
		Node dummy = front;
		Node cur = head;

		while(head != null)
		{
			if(head.val < val)
			{
				cur = head.next;
				head.next = dummy.next;
				dummy.next = head;
				dummy = dummy.next;
				head = cur;
			}
			else
			{
				cur = head.next;
				head.next = dummy.next;
				dummy.next = head;
				head = cur;
			}
		}

		return front.next;
	}

	//Test case
	public static void main(String[] args)
	{
		Solution04 solu = new Solution04();
		ListNode list = new ListNode(0);

		int[] arr1 = {10,9,8,7,6,5,4,3,2,1};

		Node head1 = list.creat(arr1);

		System.out.println("Linked List:");
		list.print(head1);
		head1 = solu.partition(head1, 5);
		System.out.println("Partition around the value 5:");
		list.print(head1);
		head1 = solu.partition(head1, 2);
		System.out.println("Partition around the value 2:");
		list.print(head1);
	}
}