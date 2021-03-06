package com.aneesh.data;

import java.util.HashMap;
import java.util.Map;

public class CompanyData {

    private String id;
    private String name;
    private String isActive;
    private String createdAt;
    private String updatedAt;
    private String unlocode;
    private String placeIdentifier;
    private String vendorPlaceId;
    private static String highestId = "0";
    public static Map<String, CompanyData> companyUnlocodes = new HashMap<>();
    public static Map<String, CompanyData> companyPlaceName = new HashMap<>();

    public CompanyData(String id, String name, String isActive, String createdAt, String updatedAt, String unlocode,
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

        updateNextId(id);
    }


    public static String getHighestId() {
        return highestId;
    }


    public void updateNextId(String id) {
        int idAsInt = Integer.parseInt(id);
        if (idAsInt > Integer.parseInt(highestId)) {
            highestId = Integer.toString(idAsInt);
        }
    }

    public String incrementAndGetNextId() {

        int currentNextId = Integer.parseInt(highestId);
        currentNextId++;
        highestId = Integer.toString(currentNextId);
        return highestId;
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

    public void markAsInactive() {
        this.isActive = "f";
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "CsvData [id=" + id + ", name=" + name + ", isActive=" + isActive + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + ", unlocode=" + unlocode + ", placeIdentifier=" + placeIdentifier
                + ", vendorPlaceId=" + vendorPlaceId + "]";
    }


}
