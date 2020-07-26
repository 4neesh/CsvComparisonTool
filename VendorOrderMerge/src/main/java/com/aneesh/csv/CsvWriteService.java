package com.aneesh.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.aneesh.data.CsvData;

@Service
public class CsvWriteService {

	FileWriter newCsvFile;
	
	public CsvWriteService() {

		try {
			createNewOutputCsv();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void createNewOutputCsv() throws IOException {
		String filename = "../VendorOrderMerge/src/main/resources/csv_files/output-place_" + new Date().getDate() +".csv";
		
		try {
		newCsvFile = new FileWriter(filename);
		newCsvFile.append("id");
		newCsvFile.append(",");
		newCsvFile.append("name");
		newCsvFile.append(",");
		newCsvFile.append("is_active");
		newCsvFile.append(",");
		newCsvFile.append("created_at");
		newCsvFile.append(",");
		newCsvFile.append("updated_at");
		newCsvFile.append(",");
		newCsvFile.append("UNLOCODE");
		newCsvFile.append(",");
		newCsvFile.append("place_identity_id");
		newCsvFile.append(",");		
		newCsvFile.append("vendor_place_id");
		
		}
		catch(IOException e) {

			e.printStackTrace();
		}

	}
	
	public void append(CsvData csvData) {
		try {
		newCsvFile.append(csvData.getId());
		newCsvFile.append(",");
		newCsvFile.append(csvData.getName());
		newCsvFile.append(",");
		newCsvFile.append(csvData.getIsActive());
		newCsvFile.append(",");
		newCsvFile.append(csvData.getCreatedAt());
		newCsvFile.append(",");
		newCsvFile.append(csvData.getUpdatedAt());
		newCsvFile.append(",");
		newCsvFile.append(csvData.getUnlocode());
		newCsvFile.append(",");
		newCsvFile.append(csvData.getPlaceIdentifier());
		newCsvFile.append(",");		
		newCsvFile.append(csvData.getVendorPlaceId());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
