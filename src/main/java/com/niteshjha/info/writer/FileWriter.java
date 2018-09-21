package com.niteshjha.info.writer;

import java.io.File;

/**
 * @author Nitesh Jha
 * @apiNote this interface represent the file writer
 */
public interface FileWriter {
    /**
     * @return File the file object
     * @apiNote this method is used to generate the file depending upon the FileWriter type
     */
    public File generateFile();
}
