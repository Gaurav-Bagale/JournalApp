package com.gaurav.JournalApp.repository;

import com.gaurav.JournalApp.entities.JournalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends JpaRepository<JournalEntity,Long>{

}