package com.aneesh.data;


public class CsvData {

	private String id;
	private String name;
	private String isActive;
	private String createdAt;
	private String updatedAt;
	private String unlocode;
	private String placeIdentifier;
	private String vendorPlaceId;
	
	public CsvData() {
		
	}
	
	public CsvData(String id, String name, String isActive, String createdAt, String updatedAt, String unlocode,
			String placeIdentifier, String vendorPlaceId) {
		super();
		this.id = id;
		this.name = name;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.unlocode = unlocode;
		this.placeIdentifier = placeIdentifier;
		this.vendorPlaceId = vendorPlaceId;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getIsActive() {
		return isActive;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public String getUnlocode() {
		return unlocode;
	}
	public String getPlaceIdentifier() {
		return placeIdentifier;
	}
	public String getVendorPlaceId() {
		return vendorPlaceId;
	}

	@Override
	public String toString() {
		return "CsvData [id=" + id + ", name=" + name + ", isActive=" + isActive + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", unlocode=" + unlocode + ", placeIdentifier=" + placeIdentifier
				+ ", vendorPlaceId=" + vendorPlaceId + "]";
	}
	
	
	
	
}
