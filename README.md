# RoomDatabaseJoin
<h1>JOIN queries Room persistence library</h1>
This tutorial showing how JOIN queries Room persistence library. The basic Room database structure tutorial is <a href="http://thoughtnerds.com/android-room-persistence-library-database-tutorial/">here check now </a>

Here we can learn advanced join queries tutorial. it includes join multiple tables and get details using simple SQL queries. <span>One of the biggest issues beginning SQL writers have is being able to write queries that use more than one table, that is to use database joins. In Room, we can use normal SQL queries.</span>

<img src="http://thoughtnerds.com/wp-content/uploads/2018/02/783722_5d10_2-300x112.jpg" alt="joins" width="820" height="306" class="alignnone wp-image-585" />

We are using the three Entities in This database and Corresponding @Dao's
<ol>
 	<li>School</li>
 	<li>Student</li>
 	<li>ClassStudent</li>
</ol>
<h5 style="text-align: center;"><strong> School</strong></h5>
<pre><span>package </span>com.cretlabs.roomdatabase.entities<span>;
</span><span>
</span><span>import </span>android.arch.persistence.room.<span>Entity</span><span>;
</span><span>import </span>android.arch.persistence.room.<span>PrimaryKey</span><span>;
</span><span>import </span>android.support.annotation.<span>NonNull</span><span>;
</span><span>
</span><span>/**
</span><span> * Created by Gokul on 2/18/2018.
</span><span> */
</span><span>@Entity
</span><span>public class </span>School {

    <span>@NonNull
</span><span>    @PrimaryKey
</span><span>    </span><span>private long </span><span>schoolId</span><span>;
</span><span>    public </span><span>School</span>() {
    }
    <span>private </span>String <span>schoolName</span><span>;
</span><span>    private </span>String <span>schoolAddress</span><span>;
</span><span>    private </span>String <span>schoolPhoneNumber</span><span>;
</span><span>
</span><span>    public </span><span>School</span>(<span>@NonNull </span><span>long </span>schoolId<span>, </span>String schoolName<span>, </span>String schoolAddress<span>, </span>String schoolPhoneNumber) {
        <span>this</span>.<span>schoolId </span>= schoolId<span>;
</span><span>        this</span>.<span>schoolName </span>= schoolName<span>;
</span><span>        this</span>.<span>schoolAddress </span>= schoolAddress<span>;
</span><span>        this</span>.<span>schoolPhoneNumber </span>= schoolPhoneNumber<span>;
</span><span>    </span>}

    <span>@NonNull
</span><span>    </span><span>public long </span><span>getSchoolId</span>() {
        <span>return </span><span>schoolId</span><span>;
</span><span>    </span>}

    <span>public void </span><span>setSchoolId</span>(<span>@NonNull </span><span>long </span>schoolId) {
        <span>this</span>.<span>schoolId </span>= schoolId<span>;
</span><span>    </span>}

    <span>public </span>String <span>getSchoolName</span>() {
        <span>return </span><span>schoolName</span><span>;
</span><span>    </span>}

    <span>public void </span><span>setSchoolName</span>(String schoolName) {
        <span>this</span>.<span>schoolName </span>= schoolName<span>;
</span><span>    </span>}

    <span>public </span>String <span>getSchoolAddress</span>() {
        <span>return </span><span>schoolAddress</span><span>;
</span><span>    </span>}

    <span>public void </span><span>setSchoolAddress</span>(String schoolAddress) {
        <span>this</span>.<span>schoolAddress </span>= schoolAddress<span>;
</span><span>    </span>}

    <span>public </span>String <span>getSchoolPhoneNumber</span>() {
        <span>return </span><span>schoolPhoneNumber</span><span>;
</span><span>    </span>}

    <span>public void </span><span>setSchoolPhoneNumber</span>(String schoolPhoneNumber) {
        <span>this</span>.<span>schoolPhoneNumber </span>= schoolPhoneNumber<span>;
</span><span>    </span>}
}

