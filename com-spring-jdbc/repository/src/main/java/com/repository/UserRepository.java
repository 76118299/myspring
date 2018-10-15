package com.repository;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.Collections;

@Repository
public class UserRepository {
    private DataSource dataSource ;
    private DataSource masterDataSource;
    private JdbcTemplate jdbcTemplate;

    public UserRepository(DataSource dataSource, @Qualifier("masterDataSource") DataSource masterDataSource, @Qualifier("savleDataSource") DataSource savleDataSource) {
        this.dataSource = dataSource;
        this.masterDataSource = masterDataSource;
        this.savleDataSource = savleDataSource;
    }

    private DataSource savleDataSource;
    @Autowired
    public UserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Transactional
    public boolean save(User user){

        return  true;
    }

    public Collection<User> getUsers(){
        return Collections.emptyList();
    }
}
