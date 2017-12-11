package com.hmtmcse.basic.consoletable;

import com.bethecoder.ascii_table.ASCIITable;
import com.bethecoder.ascii_table.ASCIITableHeader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Touhid Mia on 06/01/2016.
 */
public class BuildReport {


    public static List<BuildReportData> reportData = new ArrayList<BuildReportData>();

    public static void generate() {
        ASCIITableHeader[] reportObject = {
                new ASCIITableHeader("SL", ASCIITable.ALIGN_LEFT),
                new ASCIITableHeader("Name"),
                new ASCIITableHeader("File Name", ASCIITable.ALIGN_CENTER),
                new ASCIITableHeader("Is Changed", ASCIITable.ALIGN_LEFT),
                new ASCIITableHeader("Build Time", ASCIITable.ALIGN_CENTER),
        };
        String[][] data = new String[reportData.size()][5];
        for (int i = 0; i < reportData.size(); i++) {
            BuildReportData buildReportData = reportData.get(i);
            data[i][0] = (i + 1) + "";
            data[i][1] = buildReportData.getName();
            data[i][2] = buildReportData.getFilename();
            data[i][3] = buildReportData.getIschange();
            data[i][4] = buildReportData.getBuildtime();
        }
        ASCIITable.getInstance().printTable(reportObject, data);

    }


}
