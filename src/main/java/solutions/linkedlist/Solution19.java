package solutions.linkedlist;

import solutions.datastructure.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * @author chujunjie
 * @date Create in 21:55 2020/8/27
 */
public class Solution19 {

    /**
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * <p>
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     *
     * @param head head
     * @param n    n
     * @return ListNode
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (null != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode b1 = new ListNode(2);
        ListNode c1 = new ListNode(3);
        ListNode d1 = new ListNode(4);
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;

        ListNode listNode = removeNthFromEnd(a1, 3);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
