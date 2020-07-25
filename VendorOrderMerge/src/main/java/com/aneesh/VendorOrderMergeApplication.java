package com.aneesh;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aneesh.csv.CsvLoadService;
import com.aneesh.data.CompanyData;
import com.aneesh.data.CsvData;
import com.aneesh.data.OutputData;
import com.aneesh.data.VendorData;

@SpringBootApplication
public class VendorOrderMergeApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(VendorOrderMergeApplication.class, args);
		
		//read all data in from csvs
		Map<String, VendorData> vendorData = new CsvLoadService<VendorData>().loadCsv("../VendorOrderMerge/src/main/resources/csv_files/vendor-place.csv");
		Map<String,CsvData> companyData = new CsvLoadService<CompanyData>().loadOtherCsv("../VendorOrderMerge/src/main/resources/csv_files/output-place.csv");
		Map<String, CsvData> outputData = new CsvLoadService<OutputData>().loadOtherCsv("../VendorOrderMerge/src/main/resources/csv_files/company-place.csv");
		
		
		
	}

}
