package com.br;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.br.bean.User;
import com.br.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    void testSelectList() {
        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    void testSelectPage() {
        Page<User> page = new Page<>();
        page.setPages(1);
        page.setMaxLimit(2L);
        IPage<User> selectPage = userMapper.selectPage(page, null);
        System.out.println(selectPage);
    }

    @Test
    void testInsert() {
        User user = new User();
        user.setName("zhangsan1");
        user.setAge(3);
        user.setEmail("zhangsan1@qq.com");
        int result = userMapper.insert(user);
        System.out.println(result);
        System.out.println(user);
    }

    @Test
    void testUpdate() {
        User user = new User();
        user.setId(1L);
        user.setName("zhangsan2");
        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    @Test
    void testDelete() {
        userMapper.deleteById(1369119094360223745L);
    }
}
