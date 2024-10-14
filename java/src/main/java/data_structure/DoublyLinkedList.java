package data_structure;

public class DoublyLinkedList {

    class Node {
        int value;
        Node next;
        Node pre;

        Node(int value) {
            this.value = value;
        }
    }

    Node head;
    Node tail;
    int length;

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.pre = tail;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }
        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.pre;
            tail.next = null;
            temp.pre = null;
        }
        length--;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.pre = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.pre = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Invalid index!!!");
            return null;
        } else {
            Node temp;
            if (index < length / 2) {
                temp = head;
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }
            } else {
                temp = tail;
                for (int i = length - 1; i > index; i--) {
                    temp = temp.pre;
                }
            }
            return temp;
        }
//            Below solution also works but in the average-case it could take more loop than the above solution.
//            if (index < 0 || index >= length) {
//                System.out.println("Invalid index!!!");
//                return null;
//            } else {
//                int counter = 0;
//                Node temp = head;
//                while(temp != null && counter != index) {
//                    temp = temp.next;
//                    counter++;
//                }
//                return temp;
//            }
    }

    public void set(int index, int value) {
        if (index < 0 || index > length) {
            System.out.println("Invalid index!!!");
        } else {
            Node current = get(index);
            current.value = value;
        }
    }

    public void insert(int index, int value) {
        if (index < 0 || index >= length) {
            System.out.println("Invalid index!!!");
        } else if (index == 0) {
            prepend(value);
        } else if (index == length - 1) {
            append(value);
        } else {
            Node newNode = new Node(value);
            Node current = get(index);
            Node pre = current.pre;
            pre.next = newNode;
            newNode.pre = pre;
            newNode.next = current;
            current.pre = newNode;
            length++;
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Invalid index!!!");
        } else if (index == 0) {
            removeFirst();
        } else if (index == length - 1) {
            removeLast();
        } else {
            Node current = get(index);
            System.out.println("Current " + current.value);
            Node pre = current.pre;
            System.out.println("Pre: " + pre.value);
            pre.next = current.next;
            current.next.pre = pre;
            current.next = null;
            current.pre = null;
            length--;
        }
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
