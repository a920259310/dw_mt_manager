package top.putop.mi.service;

import top.putop.mi.db.model.TaskManager;

/**
 * 任务管理器接口
 * @author lxf
 */
public interface ITaskManagerService extends IBaseService<TaskManager> {

    /**
     * 生成指定表的数据处理脚本类容
     * @param tbId
     * @return
     */
    public Boolean genRunCodeByTbId(int tbId);

    /**
     * 生成指定表的建表脚本类容
     * @param tbId
     * @return
     */
    public Boolean genCreateCodeByTbId(int tbId,String taskName,String taskComment);

    /**
     * 生成指定表的Mysql数据同步脚本类容
     * @param tbId
     * @return
     */
    public Boolean genMysqlImportCodeByTbId(int tbId,String taskName,String taskComment);

    /**
     * 生成指定表的Oracle数据同步脚本类容
     * @param tbId
     * @return
     */
    public Boolean genOracleImportCodeByTbId(int tbId,String taskName,String taskComment);

    /**
     * 生成指定表的Es数据导出脚本类容
     * @param tbId
     * @return
     */
    public Boolean genEsExportCodeByTbId(int tbId);

    /**
     * 生成指定表的Mysql数据导出脚本类容
     * @param tbId
     * @return
     */
    public Boolean genMysqlExportCodeByTbId(int tbId);
}
