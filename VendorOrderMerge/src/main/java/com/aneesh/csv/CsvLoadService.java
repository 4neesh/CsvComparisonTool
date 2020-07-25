package com.aneesh.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.aneesh.data.CsvData;
import com.aneesh.data.VendorData;

@Service
public class CsvLoadService<T> {
	
	public Map<String, VendorData> loadCsv(String filename) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		Map<String, VendorData> vd = new HashMap<>();
		try {
			String line;
			br.readLine();
		
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");
				String[] properties = new String[4];
			
				properties[0] = null; //placeId
				properties[1] = null; //placeName
				properties[2] = null; //latitude
				properties[3] = null; //unlocode
				for(int i = 0; i<values.length; i++) {
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
	
public Map<String, CsvData> loadOtherCsv(String filename) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		Map<String, CsvData> vd = new HashMap<>();
		try {
			String line;
			br.readLine();
		
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");
				String[] properties = new String[8];
			
				properties[0] = null; //id
				properties[1] = null; //name
				properties[2] = null; //isActive
				properties[3] = null; //createdAt
				properties[4] = null; //updatedAt
				properties[5] = null; //unlocode
				properties[6] = null; //placeIdentityId
				properties[7] = null; //vendorPlaceId
				
				
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
				vd.put(properties[7], record);
				
			}
		}
		catch (Exception e){
			br.close();
		}
		return vd;
	}
	
}
