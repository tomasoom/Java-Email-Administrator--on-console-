package mailProject;
import java.util.Scanner;
import java.util.*;

public class Email {
    public String firstName;
    public String lastName;
    private String department;
    private int mailboxCapacity;
    private String password;
    private String email;
    private String altEmail;

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setDepartment(){
        Scanner input = new Scanner(System.in);
        System.out.print("Choose a department:\n1-Sales\n2-Development\n3-Accounting\nOthers-None\n\nOption: ");
        int option = Integer.parseInt(input.nextLine());

        switch (option){
            case 1:
                this.department = "Sales";
                break;

            case 2:
                this.department = "Development";
                break;

            case 3:
                this.department = "Accounting";
                break;

            default:
                this.department = "";
        }
    }

    public String generateEmail(){
        String email;
        if(this.department.equals("")){
            email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase() + "company.com";
        }
        else{
            email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase() + ".company.com";
        }
        this.email = email;
        return this.email;
    }

    public String generatePassword(){
        int maxLength = 15;
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String psw = "";
        List<Character> pass = new ArrayList<Character>();

        for(int i = 0; i < characters.length(); i++){
            pass.add(characters.charAt(i));
        }

        Collections.shuffle(pass);

        if(maxLength >= pass.size()){
            for(int j = 0; j < pass.size(); j++){
                psw += pass.get(j);
            }
        }
        else{
            for(int j = 0; j < maxLength; j++){
                psw += pass.get(j);
            }
        }
        this.password = psw;
        return this.password;
    }

    public void changePassword(){
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Insert a new password(Max 20 chars): ");
            String novaPassword = input.nextLine();
            this.password = novaPassword;
            System.out.println("New password: " + this.password);
        }while(password.length() > 20);
    }

    public void setMailboxCapacity(){
        Scanner input = new Scanner(System.in);
        System.out.print("Set the mailbox capacity: ");
        int mailboxCapacity = Integer.parseInt(input.nextLine());
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAltEmail() {
        if (this.department != null && this.altEmail == null) {
            Scanner input = new Scanner(System.in);
            System.out.print("Define alternative email adress: ");
            String text = input.next();
            String email = text + "@" + this.department.toLowerCase() + ".company.com";
            this.altEmail = email;
        } else {
            System.out.println("An alternative email can't be created!A department is absent or an alternative email already exists!");
            this.setDepartment();
        }
    }

    public void displayInfo(){
        if(this.email != null && this.mailboxCapacity != 0){
            System.out.println("------------------------------\nName: " + this.firstName + " " + this.lastName + "\nEmail: " + this.email + "\nMailbox capacity: " + this.mailboxCapacity + "\n------------------------------");
        }
        else{
            System.out.println("Insufficient data to perform this task! (Check if email or mailbox capacity are already defined)");
        }

    }

}

