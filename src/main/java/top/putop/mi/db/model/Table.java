package top.putop.mi.db.model;

import java.util.List;

public class Table extends TbManager{

    private String dbName;
    private List<ColManager> columns;
    private List<SrcParamManager> dbParams;

    public List<SrcParamManager> getSrcParams() {
        return dbParams;
    }

    public void setSrcParams(List<SrcParamManager> dbParams) {
        this.dbParams = dbParams;
    }

    public String getSrcName() {
        return dbName;
    }

    public void setSrcName(String dbName) {
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
