
package com.cretlabs.roomdatabase.database;

import android.os.AsyncTask;

import com.cretlabs.roomdatabase.entities.ClassStudent;
import com.cretlabs.roomdatabase.entities.School;
import com.cretlabs.roomdatabase.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class DataInitializer {

    public static void AddSampleDataAsync(final RoomDatabase db) {
        PopulateSampleDbAsync task = new PopulateSampleDbAsync(db);
        task.execute();
    }
    private static void populateSampleData(RoomDatabase db) {
        List<School> schoolList = new ArrayList<>();
        schoolList.add(new School(1, "School 1", "School Address 1", "1111111111"));
        schoolList.add(new School(2, "School 2", "School Address 2", "2222222222"));
        schoolList.add(new School(3, "School 3", "School Address 3", "3333333333"));
        schoolList.add(new School(4, "School 4", "School Address 4", "4444444444"));
        schoolList.add(new School(5, "School 5", "School Address 5", "5555555555"));
        db.schoolDao().insertMultipleRecord(schoolList);
        List<ClassStudent> classStudentList = new ArrayList<>();
        classStudentList.add(new ClassStudent(10, 1, "ClassStudent 1", "ClassStudent Address 1", "6666666666"));
        classStudentList.add(new ClassStudent(11, 2, "ClassStudent 2", "ClassStudent Address 2", "7777777777"));
        classStudentList.add(new ClassStudent(12, 3, "ClassStudent 3", "ClassStudent Address 3", "8888888888"));
        classStudentList.add(new ClassStudent(13, 4, "ClassStudent 4", "ClassStudent Address 4", "9999999999"));
        classStudentList.add(new ClassStudent(14, 5, "ClassStudent 5", "ClassStudent Address 5", "10101010110"));
        db.classDao().insertMultipleRecord(classStudentList);

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(21, 10, "Student 1", "Student Address 1"));
        studentList.add(new Student(22, 10, "Student 2", "Student Address 2"));
        studentList.add(new Student(23, 10, "Student 3", "Student Address 3"));

        studentList.add(new Student(24, 11, "Student 4", "Student Address 4"));
        studentList.add(new Student(25, 11, "Student 5", "Student Address 5"));
        studentList.add(new Student(26, 11, "Student 6", "Student Address 6"));

        studentList.add(new Student(27, 12, "Student 7", "Student Address 7"));
        studentList.add(new Student(28, 12, "Student 8", "Student Address 8"));
        studentList.add(new Student(29, 12, "Student 9", "Student Address 9"));

        studentList.add(new Student(30, 13, "Student 10", "Student Address 10"));
        studentList.add(new Student(31, 13, "Student 11", "Student Address 11"));
        studentList.add(new Student(32, 13, "Student 12", "Student Address 12"));

        studentList.add(new Student(30, 14, "Student 13", "Student Address 13"));
        studentList.add(new Student(31, 14, "Student 14", "Student Address 14"));
        studentList.add(new Student(32, 14, "Student 15", "Student Address 15"));

        studentList.add(new Student(30, 15, "Student 16", "Student Address 16"));
        studentList.add(new Student(31, 15, "Student 17", "Student Address 17"));
        studentList.add(new Student(32, 15, "Student 18", "Student Address 18"));
        db.studentDao().insertMultipleRecord(studentList);
    }

    private static class PopulateSampleDbAsync extends AsyncTask<Void, Void, Void> {

        private final RoomDatabase mDb;

        PopulateSampleDbAsync(RoomDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateSampleData(mDb);
            return null;
        }
    }
}
