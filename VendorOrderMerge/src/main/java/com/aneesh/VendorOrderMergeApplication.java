package com.aneesh;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aneesh.csv.CsvLoadService;
import com.aneesh.csv.CsvWriteService;
import com.aneesh.data.CsvData;
import com.aneesh.data.VendorData;

@SpringBootApplication
public class VendorOrderMergeApplication implements CommandLineRunner{

	public static void main(String[] args) throws IOException {
		SpringApplication.run(VendorOrderMergeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
				
		//read all data in from csvs
		Map<String, VendorData> vendorData = new CsvLoadService<VendorData>().loadCsv("../VendorOrderMerge/src/main/resources/csv_files/vendor-place.csv");
		Map<String, CsvData> companyData = new CsvLoadService<CsvData>().loadCompanyCsv("../VendorOrderMerge/src/main/resources/csv_files/company-place.csv");
		Map<String, CsvData> companyUnlocodes = new HashMap<>();
		Map<String, CsvData> companyPlaceName = new HashMap<>();

		CsvWriteService outputCsv = new CsvWriteService();
				
		for(CsvData currentCompanyRecord : companyData.values()) {
			outputCsv.append(currentCompanyRecord);
			companyUnlocodes.put(currentCompanyRecord.getUnlocode(), currentCompanyRecord);
			companyPlaceName.put(currentCompanyRecord.getName(), currentCompanyRecord);

		}
		
		for(VendorData vendorRecord : vendorData.values()) {
			
			if(companyUnlocodes.containsKey(vendorRecord.getUnlocode())
					|| companyPlaceName.containsKey(vendorRecord.getPlaceName())) {
				
				//obtain the record to be updated
				
				
				//create a new record to be added
				CsvData newRecord = buildNewCsvData(companyData.get(vendorRecord.getUnlocode()), vendorRecord.getPlaceId());
				
				//add the new record
				outputCsv.append(newRecord);
				
				//update the previous record
				
			}				
			else {
				continue;
			}				
		}			
		outputCsv.closeWriters();			
	}

	public CsvData buildNewCsvData(CsvData csvData, String placeId) {
		return new CsvData(csvData.incrementAndGetNextId(),
				csvData.getName(),
				"t",
				csvData.getCreatedAt(),
				new Date().toString(),
				csvData.getUnlocode(),
				csvData.getPlaceIdentifier(),
				placeId);
	}
}
