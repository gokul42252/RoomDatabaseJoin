/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.cretlabs.roomdatabase.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.cretlabs.roomdatabase.dao.ClassStudentDao;
import com.cretlabs.roomdatabase.dao.SchoolDao;
import com.cretlabs.roomdatabase.dao.StudentDao;
import com.cretlabs.roomdatabase.entities.ClassStudent;
import com.cretlabs.roomdatabase.entities.School;
import com.cretlabs.roomdatabase.entities.Student;

@Database(entities = {Student.class, ClassStudent.class, School.class}, version = 1)
public abstract class RoomDatabase extends android.arch.persistence.room.RoomDatabase {

    private static RoomDatabase INSTANCE;

    public abstract StudentDao studentDao();

    public abstract ClassStudentDao classDao();

    public abstract SchoolDao schoolDao();

    public static RoomDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context, RoomDatabase.class,"School_DB")
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}