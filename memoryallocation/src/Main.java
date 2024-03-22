import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IMemoryAllocator allocator = new MemoryAllocator(1000, new FirstFitAlgorithm());
        initializeMemory(allocator);
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();

            performAction(choice, scanner, allocator);
        } while (choice != 4);
    }

    private static void performAction(int choice, Scanner scanner, IMemoryAllocator allocator) {
        switch (choice) {
            case 1:
                allocateMemory(scanner, allocator);
                break;
            case 2:
                deallocateMemory(scanner, allocator);
                break;
            case 3:
                showMemory(allocator);
                break;
            case 4:
                System.out.println("Exiting the program. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }


    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Allocate");
        System.out.println("2. Deallocate");
        System.out.println("3. Show Memory");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void allocateMemory(Scanner scanner, IMemoryAllocator allocator) {
        System.out.print("Enter object name: ");
        String objectName = scanner.next();
        System.out.print("Enter size: ");
        int size = scanner.nextInt();
        allocator.Allocate(objectName, size);
    }

    private static void deallocateMemory(Scanner scanner, IMemoryAllocator allocator) {
        System.out.print("Enter object name to deallocate: ");
        String objectToDeallocate = scanner.next();
        allocator.DeAllocate(objectToDeallocate);
    }

    private static void showMemory(IMemoryAllocator allocator) {
        allocator.ShowMemory();
    }

    private static void initializeMemory(IMemoryAllocator allocator) {
        allocator.Allocate("A", 50);
        allocator.Allocate("B", 200);
        allocator.Allocate("C", 300);
        allocator.Allocate("D", 100);
        allocator.Allocate("E", 50);
        allocator.Allocate("F", 200);
    }
}