package com.springboot.thrsky.girl.Service;

import com.springboot.thrsky.girl.Entity.Girl;
import com.springboot.thrsky.girl.Respository.GirlRepository;
import com.springboot.thrsky.girl.dto.Result;
import com.springboot.thrsky.girl.enums.ResultEnum;
import com.springboot.thrsky.girl.exception.GirlAgeException;
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

    public Result<Girl> getAge(Integer id) throws Exception{
        Girl girl=girlRepository.findOne(id);
        int age=girl.getAge();
        if(age<=10){
            //返回还在上小学  code=100
            throw new GirlAgeException(ResultEnum.SMALL_GIRL);
        }else if(age>10&&age<16)
        {
            //可能在上初中   code=101
            throw new GirlAgeException(ResultEnum.MIDDLE_GIRL);
        }else{
            Result result=new Result();
            result.setCode(ResultEnum.HIGH_GIRL.getCode());
            result.setMsg(ResultEnum.HIGH_GIRL.getMsg());
            result.setData(girl);
            return result;
        }

    }


    /**
     * 返回一个女生信息
     * @param id
     * @return
     */
    public Girl getOne(Integer id){
        return girlRepository.findOne(id);
    }
}
