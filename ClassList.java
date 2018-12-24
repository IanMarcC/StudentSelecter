package com.codebind;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassList {
    private int number;
    private Student[] wholeClass;
    private ArrayList<Student> goodStudents;

    public ClassList(int classNum) throws Exception {
        goodStudents = new ArrayList<Student>();
        number = classNum;
        File file = new File("C:\\Users\\Ian\\IdeaProjects\\ExerciseSelect\\src\\"+number+"classroster.txt");
        Scanner scan = new Scanner(file);
        int count = 0;
        while(scan.hasNextLine()){
            count++;
            scan.nextLine();
        }
        wholeClass = new Student[count];
        Scanner scan2 = new Scanner(file);
        int i = 0;
        while(scan2.hasNextLine()){
            wholeClass[i] = new Student(scan2.nextLine());
            i++;
        }
    }
    public void clearList(){
        goodStudents.clear();
    }
    public Student[] getWholeClass(){
        return wholeClass;
    }

    public ArrayList<Student> getGoodStudents() {
        return goodStudents;
    }
}
