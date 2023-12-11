package com.example.springtrainingdemo.repo;

import com.example.springtrainingdemo.model.Student;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Profile("redis")
@Repository
public class RedisRepository {

    private HashOperations hashOperations;
    private RedisTemplate<Integer,Student> redisTemplate;

    public RedisRepository(RedisTemplate<Integer,Student> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
        this.redisTemplate = redisTemplate;
    }

    public void saveStudent(Student student) {
        this.hashOperations.put("Student", student.getId(), student);
    }

    public List<Student> findAll() {
        return this.hashOperations.values("Student");
    }
}
