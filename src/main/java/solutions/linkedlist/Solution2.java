package solutions.linkedlist;

import solutions.datastructure.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @author chujunjie
 * @date Create in 22:00 2020/8/27
 */
public class Solution2 {

    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1 l1
     * @param l2 l2
     * @return ListNode
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode sentinel = dummy;
        int k = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + k;
            k = sum / 10;
            sentinel.next = new ListNode(sum % 10);
            sentinel = sentinel.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (k > 0) {
            sentinel.next = new ListNode(k);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode b1 = new ListNode(4);
        ListNode c1 = new ListNode(3);
        a1.next = b1;
        b1.next = c1;

        ListNode a2 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode c2 = new ListNode(4);
        a2.next = b2;
        b2.next = c2;

        ListNode listNode = addTwoNumbers(a1, a2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
