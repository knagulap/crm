package com.crm.customer.shared.utils;

import java.io.File;
import java.io.IOException;

public class FileCreationTest {
    public static void main(String[] args) {
        File file = new File("logs/crm_customer.log");
        try {
            boolean created = file.createNewFile();
            if (created) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File creation failed.");
            }
        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}
