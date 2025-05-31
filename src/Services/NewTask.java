package Services;

import Entities.Task;

import java.util.Scanner;

public class NewTask {

    public static Task CreatedNewTask(){
        Scanner input = new Scanner(System.in);
        String description = input.nextLine();
        return new Task(description);
    }
}
