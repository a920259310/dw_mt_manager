package top.putop.mi.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.putop.mi.db.model.DbManager;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestDbManagerService {

    @Autowired
    private IDbManagerService iDbManagerService;

    @Test
    public void insert() {
        DbManager dbManager = new DbManager();
        dbManager.setDbName("NC数据源");
        dbManager.setDbComment("线上NC的订单数据源");
        dbManager.setDbAccessType(1);
        iDbManagerService.insert(dbManager);
    }

    @Test
    public void insertSelective() {
        DbManager dbManager = new DbManager();
        dbManager.setDbName("NC数据源");
        dbManager.setDbComment("线上NC的订单数据源");
        dbManager.setDbAccessType(1);
        iDbManagerService.insertSelective(dbManager);
    }
}
