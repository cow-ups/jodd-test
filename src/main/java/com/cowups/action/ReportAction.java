package com.cowups.action;

import com.cowups.service.ReportService;
import jodd.madvoc.meta.Action;
import jodd.madvoc.meta.In;
import jodd.madvoc.meta.MadvocAction;
import jodd.madvoc.meta.scope.Request;
import jodd.petite.meta.PetiteInject;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author: Ma_guowei
 * @Date: 2018-09-10
 * @Description:
 **/
@MadvocAction
public class ReportAction {

    @PetiteInject
    private ReportService reportService;
    @In
    private int workbookIndex;// 模版标识（工作簿）
    @In
    private int sheetIndex;// sheet 索引（工作簿可以包含多个sheet工作表，sheet工作表的索引以 0 为开始索引）
    @In
    private String month;
    @In @Request
    HttpServletResponse response;

    @Action(value = "exp")
    public void test() throws IOException {
        OutputStream output = null;
        String excelName = reportService.getWorkBookName(workbookIndex);
        Workbook wb = reportService.generReport(workbookIndex, sheetIndex);
        try {
            output = response.getOutputStream();
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename=" + excelName + ".xlsx");
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            wb.write(output);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }
}
