package com.hmtmcse.elasticsearch.esorm;

/**
 * Created by touhid on 6/09/2016.
 */
public class QueryBuilder {

    public static void list(){
        getModelName();
    }

    public String findById(){
        System.out.println("Oi");
        return "Mia vai";
    }

    public String save(){
        return null;
    }

    public String delete(){
        return null;
    }


    private static String getModelName(){
        String fileName = new Throwable().getStackTrace()[1].getFileName();
        String[] parts = fileName.split("\\.");
        if (parts.length != 2 ){
            return null;
        }
        fileName = parts[0];
        String name = Character.toLowerCase(fileName.charAt(0)) + fileName.substring(1);
        return name;
    }


}
