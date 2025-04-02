package com.example.demo.repository;

import com.example.demo.model.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface TaskRepository extends PagingAndSortingRepository<Task, Long>, CrudRepository<Task, Long> {

    @Modifying
    @Query("UPDATE Task t set t.done = :done WHERE t.id = :id")
    void setStatusDoneOnId(@Param("id") Long id, @Param("done") boolean done);
}
