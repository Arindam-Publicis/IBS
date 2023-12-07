import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Customer {
    private String customerName, customerEmail, customerAddress, customerGender, customerAadhar, customerPhone;
    private float balance;
    BufferedReader buff;
    InputStreamReader isr;
    public Customer(InputStreamReader isr, BufferedReader buff) {
        this.isr=isr;
        this.buff=buff;
    }
    public Customer(String customerName, String customerEmail, String customerAddress, String customerGender, String customerAadhar, String customerPhone, float balance) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerGender = customerGender;
        this.customerAadhar = customerAadhar;
        this.customerPhone = customerPhone;
        this.balance = balance;
    }



    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerAadhar() {
        return customerAadhar;
    }

    public void setCustomerAadhar(String customerAadhar) {
        this.customerAadhar = customerAadhar;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    public void showCustomerDetails(){
        System.out.println("Showing Details->");
        System.out.println("Name ->"+getCustomerName()+"\nEmail ->"+getCustomerEmail()+"\nAddress ->"+getCustomerAddress()+"\nGender ->"+getCustomerGender()+"\nAadhar Number ->"+getCustomerAadhar()+"\nPhone Number ->"+getCustomerPhone());
    }
}