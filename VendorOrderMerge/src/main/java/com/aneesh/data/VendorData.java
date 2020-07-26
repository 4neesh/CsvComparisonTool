package com.aneesh.data;


public class VendorData {

	private String placeId;
	private String placeName;
	private String latitude;
	private String unlocode;
	
	public VendorData(String placeId, String placeName, String latitude, String unlocode) {
		super();
		this.placeId = placeId;
		this.placeName = placeName;
		this.latitude = latitude;
		
		if(unlocode != null) {
		unlocode = unlocode.replaceAll(" ",  "");}
		this.unlocode = unlocode;
	}

	public String getPlaceId() {
		return placeId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getUnlocode() {
		return unlocode;
	}

	@Override
	public String toString() {
		return "VendorData [placeId=" + placeId + ", placeName=" + placeName + ", latitude=" + latitude + ", unlocode="
				+ unlocode + "]";
	}
	
	
	
}
