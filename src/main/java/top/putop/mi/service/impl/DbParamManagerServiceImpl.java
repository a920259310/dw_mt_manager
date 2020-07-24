package top.putop.mi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.putop.mi.db.dao.DbParamManagerMapper;
import top.putop.mi.db.model.DbParamManager;
import top.putop.mi.service.IDbParamManagerService;

/**
 * 数据源参数管理器实现类
 *
 * @author lxf
 *
 */
@Service
public class DbParamManagerServiceImpl implements IDbParamManagerService {

    @Autowired
    private DbParamManagerMapper paramManagerMapper;

    @Override
    public int deleteByPrimaryKey(Integer paramId) {
        return paramManagerMapper.deleteByPrimaryKey(paramId);
    }

    @Override
    public int insert(DbParamManager paramManager) {
        return paramManagerMapper.insert(paramManager);
    }

    @Override
    public int insertSelective(DbParamManager paramManager) {
        return paramManagerMapper.insertSelective(paramManager);
    }

    @Override
    public DbParamManager selectByPrimaryKey(Integer paramId) {
        return paramManagerMapper.selectByPrimaryKey(paramId);
    }

    @Override
    public int updateByPrimaryKeySelective(DbParamManager paramManager) {
        return paramManagerMapper.updateByPrimaryKeySelective(paramManager);
    }

    @Override
    public int updateByPrimaryKey(DbParamManager paramManager) {
        return paramManagerMapper.updateByPrimaryKey(paramManager);
    }
}
