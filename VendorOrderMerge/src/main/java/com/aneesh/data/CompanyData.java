package com.aneesh.data;

public class CompanyData extends CsvData {

	@Override
	public String toString() {
		return "CompanyData [getId()=" + getId() + ", getName()=" + getName() + ", getIsActive()=" + getIsActive()
				+ ", getCreatedAt()=" + getCreatedAt() + ", getUpdatedAt()=" + getUpdatedAt() + ", getUnlocode()="
				+ getUnlocode() + ", getPlaceIdentifier()=" + getPlaceIdentifier() + ", getVendorPlaceId()="
				+ getVendorPlaceId() + "]";
	}

	
}
