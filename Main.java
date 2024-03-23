import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<String> nameList = new LinkedList<String>();
        LinkedList<String> emailList = new LinkedList<String>();
        LinkedList<Long> numberList = new LinkedList<Long>();
        boolean run = true;

        while (run) {
            System.out.println("*******************************************************");
            System.out.println("(A)dd");
            System.out.println("(D)elete");
            System.out.println("(E)mail Search");
            System.out.println("(P)rint List");
            System.out.println("(S)earch");
            System.out.println("(Q)uit");
            System.out.println("*******************************************************");
    
            System.out.print("Please Enter A Command: ");
            String user_input = input.next();
    
            if (user_input == "Q") {
                run = false;
                System.exit(0);
            } else {
                switch (user_input) {
                    case "A":
                        System.out.println("Enter the name for the entry: ");
                        String name_input = input.next();
                        
        
                        while (run) {
                            System.out.println("Enter the email of the entry: ");
                            String email_input = input.next();
        
                            if (email_input.contains("@")) {
                                run = false;
                                emailList.add(email_input);
                            } else {
                                System.out.println("Please have an @ at your email!");
                                run = true;
                            }
                        }
        
                        System.out.println("Enter the phone number of the entry: ");
                        long number_input = input.nextLong();
        
                        nameList.add(name_input);
                        numberList.add(number_input);
                        
                        System.out.println("\n");
                        System.out.println("The contact of: ");
                        System.out.println("Name: " + nameList.getLast());
                        System.out.println("Email: " + emailList.getLast());
                        System.out.println("Phone Number: " + numberList.getLast());
                        System.out.println("has been successfully saved");

                        run = true;
                        break;
                    case "D":
                        if (nameList.size() == 0) {
                            System.out.println("A contact needs to be added first!");
                        } else if (nameList.size() == 1) {
                            System.out.println("Would you like to delete the contact of " + nameList.getLast() + "? (y/n)");
                            char first_delete_input = input.next().charAt(0);
                            if (first_delete_input == 'y') {
                                nameList.removeLast();
                                System.out.println("Contact deleted");
                                run = true;
                                break;
                            } else {
                                run = true;
                                break;
                            }
                        } else {
                            for (int i = 0 ; i < nameList.size() ; i++) {
                                System.out.println(i + 1 + ". " + nameList.get(i));
                            }
                            System.out.println("Select which contact you would like to delete (pick the number): ");
                            int second_delete_input = input.nextInt();

                            if (second_delete_input > nameList.size()) {
                                System.out.println("Unregistered contact! There are only " + nameList.size() + " contacts saved on this device");
                                run = true;
                                break;
                            }

                            System.out.println("The contact of " + nameList.get(second_delete_input - 1) + " is deleted");
                            if (second_delete_input > 0) {
                                nameList.remove(second_delete_input - 1);
                                emailList.remove(second_delete_input - 1);
                                numberList.remove(second_delete_input - 1);
                            }

                        }
                        run = true;
                        break;
                    case "E":
                        for (int i = 0 ; i < nameList.size() ; i++) {
                            System.out.println(i + 1 + ". " + nameList.get(i));
                        }
                        System.out.println("Whose email would you like to search (pick the number): ");
                        int first_email_search_input = input.nextInt();

                        if (first_email_search_input > nameList.size()) {
                            System.out.println("Unregistered contact! There are only " + nameList.size() + " contacts saved on this device");
                            run = true;
                            break;
                        }

                        System.out.println("The contact you chose is = " + nameList.get(first_email_search_input - 1));
                        System.out.println("The email of " + nameList.get(first_email_search_input - 1) + " is " + emailList.get(first_email_search_input - 1));
                        run = true;
                        break;
                    case "P":
                        for (int i = 0 ; i < nameList.size() ; i++) {
                            System.out.println("Contact " + (i+1));
                            System.out.println("Name: " + nameList.get(i));
                            System.out.println("Email: " + emailList.get(i));
                            System.out.println("Phone Number: " + numberList.get(i));
                            System.out.println("\n");
                        }
                        run = true;
                        break;
                    case "S":
                        for (int i = 0 ; i < nameList.size() ; i++) {
                            System.out.println(i + 1 + ". " + nameList.get(i));
                        }
                        System.out.println("Select which contact you would like to search (pick the number): ");
                        int first_search_input = input.nextInt();

                        if (first_search_input > nameList.size()) {
                            System.out.println("Unregistered contact! There are only " + nameList.size() + " contacts saved on this device");
                            run = true;
                            break;
                        }

                        if (first_search_input > 0) {
                            System.out.println("Name: " + nameList.get(first_search_input - 1));
                            System.out.println("Email: " + emailList.get(first_search_input - 1));
                            System.out.println("Phone Number: " + numberList.get(first_search_input - 1));
                        }

                        run = true;
                        break;
                    case "Q":
                        System.exit(0);
                    default:
                        System.out.println("Unkown Entry");
                        run = true;
                }
            }
        }
    }
}