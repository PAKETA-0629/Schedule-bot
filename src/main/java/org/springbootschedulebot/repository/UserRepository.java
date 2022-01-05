package org.springbootschedulebot.repository;

import org.springbootschedulebot.model.User;
import org.springbootschedulebot.util.States;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users(user_name) VALUES (:name)", nativeQuery = true)
    void create(@Param("name") String name);

    @Query(value = "SELECT * FROM users WHERE user_name=:name", nativeQuery = true)
    User findByName(@Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users SET state=:state, stage=:stage WHERE id=:userid", nativeQuery = true)
    void updateState(@Param("userid") Long userid, @Param("state") String state, @Param("stage") Long stage);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users SET stage=:stage WHERE id=:userid", nativeQuery = true)
    void updateStage(@Param("userid") Long userid, @Param("stage") Long stage);
}
