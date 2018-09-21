package com.niteshjha.info.writer;

import com.niteshjha.info.model.Transactions;
import com.niteshjha.info.reader.CSVFileReader;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author Nitesh Jha
 * @apiNote CSV2JSONFileWriter is used to writer the content to json file which is retrieved from csv file
 */
public class CSV2JSONFileWriter implements FileWriter {

    //absolute location of the file
    private String inputFilePath;
    //year according to which the data will be copied in json file
    private int year;
    //json file name that will be created
    private static final String JSON_FILE_NAME = "transaction_" + LocalDateTime.now().toLocalDate() + ".json";

    public CSV2JSONFileWriter(String inputFilePath, int year) {
        this.inputFilePath = inputFilePath;
        this.year = year;
    }

    @Override
    public File generateFile() {
        System.out.println("Reading the CSV File from " + inputFilePath);
        Transactions transactions = new CSVFileReader().processInputFile(inputFilePath, year);
        File jsonFile = new File(JSON_FILE_NAME);
        System.out.println("Generating the Json File");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(jsonFile, transactions);
        } catch (IOException e) {
            System.out.println("Error Occurred while generating the json file " + e.getMessage());
        }
        System.out.println("File " + JSON_FILE_NAME + " generated Successfully");
        return jsonFile;
    }

}
