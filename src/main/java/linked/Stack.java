package linked;

/**
 * 使用链表实现的一个LIFO的栈，支持push、pop、size
 * @Author: mengchao
 * @Date: 2020/11/15 23:31
 */
public class Stack<E> {
    private Node first;
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

    public void push(E object){
        Node node = new Node(object);
        node.next = first;
        first = node;
        size++;
    }

    public E pop(){
        E object = first.object;
        first = first.next;
        size--;
        return object;
    }

}
