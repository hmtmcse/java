package com.hmtmcse.advanced.db;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Touhid Mia on 10/12/2015.
 */
public class SchemaCreator extends MySQLConnection {

    private String SELECTED_DB = "";
    private final String SHOW_TABLES = "SELECT TABLE_NAME,ENGINE,TABLE_COLLATION FROM information_schema.TABLES WHERE TABLE_SCHEMA =";
    private final String DECRIBE_TABLE = "DESCRIBE ";
    private final String TABLE_CONSTRAINT = "SELECT TABLE_NAME,COLUMN_NAME,CONSTRAINT_NAME,REFERENCED_TABLE_NAME,REFERENCED_COLUMN_NAME FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE TABLE_SCHEMA = '%s' AND TABLE_NAME = '%s' AND referenced_column_name IS NOT NULL";


    public SchemaCreator(String selectDB) throws SQLException, ClassNotFoundException {
        super(selectDB);
        this.SELECTED_DB = selectDB;
    }

    public String getDatabaseSchema() throws SQLException {
        JSONArray tables = getAllTables();
        JSONArray tablesMeta = getAllTables();

        JSONObject metadata = new JSONObject();
        metadata.put("numberOfTable",tables.size());
        metadata.put("tables",tablesMeta);

        JSONObject fullSchema = new JSONObject();
        fullSchema.put("metadata",metadata);

        JSONArray databaseSchema = new JSONArray();
        for (int i = 0; i < tables.size(); i ++){
            JSONObject jsonObject = (JSONObject) tables.get(i);
            String name = jsonObject.get("TABLE_NAME").toString();
            JSONArray tableInfoArray = getTableDescription(name);
            jsonObject.put("TABLE_INFORMATION",tableInfoArray);
            jsonObject.put("TABLE_COLUMN_SIZE",tableInfoArray.size());
            jsonObject.put("CONSTRAINT",getTableConstraint(name));
            databaseSchema.add(jsonObject);
        }
        fullSchema.put("schema",databaseSchema);
        System.out.println(fullSchema);
        return "";
    }

    public JSONArray getAllTables() throws SQLException {
        ResultSet resultSet = statement.executeQuery(SHOW_TABLES + "'" + SELECTED_DB + "'" );
        JSONObject tableObject;
        JSONArray tableInformation = new JSONArray();
        while (resultSet.next()){
            tableObject = new JSONObject();
            tableObject.put("TABLE_NAME",resultSet.getString("TABLE_NAME"));
            tableObject.put("ENGINE",resultSet.getString("ENGINE"));
            tableObject.put("TABLE_COLLATION",resultSet.getString("TABLE_COLLATION"));
            tableObject.put("TABLE_COLLATION",resultSet.getString("TABLE_COLLATION"));
            tableInformation.add(tableObject);
        }
        return tableInformation;
    }

    public JSONArray getTableDescription(String tableName) throws SQLException {
        ResultSet resultSet = statement.executeQuery(DECRIBE_TABLE + tableName);
        JSONObject fieldObject;
        JSONArray fieldInformation = new JSONArray();
        while (resultSet.next()){
            fieldObject = new JSONObject();
            fieldObject.put("FIELD",resultSet.getString("Field"));
            fieldObject.put("TYPE",resultSet.getString("Type"));
            fieldObject.put("IS_NULL",resultSet.getString("Null"));
            fieldObject.put("KEY",resultSet.getString("Key"));
            fieldObject.put("DEFAULT",resultSet.getString("Default"));
            fieldObject.put("EXTRA",resultSet.getString("Extra"));
            fieldInformation.add(fieldObject);
        }
        return fieldInformation;
    }

    public JSONArray getTableConstraint(String tableName) throws SQLException {
        ResultSet resultSet = statement.executeQuery(String.format(TABLE_CONSTRAINT,SELECTED_DB,tableName));
        JSONObject constraintObject;
        JSONArray constraintList = new JSONArray();
        while (resultSet.next()){
            constraintObject = new JSONObject();
            constraintObject.put("COLUMN_NAME",resultSet.getString("COLUMN_NAME"));
            constraintObject.put("CONSTRAINT_NAME",resultSet.getString("CONSTRAINT_NAME"));
            constraintObject.put("REFERENCED_TABLE_NAME",resultSet.getString("REFERENCED_TABLE_NAME"));
            constraintObject.put("REFERENCED_COLUMN_NAME",resultSet.getString("REFERENCED_COLUMN_NAME"));
            constraintList.add(constraintObject);
        }
        return constraintList;
    }


}
