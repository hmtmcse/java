package com.hmtmcse.basic.consoletable;


import com.bethecoder.ascii_table.ASCIITable;
import com.bethecoder.ascii_table.ASCIITableHeader;
import com.bethecoder.ascii_table.impl.CollectionASCIITableAware;
import com.bethecoder.ascii_table.spec.IASCIITableAware;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Touhid Mia on 06/01/2016.
 */
public class ConsoleStringTable {

    public static void main(String[] args) {
        ASCIITableHeader[] headerObjs = {
                new ASCIITableHeader("User Name", ASCIITable.ALIGN_LEFT),
                new ASCIITableHeader("Salary"),
                new ASCIITableHeader("Designation", ASCIITable.ALIGN_CENTER),
                new ASCIITableHeader("Address", ASCIITable.ALIGN_LEFT),
                new ASCIITableHeader("Lucky#", ASCIITable.ALIGN_RIGHT),
        };

        String[][] data = {
                { "Ram", "2000", "Manager", "#99, Silk board sdadfkj asdlfkjalskdf laksdfklasdjf", "1111"  },
                { "Sri", "12000", "Developer", "BTM Layout", "22222" },
                { "Prasad", "42000", "Lead", "#66, Viaya Bank Layout", "333333" },
                { "Anu", "132000", "QA", "#22, Vizag", "4444444" },
                { "Sai", "62000", "Developer", "#3-3, Kakinada"  },
                { "Venkat", "2000", "Manager"   },
                { "Raj", "62000"},
                { "BTC"},
        };



        System.out.println(ASCIITable.getInstance().getTable(headerObjs, data));

        Employee stud = new Employee("Sriram", 2, "Chess", false, 987654321.21d);
        Employee stud2 = new Employee("Sudhakar", 29, "Painting", true, 123456789.12d);
        List<Employee> students = Arrays.asList(stud, stud2);

        IASCIITableAware asciiTableAware =
                new CollectionASCIITableAware<Employee>(students,
                        "name", "age", "married", "hobby", "salary");  //properties to read
        ASCIITable.getInstance().printTable(asciiTableAware);

        BuildReportData buildReportData = new BuildReportData(1,"Touhid","touhid.zip","YES","10");
        BuildReport.reportData.add(buildReportData);
        BuildReport.generate();




//        BuildReportData buildReportData1 = new BuildReportData(2,"Touhid1");
//        List<BuildReportData> report = Arrays.asList(buildReportData);
//        IASCIITableAware reportTableAware = new CollectionASCIITableAware<BuildReportData>(report,"sl","name","filename","isChange","buildTime");
//        ASCIITable.getInstance().printTable(reportTableAware);

//        System.out.println(ASCIITable.getInstance().getTable(reportTableAware));


//        BuildReportData buildReportData = new BuildReportData("test1");
//        BuildReportData buildReportData1 = new BuildReportData("test2");
//
//        List<BuildReportData> students = Arrays.asList(buildReportData, buildReportData1);;
//
//
//        IASCIITableAware asciiTableAware =
//                new CollectionASCIITableAware<BuildReportData>(students,
//                        "binaryName");  //properties to read
//        ASCIITable.getInstance().printTable(asciiTableAware);



    }

}
