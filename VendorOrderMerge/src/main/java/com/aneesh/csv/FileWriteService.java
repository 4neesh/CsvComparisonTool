package com.aneesh.csv;

import com.aneesh.data.CompanyData;

public interface FileWriteService {

    void createNewOutputFile();

    void close();

    void append(CompanyData csvData);
}
