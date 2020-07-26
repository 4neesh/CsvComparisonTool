package com.aneesh.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.aneesh.data.CsvData;
import com.opencsv.CSVWriter;


public class CsvWriteService {

	private static String filename = "../VendorOrderMerge/src/main/resources/csv_files/output-place_" + new Date().getDate() +".csv";
	FileWriter newCsvFile;
	CSVWriter csvWriter;
	{

	try {
		newCsvFile = new FileWriter(filename);
		csvWriter = new CSVWriter(newCsvFile);

	} 
	catch (IOException e) {
		e.printStackTrace();
		}
	}
	
	public CsvWriteService() {

		try {
			createNewOutputCsv();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//get file name method and pass into the update csv class and method on the main thread application class.
	
	public void createNewOutputCsv() throws IOException {
		
		String[] header = {"id", "name", "is_active", "created_at", "updated_at", "UNLOCODE", "place_identity_id", "vendor_place_id"};
		
		csvWriter.writeNext(header);

	}
	
	public void append(CsvData csvData) {
		String[] lineToWriter = {csvData.getId(), csvData.getName(),
								csvData.getIsActive(), csvData.getCreatedAt(),
								csvData.getUpdatedAt(), csvData.getUnlocode(),
								csvData.getPlaceIdentifier(), csvData.getVendorPlaceId()};
		csvWriter.writeNext(lineToWriter);
		
	}
	
	public void closeWriters() throws IOException {
		csvWriter.close();
		newCsvFile.close();
	}
	
}
