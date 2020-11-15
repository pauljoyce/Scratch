package linked;

/**
 * 用链表实现的FIFO的队列
 * @Author: mengchao
 * @Date: 2020/11/15 23:50
 */
public class Queue<E> {
    private Node first;
    private Node last;
    private int size;
    private class Node{
        E object;
        Node next;

        public Node(E object){
            this.object = object;
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(E object){
        if (isEmpty()){
            last = new Node(object);
            first = last;
        }else {
            last.next = new Node(object);
            last = last.next;
        }
        size++;
    }

    public E dequeue(){
        E object = first.object;
        first = first.next;
        if (isEmpty()){
            last = null;
        }
        size--;
        return object;
    }
}
