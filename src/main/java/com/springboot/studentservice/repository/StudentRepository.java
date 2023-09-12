package com.springboot.studentservice.repository;

import com.springboot.studentservice.interfaces.StudentDetailsProjection;
import com.springboot.studentservice.dto.StudentDetailsDto;
import com.springboot.studentservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String name);

    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByLastNameNull();

    // JPQL query
    @Query("select s.firstName from Student s where s.email= ?1")
    public String findNameByEmail(String email);

    @Query("select s.email from Student s where s.firstName = ?1 and s.lastName = ?2")
    public String findEmailByFirstNameAndLastName(String fName, String lName);

    // Native Query
    @Query(
            value = "select first_name from student where email = ?1",
            nativeQuery = true
    )
    public String findFirstNameByEmailNative(String name);

    // Native Query named param
    @Query(
            value = "select first_name from student where email = :email",
            nativeQuery = true
    )
    public String findFirstNameByEmailNativeNamedParam(@Param("email") String email);

    // Native query named param multiple
    @Query(
            value=" select email from student where first_name = :fName and last_name = :lName",
            nativeQuery = true
    )
    public String findEmailByFirstNameNLastNameNativeParam(
            @Param("fName") String fName,
            @Param("lName") String lName
    );

    @Modifying
    @Transactional
    @Query(
            value="update student set last_name = ?1 where email = ?2 ",
            nativeQuery = true
    )
    public int updateLastNameByEmail(String lName, String email);

    @Modifying
    @Transactional
    @Query(
            value="update student set first_name=?1,last_name = ?2, email=?3, birth_date=?4, enter_year=?5 where student_id=?6 ",
            nativeQuery = true
    )
    public int updateStudentById(String fName, String lName, String email, Date birthDate, int year, long id);
//    public int updateStudentById(Student student, int id);
    @Modifying
    @Transactional
    @Query(
            value = "Delete from Student where student_id = ?1",
            nativeQuery = true
    )
    public int deleteStudentById(int id);

    // return all students with their address
    @Query(
//            value="select s.student_id, s.first_name,  s.last_name , s.enter_year, s.email, s.address_id,  a.street, a.city,a.state, a.country from student s, address a \n"+
//                    "where s.address_id = a.stu_address_id",
            value="select * from student s, address a where s.address_id = a.stu_address_id",
            nativeQuery = true
    )

    public List<Student> findAllStudentsWithAddress();

    // return one student by email with address
    @Query(
            value = "select student_id, first_name,  last_name ,  email, s.address_id,  street, city, state, country from student s, address a\n" +
                    "where s.address_id = a.stu_address_id and s.email = ?1",
            nativeQuery = true
    )
    public Student findStudentByEmail(String email);

    // return students with same first name
    @Query(name="Student.findStudentWithSameFirstName",nativeQuery = true)
    public List<Student> findStudentByFirstName(String fName);

    // return students with same last name
    @Query(name = "Student.findStudentWithSameLastName", nativeQuery = true)
    public List<Student> findStudentByLastName(String lName);

    // return students with same last name
    @Query(name = "Student.findStudentWithSameLastNameWithDto", nativeQuery = true)
    public List<StudentDetailsDto> findStudentByLastNameWithDto(String lName);

    // return students with same last name
    @Query(name = "Student.findStudentWithSameFirstAndLastNameWithDto", nativeQuery = true)
    public List<StudentDetailsDto> findStudentWithSameFirstAndLastNameWithDto(String fName,String lName);



}
