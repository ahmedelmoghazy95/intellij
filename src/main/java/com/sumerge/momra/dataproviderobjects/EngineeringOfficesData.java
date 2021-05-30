package com.sumerge.momra.dataproviderobjects;

import com.sumerge.momra.utilities.CustomAnnotations;

public class EngineeringOfficesData {

    @CustomAnnotations.ExcelColumn(1)
    String testCaseName;

    @CustomAnnotations.ExcelColumn(2)
    String username;

    @CustomAnnotations.ExcelColumn(3)
    String password;

    @CustomAnnotations.ExcelColumn(4)
    String officeNameLabel;

    @CustomAnnotations.ExcelColumn(5)
    String officeNumberLabel;

    @CustomAnnotations.ExcelColumn(6)
    String officeSecretariatLabel;

    @CustomAnnotations.ExcelColumn(7)
    String officeMunicipialLabel;

    @CustomAnnotations.ExcelColumn(8)
    String officeNumberOfInspectorsLabel;

    @CustomAnnotations.ExcelColumn(9)
    String officeCapacityLabel;

    @CustomAnnotations.ExcelColumn(10)
    String officeActionsLabel;


    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOfficeNameLabel() {
        return officeNameLabel;
    }

    public void setOfficeNameLabel(String officeNameLabel) {
        this.officeNameLabel = officeNameLabel;
    }

    public String getOfficeNumberLabel() {
        return officeNumberLabel;
    }

    public void setOfficeNumberLabel(String officeNumberLabel) {
        this.officeNumberLabel = officeNumberLabel;
    }

    public String getOfficeSecretariatLabel() {
        return officeSecretariatLabel;
    }

    public void setOfficeSecretariatLabel(String officeSecretariatLabel) {
        this.officeSecretariatLabel = officeSecretariatLabel;
    }

    public String getOfficeActions () { return officeActionsLabel; }

    public void setOfficeActionsLabel (String officeActionsLabel) {
        this.officeActionsLabel = officeActionsLabel;
    }

    public String getOfficeMunicipialLabel() {
        return officeMunicipialLabel;
    }

    public void setOfficeMunicipialLabel(String officeMunicipialLabel) {
        this.officeMunicipialLabel = officeMunicipialLabel;
    }

    public String getOfficeNumberOfInspectorsLabel() {
        return officeNumberOfInspectorsLabel;
    }

    public String getOfficeActionsLabel() {
        return officeActionsLabel;
    }

    public void setOfficeNumberOfInspectorsLabel(String officeNumberOfInspectorsLabel) {
        this.officeNumberOfInspectorsLabel = officeNumberOfInspectorsLabel;
    }

    public String getOfficeCapacityLabel() {
        return officeCapacityLabel;
    }

    public void setOfficeCapacityLabel(String officeCapacityLabel) {
        this.officeCapacityLabel = officeCapacityLabel;
    }


}
