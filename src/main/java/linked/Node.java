package linked;

import java.util.HashSet;
import java.util.Objects;

/**
 * @Author: mengchao
 * @Date: 2020/11/7 16:05
 */
public class Node {
    int val;
    Node next;

    Node(int x) {
        val = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return val == node.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    static class Solution {

        /**
         * 在链表第一个元素前添加一个元素
         * @return
         */
        public Node addFirstNode(Node node){
            Node node1 = new Node(0);
            node1.next = node;
            return node1;
        }

        /**
         * 删除链表第一个元素
         * @return
         */
        public Node deleteFirstNode(Node node){
            return node.next;
        }

        /**
         * 在末尾添加一个元素
         *
         */
        public Node addLastNode(Node lastNode){
            Node node = new Node(10);
            node.next = null;
            lastNode.next = node;
            return lastNode;
        }

        /**
         * 链表反转
         * @param head
         * @return
         */
        public Node reverseList(Node head) {
            //定义一个前置节点变量，默认是null，因为对于第一个节点而言没有前置节点
            Node pre = null;
            //定义一个当前节点变量，首先将头节点赋值给它
            Node curr = head;
            //遍历整个链表，直到当前指向的节点为空，也就是最后一个节点了
            while (curr != null) {
                //在循环体里会去改变当前节点的指针方向，本来当前节点的指针是指向的下一个节点，现在需要改为指向前一个节点，但是如果直接就这么修改了，那链条就断了，再也找不到后面的节点了，所以首先需要将下一个节点先临时保存起来，赋值到temp中，以备后续使用
                Node temp = curr.next;
                //开始处理当前节点，将当前节点的指针指向前面一个节点
                curr.next = pre;
                //将当前节点赋值给变量pre，也就是让pre移动一步，pre指向了当前节点
                pre = curr;
                //将之前保存的临时节点（后面一个节点）赋值给当前节点变量
                curr = temp;
                //循环体执行链表状态变更情况：
                //NULL<-1 2->3->4->5->NULL
                //NULL<-1<-2 3->4->5->NULL
                //NULL<-1<-2<-3 4->5->NULL
                //NULL<-1<-2<-3<-4 5->NULL
                //NULL<-1<-2<-3<-4<-5
                //循环体遍历完之后，pre指向5的节点
            }
            //完成，时间复杂度为O(n)
            return pre;
        }

        /**
         * 判断链表是否有环，快慢指针
         * @param head
         * @return
         */
        public boolean findCycle(Node head){
            Node node1 = head;
            Node node2 = head;
            while (node2!=null&&node2.next!=null){
                node1 = node1.next;
                node2 = node2.next;
                if (node1==node2){
                    return true;
                }
            }
            return false;
        }

        /**
         * 判断链表是否有环，使用HashSet，需要重写equals和hashcode方法
         * @param head
         * @return
         */
        public boolean findCycle1(Node head){
            HashSet<Node> hashSet = new HashSet<>();
            Node node = head;
            while (node!=null&&node.next!=null){
                if (hashSet.contains(node)){
                    return true;
                }else {
                    hashSet.add(node);
                }
                node = node.next;
            }
            return false;
        }

    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //node5.next = node3;
        Solution solution = new Solution();
        //System.out.println(solution.findCycle1(node1));
        Node node = solution.addFirstNode(node1);
        System.out.println();
    }
}
