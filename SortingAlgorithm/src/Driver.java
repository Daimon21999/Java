import java.util.Scanner;

public class Driver {

    private static <T extends Sorting> void menushka(T method) {
        int[] arr;
        Scanner scn = new Scanner(System.in);
        String choose;
        Colorama.println("Create array with input - c\nCreate random array - r");
        choose = scn.next();
        if (choose.equals("c"))
            arr = method.create();
        else if (choose.equals("r")) {
            Colorama.print("Enter number,max value of elements: ");
            int number = scn.nextInt();
            int max = scn.nextInt();
            arr = method.randCreate(number, max);
        } else {
            Colorama.println("Sorry, incorrect option");
            return;
        }

        Colorama.println("Choose: sort - s\n        test - t");
        choose = scn.next();
        switch (choose) {
            case "s":
                method.sort(arr, 0, arr.length - 1);
                method.sort(arr);
                System.out.println();
                method.print(arr);
                Colorama.print("Press any key: ");
                scn.next();
                Colorama.clear();
                break;
            case "t":
                Colorama.println(method.test(arr));
                Colorama.print("Press any key: ");
                scn.next();
                Colorama.clear();
                break;
        }
    }

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.menu();
    }

    private void menu() {
        Scanner scn = new Scanner(System.in);
        String choose;
        Colorama.clear();
        Colorama.println("set", Colorama.Fore.CYAN);
        Colorama.println("########################################");
        Colorama.println("######## Welcome to Sorting app ########");
        Colorama.println("########################################");
        Colorama.println();
        do {
            Colorama.print("set", Colorama.Fore.BOLD);
            Colorama.println(Colorama.Fore.BROWN, "Bubble Sort", Colorama.Fore.WHITE, "......................", Colorama.Fore.BROWN, " b");
            Colorama.println(Colorama.Fore.YELLOW, "Shaker Sort", Colorama.Fore.WHITE, "......................", Colorama.Fore.YELLOW, " sh");
            Colorama.println(Colorama.Fore.BRIGHT_YELLOW, "Selection Sort", Colorama.Fore.WHITE, "...................", Colorama.Fore.BRIGHT_YELLOW, " s");
            Colorama.println(Colorama.Fore.PURPLE, "Insertion Sort", Colorama.Fore.WHITE, "...................", Colorama.Fore.PURPLE, " i");
            Colorama.println(Colorama.Fore.BRIGHT_PURPLE, "Heap Sort", Colorama.Fore.WHITE, "........................", Colorama.Fore.BRIGHT_PURPLE, " h");
            Colorama.println(Colorama.Fore.RED, "Quick Sort", Colorama.Fore.WHITE, ".......................", Colorama.Fore.RED, " q");
            Colorama.println(Colorama.Fore.BRIGHT_GREEN, "Exit", Colorama.Fore.WHITE, ".............................", Colorama.Fore.BRIGHT_GREEN, " exit");
            Colorama.print("reset", "set", Colorama.Fore.BRIGHT_GREEN, "Choose something... ");
            choose = scn.next();
            switch (choose) {
                case "b":
                    BubbleSort bubbleSort = new BubbleSort();
                    menushka(bubbleSort);
                    break;
                case "i":
                    InsertionSort insertionSort = new InsertionSort();
                    menushka(insertionSort);
                    break;
                case "s":
                    SelectionSort selectionSort = new SelectionSort();
                    menushka(selectionSort);
                    break;
                case "sh":
                    ShakerSort shakerSort = new ShakerSort();
                    menushka(shakerSort);
                    break;
                case "q":
                    QuickSort quickSort = new QuickSort();
                    menushka(quickSort);
                    break;
                case "h":
                    HeapSort heapSort = new HeapSort();
                    menushka(heapSort);
                    break;
                default:
                    Colorama.println("Goodbye!");
                    return;
            }
        } while (true);
    }
}
