package top.putop.mi.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.putop.mi.db.dao.TbManagerMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestTbManagerMapper {

    @Autowired
    private TbManagerMapper tbManagerMapper;

    @Test
    public void getTableByPrimaryKey(){
        System.out.println(tbManagerMapper.getTableByPrimaryKey(1));
    }

}