</pre>
<h5 style="text-align: center;"><strong>Student</strong></h5>
<pre><span>package </span>com.cretlabs.roomdatabase.entities<span>;
</span><span>
</span><span>import </span>android.arch.persistence.room.<span>Entity</span><span>;
</span><span>import </span>android.arch.persistence.room.<span>PrimaryKey</span><span>;
</span><span>import </span>android.support.annotation.<span>NonNull</span><span>;
</span><span>
</span><span>/**
</span><span> * Created by Gokul on 2/18/2018.
</span><span> */
</span><span>@Entity</span>( <span>tableName </span>= <span>"Student"</span>)
<span>public class </span>Student {
    <span>@NonNull
</span><span>    @PrimaryKey</span>(<span>autoGenerate </span>= <span>true</span>)
    <span>private long </span><span>studentId</span><span>;
</span><span>    public </span><span>Student</span>() {
    }
    <span>private long </span><span>classId</span><span>;
</span><span>    private </span>String <span>studentName</span><span>;
</span><span>    private </span>String <span>studentAddress</span><span>;
</span><span>
</span><span>    public </span><span>Student</span>(<span>@NonNull </span><span>long </span>studentId<span>, long </span>classId<span>, </span>String studentName<span>, </span>String studentAddress) {
        <span>this</span>.<span>studentId </span>= studentId<span>;
</span><span>        this</span>.<span>classId </span>= classId<span>;
</span><span>        this</span>.<span>studentName </span>= studentName<span>;
</span><span>        this</span>.<span>studentAddress </span>= studentAddress<span>;
</span><span>    </span>}

    <span>@NonNull
</span><span>    </span><span>public long </span><span>getStudentId</span>() {
        <span>return </span><span>studentId</span><span>;
</span><span>    </span>}

    <span>public void </span><span>setStudentId</span>(<span>@NonNull </span><span>long </span>studentId) {
        <span>this</span>.<span>studentId </span>= studentId<span>;
</span><span>    </span>}

    <span>public long </span><span>getClassId</span>() {
        <span>return </span><span>classId</span><span>;
</span><span>    </span>}

    <span>public void </span><span>setClassId</span>(<span>long </span>classId) {
        <span>this</span>.<span>classId </span>= classId<span>;
</span><span>    </span>}

    <span>public </span>String <span>getStudentName</span>() {
        <span>return </span><span>studentName</span><span>;
</span><span>    </span>}

    <span>public void </span><span>setStudentName</span>(String studentName) {
        <span>this</span>.<span>studentName </span>= studentName<span>;
</span><span>    </span>}

    <span>public </span>String <span>getStudentAddress</span>() {
        <span>return </span><span>studentAddress</span><span>;
</span><span>    </span>}

    <span>public void </span><span>setStudentAddress</span>(String studentAddress) {
        <span>this</span>.<span>studentAddress </span>= studentAddress<span>;
</span><span>    </span>}
}</pre>
<h5 style="text-align: center;"><strong>ClassStudent</strong></h5>
<pre><span>package </span>com.cretlabs.roomdatabase.entities<span>;
</span><span>
</span><span>import </span>android.arch.persistence.room.<span>Entity</span><span>;
</span><span>import </span>android.arch.persistence.room.<span>PrimaryKey</span><span>;
</span><span>import </span>android.support.annotation.<span>NonNull</span><span>;
</span><span>
</span><span>/**
</span><span> * Created by Gokul on 2/18/2018.
</span><span> */
</span><span>
</span><span>@Entity
</span><span>public class </span>ClassStudent {

    <span>@NonNull
</span><span>    @PrimaryKey
</span><span>    </span><span>private long </span><span>classId</span><span>;
</span><span>    private long </span><span>schoold</span><span>;
</span><span>    private </span>String <span>className</span><span>;
</span><span>    private </span>String <span>classNumber</span><span>;
</span><span>    private </span>String <span>classDivision</span><span>;
</span><span>
</span><span>    public </span><span>ClassStudent</span>(<span>@NonNull </span><span>long </span>classId<span>, long </span>schoold<span>, </span>String className<span>, </span>String classNumber<span>, </span>String classDivision) {
        <span>this</span>.<span>classId </span>= classId<span>;
</span><span>        this</span>.<span>schoold </span>= schoold<span>;
</span><span>        this</span>.<span>className </span>= className<span>;
</span><span>        this</span>.<span>classNumber </span>= classNumber<span>;
</span><span>        this</span>.<span>classDivision </span>= classDivision<span>;
</span><span>    </span>}

    <span>@NonNull
</span><span>    </span><span>public long </span><span>getClassId</span>() {
        <span>return </span><span>classId</span><span>;
</span><span>    </span>}

    <span>public void </span><span>setClassId</span>(<span>@NonNull </span><span>long </span>classId) {
        <span>this</span>.<span>classId </span>= classId<span>;
</span><span>    </span>}

    <span>public long </span><span>getSchoold</span>() {
        <span>return </span><span>schoold</span><span>;
</span><span>    </span>}

    <span>public void </span><span>setSchoold</span>(<span>long </span>schoold) {
        <span>this</span>.<span>schoold </span>= schoold<span>;
</span><span>    </span>}

    <span>public </span>String <span>getClassName</span>() {
        <span>return </span><span>className</span><span>;
</span><span>    </span>}

    <span>public void </span><span>setClassName</span>(String className) {
        <span>this</span>.<span>className </span>= className<span>;
</span><span>    </span>}

    <span>public </span>String <span>getClassNumber</span>() {
        <span>return </span><span>classNumber</span><span>;
</span><span>    </span>}

    <span>public void </span><span>setClassNumber</span>(String classNumber) {
        <span>this</span>.<span>classNumber </span>= classNumber<span>;
</span><span>    </span>}

    <span>public </span>String <span>getClassDivision</span>() {
        <span>return </span><span>classDivision</span><span>;
</span><span>    </span>}

    <span>public void </span><span>setClassDivision</span>(String classDivision) {
        <span>this</span>.<span>classDivision </span>= classDivision<span>;
</span><span>    </span>}
}</pre>
We have inserted sample data to db like this
<pre><span>private static void </span><span>populateSampleData</span>(RoomDatabase db) {
    List&lt;School&gt; schoolList = <span>new </span>ArrayList&lt;&gt;()<span>;
</span><span>    </span>schoolList.add(<span>new </span>School(<span>1</span><span>, </span><span>"School 1"</span><span>, </span><span>"School Address 1"</span><span>, </span><span>"1111111111"</span>))<span>;
</span><span>    </span>schoolList.add(<span>new </span>School(<span>2</span><span>, </span><span>"School 2"</span><span>, </span><span>"School Address 2"</span><span>, </span><span>"2222222222"</span>))<span>;
</span><span>    </span>schoolList.add(<span>new </span>School(<span>3</span><span>, </span><span>"School 3"</span><span>, </span><span>"School Address 3"</span><span>, </span><span>"3333333333"</span>))<span>;
</span><span>    </span>schoolList.add(<span>new </span>School(<span>4</span><span>, </span><span>"School 4"</span><span>, </span><span>"School Address 4"</span><span>, </span><span>"4444444444"</span>))<span>;
</span><span>    </span>schoolList.add(<span>new </span>School(<span>5</span><span>, </span><span>"School 5"</span><span>, </span><span>"School Address 5"</span><span>, </span><span>"5555555555"</span>))<span>;
</span><span>    </span>db.schoolDao().insertMultipleRecord(schoolList)<span>;
</span><span>    </span>List&lt;ClassStudent&gt; classStudentList = <span>new </span>ArrayList&lt;&gt;()<span>;
</span><span>    </span>classStudentList.add(<span>new </span>ClassStudent(<span>10</span><span>, </span><span>1</span><span>, </span><span>"ClassStudent 1"</span><span>, </span><span>"ClassStudent Address 1"</span><span>, </span><span>"6666666666"</span>))<span>;
</span><span>    </span>classStudentList.add(<span>new </span>ClassStudent(<span>11</span><span>, </span><span>2</span><span>, </span><span>"ClassStudent 2"</span><span>, </span><span>"ClassStudent Address 2"</span><span>, </span><span>"7777777777"</span>))<span>;
</span><span>    </span>classStudentList.add(<span>new </span>ClassStudent(<span>12</span><span>, </span><span>3</span><span>, </span><span>"ClassStudent 3"</span><span>, </span><span>"ClassStudent Address 3"</span><span>, </span><span>"8888888888"</span>))<span>;
</span><span>    </span>classStudentList.add(<span>new </span>ClassStudent(<span>13</span><span>, </span><span>4</span><span>, </span><span>"ClassStudent 4"</span><span>, </span><span>"ClassStudent Address 4"</span><span>, </span><span>"9999999999"</span>))<span>;
</span><span>    </span>classStudentList.add(<span>new </span>ClassStudent(<span>14</span><span>, </span><span>5</span><span>, </span><span>"ClassStudent 5"</span><span>, </span><span>"ClassStudent Address 5"</span><span>, </span><span>"10101010110"</span>))<span>;
</span><span>    </span>db.classDao().insertMultipleRecord(classStudentList)<span>;
</span><span>
</span><span>    </span>List&lt;<span>Student</span>&gt; studentList = <span>new </span>ArrayList&lt;&gt;()<span>;
</span><span>    </span>studentList.add(<span>new </span><span>Student</span>(<span>21</span><span>, </span><span>10</span><span>, </span><span>"Student 1"</span><span>, </span><span>"Student Address 1"</span>))<span>;
</span><span>    </span>studentList.add(<span>new </span><span>Student</span>(<span>22</span><span>, </span><span>10</span><span>, </span><span>"Student 2"</span><span>, </span><span>"Student Address 2"</span>))<span>;
</span><span>    </span>studentList.add(<span>new </span><span>Student</span>(<span>23</span><span>, </span><span>10</span><span>, </span><span>"Student 3"</span><span>, </span><span>"Student Address 3"</span>))<span>;
</span><span>
</span><span>    </span>studentList.add(<span>new </span><span>Student</span>(<span>24</span><span>, </span><span>11</span><span>, </span><span>"Student 4"</span><span>, </span><span>"Student Address 4"</span>))<span>;
</span><span>    </span>studentList.add(<span>new </span><span>Student</span>(<span>25</span><span>, </span><span>11</span><span>, </span><span>"Student 5"</span><span>, </span><span>"Student Address 5"</span>))<span>;
</span><span>    </span>studentList.add(<span>new </span><span>Student</span>(<span>26</span><span>, </span><span>11</span><span>, </span><span>"Student 6"</span><span>, </span><span>"Student Address 6"</span>))<span>;
</span><span>
</span><span>    </span>studentList.add(<span>new </span><span>Student</span>(<span>27</span><span>, </span><span>12</span><span>, </span><span>"Student 7"</span><span>, </span><span>"Student Address 7"</span>))<span>;
</span><span>    </span>studentList.add(<span>new </span><span>Student</span>(<span>28</span><span>, </span><span>12</span><span>, </span><span>"Student 8"</span><span>, </span><span>"Student Address 8"</span>))<span>;
</span><span>    </span>studentList.add(<span>new </span><span>Student</span>(<span>29</span><span>, </span><span>12</span><span>, </span><span>"Student 9"</span><span>, </span><span>"Student Address 9"</span>))<span>;
</span><span>
</span><span>    </span>studentList.add(<span>new </span><span>Student</span>(<span>30</span><span>, </span><span>13</span><span>, </span><span>"Student 10"</span><span>, </span><span>"Student Address 10"</span>))<span>;
</span><span>    </span>studentList.add(<span>new </span><span>Student</span>(<span>31</span><span>, </span><span>13</span><span>, </span><span>"Student 11"</span><span>, </span><span>"Student Address 11"</span>))<span>;
</span><span>    </span>studentList.add(<span>new </span><span>Student</span>(<span>32</span><span>, </span><span>13</span><span>, </span><span>"Student 12"</span><span>, </span><span>"Student Address 12"</span>))<span>;
</span><span>
</span><span>    </span>studentList.add(<span>new </span><span>Student</span>(<span>30</span><span>, </span><span>14</span><span>, </span><span>"Student 13"</span><span>, </span><span>"Student Address 13"</span>))<span>;
</span><span>    </span>studentList.add(<span>new </span><span>Student</span>(<span>31</span><span>, </span><span>14</span><span>, </span><span>"Student 14"</span><span>, </span><span>"Student Address 14"</span>))<span>;
</span><span>    </span>studentList.add(<span>new </span><span>Student</span>(<span>32</span><span>, </span><span>14</span><span>, </span><span>"Student 15"</span><span>, </span><span>"Student Address 15"</span>))<span>;
</span><span>
</span><span>    </span>studentList.add(<span>new </span><span>Student</span>(<span>30</span><span>, </span><span>15</span><span>, </span><span>"Student 16"</span><span>, </span><span>"Student Address 16"</span>))<span>;
</span><span>    </span>studentList.add(<span>new </span><span>Student</span>(<span>31</span><span>, </span><span>15</span><span>, </span><span>"Student 17"</span><span>, </span><span>"Student Address 17"</span>))<span>;
</span><span>    </span>studentList.add(<span>new </span><span>Student</span>(<span>32</span><span>, </span><span>15</span><span>, </span><span>"Student 18"</span><span>, </span><span>"Student Address 18"</span>))<span>;
</span><span>    </span>db.studentDao().insertMultipleRecord(studentList)<span>;
</span>}</pre>
Suppose we have to Display all School name, all class names and display all students in that class. How we can query on this database.

