package leetCode;

/**
 * @Author: mengchao
 * @Date: 2020/11/29 23:35
 */
public class LeetCode21 {

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {
        ListNode finalListNode = new ListNode();
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode listNode = new ListNode();
            if (l1.val< l2.val){
                listNode.val = l2.val;
                mergeTwoLists()
            }else if (l1.val> l2.val){
                listNode.val = l1.val;
            }else {
                listNode.val = l1.val;
                ListNode listNode1 = new ListNode(l1.val);
                listNode.next = listNode1;
            }

            finalListNode.next = listNode;
        }

        public ListNode merge(){

        }
    }
}
