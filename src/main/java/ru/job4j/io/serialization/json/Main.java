package ru.job4j.io.serialization.json;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Ivan", "Ivanov");
        CreditCard card = new CreditCard("123", false, 100500L, person, new long[]{150L, 300L, 5500L});

        JSONObject jsonCard = new JSONObject(card);
        System.out.println(jsonCard);
    }
}
