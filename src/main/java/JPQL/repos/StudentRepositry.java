package JPQL.repos;

import JPQL.entities.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepositry extends CrudRepository<Student, Long> {
    @Query("from Student")
    List<Student> findAllStudents(Pageable pageable);

    @Query("select firstname, lastname from Student")
    List<Object[]> findStudentPartialData();

    @Query("from Student where firstname=:firstname")
    List<Student> findAllStudentsByFirstName(@Param("firstname") String firstname);

    @Query("from Student where score>:min and score<:max")
    List<Student> findAllStudentsByScore(@Param("min")int min, @Param("max")int max);

    @Query("from Student where score between :start and :end")
    List<Student> findAllStudentsBetweenScore(@Param("start")int start, @Param("end")int end);

    @Modifying
    @Query("delete from Student where firstname = :firstname")
    void deleteStudentByFirstName(@Param("firstname") String firstame);

    @Modifying
    @Query("update Student set score = :score where firstname = :firstname ")
    void updateStudentsScoreByFirstName(@Param("score")int score, @Param("firstname")String firstname);

    @Query(value = "select * from student",nativeQuery = true)
    List<Student> findAllStudentNQ();

    @Query(value = "select * from student where fname=:firstname",nativeQuery = true)
    List<Student> findStudentFirstNameNQ(@Param("firstname") String firstname);

    @Query(value = "select fname from student",nativeQuery = true)
    List<Object[]> findStudentByFirstNameNQ();
}
