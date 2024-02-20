package com.assign2.assign2.controllers;

// import java.util.ArrayList;

import com.assign2.assign2.models.StudentsRepository;
import com.assign2.assign2.models.students;

import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
// import com.assign2.assign2.models.StudentsRepository;

@Controller
public class studentsController {
    @Autowired
    private StudentsRepository studentsRepo;
    @GetMapping("/students/view")
    public String getallStudents(Model model){
        System.out.println("Getting all students");
        //get all students from database
        List<students> students = studentsRepo.findAll();
        // end of databse call
        model.addAttribute("st", students);
        return "students/showAll";
    }

    @PostMapping("/students/addStudents")
    public String addStudent(@RequestParam Map<String, String> newstudent, HttpServletResponse response)
    {
        System.out.println("ADD student");
        String newName = newstudent.get("name");
        Integer newHeight = Integer.parseInt(newstudent.get("height"));
        Integer newWeight= Integer.parseInt(newstudent.get("weight"));
        Double newGpa= Double.parseDouble(newstudent.get("gpa"));
        String newHair = newstudent.get("hair");
        studentsRepo.save(new students(newName, newHair, newHeight, newWeight, newGpa));
        response.setStatus(201);
        return "students/addedStudent";

    }
}
