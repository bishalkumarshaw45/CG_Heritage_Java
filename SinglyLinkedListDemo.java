public class SinglyLinkedListDemo {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtEnd(10);
        list.insertAtBeginning(5);
        list.insertAtEnd(20);
        list.insertAtPosition(2, 15); // inserts before current index 2
        list.insertAtEnd(25);
        System.out.println("List after inserting 5 elements:");
        list.traverse();

        list.delete(15);
        System.out.println("List after deleting 15 from the middle:");
        list.traverse();

        list.delete(5);
        System.out.println("List after deleting 5 from the beginning:");
        list.traverse();

        int existing = 20;
        int missing = 100;
        System.out.println("Search " + existing + ": " + (list.search(existing) ? "Found" : "Not found"));
        System.out.println("Search " + missing + ": " + (list.search(missing) ? "Found" : "Not found"));
    }
}

class SinglyLinkedList {
    private Node head;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertAtPosition(int pos, int data) {
        if (pos <= 0 || head == null) {
            insertAtBeginning(data);
            return;
        }
        Node current = head;
        int index = 0;
        while (current != null && index < pos - 1) {
            current = current.next;
            index++;
        }
        Node newNode = new Node(data);
        if (current == null) {
            insertAtEnd(data);
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void delete(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void traverse() {
        Node current = head;
        StringBuilder builder = new StringBuilder();
        while (current != null) {
            builder.append(current.data);
            if (current.next != null) {
                builder.append(" -> ");
            }
            current = current.next;
        }
        System.out.println(builder.length() == 0 ? "List is empty." : builder.toString());
        System.out.println();
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
