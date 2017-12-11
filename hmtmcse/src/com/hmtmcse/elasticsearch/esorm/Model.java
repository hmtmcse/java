package com.hmtmcse.elasticsearch.esorm;


public class Model extends QueryBuilder{


    public static void main(String[] args) {
      Model.list();
      String test = new Model().findById();
    }



}
