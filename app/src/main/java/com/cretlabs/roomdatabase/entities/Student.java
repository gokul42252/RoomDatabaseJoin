package com.cretlabs.roomdatabase.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Gokul on 2/18/2018.
 */
@Entity( tableName = "Student")
public class Student {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private long studentId;
    public Student() {
    }
    private long classId;
    private String studentName;
    private String studentAddress;

    public Student(@NonNull long studentId, long classId, String studentName, String studentAddress) {
        this.studentId = studentId;
        this.classId = classId;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
    }

    @NonNull
    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(@NonNull long studentId) {
        this.studentId = studentId;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }
}
