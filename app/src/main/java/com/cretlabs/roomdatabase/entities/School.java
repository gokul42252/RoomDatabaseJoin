package com.cretlabs.roomdatabase.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Gokul on 2/18/2018.
 */
@Entity
public class School {

    @NonNull
    @PrimaryKey
    private long schoolId;
    public School() {
    }
    private String schoolName;
    private String schoolAddress;
    private String schoolPhoneNumber;

    public School(@NonNull long schoolId, String schoolName, String schoolAddress, String schoolPhoneNumber) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.schoolAddress = schoolAddress;
        this.schoolPhoneNumber = schoolPhoneNumber;
    }

    @NonNull
    public long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(@NonNull long schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public String getSchoolPhoneNumber() {
        return schoolPhoneNumber;
    }

    public void setSchoolPhoneNumber(String schoolPhoneNumber) {
        this.schoolPhoneNumber = schoolPhoneNumber;
    }
}
