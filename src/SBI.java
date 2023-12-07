import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SBI implements Bank {
    BufferedReader buff;
    InputStreamReader isr;
    private int withdrawTime=0;
    private int flag=0;
    private float miniBalance=3000f;
    private float balance = miniBalance;
    private float FDROI=5.5f;
    HashMap<String,Float> mp=new HashMap<>();
    public SBI(InputStreamReader isr, BufferedReader buff) {
        this.isr = isr;
        this.buff = buff;
        Customer customer = new Customer(isr,buff);
        ArrayList<String> custDet=new ArrayList<>(Arrays.asList("Name","Email","Address","Gender","Aadhaar Number","Phone Number"));
        for(String it:custDet){
            System.out.println("Please enter your "+it);
            try {
                String custInput=buff.readLine();
                switch (it){
                    case "Name"->customer.setCustomerName(custInput);
                    case "Email"->customer.setCustomerEmail(custInput);
                    case "Address"->customer.setCustomerAddress(custInput);
                    case "Gender"->customer.setCustomerGender(custInput);
                    case "Aadhaar Number"->customer.setCustomerAadhar(custInput);
                    case "Phone Number"->customer.setCustomerPhone(custInput);
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }

        }
        System.out.println("Hey "+customer.getCustomerName()+", we have opened a SBI account for you with a balance of "+miniBalance+" inr.");
    }
    @Override
    public void depositMoney() {
        System.out.println("Enter the amount you want to deposit");
        try {
            float amt=Float.parseFloat(buff.readLine());
            balance+=amt;
            System.out.println(amt+" inr is deposited in your account. Your current account balance is "+balance);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void withdrawMoney() {
        System.out.println("Enter the amount you want to withdraw");
        try {
            float amt=Float.parseFloat(buff.readLine());
            if(balance-amt-flag*(amt*0.01f)>=miniBalance){
                balance-=amt+flag*(amt*0.01f);
                withdrawTime++;
                if(withdrawTime>3)flag=1;

                System.out.println(amt+" inr is withdrawn from your account. Your current account balance is "+balance);
            }
            else System.out.println("You have less than or equal to "+miniBalance+" inr in your account");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void openFD() {
        System.out.println("Currently we are offering rate of interest of "+FDROI+"%.");
        System.out.println("Enter the amount of which you want to make FD");
        float fdAmt=0;
        int years=0;
        try {
            fdAmt=Float.parseFloat(buff.readLine());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Enter the number of years for which you want to create FD");
        try {
            years=Integer.parseInt(buff.readLine());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("You are going to create a FD of "+fdAmt+" rupees");
        for(int i=0;i<years;i++){
            float total=fdAmt*(float)Math.pow((100d+FDROI)/100,i+1);
            System.out.println("After "+(i+1)+" year(s) your total amount will be "+total);
            if(i==years-1) System.out.println("Your total profit will be "+(total-fdAmt));
        }

    }

    @Override
    public void applyLoan() {
        if(balance>2f*miniBalance) {
            mp.put("Home",9f);
            mp.put("Education",5f);
            mp.put("Personal",10f);
            mp.put("Car",11f);
            ArrayList<String> loanList=new ArrayList<>(mp.keySet());
            System.out.println("Please choose which type of loan you want to take");
            int i = 0;
            for (String it : loanList) System.out.println(++i + ". " + it + " loan");
            int number = 0, years = 0;
            try {
                number = Integer.parseInt(buff.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Currently we are providing "+loanList.get(number - 1)+" loan for "+mp.getOrDefault(loanList.get(number - 1), 0f)+"% of interest annually.");
            System.out.println("Enter the amount of which you want to take Loan");
            float loanAmt=0;
            try {
                loanAmt=Float.parseFloat(buff.readLine());
            }
            catch (IOException e){
                e.printStackTrace();
            }


            System.out.println("Enter the number of years for which you want to take Loan");
            try {
                years = Integer.parseInt(buff.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("You are going to take a loan of " + loanAmt + " rupees of " + loanList.get(number - 1) + " type for " + years + " years");
            float total = loanAmt * (float) Math.pow((100d + mp.getOrDefault(loanList.get(number - 1), 0f)) / 100, years);
            System.out.println("After " + years + " year(s) your total repay amount will be " + total);
            System.out.println("You have to give an interest of " + (total - loanAmt) + " inr only.");
        }
        else System.out.println("Sorry, right now you are not eligible to take a loan. Please try again after some months.");
    }

    @Override
    public void applyCreditCard() {

    }

    @Override
    public float getBalance() {
        return balance;
    }

    @Override
    public int getWithdrawTime() {
        return 0;
    }

}