package top.putop.mi.db.model;

import java.util.List;

public class Table extends TbManager{

    private String dbName;
    private List<ColManager> columns;
    private List<DbParamManager> dbParams;

    public List<DbParamManager> getDbParams() {
        return dbParams;
    }

    public void setDbParams(List<DbParamManager> dbParams) {
        this.dbParams = dbParams;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public List<ColManager> getColumns() {
        return columns;
    }

    public void setColumns(List<ColManager> columns) {
        this.columns = columns;
    }


    @Override
    public String toString() {
        return "Table{" +
                "dbName='" + dbName + '\'' +
                ", columns=" + columns +
                ", dbParams=" + dbParams +
                '}';
    }
}
