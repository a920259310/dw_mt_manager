package top.putop.mi.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestTbManagerService {

    @Autowired
    private ITbManagerService iTbManagerService;

    @Test
    public void getTableByPrimaryKey(){
        System.out.println(iTbManagerService.getTableByPrimaryKey(1));
    }

}
