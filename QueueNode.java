// QueueNode class representing each node in the queue
class QueueNode<T> {
    T data;
    QueueNode<T> next;

    public QueueNode(T data) {
        this.data = data;
        this.next = null;
    }
}

// Queue class implementing the queue functionality
public class Queue<T> {
    private QueueNode<T> front; // Front of the queue
    private QueueNode<T> rear;  // Rear of the queue
    private int size;           // Size of the queue

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Method to add an element to the queue
    public void enqueue(T data) {
        QueueNode<T> newNode = new QueueNode<>(data);
        if (rear == null) {
            front = rear = newNode; // Queue was empty
        } else {
            rear.next = newNode; // Link new node at the end
            rear = newNode;      // Update rear
        }
        size++;
        System.out.println(data + " added to the queue.");
    }

    // Method to remove an element from the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot dequeue.");
        }
        T data = front.data;
        front = front.next; // Move front to the next node
        if (front == null) {
            rear = null; // Queue is now empty
        }
        size--;
        System.out.println(data + " removed from the queue.");
        return data;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the queue
    public int size() {
        return size;
    }

    // Method to display the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        QueueNode<T> current = front;
        System.out.print("Queue: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method to test the queue implementation
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Display the queue
        queue.display();

        // Dequeue elements
        queue.dequeue();
        queue.dequeue();

        // Display the queue
        queue.display();

        // Check queue size
        System.out.println("Queue size: " + queue.size());
    }
}
