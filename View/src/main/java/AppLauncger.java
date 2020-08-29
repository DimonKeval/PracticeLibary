import java.util.Scanner;

public class AppLauncger {
    public static void main(String[] args) {
        Scanner scanFromConsole = new Scanner(System.in);
        System.out.println(" - - - - - - - - - - - - \nStarting the program.\n - - - - - - - - - - - - \n");

        System.out.println(" - - - - - - - - - - - - \nPlease, choose an option:\n - - - - - - - - - - - - \n" +
                "1 - Add new book\n" +
                "2 - Remove existing book\n" +
                "3 - Borrow some book\n" +
                "4 - Give back borrowed book\n");
        int option = scanFromConsole.nextInt();

//        switch (option) {
//            case 1:
//                System.out.println("Write book's title:");
//                String bookTitle = scanFromConsole.nextLine();
//                System.out.println("Write book's author:");
//                String bookAuthor = scanFromConsole.nextLine();
//
//        }
    }
}
