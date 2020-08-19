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
        System.out.println(iTaskManagerService.genMysqlImportCodeByTbId(1,1,"测试创建Mysql同步任务名称","测试创建Mysql同步任务注释"));
    }

    @Test
    public void genOracleImportCodeByTbId(){
        System.out.println(iTaskManagerService.genOracleImportCodeByTbId(1,1,"测试创建Oracle同步任务名称","测试创建Oracle同步任务注释"));
    }
}
