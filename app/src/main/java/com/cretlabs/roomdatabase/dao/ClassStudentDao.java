package com.cretlabs.roomdatabase.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.cretlabs.roomdatabase.entities.ClassStudent;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

/**
 * Created by Gokul on 2/18/2018.
 */
@Dao
public interface ClassStudentDao {

    @Query("SELECT * FROM ClassStudent")
    List<ClassStudent> getAllClass();

    @Query("SELECT * FROM ClassStudent WHERE  classId= :classId")
    ClassStudent loadClassById(int classId);

    @Query("SELECT * FROM ClassStudent where className = :className ")
    List<ClassStudent> findClassByName(String className);

    @Insert(onConflict = IGNORE)
    void insertClass(ClassStudent classes);

    @Insert(onConflict = IGNORE)
    void insertMultipleRecord(List<ClassStudent> classStudentList);

    @Delete
    void deleteClass(ClassStudent aClassStudent);
}
