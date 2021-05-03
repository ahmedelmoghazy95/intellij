package com.sumerge.momra.dataproviderobjects;

import com.sumerge.momra.utilities.CustomAnnotations;

public class SearchOfficesData {

    @CustomAnnotations.ExcelColumn(1)
    String testCaseName;

    @CustomAnnotations.ExcelColumn(2)
    String username;

    @CustomAnnotations.ExcelColumn(3)
    String password;

    @CustomAnnotations.ExcelColumn(4)
    String officeName;

    @CustomAnnotations.ExcelColumn(5)
    String officeNumber;

    @CustomAnnotations.ExcelColumn(6)
    String officeSecretariat;

    @CustomAnnotations.ExcelColumn(7)
    String officeMunicipial;

    @CustomAnnotations.ExcelColumn(8)
    String officeNumberOfInspectorsReadOnly;

    @CustomAnnotations.ExcelColumn(9)
    String officeCapacityReadOnly;


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

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public String getOfficeSecretariat() {
        return officeSecretariat;
    }

    public void setOfficeSecretariat(String officeSecretariat) {
        this.officeSecretariat = officeSecretariat;
    }

    public String getOfficeMunicipial() {
        return officeMunicipial;
    }

    public void setOfficeMunicipial(String officeMunicipial) {
        this.officeMunicipial = officeMunicipial;
    }

    public String getOfficeNumberOfInspectorsReadOnly() {
        return officeNumberOfInspectorsReadOnly;
    }

    public void setOfficeNumberOfInspectorsReadOnly(String officeNumberOfInspectorsReadOnly) {
        this.officeNumberOfInspectorsReadOnly = officeNumberOfInspectorsReadOnly;
    }

    public String getOfficeCapacityReadOnly() {
        return officeCapacityReadOnly;
    }

    public void setOfficeCapacityReadOnly(String officeCapacityReadOnly) {
        this.officeCapacityReadOnly = officeCapacityReadOnly;
    }


}
