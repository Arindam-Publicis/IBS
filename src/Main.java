import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    BufferedReader buff;
    InputStreamReader isr;
    int selectedBank, selectedOperation;

    public Main() {
        isr = new InputStreamReader(System.in);
        buff = new BufferedReader(isr);
    }
    public static int accountCreator(Main obj, Bank bank, Customer customer){
        System.out.println("You have to deposit at least "+bank.getMiniBalance()+" to open account with ICICI\nDo you want to create an account with us?Y/N");
        char ch='Y';
        try {
            ch=obj.buff.readLine().charAt(0);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        if(ch=='N')return 0;
        else{
            System.out.println("How much amount you want to deposit?\nPlease enter an amount greater than "+bank.getMiniBalance());
            float amt=0;
            try{
                amt=Integer.parseInt(obj.buff.readLine());
            }
            catch (IOException e){
                e.printStackTrace();
            }
            if(amt>= bank.getMiniBalance())customer.setBalance(amt);
            else {
                System.out.println("Sorry, we can't open your account with "+amt+" inr. Please try again later.");
                return 0;
            }
            return 1;
        }
    }
    public static void main(String[] args) {
        Main obj = new Main();
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("ICICI", "HDFC", "SBI", "AXIS"));
        System.out.println("Welcome to IBS");
        System.out.println("Please select your bank");
        int i = 0;
        for (String it : arr) {
            System.out.println(++i + ". " + it);
        }
        try {
            obj.selectedBank = Integer.parseInt(obj.buff.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bank bank;
        Customer customer=new Customer(obj.isr,obj.buff);
        switch (obj.selectedBank) {
            case 1 -> {
                bank = new ICICI(obj.isr, obj.buff,customer);
                if(accountCreator(obj,bank,customer)==0)return;
            }
            case 2 -> {bank = new HDFC(obj.isr, obj.buff,customer);
                if(accountCreator(obj,bank,customer)==0)return;
            }
            case 3 ->{bank = new SBI(obj.isr, obj.buff,customer);
                if(accountCreator(obj,bank,customer)==0)return;}
            case 4 -> {bank = new AXIS(obj.isr, obj.buff,customer);
                if(accountCreator(obj,bank,customer)==0)return;}
            default -> {
                return;
            }
        }
        boolean flag = true;
        while (flag) {
            System.out.println("Select your choice\n1. Deposit\n2. Withdraw\n3. OpenFD\n4. Apply Loan\n5. Apply CC\n6. Show Balance\n7. Exit");
            try {
                obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (obj.selectedOperation) {
                case 1 -> bank.depositMoney();
                case 2 -> bank.withdrawMoney();
                case 3 -> bank.openFD();
                case 4 -> bank.applyLoan();
                case 6 -> System.out.println("Currently your account balance is "+customer.getBalance()+".");
                case 7 -> {
                    flag = false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("choose correct one");
            }
        }
    }

}