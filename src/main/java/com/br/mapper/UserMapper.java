package com.br.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.br.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yu.zhang
 * created on 2021/03/08
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
