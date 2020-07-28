package com.aneesh.csv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class CsvLoadServiceTest {

    CsvLoadService loadService;

    @Before
    public void setup() {

        loadService = new CsvLoadService();

    }

    @Test(expected=NullPointerException.class)
    public void vendorMapEmpty() {

        fail(loadService.getVendorMap().toString());
    }

    @Test(expected=NullPointerException.class)
    public void companyMapEmpty() {

        fail(loadService.getCompanyMap().toString());
    }

    @Test
    public void loadsCompanyCsv() {

        loadService.loadCompany();
        assertEquals("load company does not load all 16 records", 16, loadService.getCompanyMap().size());

    }

    @Test
    public void loadsVendorCsv() {

        loadService.loadVendor();
        assertEquals("load vendor does not load all 15 records", 15, loadService.getVendorMap().size());

    }
}
