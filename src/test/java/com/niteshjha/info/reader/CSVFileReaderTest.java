package com.niteshjha.info.reader;

import com.niteshjha.info.model.Transaction;
import com.niteshjha.info.model.Transactions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;


@RunWith(JUnit4.class)
public class CSVFileReaderTest {

    private static Path path = null;
    private static CSVFileReader csvFileReader = null;

    @BeforeClass
    public static void setUp() {
        path = Paths.get("src/test/testResources", "Sales.csv");
        csvFileReader = new CSVFileReader();
    }

    @Test
    public void processInputFile_checkingTransactionObjectSize() {
        Transactions transactions = csvFileReader.processInputFile(path.toAbsolutePath().toString(), 2008);
        assertEquals(501, transactions.getTransactions().size());
    }


    @Test
    public void processInputFile_checkingTransactionFirstElementProperty() {
        Transactions transactions = csvFileReader.processInputFile(path.toAbsolutePath().toString(), 2008);
        Transaction transaction = transactions.getTransactions().get(1);
        assertEquals("Gerd W".toLowerCase(), transaction.getName().toLowerCase());
        assertEquals("visa", transaction.getPaymentType().toString().toLowerCase());
        assertEquals("United States".toLowerCase(), transaction.getCountry().toLowerCase());
        assertEquals(2008, transaction.getAccountCreated().toLocalDate().getYear());

    }

}