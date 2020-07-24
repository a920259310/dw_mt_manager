package top.putop.mi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.putop.mi.db.dao.DbManagerMapper;
import top.putop.mi.db.model.DbManager;
import top.putop.mi.service.IDbManagerService;

/**
 * 数据源管理器实现类
 *
 * @author lxf
 *
 */
@Service
public class DbManagerServiceImpl implements IDbManagerService {

    @Autowired
    private DbManagerMapper dbManagerMapper;

    @Override
    public int deleteByPrimaryKey(Integer dbId) {
        return dbManagerMapper.deleteByPrimaryKey(dbId);
    }

    @Override
    public int insert(DbManager dbManager) {
        return dbManagerMapper.insert(dbManager);
    }

    @Override
    public int insertSelective(DbManager dbManager) {
        return dbManagerMapper.insertSelective(dbManager);
    }

    @Override
    public DbManager selectByPrimaryKey(Integer dbId) {
        return dbManagerMapper.selectByPrimaryKey(dbId);
    }

    @Override
    public int updateByPrimaryKeySelective(DbManager dbManager) {
        return dbManagerMapper.updateByPrimaryKeySelective(dbManager);
    }

    @Override
    public int updateByPrimaryKey(DbManager dbManager) {
        return dbManagerMapper.updateByPrimaryKey(dbManager);
    }
}
