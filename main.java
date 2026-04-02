class main {
    public static void main(String[] args) {
        linkedList linkedList1 = new linkedList();
        linkedList1.add(21);
        linkedList1.add(43);
        linkedList1.add(23);
        linkedList1.add(1);
        linkedList1.add(5);
        linkedList1.add(120);
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
        Node prev;  // ссылка на предыдущий элемент

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;  // инициализируем prev
        }
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;  // старый хвост указывает на новый узел
            newNode.prev = tail;   // новый узел указывает на старый хвост
            tail = newNode;        // обновляем хвост
        }
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
                head.prev = null;  // у новой головы обнуляем ссылку на предыдущий
            } else {
                tail = null;  // список стал пустым
            }
            System.out.println("Элемент " + value + " удален!");
            return;
        }

        // 2. Удаляем хвост
        if (tail.data == value) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;  // у нового хвоста обнуляем ссылку на следующий
            }
            System.out.println("Элемент " + value + " удален!");
            return;
        }

        // 3. Ищем и удаляем в середине
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                // связываем предыдущий и следующий узлы
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
