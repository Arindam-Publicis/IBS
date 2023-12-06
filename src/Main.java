import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    BufferedReader buff;
    InputStreamReader isr;
    public Main() {
        if(isr == null)
            isr = new InputStreamReader(System.in);
        if(buff==null)
            buff = new BufferedReader(isr);
    }

    int selectedBank, selectedOperation;
    public static void main(String[] args) {
        Main obj = new Main();
        RBI mRBI = new RBI(obj.isr,obj.buff);
        ArrayList<String>arr=new ArrayList<>(Arrays.asList("ICICI","HDFC","SBI","AXIS","IDFC"));
        System.out.println("Welcome to IBS\nPlease select your bank");
        int i=0;
        for(String it:arr){
            System.out.println(++i+". "+it);
        }
        try {
            obj.selectedBank = Integer.parseInt(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Customer Selected " + arr.get(obj.selectedBank-1)+" bank");
        boolean flag=true;
        while(flag) {
        System.out.println("Select your choice\n1. Deposit\n2. Withdraw\n3. OpenFD\n4. Apply Loan\n5. Apply CC\n6.Show Balance\n7.Exit");

        try {
            obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Customer Selected " + obj.selectedOperation);


            switch (obj.selectedOperation) {
                case 1 -> mRBI.depositMoney();
                case 2 -> mRBI.withdrawMoney();
                case 6 -> System.out.println(mRBI.getBalance());
                case 7-> {
                    flag=false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("choose correct one");
            }
        }
    }

}