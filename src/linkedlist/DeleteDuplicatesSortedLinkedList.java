package linkedlist;

public class DeleteDuplicatesSortedLinkedList {

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(1);
		ListNode d = new ListNode(1);
		ListNode e = new ListNode(2);
		ListNode f = new ListNode(2); ListNode g = new ListNode(2); ListNode h = new ListNode(2);
		a.next = b; b.next = c; c.next = d; d.next = e; e.next = f; f.next = g; g.next = h;
		ListNode head = removeDuplicate(a);
		
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
	public ListNode deleteDuplicates(ListNode A) {
		ListNode curr = A;
		while (curr != null && curr.next != null) {
			ListNode ahead = curr.next;
			while (ahead != null && curr.val == ahead.val)
				ahead = ahead.next;
			if (!curr.next.equals(ahead)) {
				curr.next = ahead;
			}
			curr = ahead;
		}
		return A;
    }
	
	public static ListNode removeDuplicate(ListNode A) {
		if (A == null || A.next == null) {
			return A;
		}
		if (A.next.next == null) {
			if (A.val == A.next.val) {
				return null;
			} else {
				return A;
			}
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = A;
		ListNode curr = A, prev = dummy;
		while (curr != null) {
			while (curr.next != null && prev.next.val == curr.next.val) {
				curr = curr.next;
			}
			if (prev.next == curr)
				prev = prev.next;
			else
				prev.next = curr.next;
			curr = curr.next;
		}
		
		return dummy.next;
	}
	
	static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
	}
}
