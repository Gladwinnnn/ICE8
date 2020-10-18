import java.util.Scanner;

public class CheckScoreMenu {
    private CheckScoreCtrl ctrl;

    public CheckScoreMenu(CheckScoreCtrl ctrl) {
        this.ctrl = ctrl;
    }

    public void display() {
        System.out.println("== Quiz Management System ==");
        System.out.println("1. Check student's score");
        System.out.println("2. Quit Application");
        System.out.print("Please enter your choice: ");
    }

    public void readOption() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            display();
            choice = sc.nextInt();
            switch (choice) {
                case 1 :
                    checkScore();
                    break;
                case 2 :
                    System.out.println("bye bye");
                    break;
                default :
                    System.out.println("Enter a choice between 1 to 2");
            }
        } while (choice != 2);
    }

    public void checkScore(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the student's name> ");
            String studentName = scanner.nextLine();
            System.out.print("Enter the quiz name> ");
            String quizName = scanner.nextLine();
            double result = ctrl.calculateDifferenceFromAverage(studentName,quizName);
            if (result < 0){
                System.out.print("" + studentName + " is " + (-result) + " marks below the average");
            } else if (result > 0){
                System.out.print("" + studentName + " is " + result + " marks above the average");
            } else if (result == 0){
                System.out.print("" + studentName + " is sitting on the fence!");
            }
            System.out.println();
        } catch(NullPointerException e){
            System.out.print("No such quiz.");
            System.out.println();
        }
    }
}