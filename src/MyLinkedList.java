public class MyLinkedList<T> {
    private MyNode<T> head;

    public static class MyNode<T> {
        T value;
        MyNode<T> next;

        public MyNode(T value) {
            this.value = value;
            this.next = null;
        }

        public static <T> MyNode<T> createNode(T value) {
            return new MyNode<>(value);
        }
    }

    public MyLinkedList() {
        this.head = null;
    }

    public void addLast(MyNode<T> newNode) {
        if (head == null) {
            head = newNode;
            return;
        }

        MyNode<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public MyNode<T> nodeAt(int index) {
        if (index < 0 || head == null) {
            return null;
        }

        int i = 0;
        MyNode<T> current = head;
        while (i < index && current != null) {
            current = current.next;
            i++;
        }
        return current;
    }

    public void addAfter(MyNode<T> node, MyNode<T> newNode) {
        if (node == null) {
            return;
        }
        MyNode<T> oldNext = node.next;
        node.next = newNode;
        newNode.next = oldNext;
    }

    public void addBefore(MyNode<T> node, MyNode<T> newNode) {
        if (node == null) {
            return;
        }
        if (head == node) {
            newNode.next = head;
            head = newNode;
        } else {
            MyNode<T> current = head;
            while (current != null && current.next != node) {
                current = current.next;
            }
            if (current != null) {
                newNode.next = node;
                current.next = newNode;
            }
        }
    }

    public void print() {
        MyNode<T> current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }
}
