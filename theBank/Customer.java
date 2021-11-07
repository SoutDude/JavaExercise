package IAMLEARNING;

import java.util.ArrayList;

public class Customer {
    private String Name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialAmount) {
        this.Name = name;
        this.transactions = new ArrayList<Double>();
        addTransactions(initialAmount);
    }

    public void addTransactions(double amount) {
        this.transactions.add(amount);
    }

    public String getName() {
        return Name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
