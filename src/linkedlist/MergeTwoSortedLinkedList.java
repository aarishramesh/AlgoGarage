package linkedlist;

public class MergeTwoSortedLinkedList {
	
	public static void main(String[] args) {
		ListNode Aa = new ListNode(5); ListNode Ab = new ListNode(5); ListNode Ac = new ListNode(5);
		Aa.next = Ab; Ab.next = Ac;
		ListNode Ba = new ListNode(4); ListNode Bb = new ListNode(5); ListNode Bc = new ListNode(5);
		Ba.next = Bb; Bb.next = Bc;
		
		ListNode mergedHead = mergeTwoLists(Aa, Ba);
		while (mergedHead != null) {
			System.out.print(mergedHead.val + " ");
			mergedHead = mergedHead.next;
		}
	}
	
	public static ListNode mergeTwoLists(ListNode A, ListNode B) {
		ListNode newHead = null;
		if (A == null)
			return B;
		if (B == null)
			return A;
		if (A != null && B != null) {
			ListNode itr = null;
			while (A != null && B != null) {
				if (A.val != B.val) {
					ListNode newNode = null;
					if (A.val < B.val) {
						newNode = new ListNode(A.val);
						A = A.next;
					} else if (B.val < A.val) {
						newNode = new ListNode(B.val);
						B = B.next;
					}
					if (newHead == null) {
						newHead = newNode;
						itr = newHead;
					} else {
						itr.next = newNode;
						itr = itr.next;
					}
				} else {
					ListNode newNode = new ListNode(A.val);
					if (newHead == null) {
						newHead = newNode;
						itr = newHead;
					} else {
						itr.next = newNode;
						itr = itr.next;
					}
					A = A.next;
					newNode = new ListNode(B.val);
					itr.next = newNode;
					itr = itr.next;
					B = B.next;
				}
			}
			
			if (A == null) {
				while (B != null) {
					ListNode newNode = new ListNode(B.val);
					itr.next = newNode;
					itr = itr.next;
					B = B.next;
				}
			} else if (B == null) {
				while (A != null) {
					ListNode newNode = new ListNode(A.val);
					itr.next = newNode;
					itr = itr.next;
					A = A.next;
				}
			}
		}
		return newHead;
	}

	static class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
}
