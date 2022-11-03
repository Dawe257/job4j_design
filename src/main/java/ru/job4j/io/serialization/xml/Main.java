package ru.job4j.io.serialization.xml;

import ru.job4j.io.serialization.json.CreditCard;
import ru.job4j.io.serialization.json.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        Person person = new Person("Ivan", "Ivanov");
        CreditCard card = new CreditCard("123", false, 100500L, person, new long[]{150L, 300L, 5500L});

        JAXBContext context = JAXBContext.newInstance(CreditCard.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(card, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            CreditCard result = (CreditCard) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }

    }
}