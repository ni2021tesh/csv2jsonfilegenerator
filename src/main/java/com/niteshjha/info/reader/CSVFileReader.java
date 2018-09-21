package com.niteshjha.info.reader;

import com.niteshjha.info.model.PaymentType;
import com.niteshjha.info.model.Transaction;
import com.niteshjha.info.model.Transactions;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.niteshjha.info.utility.DateConverterUtility.getDate;
import static com.niteshjha.info.utility.DateConverterUtility.getString;

/**
 * @author Nitesh Jha
 * @apiNote CSVFileReader is used to read CSV file whose absolute path will be provided at runtime by the user
 */
public class CSVFileReader implements FileReader {

    /**
     * @param line is the single transaction separated by ','
     * @return Transaction it is a single Transaction retrieved from csv file
     */
    private static Transaction apply(String line) {

        String[] p = getString(line).split(",");// a CSV has comma separated lines
        Transaction item = new Transaction();
        try {
            item.setTransactionDate(getDate(p[0].trim()));
            item.setProduct(p[1].trim());
            item.setPaymentType(PaymentType.valueOf(p[3].trim().toUpperCase()));
            item.setName(p[4].trim());
            item.setCity(p[5].trim());
            item.setState(p[6].trim());
            item.setCountry(p[7].trim());
            item.setAccountCreated(getDate(p[8].trim()));
            item.setLastLogin(getDate(p[9].trim()));
            item.setPrice(new BigDecimal(p[2].trim()));
            item.setLatitude(p[10].trim());
            item.setLongitude(p[11].trim());
            //calculating the account age from account created field
            LocalDate accountCreated = item.getAccountCreated().toLocalDate();
            LocalDate today = LocalDate.now();                          //Today's date
            Period period = Period.between(accountCreated, today);
            item.setAccountAge(period.getYears() + "year - " + period.getMonths() + "month - " + period.getDays() + "days");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return item;
    }


    @Override
    public Transactions processInputFile(String inputFilePath, int year) {
        List<Transaction> inputList = new ArrayList<Transaction>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(inputFilePath))));) {
            inputList =
                    br.lines().skip(1)//skipping the header of the file
                            .map(CSVFileReader::apply)//converting stream of line item to Transaction Object
                            .filter(transaction -> transaction.getAccountCreated().toLocalDate().getYear() <= year) //filter the account created
                            .collect(Collectors.toList()); //collecting to list
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new Transactions(inputList);
    }
}
