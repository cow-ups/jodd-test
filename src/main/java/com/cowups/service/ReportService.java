package com.cowups.service;

import jodd.petite.meta.PetiteBean;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @Author: Ma_guowei
 * @Date: 2018-09-10
 * @Description:
 **/
@PetiteBean
public class ReportService {
    /**
     * 生成report
     *
     * @param workbookIndex
     * @param sheetIndex
     * @return
     */
    public Workbook generReport(int workbookIndex, int sheetIndex) {
        String workbookPath = getWorkbookPath(workbookIndex);
        Workbook wb = getWorkbook(workbookPath);
        buildReportData(workbookIndex, wb, sheetIndex);
        return wb;
    }

    // TODO 生成表格具体的数据
    private void buildReportData(int workbookIndex, Workbook wb, int sheetIndex) {
        Sheet sheet = wb.getSheetAt(sheetIndex);
        // TODO 回填单元格的数值
        if (workbookIndex == 0) {
            // TODO 获取所需要的数据
            // 补充Excel数据
            sheet.createRow(0).createCell(0).setCellValue("test-jodd" + workbookIndex);
            sheet.createRow(1).createCell(0).setCellValue("test-jodd_v5" + workbookIndex);
            sheet.createRow(2).createCell(0).setCellValue("test-jodd-poi" + workbookIndex);
        } else if (workbookIndex == 1) {
            // TODO 获取所需要的数据
            // 补充Excel数据
            sheet.createRow(0).createCell(0).setCellValue("test-jodd" + workbookIndex);
            sheet.createRow(1).createCell(0).setCellValue("test-jodd_v5" + workbookIndex);
            sheet.createRow(2).createCell(0).setCellValue("test-jodd-poi" + workbookIndex);
        }
    }

    /**
     * 获取工作簿的路径(这里是相对路径)
     *
     * @param workbookIndex
     * @return
     */
    private String getWorkbookPath(int workbookIndex) {
        return "templates/t" + workbookIndex + ".xlsx";
    }

    /**
     * 根据路径获取工作簿
     *
     * @param workbookPath
     * @return
     */
    public Workbook getWorkbook(String workbookPath) {
        Workbook wb = null;
        try {
            wb = new XSSFWorkbook(this.getClass().getClassLoader().getResourceAsStream(workbookPath));
        } catch (Exception e) {
        }
        return wb;
    }

    // TODO 自定义工作簿名称
    public String getWorkBookName(int workbookIndex) {
        String fileName = "test-jodd";
        return fileName;
    }
}
