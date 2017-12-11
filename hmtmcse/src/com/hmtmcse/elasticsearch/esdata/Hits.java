package com.hmtmcse.elasticsearch.esdata;

/**
 * Created by touhid on 5/02/2017.
 */
public class Hits {


    public Long total;

    private String _index;
    private String _type;
    private String _id;
    private String _source;
;


    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
}
