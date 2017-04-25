package com.springboot.thrsky.girl.Controller;

import com.springboot.thrsky.girl.Entity.Girl;
import com.springboot.thrsky.girl.Respository.GirlRepository;
import com.springboot.thrsky.girl.Service.GirlService;
import com.springboot.thrsky.girl.dto.Result;
import com.springboot.thrsky.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by thRShy on 2017/4/24.
 */
@RestController
public class GirlController {


    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 获取女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 插入一个女生
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl , BindingResult bindingResult){
        //验证之后的信息会赋给BindingResult中
        if(bindingResult.hasErrors()){

            return ResultUtil.failed(1,bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        girl.setMoney(girl.getMoney());
        return ResultUtil.success(girlRepository.save(girl));

    }

    /*
     * 搜索一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl getGirl(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }


    /**
     * 更新一个女生
     * @param id
     * @param age
     * @param cupSize
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("age") Integer age,
                           @RequestParam("cupSize") String cupSize){

        Girl girl=new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setId(id);

        return girlRepository.save(girl);
    }
//

    /**
     * 删除一个女生
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    /**
     * 同时插入两个女生
     */
    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public Result<Girl> getAge(@PathVariable("id") Integer id)
            throws Exception{
        return girlService.getAge(id);
    }

}




