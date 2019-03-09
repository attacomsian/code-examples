package com.attacomsian.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class JacksonApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JacksonApplication.class, args);
    }

    @Override
    public void run(String[] args) throws IOException {

        /*=========JSON FILE TO OBJECT=============*/

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //read json file and convert to customer object
        Customer customer = objectMapper.readValue(new File("customer.json"), Customer.class);

        //print customer details
        System.out.println(customer);

        /*=========OBJECT TO JSON FILE =============*/

        //create a customer object
        Customer customerObj = new Customer();
        customerObj.setId(567L);
        customerObj.setName("Maria Kovosi");
        customerObj.setEmail("maria@example.com");
        customerObj.setPhone("+12 785 4895 321");
        customerObj.setAge(29);
        customerObj.setProjects(new String[]{"Path Finder App", "Push Notifications"});

        Address address = new Address();
        address.setStreet("Karchstr.");
        address.setCity("Hanover");
        address.setZipcode(66525);
        address.setCountry("Germany");
        customerObj.setAddress(address);

        List<String> paymentMethods = new ArrayList<>();
        paymentMethods.add("PayPal");
        paymentMethods.add("SOFORT");
        customerObj.setPaymentMethods(paymentMethods);

        Map<String, Object> info = new HashMap<>();
        info.put("gender", "female");
        info.put("married", "No");
        info.put("income", "120,000 EURO");
        info.put("source", "Google Search");
        customerObj.setProfileInfo(info);

        //configure objectMapper for pretty input
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        //write customerObj object to customer2.json file
        objectMapper.writeValue(new File("customer2.json"), customerObj);

        /*=========JSON FILE TO MAP=============*/

        //convert json file to map
        Map<?, ?> map = objectMapper.readValue(new FileInputStream("customer.json"), Map.class);

        //iterate over map entries and print to console
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        /*=========JSON FILE TO TREE MODEL=============*/

        //read customer.json file into tree model
        JsonNode rootNode = objectMapper.readTree(new File("customer.json"));

        //read name and phone nodes
        System.out.println("Customer Name: " + rootNode.path("name").asText());
        System.out.println("Customer Phone: " + rootNode.path("phone").asText());
        System.out.println("Customer Age: " + rootNode.path("age").asInt());
        System.out.println("Customer City: " + rootNode.path("address").path("city").asText());
        System.out.println("Customer Project: " + rootNode.path("projects").get(0).asText());
    }
}
