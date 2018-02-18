package com.cretlabs.roomdatabase.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.cretlabs.roomdatabase.entities.JoinSchoolClassStudentData;
import com.cretlabs.roomdatabase.entities.School;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

/**
 * Created by Gokul on 2/18/2018.
 */

@Dao
public interface SchoolDao {

    @Query("SELECT * FROM School")
    List<School> getAllSchools();

    @Query("SELECT * FROM School WHERE  schoolId= :schoolId")
    School loadSchoolById(int schoolId);

    @Query("SELECT * FROM School where schoolName = :schoolName ")
    List<School> findSchoolByName(String schoolName);

    @Insert(onConflict = IGNORE)
    void insertSchool(School school);

    @Insert(onConflict = IGNORE)
    void insertMultipleRecord(List<School> schools);
    @Delete
    void deleteSchool(School school);

    @Query("SELECT School.schoolName,ClassStudent.className," +
            "COUNT(Student.studentId) as studentcount," +
            "'[' || GROUP_CONCAT(DISTINCT('{\"id\":'||'\"'||Student.studentId || '\"'|| ', \" name \":'|| '\"'||Student.studentName|| '\"'||'}'))||']' studentDetails " +
            "FROM School " +
            "LEFT JOIN ClassStudent ON ClassStudent.schoold=School.schoolId\n" +
            "LEFT JOIN Student ON ClassStudent.classId=Student.classId\n" +
            "GROUP BY School.schoolId")
    List<JoinSchoolClassStudentData> getSchoolCLassDataWithStudents();


}
