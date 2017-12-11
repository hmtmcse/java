package com.hmtmcse.basic.consoletable;

import com.bethecoder.ascii_table.ASCIITable;
import com.bethecoder.ascii_table.impl.CollectionASCIITableAware;
import com.bethecoder.ascii_table.spec.IASCIITableAware;

import java.util.Arrays;
import java.util.List;

/**
 * Created by touhid on 7/01/2016.
 */
public class Test {


    public static void main(String[] args) throws Exception {
        collectionTests();
    }


    private static void collectionTests() {

        Employee stud = new Employee("Sriram", 2, "Chess", false, 987654321.21d);
        Employee stud2 = new Employee("Sudhakar", 29, "Painting", true, 123456789.12d);
        List<Employee> students = Arrays.asList(stud, stud2);

        IASCIITableAware asciiTableAware =
                new CollectionASCIITableAware<Employee>(students,
                        "name", "age", "married", "hobby", "salary");  //properties to read
        ASCIITable.getInstance().printTable(asciiTableAware);

//
//        asciiTableAware =
//                new CollectionASCIITableAware<Employee>(students,
//                        Arrays.asList("name", "age", "married", "hobby", "salary"), //properties to read
//                        Arrays.asList("STUDENT_NAME", "HIS_AGE")); //custom headers
//        ASCIITable.getInstance().printTable(asciiTableAware);
    }


}
