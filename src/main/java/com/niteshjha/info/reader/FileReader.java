package com.niteshjha.info.reader;

import com.niteshjha.info.model.Transactions;

/**
 * @author Nitesh Jha
 * @apiNote this interface represent Generic file Reader if in future anyone needs to create another type of reader then implement this interface
 */
public interface FileReader {
    /**
     * @param inputFilePath the absolute path of the file
     * @param year          year for which data need to be sorted
     * @return Transactions which contain list of Transaction
     */
    public Transactions processInputFile(String inputFilePath, int year);
}
