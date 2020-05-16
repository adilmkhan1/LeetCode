package May2020_Challenge;

public class OddEvenLinkedList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		ListNode head;

		public void insert(int x) {
			ListNode n = new ListNode(x);

			if (head == null) {
				n.next = head;
				head = n;
				return;
			} else {

				ListNode temp = head;

				while (temp.next != null) {
					temp = temp.next;
				}

				n.next = temp.next;
				temp.next = n;
			}
		}

		public void printList() {
			ListNode temp = head;

			while (temp != null) {
				System.out.print(temp.val + " -> " + " ");
				temp = temp.next;
			}

		}

		public ListNode oddEvenList(ListNode head) {
			if (head == null)
				return head;

			ListNode result = head;

			ListNode odd = head;

			ListNode even = head.next;

			ListNode temp = head.next;

			while (odd != null && even != null) {
				ListNode t = even.next;

				if (t == null) // for 2 nodes only check
					break;

				odd.next = even.next;

				odd = odd.next;

				even.next = odd.next;

				even = even.next;

			}

			odd.next = temp; //re-wire odd  tail and even head

			return result;

		}

	}

	public static void main(String[] args) {

		ListNode list = new ListNode();

		list.insert(2);
		list.insert(1);
		list.insert(3);
		list.insert(5);
		list.insert(6);
		list.insert(4);
		list.insert(7);

		list.oddEvenList(list.head);

		list.printList();

	}

}
