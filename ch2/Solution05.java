public class Solution05
{
	/**
	 *  Solution idea:
	 *
	 *  In the reverse order, we can sum in a logical way which works 
	 *  from the lower digit to the higher digit.
	 *  While in the forward order, we just need to write a function that
	 *  can reverse the linked list. Then, we can do the sum in a reverse
	 *  order.
	**/
	public Node sumListReverse(Node n1, Node n2)
	{
		if(n1 == null)
			return n2;
		if(n2 == null)
			return n1;

		Node head = new Node((n1.val + n2.val)%10);
		Node dummy = head;
		int flag = (n1.val + n2.val) > 9 ? 1 : 0;

		while(n1.next != null && n2.next != null)
		{
			n1 = n1.next;
			n2 = n2.next;
			dummy.next = new Node((n1.val + n2.val)%10 + flag);
			flag = (n1.val + n2.val + flag) > 9 ? 1 : 0;
			dummy = dummy.next;
		}

		if(n1.next != null)
			dummy.next = n1.next;
		else 
			dummy.next = n2.next;

		if(dummy.next != null)
			dummy.next.val += flag;

		return head;
	}

	public Node sumListForward(Node n1, Node n2)
	{
		n1 = reverseList(n1);
		n2 = reverseList(n2);
		Node n3 = sumListReverse(n1, n2);
		return reverseList(n3);		
	}

	public Node reverseList(Node head) 
	{
        if(head == null)
        return head;
        
        Node cur = head;
        Node node = null;
        
        while(head.next != null)
        {
            head = head.next;
            cur.next = node;
            node = cur;
            cur = head;
        }
        head.next = node;
        
        return head;
    }

	//Test case
	public static void main(String[] args)
	{
		Solution05 solu = new Solution05();
		ListNode list = new ListNode(0);

		int[] arr1 = {7,1,6};
		int[] arr2 = {5,9,2};
		int[] arr3 = {6,1,7};
		int[] arr4 = {2,9,5};

		Node head1 = list.creat(arr1);
		Node head2 = list.creat(arr2);
		Node head3 = list.creat(arr3);
		Node head4 = list.creat(arr4);

		list.print(head1);
		System.out.println("plus");
		list.print(head2);
		System.out.println("in reverse order, the sum is:");
		Node result = solu.sumListReverse(head1, head2);
		list.print(result);

		System.out.println();

		list.print(head3);
		System.out.println("plus");
		list.print(head4);
		System.out.println("in forward order, the sum is:");
		result = solu.sumListForward(head3, head4);
		list.print(result);
	}
}