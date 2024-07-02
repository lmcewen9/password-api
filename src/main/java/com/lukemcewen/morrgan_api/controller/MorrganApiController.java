package com.lukemcewen.morrgan_api.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


@Controller
@ResponseBody
@RequestMapping("/")
public class MorrganApiController implements ErrorController{

    @Autowired
    EntityManager em;

    @GetMapping
    public String random(){
        return "Fuck you!";
    }

    @RequestMapping("/error")
    public String handleError(){
        return "Bad Query...";
    }

    public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c){
        List<T> r = new ArrayList<>(c.size());
        for (Object o: c){
            r.add(clazz.cast(o));
        }
        return r;
    }

    @GetMapping("/tables")    
    public List<Object[]> findAllTables(){
        String sql = "select table_name, column_name \r\n" + //
                        "from information_schema.columns \r\n" + //
                        "where table_name in (\r\n" + //
                        "   select tablename from pg_tables where schemaname = 'public');";
        Query query = em.createNativeQuery(sql);
        return castList(Object[].class, query.getResultList());
    }

    @GetMapping("/{table}")
    public List<Object[]> findTable(@PathVariable String table){
        String sql = String.format("select * from %s;", table);
        Query query = em.createNativeQuery(sql);
        return castList(Object[].class, query.getResultList());
    }

    @GetMapping("/{table}/{field}")
    public List<?> getField(@PathVariable String table, @PathVariable String field){
        String sql = String.format("select %s from %s", field, table);
        Query query = em.createNativeQuery(sql);
        return query.getResultList();
    }

    @GetMapping("/{table}/{field}/{item}")
    public List<Object[]> getItem(@PathVariable String table, @PathVariable String field, @PathVariable String item){
        String sql = String.format("select t from %s t where t.%s like '%s';", table, field, item);
        Query query = em.createNativeQuery(sql);
        return castList(Object[].class, query.getResultList());
    }

    @GetMapping("/{table}/{field}/{int}")
    public List<Object[]> getIntItem(@PathVariable String table, @PathVariable String field, @PathVariable int item){
        String sql = String.format("select t from %s t where t.%s between %d and %d;", table, field, item, item);
        Query query = em.createNativeQuery(sql);
        return castList(Object[].class, query.getResultList());
    }
}
