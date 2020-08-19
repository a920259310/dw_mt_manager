package top.putop.mi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.putop.mi.db.dao.*;
import top.putop.mi.db.model.*;
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
    @Autowired
    private DwDbManagerMapper dwDbManagerMapper;
    @Autowired
    private ColManagerMapper colManagerMapper;
    @Autowired
    private SrcManagerMapper srcManagerMapper;
    @Autowired
    private SrcParamManagerMapper srcParamManagerMapper;

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

        TbManager tbManager = tbManagerMapper.selectByPrimaryKey(tbId);
        DwDbManager dwDbManager = dwDbManagerMapper.selectByPrimaryKey(tbManager.getDwDbId());

        String dbName = dwDbManager.getDbName();

        String tableName = tbManager.getTbName();
        String tableComment = tbManager.getTbComment();
        String tableFormt = tbManager.getTbComFormat();

        List<ColManager> columns = colManagerMapper.selectByTbId(tbManager.getTbId());

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
    public Boolean genMysqlImportCodeByTbId(int srcId,int tbId,String taskName,String taskComment) {

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

        TbManager tbManager = tbManagerMapper.selectByPrimaryKey(tbId);
        DwDbManager dwDbManager = dwDbManagerMapper.selectByPrimaryKey(tbManager.getDwDbId());

        String dbName = dwDbManager.getDbName();
        String tableName = tbManager.getTbName();

        List<ColManager> columns = colManagerMapper.selectByTbId(tbId);

        StringBuffer colStr = new StringBuffer();

        for(int i=0 ; i < columns.size() ; i++){
            String colName = columns.get(i).getColName();
            colStr.append(String.format("`%s`,",colName));
        }

        String ip = "";
        String port = "";
        String sourceSrcName = "";
        String username = "";
        String password = "";

        List<SrcParamManager> params = srcParamManagerMapper.selectByTbSrcId(srcId);

//        JDBC：[db_type:数据库类型,
//                db_service_name:服务类型,
//                db_pro_ip:数据库IP,
//                db_pro_port:数据库端口,
//                db_name:数据库名称,
//                db_user_name:数据库账号,
//                db_pass:数据库密码]

        for(SrcParamManager param : params){
            String paramKey = param.getSrcParamName();
            String paramValue = param.getSrcParamValue();
            if(paramKey.contains("db_pro_ip")) ip = paramValue;
            if(paramKey.contains("db_pro_port")) port = paramValue;
            if(paramKey.contains("db_name")) sourceSrcName = paramValue;
            if(paramKey.contains("db_user_name")) username = paramValue;
            if(paramKey.contains("db_pass")) password = paramValue;
        }



        TaskManager taskManager = new TaskManager();
        taskManager.setTaskType(1);
        taskManager.setScriptType(2);
        taskManager.setTaskName(taskName);
        taskManager.setTaskComment(taskComment);
        taskManager.setTaskContext(String.format(shellContext,dbName,tableName,ip,port,sourceSrcName,username,password,colStr.substring(0,colStr.lastIndexOf(","))));
        taskManager.setEnableFlag(1);
        taskManager.setTbId(tbId);
        taskManager.setSrcId(srcId);
        taskManager.setCreateTime(new Date());
        taskManager.setUpdateTime(new Date());

        insert(taskManager);

        return true;
    }

    @Override
    public Boolean genOracleImportCodeByTbId(int srcId,int tbId,String taskName,String taskComment) {

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

        TbManager tbManager = tbManagerMapper.selectByPrimaryKey(tbId);
        DwDbManager dwDbManager = dwDbManagerMapper.selectByPrimaryKey(tbManager.getDwDbId());

        String dbName = dwDbManager.getDbName();
        String tableName = tbManager.getTbName();

        List<ColManager> columns = colManagerMapper.selectByTbId(tbId);

        StringBuffer colStr = new StringBuffer();

        for(int i=0 ; i < columns.size() ; i++){
            String colName = columns.get(i).getColName();
            colStr.append(String.format("`%s`,",colName));
        }

        String ip = "";
        String port = "";
        String sourceSrcName = "";
        String username = "";
        String password = "";

        List<SrcParamManager> params = srcParamManagerMapper.selectByTbSrcId(srcId);

        for(SrcParamManager param : params){
            String paramKey = param.getSrcParamName();
            String paramValue = param.getSrcParamValue();
            if(paramKey.contains("db_pro_ip")) ip = paramValue;
            if(paramKey.contains("db_pro_port")) port = paramValue;
            if(paramKey.contains("db_name")) sourceSrcName = paramValue;
            if(paramKey.contains("db_user_name")) username = paramValue;
            if(paramKey.contains("db_pass")) password = paramValue;
        }

        TaskManager taskManager = new TaskManager();
        taskManager.setTaskType(1);
        taskManager.setScriptType(2);
        taskManager.setTaskName(taskName);
        taskManager.setTaskComment(taskComment);
        taskManager.setTaskContext(String.format(shellContext,dbName,tableName,ip,port,sourceSrcName,username,password,colStr.substring(0,colStr.lastIndexOf(","))));
        taskManager.setEnableFlag(1);
        taskManager.setTbId(tbId);
        taskManager.setSrcId(srcId);
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
