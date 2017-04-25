package com.springboot.thrsky.girl.Service;

import com.springboot.thrsky.girl.Entity.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by thRShy on 2017/4/25.
 */

@RunWith(SpringRunner.class)//将启动我们整个Spring工程
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void getOneTest() throws Exception {
        Girl girl=girlService.getOne(11);
        Assert.assertEquals(new Integer (13),girl.getAge());
    }

}