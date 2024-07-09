package com.fancky.shardingreadwrite.controller;


import com.fancky.shardingreadwrite.model.entity.Person;
import com.fancky.shardingreadwrite.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;


    @PostMapping(value = "/addPerson")
    public String addPerson(@RequestBody Person person) throws Exception {
        personService.insert(person);
        return "";
    }


    /**
     * 通过mysql  查看执行的log.返发现
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/query/{id}")
    public String query(@PathVariable Integer id) throws Exception {
        personService.queryById(id);
        return "";
    }

    /**
     * 通过mysql  查看执行的log.返发现
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/getDataSource")
    public String getDataSource() throws Exception {
        personService.getDataSource();
        return "";
    }

}
