class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

   
        list.add(21);
        list.add(43);
        list.add(23);
        list.add(1);
        list.add(5);
        list.add(120);
        
        list.display();
        
        System.out.println("\nПоиск элементов:");
        list.find(1);
        list.find(22);
        System.out.println("\nУдаление элементов:");
        list.delete(21);
        list.delete(25);
        System.out.println("\nСписок после удаления:");
        list.display();
        System.out.println("\nДобавление в начало:");
        list.addFirst(100);
        list.display();
   
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;
    int count;

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


    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        count++;
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
        count++;
    }


    public void display() {
        if (head == null) {
            System.out.println("Список пуст");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();
    }


    public Node find(int value) {
        Node current = head;
        int position = 0;

        while (current != null) {
            if (current.data == value) {
                System.out.println("Элемент " + value + " найден на позиции " + position);
                return current;
            }
            current = current.next;
            position++;
        }
        System.out.println("Элемент " + value + " не найден");
        return null;
    }

    public void delete(int value) {
        if (head == null) {
            System.out.println("Список пуст");
            return;
        }

        if (head.data == value) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            count--;
            System.out.println("Элемент " + value + " удален!");
            return;
        }


        if (tail.data == value) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
            count--;
            System.out.println("Элемент " + value + " удален!");
            return;
        }


        Node current = head;
        while (current != null) {
            if (current.data == value) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                count--;
                System.out.println("Элемент " + value + " удален!");
                return;
            }
            current = current.next;
        }

        System.out.println("Элемент " + value + " для удаления не найден");
    }


}


    


   






}
