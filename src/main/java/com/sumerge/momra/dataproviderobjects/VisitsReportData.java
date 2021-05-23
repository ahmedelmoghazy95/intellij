package com.sumerge.momra.dataproviderobjects;

import com.sumerge.momra.utilities.CustomAnnotations;

public class VisitsReportData {



    @CustomAnnotations.ExcelColumn(1)
    String visitNumber;

    @CustomAnnotations.ExcelColumn(2)
    String visitOfficeName;

    @CustomAnnotations.ExcelColumn(3)
    String visitOfficePhone;

    @CustomAnnotations.ExcelColumn(4)
    String visitLicenseOwnerName;

    @CustomAnnotations.ExcelColumn(5)
    String visitLicensePhone;

    @CustomAnnotations.ExcelColumn(6)
    String visitActivity;

    @CustomAnnotations.ExcelColumn(7)
    String visitAddress;

    @CustomAnnotations.ExcelColumn(8)
    String visitAssignDate;

    @CustomAnnotations.ExcelColumn(9)
    String visitDate;

    @CustomAnnotations.ExcelColumn(10)
    String visitStatus;


    public String getVisitNumber() {
        return visitNumber;
    }

    public void setVisitNumber (String visitNumber) {
        this.visitNumber = visitNumber;
    }

    public String getVisitOfficeName() {
        return visitOfficeName;
    }

    public void setVisitOfficeName (String visitOfficeName) {
        this.visitOfficeName = visitOfficeName;
    }

    public String getVisitOfficePhone() {
        return visitOfficePhone;
    }

    public void setVisitOfficePhone(String visitOfficePhone) {
        this.visitOfficePhone = visitOfficePhone;
    }

    public String getVisitLicenseOwnerName() {
        return visitLicenseOwnerName;
    }

    public void setVisitLicenseOwnerName (String visitLicenseOwnerName) {
        this.visitLicenseOwnerName = visitLicenseOwnerName;
    }

    public String getVisitLicensePhone() {
        return visitLicensePhone;
    }

    public void setVisitLicensePhone(String visitLicensePhone) {
        this.visitLicensePhone = visitLicensePhone;
    }

    public String getVisitActivity() {
        return visitActivity;
    }

    public void setVisitActivity(String visitActivity) {
        this.visitActivity = visitActivity;
    }

    public String getVisitAddress() {
        return visitAddress;
    }

    public void setVisitAddress(String visitAddress) {
        this.visitAddress = visitAddress;
    }

    public String getVisitAssignDate() {
        return visitAssignDate;
    }

    public void setVisitAssignDate(String visitAssignDate) {
        this.visitAssignDate = visitAssignDate;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate (String visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(String visitStatus) {
        this.visitStatus = visitStatus;
    }


}
