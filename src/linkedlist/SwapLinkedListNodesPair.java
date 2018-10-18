package linkedlist;

public class SwapLinkedListNodesPair {
	public ListNode swapPairs(ListNode first) {
		ListNode second = first.next;
		if (second != null) {
			first.next = swapPairs(second.next);
			second.next = first;
			return second;	
		} else
			return first;
	}

	static class ListNode {
		int data;
		ListNode next;
	}
	
	ListNode pairWiseSwap(ListNode node) { 
        
        // Base Case: The list is empty or has only one node 
        if (node == null || node.next == null) { 
            return node; 
        } 
  
        // Store head of list after two nodes 
        ListNode remaing = node.next.next; 
  
        // Change head 
        ListNode newhead = node.next; 
  
        // Change next of second node 
        node.next.next = node; 
  
        // Recur for remaining list and change next of head 
        node.next = pairWiseSwap(remaing); 
  
        // Return new head of modified list 
        return newhead; 
    } 
    
	ListNode pairWiseSwapIterative(ListNode node) {
		if (node == null || node.next == null)
			return node;
		ListNode curr = node, ahead = node.next, ans = curr.next, prev = null;
		while (curr != null && ahead != null) {
			ListNode temp = ahead.next;
			curr.next = temp;
			ahead.next = curr;
			if (prev != null)
				prev.next = ahead;
			prev = curr;
			curr = temp;
			if (curr != null)
				ahead = curr.next;
		}
		return ans;
	}
}
	