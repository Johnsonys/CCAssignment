import java.util.*;

public class Solution07
{
	/**
	 *  Solution idea:
	 *
	 *  Traverse the first linked list and store the node using HashSet.
	 *  Then, traverse the second linked list and store the node. If we
	 *  fail to add the node, it means these two lists intersect.
	**/

	public Node getIntersectionNode(Node headA, Node headB) 
	{
        HashSet<Node> set = new HashSet<Node>();
        
        if(headA == null || headB == null)
        return null;
        
        while(headA != null)
        {
            set.add(headA);
            headA = headA.next;
        }
        
        while(headB != null)
        {
            if(!set.add(headB))
            {
               return headB; 
            }
            headB = headB.next;
        }
        
        return null;
    }
	
	//Test case
	public static void main(String[] args)
	{
		Solution07 solu = new Solution07();
		ListNode list = new ListNode(0);

		int[] arr1 = {1};
		int[] arr2 = {2};
		int[] arr3 = {6,7,8,9,10};

		Node head1 = list.creat(arr1);
		Node head2 = list.creat(arr2);
		Node head3 = list.creat(arr3);
		head1.next = head3;
		head2.next = head3;
		Node result = solu.getIntersectionNode(head1, head2);

		
		list.print(head1);
		list.print(head2);
		System.out.println("the intersection of two linked list:");		
		list.print(result);
	}
}