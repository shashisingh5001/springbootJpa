package com.jpaexample.springbootJpa.controller;

import com.jpaexample.springbootJpa.model.Users;
import com.jpaexample.springbootJpa.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @GetMapping(value="/all")
     public List<Users> findAll(){

        return userJpaRepository.findAll();
     }

     @GetMapping(value="/{name}")
    public Users findByName(@PathVariable final String name){
         return userJpaRepository.findByName(name);
    }

     @PostMapping(value="/load")
     public  Users load(@RequestBody final Users users){
         userJpaRepository.save(users);
         return userJpaRepository.findByName(users.getName());
     }
     @DeleteMapping("/delete/{id}")
     public void delete(@PathVariable("id") long id){
           Users users=userJpaRepository.getOne(id);
           if(id==users.getId()) {
               userJpaRepository.delete(users);
           }
           else {
               System.out.println("Record is Not Available "+id);
           }
     }
}
