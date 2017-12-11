package com.hmtmcse.advanced.filter.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Touhid Mia on 27/12/2015.
 */
public final class DataFilter {


    public static List<Data> get(List<Data> list, String text){
        List<Data> secondList = new ArrayList<Data>();
        for( Data d : list) {
            if (d.name.toLowerCase().contains(text.toLowerCase())) {
                secondList.add(d);
            }
        }
        return secondList;
    }



}
