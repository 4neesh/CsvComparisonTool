package com.aneesh.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.aneesh.data.CsvData;
import com.aneesh.data.VendorData;


public class CsvLoadService<T> {
	
	private static final String DELIMITER = ",";
	private BufferedReader br;
	public Map<String, VendorData> loadCsv(String filename) throws IOException {
		
		br = new BufferedReader(new FileReader(filename));
		Map<String, VendorData> vd = new HashMap<>();
		try {
			String line;
			br.readLine();
		
			while((line = br.readLine()) != null) {
				
				String[] values = line.split(DELIMITER, -1);
				String[] properties = new String[4];

				for(int i = 0; i<properties.length; i++) {
					properties[i] = values[i];
				}
				VendorData newV = new VendorData(properties[0],properties[1],properties[2],properties[3]);
				vd.put(properties[0], newV);
			}
		}
		catch (Exception e){
			br.close();
		}
		return vd;
	}
	
public Map<String, CsvData> loadOutputCsv(String filename) throws IOException {
		
		br = new BufferedReader(new FileReader(filename));
		Map<String, CsvData> vd = new HashMap<>();
		try {
			String line;
			br.readLine();
		
			while((line = br.readLine()) != null) {
				
				String[] values = line.split(DELIMITER, -1);
				
				String[] properties = new String[8];

				for(int i = 0; i<values.length; i++) {
					properties[i] = values[i];
				}
								
				CsvData record = new CsvData(properties[0],
											properties[1],
											properties[2],
											properties[3],
											properties[4],
											properties[5],
											properties[6],
											properties[7]
											);
				vd.put(properties[0], record);
				
			}
		}
		catch (Exception e){
			br.close();
		}
		return vd;
	}

public Map<String, CsvData> loadCompanyCsv(String filename) throws IOException {
	
	br = new BufferedReader(new FileReader(filename));
	Map<String, CsvData> vd = new HashMap<>();
	try {
		String line;
		br.readLine();
	
		while((line = br.readLine()) != null) {
						
			String[] values = line.split(DELIMITER, -1);
			
			String[] properties = new String[8];
		
			for(int i = 0; i<values.length; i++) {
				properties[i] = values[i];
			}
						
			CsvData record = new CsvData(properties[0],
										properties[1],
										properties[2],
										properties[3],
										properties[4],
										properties[5],
										properties[6],
										properties[7]
										);
			vd.put(properties[5], record);
			
		}
	}
	catch (Exception e){
		br.close();
	}
	return vd;
}

	
}
