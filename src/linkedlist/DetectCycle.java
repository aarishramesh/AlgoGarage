package linkedlist;

import java.util.HashSet;

public class DetectCycle {
	
	static HashSet<ListNode> visited = new HashSet<ListNode>();
	
	public static void main(String[] args) {
		ListNode Aa = new ListNode(1); ListNode Ab = new ListNode(2); ListNode Ac = new ListNode(3);
		ListNode Ad = new ListNode(4);
		Aa.next = Ab; Ab.next = Ac; Ac.next = Ad; Ad.next = Ac;
		ListNode cyclicNode = detectCycle(null);
		System.out.println(cyclicNode != null ? cyclicNode.val : null);
	}
	
	public static ListNode detectCycle(ListNode a) {
		if (a == null)
			return null;
		if (visited.contains(a))
			return a;
		else
			visited.add(a);
		return detectCycle(a.next);
    }
	
	static class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
}
