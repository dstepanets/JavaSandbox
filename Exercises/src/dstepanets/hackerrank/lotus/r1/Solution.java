package dstepanets.hackerrank.lotus.r1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class SinglyLinkedListNode {
	public final int data;
	public SinglyLinkedListNode next;

	public SinglyLinkedListNode(int nodeData) {
		this.data = nodeData;
		this.next = null;
	}
}

class SinglyLinkedList {
	public SinglyLinkedListNode head;
	public SinglyLinkedListNode tail;

	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void insertNode(int nodeData) {
		SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

		if (this.head == null) {
			this.head = node;
		} else {
			this.tail.next = node;
		}

		this.tail = node;
	}
}

class SinglyLinkedListPrintHelper {
	public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}
}



class Result {

	/*
	 * Complete the 'removeNodes' function below.
	 *
	 * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
	 * The function accepts following parameters:
	 *  1. INTEGER_SINGLY_LINKED_LIST listHead
	 *  2. INTEGER x
	 */

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode {
	 *     int data;
	 *     SinglyLinkedListNode next;
	 * }
	 *
	 */

	public static SinglyLinkedListNode removeNodes(SinglyLinkedListNode listHead, int x) {
		SinglyLinkedListNode cur = listHead, prev = null;
		while (cur != null) {
			if (cur.data > x) {
				if (cur == listHead) {
					listHead = listHead.next;
				} else {
					prev.next = cur.next;
				}
			} else {
				prev = cur;
			}
			cur = cur.next;
		}
		return listHead;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		SinglyLinkedList listHead = new SinglyLinkedList();

		int listHeadCount = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, listHeadCount).forEach(i -> {
			try {
				int listHeadItem = Integer.parseInt(bufferedReader.readLine().trim());

				listHead.insertNode(listHeadItem);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int x = Integer.parseInt(bufferedReader.readLine().trim());

		SinglyLinkedListNode result = Result.removeNodes(listHead.head, x);

		SinglyLinkedListPrintHelper.printList(result, "\n", bufferedWriter);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
