package com.assign2.assign2.controllers;

// import java.util.ArrayList;

import com.assign2.assign2.models.StudentsRepository;
import com.assign2.assign2.models.students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.http.ResponseEntity;
import java.util.Map;
// import com.assign2.assign2.models.StudentsRepository;

@Controller
public class studentsController {
    @Autowired
    private StudentsRepository studentsRepo;
    @GetMapping("students/view")
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

    // @PostMapping("/students/editStudents")
    // public String editStudent(@RequestParam Map<String, String> newstudent, HttpServletResponse response){
    //     System.out.println("EDIT student");
    //     String newName = newstudent.get("name");
    //     Integer newHeight = Integer.parseInt(newstudent.get("height"));
    //     Integer newWeight= Integer.parseInt(newstudent.get("weight"));
    //     Double newGpa= Double.parseDouble(newstudent.get("gpa"));
    //     String newHair = newstudent.get("hair");
        
    //     students toUpdate = studentsRepo.findByPid(Integer.parseInt(newstudent.get("pid")));
    //     toUpdate.setName(newName);
    //     toUpdate.setHeight(newHeight);
    //     toUpdate.setWeight(newWeight);
    //     toUpdate.setGpa(newGpa);
    //     toUpdate.setHair(newHair);
    //     studentsRepo.save(toUpdate);

    //     return "students/editedStudent";
        
    // }
    
    // @DeleteMapping("/students/{id}")
    // public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
    //     try {
    //         // Check if the student exists
    //         if (!studentsRepo.existsById(id)) {
    //             return ResponseEntity.notFound().build();
    //         }

    //         // Delete the student
    //         System.out.println("DELETE student");
    //         studentsRepo.deleteById(id);
    //         return ResponseEntity.ok().build();
    //     } catch (Exception e) {
    //         return ResponseEntity.badRequest().body("Error deleting student: " + e.getMessage());
    //     }
    // }

    
     
   
}

