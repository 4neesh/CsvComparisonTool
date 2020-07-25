package com.aneesh.data;

public class OutputData extends CsvData{

	@Override
	public String toString() {
		return "OutputData [getId()=" + getId() + ", getName()=" + getName() + ", getIsActive()=" + getIsActive()
				+ ", getCreatedAt()=" + getCreatedAt() + ", getUpdatedAt()=" + getUpdatedAt() + ", getUnlocode()="
				+ getUnlocode() + ", getPlaceIdentifier()=" + getPlaceIdentifier() + ", getVendorPlaceId()="
				+ getVendorPlaceId() + "]";
	}

	
}
