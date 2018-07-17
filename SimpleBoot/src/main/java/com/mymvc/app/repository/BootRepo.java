package com.mymvc.app.repository;

import com.mymvc.app.model.BootUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BootRepo extends JpaRepository<BootUser,Long>{

    @Query("SELECT userName FROM BootUser WHERE userName =:userName")
    public String findUserByName(@Param("userName") String userName);
}
