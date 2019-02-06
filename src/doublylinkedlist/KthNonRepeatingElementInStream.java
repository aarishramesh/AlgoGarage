package doublylinkedlist;

import java.util.ArrayList;

import doublylinkedlist.KthNonRepeatingElementInStream.DoublyLinkedList.DllNode;

/**
 * https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/
 * 
 * @author polymath
 *
 */
public class KthNonRepeatingElementInStream {
	public static void main(String[] args) {
		KthNonRepeatingElementInStream instance = new KthNonRepeatingElementInStream();
		char[] characters = "geeksforgeeksandgeeksquizfor".toCharArray();
		instance.findKthNonRepeatingElement(characters);
	}
	public void findKthNonRepeatingElement(char[] characters) {
		if (characters != null && characters.length != 0) {
			int[] isCharPresent = new int[256];
			ArrayList<DllNode> nodesList = new ArrayList<DllNode>(256);
			for (int i = 0; i < 256; i++) {
				nodesList.add(null);
			}
			DoublyLinkedList dll = new DoublyLinkedList();
			for (Character ch : characters) {
				if (isCharPresent[ch - '0'] == 0) {
					DllNode node = dll.addDllNode(ch);
					nodesList.set(ch - '0', node);
					isCharPresent[ch - '0'] = 1;
				} else {
					if (isCharPresent[ch - '0'] == 1) {
						DllNode node = nodesList.get(ch - '0');
						dll.removeDllNode(node);
					}
					isCharPresent[ch - '0'] = 2;
				}
				System.out.println(dll.peek() != null ? dll.peek().data : "null");
			}
		}
	}
	
	static class DoublyLinkedList {
		static class DllNode {
			DllNode prev, next;
			Object data;
			
			DllNode(Object data) {
				this.data = data;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((data == null) ? 0 : data.hashCode());
				result = prime * result + ((next == null) ? 0 : next.hashCode());
				result = prime * result + ((prev == null) ? 0 : prev.hashCode());
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				DllNode other = (DllNode) obj;
				if (data == null) {
					if (other.data != null)
						return false;
				} else if (!data.equals(other.data))
					return false;
				if (next == null) {
					if (other.next != null)
						return false;
				} else if (!next.equals(other.next))
					return false;
				if (prev == null) {
					if (other.prev != null)
						return false;
				} else if (!prev.equals(other.prev))
					return false;
				return true;
			}
			
			
		}
		
		DllNode head, tail;
		
		DllNode addDllNode(Object data) {
			DllNode node = new DllNode(data);
			if (head == null) {
				head = node;
				tail = node;
			} else {
				if (head.equals(tail)) {
					head.next = node;
					node.prev = head;
					tail = node;
				} else {
					tail.next = node;
					node.prev = tail;
					tail = node;
				}
			}
			return node;
		}
		
		void removeDllNode(DllNode node) {
			if (node != null) {
				if (node.prev == null && node.next == null) {
					head = tail = null;
				} else {
					if (node.prev != null) {
						if (node.next == null) // tail node removal
							tail = node.prev;
						node.prev.next = node.next;
					}
					if (node.next != null) {
						if (node.prev == null) // head node removal
							head = node.next;
						node.next.prev = node.prev;
					}
				}
			}
		}
		
		DllNode peek() {
			return head;
		}
	}
}
