package mailProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static void menu(Email email){
        Scanner input = new Scanner(System.in);
        System.out.print("Name: " + email.firstName + " " + email.lastName + " Password: " + email.printPassword() + "\n1-User information\n2-Insert a department\n3-Change password\n4-Define mailbox capacity\n5-Create an alternative email\n6-Search another worker\n");
        System.out.println();
        int option = Integer.parseInt(input.nextLine());

        switch(option){
            case 1:
                email.displayInfo();
                menu(email);
                break;

            case 2:
                email.setDepartment();
                email.generateEmail();
                menu(email);
                break;

            case 3:
                email.changePassword();
                menu(email);
                break;

            case 4:
                email.setMailboxCapacity();
                menu(email);
                break;

            case 5:
                email.setAltEmail();
                menu(email);
                break;

            case 6:
                break;

            default:
                System.out.println("Invalid option!");
                menu(email);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String searchedName;

        List<Email> emailList = new ArrayList<Email>();

        Email mail1 = new Email("Tomas", "Oom");
        emailList.add(mail1);
        Email mail2 = new Email("Marcelo", "Sousa");
        emailList.add(mail2);

        do {
            System.out.print("Search a name on the workers list (no if not): ");
            searchedName = input.nextLine();
            if(searchedName.equals("no")){
                break;
            }
            for (int i = 0; i < emailList.size(); i++) {
                if (searchedName.equals(emailList.get(i).firstName + " " + emailList.get(i).lastName)) {
                    menu(emailList.get(i));
                }
            }
        } while (searchedName != "no");
    }
}
