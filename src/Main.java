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
        switch (obj.selectedBank) {
            case 1 -> bank = new ICICI(obj.isr, obj.buff);
            case 2 -> bank = new HDFC(obj.isr, obj.buff);
            case 3 -> bank = new SBI(obj.isr, obj.buff);
            case 4 -> bank = new AXIS(obj.isr, obj.buff);
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
                case 6 -> System.out.println("Currently your account balance is " + bank.getBalance()+".");
                case 7 -> {
                    flag = false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("choose correct one");
            }
        }
    }

}