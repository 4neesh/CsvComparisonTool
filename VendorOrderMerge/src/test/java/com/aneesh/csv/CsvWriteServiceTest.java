package com.aneesh.csv;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CsvWriteServiceTest {

    private CsvWriteService writeService;

    @Before
    public void setup(){
         writeService = new CsvWriteService();
    }


    @Test
    public void constructorCreatesFileWriter() {

        assertNotNull("FileWriter is null when CsvWriteService is created",writeService.getNewCsvFile());

    }

    @Test
    public void constructorCreatesCsvWriter() {

        assertNotNull("CsvWriter is null when CsvWriteService is created",writeService.getCsvWriter());

    }



}
