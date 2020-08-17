package top.putop.mi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.putop.mi.db.dao.SrcManagerMapper;
import top.putop.mi.db.model.SrcManager;
import top.putop.mi.service.ISrcManagerService;

/**
 * 数据源管理器实现类
 *
 * @author lxf
 *
 */
@Service
public class SrcManagerServiceImpl implements ISrcManagerService {

    @Autowired
    private SrcManagerMapper dbManagerMapper;

    @Override
    public int deleteByPrimaryKey(Integer dbId) {
        return dbManagerMapper.deleteByPrimaryKey(dbId);
    }

    @Override
    public int insert(SrcManager dbManager) {
        return dbManagerMapper.insert(dbManager);
    }

    @Override
    public int insertSelective(SrcManager dbManager) {
        return dbManagerMapper.insertSelective(dbManager);
    }

    @Override
    public SrcManager selectByPrimaryKey(Integer dbId) {
        return dbManagerMapper.selectByPrimaryKey(dbId);
    }

    @Override
    public int updateByPrimaryKeySelective(SrcManager dbManager) {
        return dbManagerMapper.updateByPrimaryKeySelective(dbManager);
    }

    @Override
    public int updateByPrimaryKey(SrcManager dbManager) {
        return dbManagerMapper.updateByPrimaryKey(dbManager);
    }
}
