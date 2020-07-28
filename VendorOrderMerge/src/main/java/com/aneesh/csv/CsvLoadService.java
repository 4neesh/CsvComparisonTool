package com.aneesh.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.aneesh.data.CompanyData;
import com.aneesh.data.VendorData;


public class CsvLoadService implements FileLoadService {

    private static final String DELIMITER = ",";
    private BufferedReader br;
    private Map<String, VendorData> vendorMap;
    private Map<String, CompanyData> companyMap;

    String vendorCsv = "../VendorOrderMerge/src/main/resources/csv_files/vendor-place.csv";
    String companyCsv = "../VendorOrderMerge/src/main/resources/csv_files/company-place.csv";

//	@Value("${company-csv-filename}")
//	private String companyCsv;
//	
//	@Value("${vendor-csv-filename}")
//	private String vendorCsv;

    public Map<String, VendorData> loadVendor() {


        vendorMap = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader(vendorCsv));
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] values = line.split(DELIMITER, -1);
                String[] properties = new String[4];

                for (int i = 0; i < properties.length; i++) {
                    properties[i] = values[i];
                }
                VendorData newV = new VendorData(properties[0], properties[1], properties[2], properties[3]);
                vendorMap.put(properties[0], newV);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vendorMap;
    }


    public Map<String, CompanyData> loadCompany() {


        companyMap = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader(companyCsv));
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] values = line.split(DELIMITER, -1);

                String[] properties = new String[8];

                for (int i = 0; i < values.length; i++) {
                    properties[i] = values[i];
                }

                CompanyData record = new CompanyData(properties[0],
                        properties[1],
                        properties[2],
                        properties[3],
                        properties[4],
                        properties[5],
                        properties[6],
                        properties[7]
                );
                companyMap.put(properties[0], record);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return companyMap;
    }


    public Map<String, VendorData> getVendorMap() {
        return vendorMap;
    }


    public Map<String, CompanyData> getCompanyMap() {
        return companyMap;
    }


}
