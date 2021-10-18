package utils;

public class ExcelTestUtils {

    public static void main(String[] args) {
        String excelpath = "./import from excel/import.xlsx";
        String sheetName = "Sheet1";

        ExcelUtils excel = new ExcelUtils(excelpath,sheetName);

        excel.getCellData(1,0);
        excel.getCellData(1,1);
        excel.getCellData(1,2);
        excel.getCellData(1,3);
    }
}
