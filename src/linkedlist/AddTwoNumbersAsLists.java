package linkedlist;

public class AddTwoNumbersAsLists {
	
	public static void main(String[] args) {
		ListNode Aa = new ListNode(2); ListNode Ab = new ListNode(4); ListNode Ac = new ListNode(3);
		Aa.next = Ab; Ab.next = Ac;
		ListNode Ba = new ListNode(5); ListNode Bb = new ListNode(6); ListNode Bc = new ListNode(4);
		Ba.next = Bb; Bb.next = Bc;
		ListNode head = addTwoNumbers(Aa, Ba);
		printNumbersInReverse(head);
	}
	
	public static ListNode addTwoNumbers(ListNode A, ListNode B) {
		ListNode head = null, itr = null; int carry = 0;
		while (A != null || B != null) {
			if (A == null || B == null) {
				int val = 0;
				if (A == null) {
					val = B.val;
					B = B.next;
				} else if (B == null) {
					val = A.val;
					A = A.next;
				}
				int sum = val + carry;
				if (head == null) {
					head = new ListNode(sum % 10);
					itr = head;
				} else {
					itr.next = new ListNode(sum % 10);
					itr = itr.next;
				}
				carry = sum / 10;
			} else {
				int sum = A.val + B.val + carry;
				if (head == null) {
					head = new ListNode(sum % 10);
					itr = head;
				} else {
					itr.next = new ListNode(sum % 10);
					itr = itr.next;
				}
				A = A.next; B = B.next;
				carry = sum / 10;
			}
		}
		if (carry != 0)
			itr.next = new ListNode(carry);
		return head;
	}

	static void printNumbersInReverse(ListNode head) {
		if (head != null) {
			printNumbersInReverse(head.next);
			System.out.print(head.val);
		}
	}
	
	static class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
}
