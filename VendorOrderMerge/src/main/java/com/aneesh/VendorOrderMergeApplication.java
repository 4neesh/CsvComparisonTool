package com.aneesh;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

import com.aneesh.csv.*;
import com.aneesh.data.*;

@SpringBootApplication
@EnableTask
public class VendorOrderMergeApplication {

    @Bean
    public Comparison createComparison() {
        return new Comparison();
    }

    public static void main(String[] args) {
        SpringApplication.run(VendorOrderMergeApplication.class, args);
    }

}

class Comparison implements CommandLineRunner {

    public Map<String, VendorData> vendorData;
    public Map<String, CompanyData> companyData;


    @Override
    public void run(String... args) throws Exception {

        FileLoadService csvLoadService = new CsvLoadService();

        vendorData = csvLoadService.loadVendor();
        companyData = csvLoadService.loadCompany();

        populateCompanyDataUnlocodePlacenameMaps();

        addVendorRecordsToOutput();

        appendRecordsIntoOutput();

    }

    private void appendRecordsIntoOutput() {

        FileWriteService outputCsv = new CsvWriteService();

        for (int i = 1; i <= Integer.parseInt(CompanyData.getHighestId()); i++) {
            outputCsv.append(companyData.get(Integer.toString(i)));
        }

        outputCsv.close();

    }

    private void addVendorRecordsToOutput() {
        for (VendorData vendorRecord : vendorData.values()) {

            if (CompanyData.companyUnlocodes.containsKey(vendorRecord.getUnlocode())
                    || CompanyData.companyPlaceName.containsKey(vendorRecord.getPlaceName())) {


                setCompanyRecordToInactive(vendorRecord);


                CompanyData activeRecord = buildNewActiveRecord(companyData.get(CompanyData.companyPlaceName.get(vendorRecord.getPlaceName()).getId()), vendorRecord.getPlaceId());

                //add the new record to the map
                companyData.put(activeRecord.getId(), activeRecord);

            } else {
                continue;
            }
        }
    }

    private void setCompanyRecordToInactive(VendorData vendorRecord) {
        if (CompanyData.companyUnlocodes.containsKey(vendorRecord.getUnlocode())) {
            CompanyData.companyUnlocodes.get(vendorRecord.getUnlocode()).setIsActive("f");
        }
        if (CompanyData.companyPlaceName.containsKey(vendorRecord.getPlaceName())) {
            CompanyData.companyPlaceName.get(vendorRecord.getPlaceName()).setIsActive("f");
        }
    }

    private void populateCompanyDataUnlocodePlacenameMaps() {

        for (CompanyData currentCompanyRecord : companyData.values()) {
            CompanyData.companyUnlocodes.put(currentCompanyRecord.getUnlocode(), currentCompanyRecord);
            CompanyData.companyPlaceName.put(currentCompanyRecord.getName(), currentCompanyRecord);
        }

    }

    public CompanyData buildNewActiveRecord(CompanyData csvData, String placeId) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        String formatDate = format.format(new Date());

        return new CompanyData(
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
