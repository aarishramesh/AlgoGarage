package linkedlist;

public class PartitionList {
	
	public static void main(String[] args) {
		ListNode Aa = new ListNode(6); ListNode Ab = new ListNode(4);
		Aa.next = Ab;
		//ListNode Ab = new ListNode(4); ListNode Ac = new ListNode(3);
		//ListNode Ad = new ListNode(2); ListNode Ae = new ListNode(5); ListNode Af = new ListNode(2);
		//Aa.next = Ab; Ab.next = Ac; Ac.next = Ad; Ad.next = Ae; Ae.next = Af;
		ListNode newHead = partition(Aa, 5);
		while (newHead != null) {
			System.out.print(newHead.val + " ");
			newHead = newHead.next;
		}
	}
	
	public static ListNode partition(ListNode A, int B) {
		if (A != null) {
			ListNode itr = A, largerHead = null, largerItr = null, smallerHead = null, smallerItr = null;
			while (itr != null) {
				if (itr.val >= B) {
					if (largerHead == null) {
						largerHead = new ListNode(itr.val);
						largerItr = largerHead;
					} else {
						largerItr.next = new ListNode(itr.val);
						largerItr = largerItr.next;
					}
				} else {
					if (smallerHead == null) {
						smallerHead = new ListNode(itr.val);
						smallerItr = smallerHead;
					} else {
						smallerItr.next = new ListNode(itr.val);
						smallerItr = smallerItr.next;
					}
				}
				itr = itr.next;
			}
			if (smallerHead != null) {
				smallerItr.next = largerHead;
				return smallerHead;
			} else
				return largerHead;
		}
		return null;
	}
	
	static class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
}
