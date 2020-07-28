package com.aneesh.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import com.aneesh.data.CompanyData;
import com.opencsv.CSVWriter;


public class CsvWriteService implements FileWriteService {

    private static String filename = "../VendorOrderMerge/src/main/resources/csv_files/output-place_" + new Date() + ".csv";
    private FileWriter newCsvFile;
    private CSVWriter csvWriter;


    public CsvWriteService() {

        try {
            newCsvFile = new FileWriter(filename);
            csvWriter = new CSVWriter(newCsvFile);
            createNewOutputFile();
        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    //get file name method and pass into the update csv class and method on the main thread application class.

    public void createNewOutputFile() {

        String[] header = {"id", "name", "is_active", "created_at", "updated_at", "UNLOCODE", "place_identity_id", "vendor_place_id"};

        csvWriter.writeNext(header);

    }

    public void append(CompanyData csvData) {
        String[] lineToWriter = {csvData.getId(), csvData.getName(),
                csvData.getIsActive(), csvData.getCreatedAt(),
                csvData.getUpdatedAt(), csvData.getUnlocode(),
                csvData.getPlaceIdentifier(), csvData.getVendorPlaceId()};
        csvWriter.writeNext(lineToWriter);

    }

    public void close() {
        try {
            csvWriter.close();
            newCsvFile.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public FileWriter getNewCsvFile() {
        return newCsvFile;
    }

    public CSVWriter getCsvWriter() {
        return csvWriter;
    }
}
