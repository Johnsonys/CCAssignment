import java.util.*;

public class Solution06
{
	/**
	 *  Solution idea:
	 *
	 *  Use a stack to store the first half of the 
	 *  linked list. Then, we can compare the node 
	 *  at the top of the stack to the node at the
	 *  symmetrical half until the stack is empty.
	 *  If all results of the comparation is true,
	 *  the linked list is a palindrome.
	**/
	public boolean isPalindrome(Node head) 
	{
        if(head == null || head.next == null)
        return true;
        
        if(head.next.next == null)
        {
            if(head.val != head.next.val)
            return false;
        }
        
        //use two pointers to find the middle of the linked list
        Node front = head;
        Node end = head;
        
        Stack<Node> stack = new Stack<Node>();
        stack.push(front);
        while(end.next != null && end.next.next != null)
        {
            end = end.next.next;
            front = front.next;
            stack.push(front);
        }
        
        if(end.next == null)
        {
            stack.pop();
        }
        
        while(!stack.empty())
        {
            Node node = stack.pop();
            front = front.next;
            if(front.val != node.val)
            return false;
        }
        
        return true;
    }

	//Test case
	public static void main(String[] args)
	{
		Solution06 solu = new Solution06();
		ListNode list = new ListNode(0);

		int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
		int[] arr2 = {1,2,3,4,5,4,3,2,1};

		Node head1 = list.creat(arr1);
		Node head2 = list.creat(arr2);

		System.out.println("Linked List:");
		list.print(head1);
		if(solu.isPalindrome(head1))		
			System.out.println("is a palindrome");
		else
			System.out.println("is not a palindrome");

		System.out.println();

		System.out.println("Linked List:");
		list.print(head2);
		if(solu.isPalindrome(head2))		
			System.out.println("is a palindrome");
		else
			System.out.println("is not a palindrome");
	}
}