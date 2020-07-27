package top.putop.mi.service;

import top.putop.mi.db.model.TaskManager;

/**
 * 任务管理器接口
 * @author lxf
 */
public interface ITaskManagerService extends IBaseService<TaskManager> {

    /**
     * 生成数据处理脚本类容
     * @param tbId
     * @return
     */
    public Boolean genRunCode(int tbId);

    /**
     * 生成建表脚本类容
     * @param tbId
     * @return
     */
    public Boolean genCreateCode(int tbId);

    /**
     * 生成Mysql数据同步脚本类容
     * @param tbId
     * @return
     */
    public Boolean genMysqlImportCode(int tbId);

    /**
     * 生成Oracle数据同步脚本类容
     * @param tbId
     * @return
     */
    public Boolean genOracleImportCode(int tbId);

    /**
     * 生成Es数据导出脚本类容
     * @param tbId
     * @return
     */
    public Boolean genEsExportCode(int tbId);

    /**
     * 生成Mysql数据导出脚本类容
     * @param tbId
     * @return
     */
    public Boolean genMysqlExportCode(int tbId);
}
