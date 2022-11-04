package ru.job4j.io.serialization.json;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "creditCard")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCard {

    private String num;
    private boolean expired;
    private long amount;
    private Person owner;
    @XmlElementWrapper(name = "transactions")
    @XmlElement(name = "transaction")
    private long[] transactions;

    public CreditCard() {
    }

    public CreditCard(String num, boolean expired, long amount, Person owner, long[] transactions) {
        this.num = num;
        this.expired = expired;
        this.amount = amount;
        this.owner = owner;
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "CreditCard{"
                + "num='" + num + '\''
                + ", expired=" + expired
                + ", amount=" + amount
                + ", owner=" + owner
                + ", transactions=" + Arrays.toString(transactions)
                + '}';
    }

    public String getNum() {
        return num;
    }

    public boolean isExpired() {
        return expired;
    }

    public long getAmount() {
        return amount;
    }

    public Person getOwner() {
        return owner;
    }

    public long[] getTransactions() {
        return transactions;
    }
}
