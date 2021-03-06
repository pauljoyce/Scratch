package leetCode;

/**
 * 判断链表是否有环
 * @Author: mengchao
 * @Date: 2020/11/25 23:28
 */
public class LeetCode141 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = head;
        while (node2!=null&&node2.next!=null){
            node1 = node1.next;
            node2 = node2.next.next;
            if (node1==node2){
                return true;
            }
        }
        return false;
    }
}
