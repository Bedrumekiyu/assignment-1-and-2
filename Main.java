package ass;
// assignment 1 Todolist
 public class Main {
    public static void main(String[] args) {
    	// Create a new ToDoList instance
        ToDoList toDoList = new ToDoList();

        // Add new tasks to the ToDoList
        toDoList.addToDo(new Task("Task 1", "Description 1"));
        toDoList.addToDo(new Task("Task 2", "Description 2"));

        // View the current ToDoList
        toDoList.viewToDoList();

        // Mark a specific task as completed
        toDoList.markToDoAsCompleted("Task 1");

        // View the ToDoList after marking a task as completed
        toDoList.viewToDoList();
    }
}

class Task {
    private String title;
    private String description;
    private boolean completed;

    // Constructor to create a new Task
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    // Getter method for the task title
    public String getTitle() {
        return title;
    }

    // Getter method for the task description
    public String getDescription() {
        return description;
    }

    // Getter method to check if the task is completed
    public boolean isCompleted() {
        return completed;
    }


    // Method to mark the task as completed
    public void markCompleted() {
        completed = true;
    }
}

class Node {
    private Task task;
    private Node next;

    // Constructor to create a new Node with a Task
    public Node(Task task) {
        this.task = task;
        this.next = null;
    }

    // Getter method to get the Task in the Node
    public Task getTask() {
        return task;
    }

    // Getter method to get the next Node in the list
    public Node getNext() {
        return next;
    }

    // Setter method to set the next Node in the list
    public void setNext(Node next) {
        this.next = next;
    }
}

class ToDoList {
    private Node head;

    // Method to add a new Task to the ToDoList
    public void addToDo(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    // Method to mark a specific task as completed
    public void markToDoAsCompleted(String title) {
        Node current = head;
        while (current != null) {
            if (current.getTask().getTitle().equals(title)) {
                current.getTask().markCompleted();
                System.out.println("Task '" + title + "' marked as completed.");
                return;
            }
            current = current.getNext();
        }
        System.out.println("Task not found in the to-do list.");
    }

    // Method to view the current ToDoList
    public void viewToDoList() {
        Node current = head;
        if (current == null) {
            System.out.println("To-Do List is empty.");
        } else {
            System.out.println("To-Do List:");
            while (current != null) {
                Task task = current.getTask();
                System.out.println("- Title: " + task.getTitle());
                System.out.println("  Description: " + task.getDescription());
                System.out.println("  Completed: " + (task.isCompleted() ? "Yes" : "No"));
                current = current.getNext();
            }
        }
    }
}



