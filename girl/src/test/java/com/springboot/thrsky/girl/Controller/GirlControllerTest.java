package com.springboot.thrsky.girl.Controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by thRShy on 2017/4/25.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc   //敲重点
public class GirlControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getGirl() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/girls/11"))
                .andExpect(MockMvcResultMatchers.status().isOk());
          //如果你想要把返回的结果和预想的进行对比 ，可以在后面加上下面这个语句
//        .andExpect(MockMvcResultMatchers.content().string("abc"));
    }

}