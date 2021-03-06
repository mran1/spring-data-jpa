package com.example.springdatajpa.dao;

import com.example.springdatajpa.dto.OrderReport;
import com.example.springdatajpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {

    public List<User> findByProfession(String name);
    public int countByAge(int age);
    public List<User> deleteByName(String name);
    public List<User> findByProfessionAndAge(String profession, int age);
    public List<User> findByNameIgnoreCase(String name);

    @Query("select u from User u")
    public List<User> getUsersCustomQuery();

    @Query(value = "select new com.example.springdatajpa.dto.OrderReport(u.name,p.name) from User u join u.products p on u.name=:name", nativeQuery = true)
    public List<OrderReport> getAllOrderReports(@Param("name") String name);
}
