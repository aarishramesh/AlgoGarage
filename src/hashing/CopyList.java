package hashing;

import java.util.HashMap;

public class CopyList {

	public static void main(String[] args) {
		RandomListNode one = new RandomListNode(1);
		RandomListNode two = new RandomListNode(2);
		RandomListNode three = new RandomListNode(3);
		one.next = two;
		two.next = three;
		one.random = three;
		two.random = one;
		three.random = one;
		
		RandomListNode newHead = copyRandomList(one);
		while (newHead != null) {
			System.out.print("Next : " + (newHead.next != null ? newHead.next.label : "null") );
			System.out.print(" Random : " + ( newHead.random != null ? newHead.random.label : "null"));
			System.out.println();
			newHead = newHead.next;
		}
	}
	
	public static RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode newHead = null;
		if (head != null) {
			newHead = new RandomListNode(head.label);
			HashMap<Integer, RandomListNode> nodesMap = new HashMap<Integer, RandomListNode>();
			nodesMap.put(head.label, newHead);
			RandomListNode itr = newHead;
			
			while (head != null) {
				if (!nodesMap.containsKey(head.label)) {
					RandomListNode curr = new RandomListNode(head.label);
					nodesMap.put(head.label, curr);
				}
				populateNextAndRandom(head, itr, nodesMap);
				head = head.next;
			}
		}
		return newHead;
	}

	static void populateNextAndRandom(RandomListNode head, RandomListNode itr, HashMap<Integer, RandomListNode> nodesMap) {
		if (head.next != null) {
			if (nodesMap.containsKey(head.next.label)) {
				itr.next = nodesMap.get(head.next.label);
			} else {
				RandomListNode next = new RandomListNode(head.next.label);
				nodesMap.put(head.next.label, next);
				itr.next = next;
			}
		}
		if (head.random != null) {
			if (nodesMap.containsKey(head.random.label)) {
				itr.random = nodesMap.get(head.random.label);
			} else {
				RandomListNode random = new RandomListNode(head.random.label);
				nodesMap.put(head.random.label, random);
				itr.random = random;
			}
		}
		itr = itr.next;
	}

	static class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	}
}
