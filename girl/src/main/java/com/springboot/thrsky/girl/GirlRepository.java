package com.springboot.thrsky.girl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by thRShy on 2017/4/24.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    //通过年龄来查询
    //注意方法名一定要是下面的格式  不然找不到
    public List<Girl> findByAge(Integer age);
}

