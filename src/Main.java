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
        Customer mCustomer = new Customer(obj.isr,obj.buff);

        ArrayList<String>arr=new ArrayList<>(Arrays.asList("ICICI","HDFC","SBI","AXIS","IDFC"));
        System.out.println("Welcome to IBS");
        ArrayList<String> custDet=new ArrayList<>(Arrays.asList("Name","Email","Address","Gender","Aadhaar Number","Phone Number"));
        for(String it:custDet){
            System.out.println("Please enter your "+it);
            try {
                String custInput=obj.buff.readLine();
                switch (it){
                    case "Name"->mCustomer.setCustomerName(custInput);
                    case "Email"->mCustomer.setCustomerEmail(custInput);
                    case "Address"->mCustomer.setCustomerAddress(custInput);
                    case "Gender"->mCustomer.setCustomerGender(custInput);
                    case "Aadhaar Number"->mCustomer.setCustomerAadhar(custInput);
                    case "Phone Number"->mCustomer.setCustomerPhone(custInput);
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }

        }
        mCustomer.showCustomerDetails();
        System.out.println("Please select your bank");
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
                case 3->{
                    System.out.println("Enter the amount of which you want to make FD");
                    float fdAmt=0;
                    int years=0;
                    try {
                        fdAmt=Float.parseFloat(obj.buff.readLine());
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                    System.out.println("Enter the number of years for which you want to create FD");
                    try {
                        years=Integer.parseInt(obj.buff.readLine());
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                    mRBI.openFD(fdAmt,mRBI.FDROI,years);
                }
                case 4->{
                    System.out.println("Enter the type of Loan of which you want to take");
                    String loanType="";
                    try {
                        loanType=obj.buff.readLine();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                    System.out.println("Enter the amount of which you want to take Loan");
                    float loanAmt=0;
                    int years=0;
                    try {
                        loanAmt=Float.parseFloat(obj.buff.readLine());
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                    System.out.println("Enter the number of years for which you want to create FD");
                    try {
                        years=Integer.parseInt(obj.buff.readLine());
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                    mRBI.applyLoan(loanType,loanAmt,mRBI.LoanROI,years);
                }
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