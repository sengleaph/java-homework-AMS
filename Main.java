package packageOrio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.stream.Collectors;

class Account{
    int id;
    String ownerName;
    double balance;

    public Account() {
    };

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public static <T> double getBalance(T t) {
        return 0;
    };
}
public class Main {

    //acc id owner balance
    //add acc add edit remove show
    //show account information
    // 1 . descending order by account_id
    // 2.  ascending order by account_id
    // 3. descendinder order by balance
    public static void main(String[] args) {

        int option;
        List<Account> accountList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("===================================================");
            System.out.println("1: Add account:");
            System.out.println("2: Remove Account: ");
            System.out.println("3. Edit Account ");
            System.out.println("4. Show account infor");
            System.out.println("5. Exit ");
            System.out.print("Choose option ( 1 - 5 ) : ");
            option  = input.nextInt();
            System.out.println("===================================================");

            switch (option){
                case  1 :
                    // enter account information
                    // object add list
                    //accountList.add();
                    System.out.println("Enter your account infor");
                    Account acc = new Account();
                    System.out.print("Input ID:");
                    acc.id = input.nextInt();
                    System.out.print("Enter the Name:");
                    input.nextLine();
                    acc.ownerName = input.nextLine();
                    System.out.print("input Balance:");
                    acc.balance = input.nextInt();

                    accountList.add(acc);
                    //Iterator<String> i = accountList.iterator();

                    break;
                case 2 :
                    boolean isFound = false;
                    System.out.println("Enter ID: ");
                    int index = input.nextInt();

                    for (int i=0; i<accountList.size(); i++){
                        if (accountList.get(i).id == index){
                            isFound = true ;
                            accountList.remove(i);
                        }
                    }
                    if (!isFound) {
                        System.err.println("Not Found!!!!");
                    }else{
                        System.out.println("Sucessfully Delete !!!");
                    }
                    break;
                case 3:
                    System.out.println("Input your ID :");
                    int updateID = input.nextInt();
                    boolean answers = false;
                    if (accountList.size() > 0) {
                        for (Account account : accountList) {

                            if (account.id == updateID) {
                                System.out.println("Enter the new Owner Name :");
                                account.ownerName = input.next();
                                System.out.println("Input the new Balance :");
                                account.balance = input.nextDouble();
                                answers = true;
                            }
                        }
                    }
                    if (!answers)
                        System.out.println("Invalid Update Please try again!!");
                    break;

                case 4 :
                    int showOption ;
                    System.out.println("Show account information");
                    System.out.println("1. Ascending order (by ID )");
                    System.out.println("2. Descending order (by ID) ");
                    System.out.println("3. Descendig order by balance ");

                    System.out.println("Choose show option : ");
                    showOption =  input.nextInt();
                    switch (showOption) {
                        case 1:
                            List<Account> accountList1 = accountList.stream().sorted(Comparator.comparingLong(value -> value.id)).collect(Collectors.toList());
                            accountList1.stream().forEach(System.out::println);
                            break;
                        case 2:
                            List<Account> accountList2 = accountList.stream().sorted((o1, o2) -> (o2.id - o1.id)).collect(Collectors.toList());
                            accountList2.stream().forEach(System.out::println);
                            break;


                        case 3:
                            List<Account> accountList3 = accountList.stream().sorted(Comparator.comparingDouble(Account::getBalance).reversed()).collect(Collectors.toList());
                            accountList3.stream().forEach(System.out::println);

                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + showOption);
                    }

                    break;
                case 5 :
                    System.err.println("Exit the program....!");break;

                default:
                    throw new IllegalStateException("Unexpected value: " + option);
            }
        }while(option  !=5);

    }
}