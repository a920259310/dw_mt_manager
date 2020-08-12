package top.putop.mi.service;

import top.putop.mi.db.model.Table;
import top.putop.mi.db.model.TbManager;

/**
 * 表管理器接口
 * @author lxf
 */
public interface ITbManagerService extends IBaseService<TbManager> {

    public Table getTableByPrimaryKey(Integer tbId);

}
