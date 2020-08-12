package top.putop.mi.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestTaskManagerService {

    @Autowired
    private ITaskManagerService iTaskManagerService;

    @Test
    public void genCreateCodeByTbId(){
        System.out.println(iTaskManagerService.genCreateCodeByTbId(1,"创建第一个表","测试创建表"));
    }

    @Test
    public void genMysqlImportCodeByTbId(){
        iTaskManagerService.genMysqlImportCodeByTbId(1,"同步mysql表的shell脚本","测试");
    }

}
