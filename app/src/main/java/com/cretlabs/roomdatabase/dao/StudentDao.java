package com.cretlabs.roomdatabase.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.cretlabs.roomdatabase.entities.Student;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

/**
 * Created by Gokul on 2/18/2018.
 */
@Dao
public interface StudentDao {

    @Query("SELECT * FROM Student")
    List<Student> getAllStudents();

    @Query("SELECT * FROM Student WHERE  studentId= :studentId")
    Student loadStudentById(long studentId);

    @Query("SELECT * FROM Student where studentName = :studentName ")
    List<Student> findStudentByName(String studentName);

    @Insert(onConflict = IGNORE)
    void insertStudent(Student student);

    @Insert(onConflict = IGNORE)
    void insertMultipleRecord(List<Student> students);

    @Delete
    void deleteStudent(Student student);
}
