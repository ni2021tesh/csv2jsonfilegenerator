package com.niteshjha.info;

import com.niteshjha.info.writer.CSV2JSONFileWriter;
import com.niteshjha.info.writer.FileWriterFactory;

public class TestCSVReader {
    public static void main(String[] args) {
        System.out.println("calling the file reader");
        //file path will be provided by user from command line
        String filePath = null;

        //year according to which the transaction will be copied from csv to json
        int year = 0;

        //reading the argument from command line provided by user
        if (args.length == 2) {
            try {
                filePath = args[0];
                year = Integer.parseInt(args[1]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        //checking if filePath is not null  and year is not zero
        if (filePath != null && year != 0)
            //writing the csv file to json
            FileWriterFactory.writeFile(new CSV2JSONFileWriter(filePath, year));
        else
            System.out.println("Please provide both the inputs");
    }
}
