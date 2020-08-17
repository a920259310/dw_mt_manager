package top.putop.mi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.putop.mi.db.dao.SrcParamManagerMapper;
import top.putop.mi.db.model.SrcParamManager;
import top.putop.mi.service.ISrcParamManagerService;

/**
 * 数据源参数管理器实现类
 *
 * @author lxf
 *
 */
@Service
public class SrcParamManagerServiceImpl implements ISrcParamManagerService {

    @Autowired
    private SrcParamManagerMapper paramManagerMapper;

    @Override
    public int deleteByPrimaryKey(Integer paramId) {
        return paramManagerMapper.deleteByPrimaryKey(paramId);
    }

    @Override
    public int insert(SrcParamManager paramManager) {
        return paramManagerMapper.insert(paramManager);
    }

    @Override
    public int insertSelective(SrcParamManager paramManager) {
        return paramManagerMapper.insertSelective(paramManager);
    }

    @Override
    public SrcParamManager selectByPrimaryKey(Integer paramId) {
        return paramManagerMapper.selectByPrimaryKey(paramId);
    }

    @Override
    public int updateByPrimaryKeySelective(SrcParamManager paramManager) {
        return paramManagerMapper.updateByPrimaryKeySelective(paramManager);
    }

    @Override
    public int updateByPrimaryKey(SrcParamManager paramManager) {
        return paramManagerMapper.updateByPrimaryKey(paramManager);
    }
}
