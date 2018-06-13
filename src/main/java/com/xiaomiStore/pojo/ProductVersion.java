package com.xiaomiStore.pojo;

public class ProductVersion {
    private String versionId;
    private String detailVersion;

    public ProductVersion() {
    }

    public ProductVersion(String versionId, String detailVersion) {

        this.versionId = versionId;
        this.detailVersion = detailVersion;
    }

    @Override
    public String toString() {
        return "ProductVersion{" +
                "versionId='" + versionId + '\'' +
                ", detailVersion='" + detailVersion + '\'' +
                '}';
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getDetailVersion() {
        return detailVersion;
    }

    public void setDetailVersion(String detailVersion) {
        this.detailVersion = detailVersion;
    }
}
