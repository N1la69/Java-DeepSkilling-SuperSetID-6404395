// DSA: Exercise 5

package Week1_DataStructuresAndAlgorithms.Exercise5_TaskManagementSystem;

public class TaskManagementSystem {

    // Task Class
    static class Task {
        int taskId;
        String taskName;
        String status;

        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        public String toString() {
            return "[" + taskId + "] " + taskName + " - " + status;
        }
    }

    // Node class
    static class Node {
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // Singly Linked List for Task Management
    static class TaskLinkedList {
        Node head = null;

        // ➕ Add task to end
        public void addTask(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            System.out.println("Task added.");
        }

        // Search task by ID
        public Task searchTask(int taskId) {
            Node current = head;
            while (current != null) {
                if (current.task.taskId == taskId) {
                    return current.task;
                }
                current = current.next;
            }
            return null;
        }

        // Traverse and display all tasks
        public void displayTasks() {
            if (head == null) {
                System.out.println("No tasks available.");
                return;
            }
            Node current = head;
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }

        // Delete task by ID
        public boolean deleteTask(int taskId) {
            if (head == null)
                return false;

            if (head.task.taskId == taskId) {
                head = head.next;
                System.out.println("Task deleted.");
                return true;
            }

            Node current = head;
            while (current.next != null) {
                if (current.next.task.taskId == taskId) {
                    current.next = current.next.next;
                    System.out.println("Task deleted.");
                    return true;
                }
                current = current.next;
            }

            return false;
        }
    }

    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task(101, "Design Homepage", "Pending"));
        taskList.addTask(new Task(102, "Implement Login", "In Progress"));
        taskList.addTask(new Task(103, "Database Setup", "Completed"));

        System.out.println("\nAll Tasks:");
        taskList.displayTasks();

        System.out.println("\nSearching Task ID 102:");
        Task found = taskList.searchTask(102);
        System.out.println(found != null ? found : "Task not found.");

        System.out.println("\nDeleting Task ID 102:");
        boolean deleted = taskList.deleteTask(102);
        if (!deleted)
            System.out.println("Task not found.");

        System.out.println("\nUpdated Task List:");
        taskList.displayTasks();
    }
}

// Understanding Linked Lists:
// Singly Linked List - Each node contains data + pointer to next node.
// Doubly Linked List - Each node contains data + pointers to both next and
// previous nodes.

// Add Task (at end): O(n)
// Search Task: O(n)
// Traverse: O(n)
// Delete Task: O(n)