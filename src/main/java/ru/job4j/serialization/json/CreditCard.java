package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class CreditCard {

    private String num;
    private boolean expired;
    private long amount;
    private Person owner;
    private long[] transactions;

    public CreditCard(String num, boolean expired, long amount, Person owner, long[] transactions) {
        this.num = num;
        this.expired = expired;
        this.amount = amount;
        this.owner = owner;
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "num='" + num + '\'' +
                ", expired=" + expired +
                ", amount=" + amount +
                ", owner=" + owner +
                ", transactions=" + Arrays.toString(transactions) +
                '}';
    }

    public static void main(String[] args) {
        Person person = new Person("Ivan", "Ivanov");
        CreditCard card = new CreditCard("123", false, 100500L, person, new long[] {150L, 300L, 5500L});
        final Gson gson = new GsonBuilder().create();
        String json = gson.toJson(card);
        System.out.println(json);
        CreditCard cardFromJson = gson.fromJson(json, CreditCard.class);
        System.out.println(cardFromJson);
    }
}
