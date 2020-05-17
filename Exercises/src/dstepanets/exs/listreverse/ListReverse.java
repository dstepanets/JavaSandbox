package dstepanets.exs.listreverse;

class Node {

	public final int data;
	public Node next;

	Node(int d) {
		data = d;
		next = null;
	}

	public void addNode(Node n) {

		Node t = this;

		while (t.next != null) {
			t = t.next;
		}
		t.next = n;
	}

}

class Reverse {

	public static Node reverse_list(Node head) {

		if (head == null) {
			head.next = null;
			return head;
		}

		Node rev = head;
		Node ltd = head.next;
		Node tmp;

		head.next = null;
		while (ltd != null) {
			tmp = ltd;
			ltd = ltd.next;
			tmp.next = rev;
			rev = tmp;
		}

		return rev;
	}
}

class Main {

	public static void main(String[] args) {

		Node list = new Node(0);
		for (int i = 1; i < 5; i++) {
			list.addNode(new Node(i));
		}

		Node p = list;
		while (p != null) {
			System.out.print(p.data);
			p = p.next;
		}
		System.out.println();


		p = Reverse.reverse_list(list);
		while (p != null) {
			System.out.print(p.data);
			p = p.next;
		}
		System.out.println();

	}

}

