package com.qing.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.qing.consumer.StudentService;
import com.qing.provider.entity.Student;

import java.util.function.Consumer;
import java.util.function.Predicate;

@Service(version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class StudentServiceImpl implements StudentService {

    @Override
    public String foo(String firstName, String lastName) {
        Student student1 = new Student(firstName, lastName, 9.5);
        student1 = updateStudentFee(student1,
                //Lambda expression for Predicate interface
                student -> student.grade > 8.5,
                //Lambda expression for Consumer inerface
                student -> student.feeDiscount = 30.0);
        student1.printFee();

        Student student2 = new Student(firstName, lastName, 8.0);
        student2 = updateStudentFee(student2,
                student -> student.grade >= 8,
                student -> student.feeDiscount = 20.0);
        student2.printFee();
        return student1.toString();
    }

    private static Student updateStudentFee(Student student, Predicate<Student> predicate, Consumer<Student> consumer){
        //Use the predicate to decide when to update the discount.
        if ( predicate.test(student)){
            //Use the consumer to update the discount value.
            consumer.accept(student);
        }
        return student;
    }

}


