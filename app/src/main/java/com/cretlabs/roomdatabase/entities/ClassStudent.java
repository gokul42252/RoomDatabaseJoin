package com.cretlabs.roomdatabase.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Gokul on 2/18/2018.
 */

@Entity
public class ClassStudent {

    @NonNull
    @PrimaryKey
    private long classId;
    private long schoold;
    private String className;
    private String classNumber;
    private String classDivision;

    public ClassStudent(@NonNull long classId, long schoold, String className, String classNumber, String classDivision) {
        this.classId = classId;
        this.schoold = schoold;
        this.className = className;
        this.classNumber = classNumber;
        this.classDivision = classDivision;
    }

    @NonNull
    public long getClassId() {
        return classId;
    }

    public void setClassId(@NonNull long classId) {
        this.classId = classId;
    }

    public long getSchoold() {
        return schoold;
    }

    public void setSchoold(long schoold) {
        this.schoold = schoold;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getClassDivision() {
        return classDivision;
    }

    public void setClassDivision(String classDivision) {
        this.classDivision = classDivision;
    }
}
