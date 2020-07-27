package com.aneesh;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
		
		String vendorCsvFilepath = "../VendorOrderMerge/src/main/resources/csv_files/vendor-place.csv";
		String companyCsvFilepath = "../VendorOrderMerge/src/main/resources/csv_files/company-place.csv";
		
		//read all data in from csvs
		Map<String, VendorData> vendorData = new CsvLoadService<VendorData>().loadCsv(vendorCsvFilepath);
		Map<String, CsvData> companyData = new CsvLoadService<CsvData>().loadCompanyCsv(companyCsvFilepath);
		Map<String, CsvData> companyUnlocodes = new HashMap<>();
		Map<String, CsvData> companyPlaceName = new HashMap<>();
		int maxId = 1;
		
		CsvWriteService outputCsv = new CsvWriteService();
				
		for(CsvData currentCompanyRecord : companyData.values()) {
			companyUnlocodes.put(currentCompanyRecord.getUnlocode(), currentCompanyRecord);
			companyPlaceName.put(currentCompanyRecord.getName(), currentCompanyRecord);
		}
		
		for(VendorData vendorRecord : vendorData.values()) {
			
			if(companyUnlocodes.containsKey(vendorRecord.getUnlocode())
					|| companyPlaceName.containsKey(vendorRecord.getPlaceName())) {
				
				//obtain the record to be updated
				CsvData matchedRecord = companyUnlocodes.get(vendorRecord.getUnlocode()) == null ? 
						companyUnlocodes.get(vendorRecord.getUnlocode()) : companyPlaceName.get(vendorRecord.getPlaceName());
						
				//update the existing record
				matchedRecord.setIsActive("f");;
						
				//create a new record to be added
				CsvData newRecord = buildNewCsvData(companyData.get(companyPlaceName.get(vendorRecord.getPlaceName()).getId()), vendorRecord.getPlaceId());
				maxId = Integer.parseInt(newRecord.getId());
				//add the new record to the map
				companyData.put(newRecord.getId(), newRecord);
				

				
			}				
			else {
				continue;
			}				
		}	
		
		for(int i =1; i<=maxId; i++) {		
			outputCsv.append(companyData.get(Integer.toString(i)));		
		}
		
		outputCsv.closeWriters();			
	}

	public CsvData buildNewCsvData(CsvData csvData, String placeId) {
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
		String formatDate = format.format(new Date());
		
		return new CsvData(
				csvData.incrementAndGetNextId(),
				csvData.getName(),
				"t",
				csvData.getCreatedAt(),
				formatDate,
				csvData.getUnlocode(),
				csvData.getPlaceIdentifier(),
				placeId);
	}
}
