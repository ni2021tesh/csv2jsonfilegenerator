package com.niteshjha.info.writer;

/**
 * @author Nitesh Jha
 * @apiNote This is a Abstract Factory class which is used to generate the file depending upon the type of writer provided by the user
 */
public class FileWriterFactory {
    /**
     * @param fileWriter the writer according to which the respective file will be generated for e.g. @CSV2JSONFileWriter
     * @apiNote this method generate the file whose object will be provided by the user.
     */
    public static void writeFile(FileWriter fileWriter) {
        fileWriter.generateFile();
    }
}
