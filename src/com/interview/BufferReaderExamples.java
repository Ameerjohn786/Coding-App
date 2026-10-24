package com.interview;

import java.io.*;

public class BufferReaderExamples {

    public static void main(String[] args) throws IOException {
        try (BufferedWriter writer = new BufferedWriter
                (new FileWriter("d://customer.txt"))) {

            writer.write("Customer ID: 101");
            writer.newLine();
            writer.write("Customer Name: john");
        }


        readfile();
    }

    private static void readfile() throws IOException {
        String path = "d://customer.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
