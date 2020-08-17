package top.putop.mi.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.putop.mi.db.model.SrcManager;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestSrcManagerService {

    @Autowired
    private ISrcManagerService iSrcManagerService;

    @Test
    public void insert() {
        SrcManager dbManager = new SrcManager();
        dbManager.setSrcName("NC数据源");
        dbManager.setSrcComment("线上NC的订单数据源");
        dbManager.setSrcAccessType(1);
        iSrcManagerService.insert(dbManager);
    }

    @Test
    public void insertSelective() {
        SrcManager dbManager = new SrcManager();
        dbManager.setSrcName("NC数据源");
        dbManager.setSrcComment("线上NC的订单数据源");
        dbManager.setSrcAccessType(1);
        iSrcManagerService.insertSelective(dbManager);
    }
}
