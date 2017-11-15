package com.app.crud.Repository;

import com.app.crud.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class StudentRepository {

    private MongoOperations mongoOperation;
    
    @Autowired
    StudentRepository(MongoTemplate mongoTemplate){
        this.mongoOperation = mongoTemplate;
    }

//    @PostConstruct
//    public void bootstrap(){
//        this.save(new Student(1, "Peter", "BomberCloth", "Computer Science", "Male"));
//        this.save(new Student(2, "Alex", "Hughs", "Engineering", "Male"));
//        this.save(new Student(3, "Gleb", "Moskovski", "Gender Studies", "Male"));
//        this.save(new Student(4, "Tori","Orange", "Economics", "Female"));
//    }

    public List<Student> get(int skip, int limit) {
        Query query = new Query().with(new Sort(Sort.Direction.ASC, "_id")).skip(skip).limit(limit);
        return mongoOperation.find(query, Student.class);
    }

    public Student get(int id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoOperation.findOne(query, Student.class);
    }

    public void save(Student student) {
        mongoOperation.save(student);
    }

    public void remove(Student student) {
        mongoOperation.remove(student);
    }

}
