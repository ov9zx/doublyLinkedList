class main {
    public static void main(String[] args) {
        linkedList linkedList1 = new linkedList();
        linkedList1.addFirst(21);
        linkedList1.addEnd(43);
        linkedList1.addAfterElement(24,25);
        linkedList1.addFirst(1);
        linkedList1.addFirst(5);
        linkedList1.addFirst(120);
        linkedList1.display();
        linkedList1.find(1);
        linkedList1.find(22);
        linkedList1.delete(21);
        linkedList1.delete(25);
        linkedList1.display();
    }
}

class linkedList {
    Node head;
    Node tail;

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void addAfterElement(int value, int element) {
        Node current = find(element);
        if (current == null) {
            System.out.println("Элемент " + element + " не найден, вставка невозможна");
            return;
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            // Если вставляем после последнего элемента, обновляем tail
            tail = newNode;
        }
        current.next = newNode;

        System.out.println("Элемент " + value + " вставлен после элемента " + element);
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public Node find(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                System.out.println("Элемент " + value + " найден)");
                return current;
            }
            current = current.next;
        }
        System.out.println("Элемент " + value + " не найден(((");
        return null;
    }

    public void delete(int value) {
        if (head == null) return;

        // 1. Удаляем голову
        if (head.data == value) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            System.out.println("Элемент " + value + " удален!");
            return;
        }

        // 2. Удаляем хвост
        if (tail.data == value) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
            System.out.println("Элемент " + value + " удален!");
            return;
        }

        // 3. Ищем и удаляем в середине
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                System.out.println("Элемент " + value + " удален!");
                return;
            }
            current = current.next;
        }

        // 4. Элемент не найден
        System.out.println("Элемент " + value + " для удаления не найден((");
    }
}
