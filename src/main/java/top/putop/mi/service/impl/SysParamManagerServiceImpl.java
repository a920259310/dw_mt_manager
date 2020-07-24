package top.putop.mi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.putop.mi.db.dao.SysParamManagerMapper;
import top.putop.mi.db.model.SysParamManager;
import top.putop.mi.service.ISysParamManagerService;

/**
 * 系统参数管理器实现类
 *
 * @author lxf
 *
 */
@Service
public class SysParamManagerServiceImpl implements ISysParamManagerService {

    @Autowired
    private SysParamManagerMapper paramManagerMapper;

    @Override
    public int deleteByPrimaryKey(Integer paramId) {
        return paramManagerMapper.deleteByPrimaryKey(paramId);
    }

    @Override
    public int insert(SysParamManager paramManager) {
        return paramManagerMapper.insert(paramManager);
    }

    @Override
    public int insertSelective(SysParamManager paramManager) {
        return paramManagerMapper.insertSelective(paramManager);
    }

    @Override
    public SysParamManager selectByPrimaryKey(Integer paramId) {
        return paramManagerMapper.selectByPrimaryKey(paramId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysParamManager paramManager) {
        return paramManagerMapper.updateByPrimaryKeySelective(paramManager);
    }

    @Override
    public int updateByPrimaryKey(SysParamManager paramManager) {
        return paramManagerMapper.updateByPrimaryKey(paramManager);
    }
}
