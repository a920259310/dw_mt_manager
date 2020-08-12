package top.putop.mi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.putop.mi.db.dao.DbParamManagerMapper;
import top.putop.mi.db.dao.TaskManagerMapper;
import top.putop.mi.db.dao.TbManagerMapper;
import top.putop.mi.db.model.ColManager;
import top.putop.mi.db.model.DbParamManager;
import top.putop.mi.db.model.Table;
import top.putop.mi.db.model.TaskManager;
import top.putop.mi.service.ITaskManagerService;

import java.util.Date;
import java.util.List;

/**
 * 任务管理器实现类
 *
 * @author lxf
 *
 */
@Service
public class TaskManagerServiceImpl implements ITaskManagerService {

    @Autowired
    private TaskManagerMapper taskManagerMapper;
    @Autowired
    private TbManagerMapper tbManagerMapper;

    @Override
    public int deleteByPrimaryKey(Integer taskId) {
        return taskManagerMapper.deleteByPrimaryKey(taskId);
    }

    @Override
    public int insert(TaskManager taskManager) {
        return taskManagerMapper.insert(taskManager);
    }

    @Override
    public int insertSelective(TaskManager taskManager) {
        return taskManagerMapper.insertSelective(taskManager);
    }

    @Override
    public TaskManager selectByPrimaryKey(Integer taskId) {
        return taskManagerMapper.selectByPrimaryKey(taskId);
    }

    @Override
    public int updateByPrimaryKeySelective(TaskManager taskManager) {
        return taskManagerMapper.updateByPrimaryKeySelective(taskManager);
    }

    @Override
    public int updateByPrimaryKey(TaskManager taskManager) {
        return taskManagerMapper.updateByPrimaryKey(taskManager);
    }


    @Override
    public Boolean genRunCodeByTbId(int tbId) {
        //TODO
        return null;
    }

    @Override
    public Boolean genCreateCodeByTbId(int tbId,String taskName,String taskComment) {

        String sqlContext = "create table if not exists %s.%s ( %s ) comment '%s' stored as %s;";

        Table table = tbManagerMapper.getTableByPrimaryKey(tbId);
        String dbName = table.getDbName();
        String tableName = table.getTbName();
        String tableComment = table.getTbComment();
        String tableFormt = table.getTbComFormat();

        List<ColManager> columns = table.getColumns();
        StringBuffer colStr = new StringBuffer();

        for(int i=0 ; i < columns.size() ; i++){
            String colName = columns.get(i).getColName();
            String colType = columns.get(i).getColType();
            String colComment = columns.get(i).getColComment();
            colStr.append(String.format("%s %s comment '%s',",colName,colType,colComment));
        }

        TaskManager taskManager = new TaskManager();
        taskManager.setTaskType(4);
        taskManager.setScriptType(1);
        taskManager.setTaskName(taskName);
        taskManager.setTaskComment(taskComment);
        taskManager.setTaskContext(String.format(sqlContext,dbName,tableName,colStr.substring(0,colStr.lastIndexOf(",")),tableComment,tableFormt));
        taskManager.setEnableFlag(1);
        taskManager.setTbId(tbId);
        taskManager.setCreateTime(new Date());
        taskManager.setUpdateTime(new Date());

        insert(taskManager);

        return true;
    }

