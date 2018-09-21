package com.niteshjha.info.writer;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CSV2JSONFileWriterTest {

    private static final String JSON_FILE_NAME = "transaction_" + LocalDateTime.now().toLocalDate() + ".json";
    private static CSV2JSONFileWriter csv2JSONFileWriter = null;

    @BeforeClass
    public static void setUp() {
        Path path = Paths.get("src/test/testResources", "Sales.csv");
        csv2JSONFileWriter = new CSV2JSONFileWriter(path.toAbsolutePath().toString(), 2007);
    }

    @Test
    public void generateFile_checkFileWithName_JSON_FILE_NAME_exists() {
        File file = csv2JSONFileWriter.generateFile();
        assertTrue(file.exists());
        assertEquals(JSON_FILE_NAME, file.getName());
        //deleting the file on exit
        file.deleteOnExit();
    }
}