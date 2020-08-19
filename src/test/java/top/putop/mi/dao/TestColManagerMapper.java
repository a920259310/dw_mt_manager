package top.putop.mi.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.putop.mi.db.dao.ColManagerMapper;
import top.putop.mi.db.dao.TbManagerMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestColManagerMapper {

    @Autowired
    private ColManagerMapper colManagerMapper;

    @Test
    public void selectByTbId(){
        System.out.println(colManagerMapper.selectByTbId(1));
    }

    @Test
    public void selectByPrimaryKey(){
        System.out.println(colManagerMapper.selectByPrimaryKey(2));
    }

}
