package solutions.linkedlist;

import solutions.datastructure.ListNode;

/**
 * 反转一个单链表。
 *
 * @author chujunjie
 * @date Create in 21:52 2020/8/27
 */
public class Solution206 {

    /**
     * 递归
     *
     * @param head head
     * @return ListNode
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * 迭代
     *
     * @param head head
     * @return ListNode
     */
    public static ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (null != curr) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode b1 = new ListNode(2);
        ListNode c1 = new ListNode(4);
        a1.next = b1;
        b1.next = c1;

        ListNode listNode = reverseList1(a1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