    @Override
    public Boolean genMysqlImportCodeByTbId(int tbId,String taskName,String taskComment) {

        String shellContext = "sqoop import -D mapred.job.queue.name=\"default\" \\\n" +
                "--mapreduce-job-name '%1$s.%2$s' \\\n" +
                "--connect \"jdbc:mysql://%3$s:%4$s/%5$s?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull\" \\\n" +
                "--username \"%6$s\" \\\n" +
                "--password \"%7$s\" \\\n" +
                "--query 'select %8$s from %1$s.%2$s where $CONDITIONS' \\\n" +
                "--num-mappers 1 \\\n" +
                "--hive-import \\\n" +
                "--hive-drop-import-delims \\\n" +
                "--delete-target-dir \\\n" +
                "--target-dir /tmp/%1$s/%2$s \\\n" +
                "--hive-overwrite \\\n" +
                "--hive-database \"ods_stg_%1$s\" \\\n" +
                "--hive-table \"stg_%2$s\"";

        Table table = tbManagerMapper.getTableByPrimaryKey(tbId);

        String dbName = table.getDbName();
        String tableName = table.getTbName();

        List<ColManager> columns = table.getColumns();
        StringBuffer colStr = new StringBuffer();

        for(int i=0 ; i < columns.size() ; i++){
            String colName = columns.get(i).getColName();
            colStr.append(String.format("`%s`,",colName));
        }

        String ip = "";
        String port = "";
        String sourceDbName = "";
        String username = "";
        String password = "";

        List<DbParamManager> params = table.getDbParams();

        for(DbParamManager param : params){
            String paramKey = param.getDbParamName();
            String paramValue = param.getDbParamValue();
            if(paramKey.contains("ip")) ip = paramValue;
            if(paramKey.contains("port")) port = paramValue;
            if(paramKey.contains("dbname")) sourceDbName = paramValue;
            if(paramKey.contains("username")) username = paramValue;
            if(paramKey.contains("password")) password = paramValue;
        }



        TaskManager taskManager = new TaskManager();
        taskManager.setTaskType(1);
        taskManager.setScriptType(2);
        taskManager.setTaskName(taskName);
        taskManager.setTaskComment(taskComment);
        taskManager.setTaskContext(String.format(shellContext,dbName,tableName,ip,port,sourceDbName,username,password,colStr.substring(0,colStr.lastIndexOf(","))));
        taskManager.setEnableFlag(1);
        taskManager.setTbId(tbId);
        taskManager.setCreateTime(new Date());
        taskManager.setUpdateTime(new Date());

        insert(taskManager);

        return true;
    }

    @Override
    public Boolean genOracleImportCodeByTbId(int tbId,String taskName,String taskComment) {

        String shellContext = "sqoop import -D mapred.job.queue.name=\"default\" \\\n" +
                "--mapreduce-job-name '%1$s.%2$s' \\\n" +
                "--connect \"jdbc:oracle:thin:@%3$s:%4$s:%5$s\" \\\n" +
                "--username \"%6$s\" \\\n" +
                "--password \"%7$s\" \\\n" +
                "--query 'select %8$s from %1$s.%2$s where $CONDITIONS' \\\n" +
                "--num-mappers 1 \\\n" +
                "--hive-import \\\n" +
                "--hive-drop-import-delims \\\n" +
                "--delete-target-dir \\\n" +
                "--target-dir /tmp/%1$s/%2$s \\\n" +
                "--hive-overwrite \\\n" +
                "--hive-database \"ods_stg_%1$s\" \\\n" +
                "--hive-table \"stg_%2$s\"";

        Table table = tbManagerMapper.getTableByPrimaryKey(tbId);

        String dbName = table.getDbName();
        String tableName = table.getTbName();

        List<ColManager> columns = table.getColumns();
        StringBuffer colStr = new StringBuffer();

        for(int i=0 ; i < columns.size() ; i++){
            String colName = columns.get(i).getColName();
            colStr.append(String.format("`%s`,",colName));
        }

        String ip = "";
        String port = "";
        String sourceDbName = "";
        String username = "";
        String password = "";

        List<DbParamManager> params = table.getDbParams();

        for(DbParamManager param : params){
            String paramKey = param.getDbParamName();
            String paramValue = param.getDbParamValue();
            if(paramKey.contains("ip")) ip = paramValue;
            if(paramKey.contains("port")) port = paramValue;
            if(paramKey.contains("dbname")) sourceDbName = paramValue;
            if(paramKey.contains("username")) username = paramValue;
            if(paramKey.contains("password")) password = paramValue;
        }

        TaskManager taskManager = new TaskManager();
        taskManager.setTaskType(1);
        taskManager.setScriptType(2);
        taskManager.setTaskName(taskName);
        taskManager.setTaskComment(taskComment);
        taskManager.setTaskContext(String.format(shellContext,dbName,tableName,ip,port,sourceDbName,username,password,colStr.substring(0,colStr.lastIndexOf(","))));
        taskManager.setEnableFlag(1);
        taskManager.setTbId(tbId);
        taskManager.setCreateTime(new Date());
        taskManager.setUpdateTime(new Date());

        insert(taskManager);

        return true;
    }

    @Override
    public Boolean genEsExportCodeByTbId(int tbId) {
        //TODO
        return null;
    }

    @Override
    public Boolean genMysqlExportCodeByTbId(int tbId) {
        //TODO
        return null;
    }
}
