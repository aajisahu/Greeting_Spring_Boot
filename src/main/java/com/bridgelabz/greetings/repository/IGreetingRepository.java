package com.bridgelabz.greetings.repository;

import com.bridgelabz.greetings.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGreetingRepository extends JpaRepository<User,Long> {

}