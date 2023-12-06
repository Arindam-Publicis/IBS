import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RBI {
    BufferedReader buff;
    InputStreamReader isr;
    int withdrawlTime;
    int flag;
    float balance = 1000.0f;
    float FDROI,LoanROI;
    public RBI(InputStreamReader isr, BufferedReader buff) {
        this.isr = isr;
        this.buff = buff;
        withdrawlTime=0;
        flag=0;
        FDROI=6;
        LoanROI=12;
    }


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
    public void withdrawMoney(){
        System.out.println("Enter the amount you want to withdraw");
        try {
            float amt=Float.parseFloat(buff.readLine());
            if(balance-amt-flag*(amt*0.01f)>=1000){
                balance-=amt+flag*(amt*0.01f);
                withdrawlTime++;
                if(withdrawlTime>3)flag=1;

                System.out.println(amt+" inr is withdrawn from your account. Your current account balance is "+balance);
            }
            else System.out.println("You have less than or equal to 1000 inr in your account");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void openFD(float amount, float FDROI, int years) {
        System.out.println("You are going to create a FD of "+amount+" rupees");
        for(int i=0;i<years;i++){
            float total=amount*(float)Math.pow((100d+FDROI)/100,i+1);
            System.out.println("After "+(i+1)+" year(s) your total amount will be "+total);
            if(i==years-1) System.out.println("Your total profit will be "+(total-amount));
        }
    }
    public void applyLoan(String loanType, float amount, float LoanROI, int years) {
        System.out.println("You are going to take a loan of "+amount+" rupees");
        float total=amount*(float)Math.pow((100d+LoanROI)/100,years);
        System.out.println("After "+years+" year(s) your total repay amount will be "+total);
        System.out.println("You have to give an interest of "+(total-amount)+" inr only.");
    }
    public void applyCreditCard() {}
    public float getBalance() {
        return balance;
    }
    public int getWithdrawlTime(){
        return withdrawlTime;
    }
}