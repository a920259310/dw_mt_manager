package top.putop.mi.service;

import top.putop.mi.db.model.ColManager;

import java.util.List;

/**
 * 字段管理器接口
 * @author lxf
 */
public interface IColManagerService extends IBaseService<ColManager> {
    /**
     * 获取指定表的所有字段
     * @param tbId
     * @return
     */
    List<ColManager> selectByTbId(Integer tbId);
}
