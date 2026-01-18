public class LitSewei {

    private static void printDividingLine(){
        System.out.println("____________________________________________________________");
    }

    private static void printGreeting(){
        printDividingLine();
        System.out.println("Hello! I'm Lit Sewei.\n" +
                "What can I do for you?");

    }

    private static void printGoodbye(){
        printDividingLine();
        System.out.println("Bye. Hope to see you again soon!");
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
        printGoodbye();
    }
}
