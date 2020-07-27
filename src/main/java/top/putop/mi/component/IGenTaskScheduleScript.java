package top.putop.mi.component;

/**
 * 任务调度脚本生成接口信息类
 */
public interface IGenTaskScheduleScript {


    /**
     * 导出指定任务脚本
     * @param taskId
     * @return
     */
    public Boolean exportScriptByTaskId(int taskId);

    /**
     * 导出所有任务脚本
     * @param taskId
     * @return
     */
    public Boolean exportScriptAll(int taskId);

    /**
     * 导出部分任务脚本
     * @param taskId
     * @return
     */
    public Boolean exportScriptByArr(int[] taskId);

}
