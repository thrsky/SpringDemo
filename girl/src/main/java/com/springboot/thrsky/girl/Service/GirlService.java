package com.springboot.thrsky.girl.Service;

import com.springboot.thrsky.girl.Entity.Girl;
import com.springboot.thrsky.girl.Respository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by thRShy on 2017/4/24.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA=new Girl();
        Girl girlB=new Girl();
        girlA.setAge(23);
        girlA.setCupSize("C");

        girlRepository.save(girlA);
        girlB.setAge(18);
        girlB.setCupSize("FF");

        girlRepository.save(girlB);

    }
}
