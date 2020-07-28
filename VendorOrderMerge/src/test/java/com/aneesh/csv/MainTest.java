package com.aneesh.csv;

import com.aneesh.CsvBuilder;
import com.aneesh.data.CompanyData;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void buildNewActiveRecord(){

        CsvBuilder builder = new CsvBuilder();
        CompanyData companyData = new CompanyData("1", "name", "t", "date-a",
                "date-b", "unlocode", "pId", "vId");

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        String formatDate = format.format(new Date());





        CompanyData updatedCompanyData = builder.buildNewActiveRecord(companyData, "placeId");

        assertEquals("BuildNewActiveRecord not creating new record as expected",
                new CompanyData("2", "name", "t", "date-a",
                formatDate, "unlocode", "pId", "placeId").toString(),
                updatedCompanyData.toString());


    }
}
