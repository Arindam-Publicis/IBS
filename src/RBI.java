import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RBI {
    BufferedReader buff;
    InputStreamReader isr;
    int withdrawlTime;
    int flag;
    float balance = 1000.0f;
    public RBI(InputStreamReader isr, BufferedReader buff) {
        this.isr = isr;
        this.buff = buff;
        withdrawlTime=0;
        flag=0;
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
    public void openFD(float amount, float ROI, int years) {}
    public void applyLoan(String loanType, float amount, float ROI, int years) {}
    public void applyCreditCard() {}
    public float getBalance() {
        return balance;
    }
    public int getWithdrawlTime(){
        return withdrawlTime;
    }
}