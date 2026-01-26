import java.util.ArrayList;
import java.util.Scanner;

public class LitSewei {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<String> tasks = new ArrayList<>();

    private static void printDividingLine(){
        System.out.println("____________________________________________________________");
    }

    private static void printGreeting(){
        printDividingLine();
        System.out.println("Hello! I'm Lit Sewei.\n" +
                "What can I do for you? UwU");
        printDividingLine();
    }

    private static void printGoodbye(){
        printDividingLine();
        System.out.println("Bye. See you next time~~~");
        printDividingLine();
    }

    private static void printList(){
        printDividingLine();
        System.out.println("Here is the TODO list:");
        for(int i=0;i<tasks.size();i++){
            System.out.println((i+1) + ". " + tasks.get(i));
        }
        printDividingLine();
    }

    public static void main(String[] args) {
        String logo= """
                .____    .__  __      _________                    .__\s
                |    |   |__|/  |_   /   _____/ ______  _  __ ____ |__|
                |    |   |  \\   __\\  \\_____  \\_/ __ \\ \\/ \\/ // __ \\|  |
                |    |___|  ||  |    /        \\  ___/\\     /\\  ___/|  |
                |_______ \\__||__|   /_______  /\\___  >\\/\\_/  \\___  >__|
                        \\/                  \\/     \\/            \\/   \s
                """;

        System.out.println("Hello from\n" + logo);

        printGreeting();

        // Main loop
        while(true){
            String input = sc.nextLine().trim();
            if(input.equalsIgnoreCase("bye")){
                break;
            }else if(input.equalsIgnoreCase("list")){
                printList();
            }else{
                tasks.add(input);

                printDividingLine();
                System.out.println("I've noted down this task: "+input+"!!!");
                printDividingLine();
            }
        }

        printGoodbye();
    }
}
