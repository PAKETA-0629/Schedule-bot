package org.springbootschedulebot.repository;

import org.springbootschedulebot.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TableRepository extends JpaRepository<Table, Long> {

    List<Table> findAll();
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO custom_schedule (table_name, names, keys, \"user\") VALUES(:name, '{serhay, semen}', '{room1, room2}', :user)", nativeQuery = true)
    void create(@Param("name") String name, @Param("user")Long user);
    //@Param("names")List<String> names, @Param("keys")List<String> keys
}
