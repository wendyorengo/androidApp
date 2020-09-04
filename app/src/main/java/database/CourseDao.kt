package database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.hello_world.Courses


@Dao
interface  CourseDao{
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertCourse(courses: Courses)

    @androidx.room.Query("SELECT * FROM courses")
    fun  getAllCourses(): List<Courses>



}