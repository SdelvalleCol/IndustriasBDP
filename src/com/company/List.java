package com.company;

import java.util.Arrays;
import java.util.Iterator;

import static java.lang.System.*;

public class List implements ListInterface, Iterable<ListNode> {

    private ListNode inode;
    private int size;

    public ListNode head;
    public ListNode tail;

    /**
     * List
     */
    public List() {
        clear();
    }

    /*
    ok
     */
    public List(Object object) {
        add(object);
    }

    /*
    ok
     */
    public boolean isEmpty() {
        return head==null;
    }

    /*
    ok
     */
    @Override
    public int getSize() {
        return size;
    }

    /*
    ok
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /*
    ok
     */
    @Override
    public Object getHead() {
        return head;
    }

    /*
    ok
     */
    @Override
    public Object getTail() {
        return tail;
    }

    /*
    ok
     */
    @Override
    public ListNode search(Object object) {
        Iterator<ListNode> i = this.iterator();
        ListNode inode;
        while ((inode = i.next()) != null) {
            if (inode.getObject().toString().equals(object.toString())) {
                return inode;
            }
        }
        return null;
    }

    /*
    ok
     */
    @Override
    public boolean add(Object object) {
        return insertTail(object);
    }
    /*
    ok
     */
    @Override
    public boolean insert(ListNode node, Object object) {
        try {
            if (node.next == null) {
                add(object);
            } else {
                ListNode newNode = new ListNode(object);
                newNode.next = node.next;
                node.next = newNode;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
    ok
     */
    @Override
    public boolean insert(Object ob, Object object) {
        try {
            if (ob != null) {
                ListNode node = this.search(ob);
                if (node != null) {
                    return insert(node, object);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /*
    ok
     */
    @Override
    public boolean insertHead(Object object) {
        try {
            if (isEmpty()) {
                head = new ListNode(object);
                tail = head;
            } else {
                head = new ListNode(object, head);
            }
            this.size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
    ok
     */
    @Override
    public boolean insertTail(Object object) {
        try {
            if (isEmpty()) {
                head = new ListNode(object);
                tail = head;
            } else {
                tail.next = new ListNode(object);
                tail = tail.next;
            }
            this.size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
    ok
     */
    @Override
    public boolean remove(ListNode node) {
        return remove(node.getObject());
    }
    /*
    ok
     */
    @Override
    public boolean remove(Object object) {
        ListNode node = this.search(object);
        ListNode cabeza = new ListNode();
        ListNode puntero = new ListNode();
        cabeza = head;
        puntero = head.next;
        if(node == null){
            return false;
        }else if (head == tail){
            this.clear();
            out.println("the list only had one element");
            return true;
        }else{
            while (node != puntero){
                cabeza = puntero;
                puntero = puntero.next;
            }
            if(node == puntero){
                cabeza.next = puntero.next;
                this.size--;
                return true;
            }else
                return false;
        }
    }

    @Override
    public boolean contains(Object object) {
        ListNode node = this.search(object);
        if(node != null){
            return true;
        }else
            return false;
    }
    public Object[] toArray() {
        int suma = 0;
        ListNode node = new ListNode();
        Object[] i = new Object[this.size];
        while (node != null){
            i[suma] = node.getObject();
            node = node.next;
            suma++;
        }
        return i;
    }

    @Override
    public Object[] toArray(Object[] object) {
        return new Object[0];
    }

    @Override
    public Object getBeforeTo() {
        return (getBeforeTo(tail)).getObject();
    }
    /*
    ok
     */
    @Override
    public ListNode getBeforeTo(ListNode node) {
        ListNode cabeza = new ListNode();
        ListNode puntero = new ListNode();
        cabeza = head;
        puntero = head.next;
        while (node != puntero){
            cabeza = puntero;
            puntero = puntero.next;
        }
        return cabeza;
    }

    @Override
    public Object getNextTo() {
        return head.next.getObject();
    }

    @Override
    public Object getNextTo(ListNode node) {
        ListNode ite = new ListNode();
        ite = head;
        if(ite == tail){
            return null;
        }
        while(node != ite){
            ite = ite.next;
        }
        return ite.next.getObject();
    }

    @Override
    public List subList(ListNode from, ListNode to) {
        ListNode cabeza = new ListNode();
        ListNode puntero = new ListNode();
        List sub = new List();
        cabeza = head;
        puntero = head.next;
        if(head==tail){
            sub.add(head);
            sub.rec(sub.head);
            out.println("the list have only one element");
            return sub;
        }else if(cabeza == null){
            sub.isEmpty();
            sub.rec(sub.head);
            out.println("the list does not have elements");
            return sub;
        }else{
            while(cabeza!=from){
                cabeza = puntero;
                puntero = puntero.next;
            }
            while(cabeza!=to){
                sub.add(cabeza);
                cabeza = puntero;
                puntero = puntero.next;
            }
            sub.rec(sub.head);
            return sub;
        }
    }

    @Override
    public List sortList() {
        Object[] list1 =  toArray();
        Arrays.sort(list1);
        List list2 = new List();
        for(Object x:list1){
            list2.add(x);
        }
        return list2;
    }

    @Override
    public Iterator<ListNode> iterator() {
        inode = head;
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return inode.next != null;
            }

            @Override
            public ListNode next() {
                if (inode != null) {
                    ListNode tmp = inode;
                    inode = inode.next;
                    return tmp;
                } else {
                    return null;
                }
            }
        };
    }

    public void rec(ListNode node) {
        if (node.next != null) {
            rec(node.next);
            // <- ;) ->
        }
        out.println(node.toString());
    }
}