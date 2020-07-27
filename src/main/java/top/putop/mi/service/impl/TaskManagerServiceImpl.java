package top.putop.mi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.putop.mi.db.dao.TaskManagerMapper;
import top.putop.mi.db.model.TaskManager;
import top.putop.mi.service.ITaskManagerService;

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
    public Boolean genRunCode(int tbId) {
        //TODO
        return null;
    }

    @Override
    public Boolean genCreateCode(int tbId) {
        //TODO
        return null;
    }

    @Override
    public Boolean genMysqlImportCode(int tbId) {
        //TODO
        return null;
    }

    @Override
    public Boolean genOracleImportCode(int tbId) {
        //TODO
        return null;
    }

    @Override
    public Boolean genEsExportCode(int tbId) {
        //TODO
        return null;
    }

    @Override
    public Boolean genMysqlExportCode(int tbId) {
        //TODO
        return null;
    }
}