We need
<ul>
 	<li>All School name</li>
 	<li>All Class name</li>
 	<li>All Students in each class in each school</li>
</ul>
Thus we can use JOIN queries

First, we need to create a class to hold this much of data from the database as follows.
<pre><span>package </span>com.cretlabs.roomdatabase.entities<span>;
</span><span>
</span><span>/**
</span><span> * Created by Gokul on 2/18/2018.
</span><span> */
</span><span>
</span><span>public class </span>JoinSchoolClassStudentData {
    <span>private </span>String <span>schoolName</span><span>;
</span><span>    private </span>String <span>className</span><span>;
</span><span>    private </span>String <span>studentDetails</span><span>;
</span><span>
</span><span>    public </span>String <span>getSchoolName</span>() {
        <span>return </span><span>schoolName</span><span>;
</span><span>    </span>}

    <span>public void </span><span>setSchoolName</span>(String schoolName) {
        <span>this</span>.<span>schoolName </span>= schoolName<span>;
</span><span>    </span>}

    <span>public </span>String <span>getClassName</span>() {
        <span>return </span><span>className</span><span>;
</span><span>    </span>}

    <span>public void </span><span>setClassName</span>(String className) {
        <span>this</span>.<span>className </span>= className<span>;
</span><span>    </span>}

    <span>public </span>String <span>getStudentDetails</span>() {
        <span>return </span><span>studentDetails</span><span>;
</span><span>    </span>}

    <span>public void </span><span>setStudentDetails</span>(String studentDetails) {
        <span>this</span>.<span>studentDetails </span>= studentDetails<span>;
</span><span>    </span>}
}</pre>
Need to add one more interface in SchoolDao and its returns A list if type JoinSchoolClassStudentData
<pre><span>package </span>com.cretlabs.roomdatabase.dao<span>;
</span><span>
</span><span>import </span>android.arch.persistence.room.<span>Dao</span><span>;
</span><span>import </span>android.arch.persistence.room.<span>Delete</span><span>;
</span><span>import </span>android.arch.persistence.room.<span>Insert</span><span>;
</span><span>import </span>android.arch.persistence.room.<span>Query</span><span>;
</span><span>
</span><span>import </span>com.cretlabs.roomdatabase.entities.JoinSchoolClassStudentData<span>;
</span><span>import </span>com.cretlabs.roomdatabase.entities.School<span>;
</span><span>
</span><span>import </span>java.util.List<span>;
</span><span>
</span><span>import static </span>android.arch.persistence.room.<span>OnConflictStrategy</span>.<span>IGNORE</span><span>;
</span><span>
</span><span>/**
</span><span> * Created by Gokul on 2/18/2018.
</span><span> */
</span><span>
</span><span>@Dao
</span><span>public interface </span>SchoolDao {

    <span>@Query</span>(<span>"SELECT * FROM School"</span>)
    List&lt;School&gt; <span>getAllSchools</span>()<span>;
</span><span>
</span><span>    </span><span>@Query</span>(<span>"SELECT * FROM School WHERE  schoolId= :schoolId"</span>)
    School <span>loadSchoolById</span>(<span>int </span>schoolId)<span>;
</span><span>
</span><span>    </span><span>@Query</span>(<span>"SELECT * FROM School where schoolName = :schoolName "</span>)
    List&lt;School&gt; <span>findSchoolByName</span>(String schoolName)<span>;
</span><span>
</span><span>    </span><span>@Insert</span>(<span>onConflict </span>= <span>IGNORE</span>)
    <span>void </span><span>insertSchool</span>(School school)<span>;
</span><span>
</span><span>    </span><span>@Insert</span>(<span>onConflict </span>= <span>IGNORE</span>)
    <span>void </span><span>insertMultipleRecord</span>(List&lt;School&gt; schools)<span>;
</span><span>
</span><span>    </span><span>@Delete
</span><span>    </span><span>void </span><span>deleteSchool</span>(School school)<span>;
</span><span>
</span><span>    </span><span>@Query</span>(<span>"SELECT School.schoolName,ClassStudent.className," </span>+
            <span>"COUNT(Student.studentId) as studentcount," </span>+
            <span>"'[' || GROUP_CONCAT(DISTINCT('{</span><span>\"</span><span>id</span><span>\"</span><span>:'||'</span><span>\"</span><span>'||Student.studentId || '</span><span>\"</span><span>'|| ', </span><span>\"</span><span> name </span><span>\"</span><span>:'|| '</span><span>\"</span><span>'||Student.studentName|| '</span><span>\"</span><span>'||'}'))||']' studentDetails " </span>+
            <span>"FROM School " </span>+
            <span>"LEFT JOIN ClassStudent ON ClassStudent.schoold=School.schoolId</span><span>\n</span><span>" </span>+
            <span>"LEFT JOIN Student ON ClassStudent.classId=Student.classId</span><span>\n</span><span>" </span>+
            <span>"GROUP BY School.schoolId"</span>)
    List&lt;JoinSchoolClassStudentData&gt; <span>getSchoolCLassDataWithStudents</span>()<span>;
</span>}</pre>
JOIN query looks like, Student list will return as JSON array and can be converted to object Using Gson.
<pre><span>@Query</span>(<span>"SELECT School.schoolName,ClassStudent.className," </span>+
        <span>"COUNT(Student.studentId) as studentcount," </span>+
        <span>"'[' || GROUP_CONCAT(DISTINCT('{</span><span>\"</span><span>id</span><span>\"</span><span>:'||'</span><span>\"</span><span>'||Student.studentId || '</span><span>\"</span><span>'|| ', </span><span>\"</span><span> name </span><span>\"</span><span>:'|| '</span><span>\"</span><span>'||Student.studentName|| '</span><span>\"</span><span>'||'}'))||']' studentDetails " </span>+
        <span>"FROM School " </span>+
        <span>"LEFT JOIN ClassStudent ON ClassStudent.schoold=School.schoolId</span><span>\n</span><span>" </span>+
        <span>"LEFT JOIN Student ON ClassStudent.classId=Student.classId</span><span>\n</span><span>" </span>+
        <span>"GROUP BY School.schoolId"</span>)
List&lt;JoinSchoolClassStudentData&gt; <span>getSchoolCLassDataWithStudents</span>()<span>;</span></pre>
<img src="http://thoughtnerds.com/wp-content/uploads/2018/02/WhatsApp-Image-2018-02-18-at-10.40.44-PM-169x300.jpeg" alt="JOIN queries Room persistence library" width="267" height="474" class="alignnone wp-image-587" />

Thank you Happy Coding :D

Full tutorial on http://thoughtnerds.com/join-queries-room-persistence-library/

&nbsp;
