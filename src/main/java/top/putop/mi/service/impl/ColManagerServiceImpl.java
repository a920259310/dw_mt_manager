package top.putop.mi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.putop.mi.db.dao.ColManagerMapper;
import top.putop.mi.db.model.ColManager;
import top.putop.mi.service.IColManagerService;

import java.util.List;

/**
 * 字段管理器实现类
 *
 * @author lxf
 *
 */
@Service
public class ColManagerServiceImpl implements IColManagerService {

    @Autowired
    private ColManagerMapper colManagerMapper;

    @Override
    public int deleteByPrimaryKey(Integer colId) {
        return colManagerMapper.deleteByPrimaryKey(colId);
    }

    @Override
    public int insert(ColManager colManager) {
        return colManagerMapper.insert(colManager);
    }

    @Override
    public int insertSelective(ColManager colManager) {
        return colManagerMapper.insertSelective(colManager);
    }

    @Override
    public ColManager selectByPrimaryKey(Integer colId) {
        return colManagerMapper.selectByPrimaryKey(colId);
    }

    @Override
    public int updateByPrimaryKeySelective(ColManager colManager) {
        return colManagerMapper.updateByPrimaryKeySelective(colManager);
    }

    @Override
    public int updateByPrimaryKey(ColManager colManager) {
        return colManagerMapper.updateByPrimaryKey(colManager);
    }

    @Override
    public List<ColManager> selectByTbId(Integer tbId) {
        return colManagerMapper.selectByTbId(tbId);
    }
}
