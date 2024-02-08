import java.util.Scanner;
public class OGF {
    private static void printBreakLine(){
        System.out.println(("____________________________________________________________"));
    }
    public static void main(String[] args) {
        String logo = "\n" +
                " _____  _    _                   _____ ______ \n" +
                "|  _  || |  | |                 |  __ \\|  ___|\n" +
                "| | | || |_ | |__    ___  _ __  | |  \\/| |_   \n" +
                "| | | || __|| '_ \\  / _ \\| '__| | | __ |  _|  \n" +
                "\\ \\_/ /| |_ | | | ||  __/| |    | |_\\ \\| |    \n" +
                " \\___/  \\__||_| |_| \\___||_|     \\____/\\_|    \n" +
                "                                              \n" +
                "                                              \n";
        System.out.println("Welcome! I'm your \n" + logo + "Nice to meet you!");
        System.out.println("What can I do for you?");


        Task[] tasks = new Task[100];
        int numItem = 0;
        Scanner scanner = new Scanner(System.in);
        int taskNo;
        while (true) {
            String input = scanner.nextLine();
            switch (input.split(" ")[0]) {
                case ("bye"):
                    System.out.println("Bye bye now!");
                    return;
                case ("list"):
                    System.out.println("Here are your tasks for today: ");
                    for (int i = 0; i < numItem; i++){
                        System.out.print(i+1 + ". ");
                        System.out.println(tasks[i]);
                    }
                    printBreakLine();
                    break;
                case ("mark"):
                //Fallthrough
                case ("unmark"):
                    taskNo = Integer.parseInt(input.split(" ")[1])-1;

                    if (input.split(" ")[0].equals("mark")){
                        System.out.println("Good Job! I'm setting this task as done: ");
                        tasks[taskNo].setDone(true);
                    } else{
                        System.out.println("Oop! I'm setting this task as undone: ");
                        tasks[taskNo].setDone(false);
                    }
                    System.out.println(tasks[taskNo]);
                    printBreakLine();
                    break;
                case ("todo"):
                    String newTodoDesc = input.substring(input.indexOf(" "));
                    tasks[numItem] = new Todo(newTodoDesc);
                    System.out.println("Alright, adding this task to the list: ");
                    System.out.println(tasks[numItem]);
                    numItem++;
                    System.out.printf("You have %d tasks in the list.%n", numItem);
                    printBreakLine();
                    break;
                case ("deadline"):
                    String newDeadlineDesc = input.substring(input.indexOf(" "), input.indexOf(" /by"));
                    String newDeadlineTime = input.substring(input.indexOf("/by")+4);
                    tasks[numItem] = new Deadline(newDeadlineDesc, newDeadlineTime);
                    System.out.println("Alright, adding this task to the list: ");
                    System.out.println(tasks[numItem]);
                    numItem++;
                    System.out.printf("You have %d tasks in the list.%n", numItem);
                    printBreakLine();
                    break;
                case ("event"):
                    String newEventDesc = input.substring(input.indexOf(" "), input.indexOf("/from"));
                    String newEventStart = input.substring(input.indexOf("/from")+6, input.indexOf(" /to"));
                    String newEventEnd = input.substring(input.indexOf("/to")+4);
                    tasks[numItem] = new Event(newEventDesc, newEventStart, newEventEnd);
                    System.out.println("Alright, adding this task to the list: ");
                    System.out.println(tasks[numItem]);
                    numItem++;
                    System.out.printf("You have %d tasks in the list.%n", numItem);
                    printBreakLine();
                    break;

                default:
                    System.out.println("unrecognised input");
                    printBreakLine();
                    break;
            }
        }

    }
}
