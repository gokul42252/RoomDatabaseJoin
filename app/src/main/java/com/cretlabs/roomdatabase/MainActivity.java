package com.cretlabs.roomdatabase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;

import com.cretlabs.roomdatabase.database.DataInitializer;
import com.cretlabs.roomdatabase.database.RoomDatabase;
import com.cretlabs.roomdatabase.entities.ClassStudent;
import com.cretlabs.roomdatabase.entities.JoinSchoolClassStudentData;
import com.cretlabs.roomdatabase.entities.School;
import com.cretlabs.roomdatabase.entities.Student;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private AppCompatTextView mDataappCompatTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RoomDatabase roomDatabase = RoomDatabase.getDatabase(MainActivity.this);
        //inserting sample data
        DataInitializer.AddSampleDataAsync(roomDatabase);
        mDataappCompatTextView = findViewById(R.id.AM_data);
//        showClassData(roomDatabase.classDao().getAllClass());
//
//        showStudentData(roomDatabase.studentDao().getAllStudents());
//        showSchoolData(roomDatabase.schoolDao().getAllSchools());
        /**
         * Method to get data from multiple tables using join query*/
        List<JoinSchoolClassStudentData> joinSchoolClassStudentData = roomDatabase.schoolDao().getSchoolCLassDataWithStudents();
        showJoinData(joinSchoolClassStudentData);

    }

    public void showJoinData(List<JoinSchoolClassStudentData> joinSchoolClassStudentData) {
        StringBuilder sb = new StringBuilder();
        for (JoinSchoolClassStudentData joinSchoolClassStudentData1 : joinSchoolClassStudentData) {
            sb.append(String.format(Locale.US,
                    "School name :  %s, Class name : %s,\n\n Student list : %s \n\n", joinSchoolClassStudentData1.getSchoolName(), joinSchoolClassStudentData1.getClassName(), joinSchoolClassStudentData1.getStudentDetails()));
        }
        mDataappCompatTextView.setText(String.format("\n \n%s%s", sb.toString(), mDataappCompatTextView.getText()));
    }

    public void showClassData(List<ClassStudent> classStudentList) {
        StringBuilder sb = new StringBuilder();
        for (ClassStudent classStudent : classStudentList) {
            sb.append(String.format(Locale.US,
                    " %s : %s : %s \n", classStudent.getClassId(), classStudent.getClassName(), classStudent.getClassDivision()));
        }
        mDataappCompatTextView.setText(String.format("\n \n%s%s", sb.toString(), mDataappCompatTextView.getText()));
    }

    public void showStudentData(List<Student> studentList) {
        StringBuilder sb = new StringBuilder();
        for (Student student : studentList) {
            sb.append(String.format(Locale.US,
                    "%s : %s : %s \n", student.getStudentId(), student.getStudentName(), student.getStudentAddress()));
        }
        mDataappCompatTextView.setText(String.format("\n\n%s%s", sb.toString(), mDataappCompatTextView.getText()));
    }


    public void showSchoolData(List<School> schoolList) {
        StringBuilder sb = new StringBuilder();
        for (School school : schoolList) {
            sb.append(String.format(Locale.US,
                    "%s : %s : %s \n", school.getSchoolId(), school.getSchoolName(), school.getSchoolAddress()));
        }
        mDataappCompatTextView.setText(String.format("\n\n%s%s", sb.toString(), mDataappCompatTextView.getText()));
    }
}
