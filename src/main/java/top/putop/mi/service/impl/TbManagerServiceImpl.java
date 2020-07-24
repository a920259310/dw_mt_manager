package top.putop.mi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.putop.mi.db.dao.TbManagerMapper;
import top.putop.mi.db.model.TbManager;
import top.putop.mi.service.ITbManagerService;

/**
 * 数据源管理器实现类
 *
 * @author lxf
 *
 */
@Service
public class TbManagerServiceImpl implements ITbManagerService {

    @Autowired
    private TbManagerMapper tbManagerMapper;

    @Override
    public int deleteByPrimaryKey(Integer tbId) {
        return tbManagerMapper.deleteByPrimaryKey(tbId);
    }

    @Override
    public int insert(TbManager tbManager) {
        return tbManagerMapper.insert(tbManager);
    }

    @Override
    public int insertSelective(TbManager tbManager) {
        return tbManagerMapper.insertSelective(tbManager);
    }

    @Override
    public TbManager selectByPrimaryKey(Integer tbId) {
        return tbManagerMapper.selectByPrimaryKey(tbId);
    }

    @Override
    public int updateByPrimaryKeySelective(TbManager tbManager) {
        return tbManagerMapper.updateByPrimaryKeySelective(tbManager);
    }

    @Override
    public int updateByPrimaryKey(TbManager tbManager) {
        return tbManagerMapper.updateByPrimaryKey(tbManager);
    }
}
