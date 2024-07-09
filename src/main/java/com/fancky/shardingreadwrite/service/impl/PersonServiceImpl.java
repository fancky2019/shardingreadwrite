package com.fancky.shardingreadwrite.service.impl;

import com.fancky.shardingreadwrite.model.entity.*;
import com.fancky.shardingreadwrite.dao.PersonMapper;
import com.fancky.shardingreadwrite.service.PersonService;
import org.apache.shardingsphere.infra.hint.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * (Person)表服务实现类
 *
 * @author fancky
 * @since 2021-07-23 15:38:52
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapper personMapper;

    @Autowired
    DataSource dataSource;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Person queryById(Integer id) {


//        //强制路由主库
//        try (HintManager hintManager = HintManager.getInstance();) {
//            //setMasterRouteOnly 应该改成 setWriteRouteOnly了
//            hintManager.setWriteRouteOnly();
//            Person person = this.personMapper.queryById(1);
//        }

        return this.personMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Person> queryAllByLimit(int offset, int limit) {
        return this.personMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param person 实例对象
     * @return 实例对象
     */
    @Override
    public Person insert(Person person) {
        this.personMapper.insert(person);
        return person;
    }

    /**
     * 修改数据
     *
     * @param person 实例对象
     * @return 实例对象
     */
    @Override
    public Person update(Person person) {
        this.personMapper.update(person);
        return this.queryById(person.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.personMapper.deleteById(id) > 0;
    }


    @Override
    public String getDataSource() throws SQLException {
        Person person = this.personMapper.queryById(1);
        Connection connection = dataSource.getConnection();
        int m=0;

        return "";
    }
}