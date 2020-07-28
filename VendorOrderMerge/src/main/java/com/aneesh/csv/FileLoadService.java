package com.aneesh.csv;

import java.util.Map;

import com.aneesh.data.CompanyData;
import com.aneesh.data.VendorData;

public interface FileLoadService {

    Map<String, CompanyData> loadCompany();

    Map<String, VendorData> loadVendor();
}
