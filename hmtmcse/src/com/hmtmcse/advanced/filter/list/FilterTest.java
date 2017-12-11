package com.hmtmcse.advanced.filter.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Touhid Mia on 27/12/2015.
 */
public class FilterTest {


    public static void main(String[] args) {
        List<Data> list = new ArrayList<Data>();
        Data data = new Data();
        data.name = "Touhid";
        data.email = "hmtmcse@gmail.com";
        list.add(data);

        data = new Data();
        data.name = "Mia";
        data.email = "mia@gmail.com";
        list.add(data);


        data = new Data();
        data.name = "Vai";
        data.email = "vai@gmail.com";
        list.add(data);




        System.out.println(DataFilter.get(list,"mia"));


    }

}
