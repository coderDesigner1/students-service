package com.springboot.studentservice.repository;

import com.springboot.studentservice.entity.Address;
import com.springboot.studentservice.interfaces.StudentDetailsProjection;
import com.springboot.studentservice.dto.StudentDetailsDto;
import com.springboot.studentservice.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    // Save one student
   /* @Test
    public void saveStudent() throws ParseException {
        Address address = new Address();

        address.setStu_add_street("136 Dey Ln");
        address.setStu_add_city("Springfield");
        address.setStu_add_state("MI");
        address.setStu_add_country("USA");

        Student student =  new Student();
        student.setEmail("janedoe@gmail.com");
        student.setFirstName("Jane");
        student.setLastName("Doe");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = dateFormat.parse("2019-12-05");
        student.setBirthDate(birthDate);
        student.setEnterYear(2021);
        student.setAddress(address);



        studentRepository.save(student);
    }

    // Get all the students
    @Test
    public void getAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);

    }

    //Find student by first name
    @Test
    public void getStudentByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("John");

        for (Student sDetails : studentList) {
            System.out.println("Name: " + sDetails.getFirstName() + " " + sDetails.getLastName());
            System.out.println("Address: " + sDetails.getAddress().getStu_add_street() + ", " + sDetails.getAddress().getStu_add_city()+ ", " + sDetails.getAddress().getStu_add_state() + ", " + sDetails.getAddress().getStu_add_country());
            System.out.println("-----------------------------------");
        }
        System.out.println("student List = " + studentList);

    }

    //Find student by first name
    @Test
    public void findByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("John");

        for (Student sDetails : studentList) {
            System.out.println("Name: " + sDetails.getFirstName() + " " + sDetails.getLastName());
            System.out.println("Address: " + sDetails.getAddress().getStu_add_street() + ", " + sDetails.getAddress().getStu_add_city()+ ", " + sDetails.getAddress().getStu_add_state() + ", " + sDetails.getAddress().getStu_add_country());
            System.out.println("-----------------------------------");
        }
        System.out.println("student List = " + studentList);

    }

    //Find student by few characters
    @Test
    public void getStudentByFirstNameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("oh");
        System.out.println("student list = "+ studentList);
    }
    
    // find all the students whose last name is not null
    @Test
    public void getStudentByLastNameNotNull(){
        List<Student> studentList = studentRepository.findByLastNameNotNull();
        System.out.println("studentList = " + studentList);
    }
    
    // find all the students whose last name is null
    @Test
    public void getStudentByLastNameNull(){
        List<Student> studentList = studentRepository.findByLastNameNull();
        System.out.println("studentList = " + studentList);
    }

    // find student firstname by email
    @Test
    public void getFirstNameByEmail(){
        String student = studentRepository.findNameByEmail("johndoe@gmail.com");
        System.out.println("student = " + student);
    }
    
    @Test
    public void getEmailByFirstNameAndLastName(){
        String student = studentRepository.findEmailByFirstNameAndLastName("Jane", "Doe");
        System.out.println("student = " + student);
    }

    @Test
    public void getFirstNameByEmailNative(){
        String student = studentRepository.findFirstNameByEmailNative("johndoe@gmail.com");
        System.out.println("student = " + student);
    }
    
    @Test
    public void getFirstNameByEmailNativeNamedParam(){
        String student = studentRepository.findFirstNameByEmailNativeNamedParam("johndoe@gmail.com");
        System.out.println("student = " + student);
    }
    
    @Test
    public void getEmailByFirstNameNLastNameNativeParam(){
        String student = studentRepository.findEmailByFirstNameNLastNameNativeParam("Jane", "Doe");
        System.out.println("student = " + student);
    }
    
    @Test
    public void updateLastNameByEmail(){
        int student = studentRepository.updateLastNameByEmail("Dorothy", "johndoe@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentById() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = dateFormat.parse("2019-12-05");
        int student = studentRepository.updateStudentById("B","M", "bm@gmail.com", birthDate, 2021, 36);
    }
    
    @Test
    public void findAllPagination(){
        Pageable threeRecordsEachPage = PageRequest.of(0,2);
        
        List<Student> studentList = studentRepository.findAll(threeRecordsEachPage).getContent();
        System.out.println("studentList = " + studentList);
    }

    // delete student from student table which deletes address also
    @Test
    public void deleteStudentById(){
        studentRepository.deleteStudentById(37);
    }

    // return all students with address
    @Test
    public void findAllStudentsWithAddresses(){

        List<Student> studentsWithAddresses = studentRepository.findAllStudentsWithAddress();

        for (Student sDetails : studentsWithAddresses) {
////          System.out.println("Name: " + sDetails.getFirstName() + " " + sDetails.getLastName());
//            System.out.println("Address: " + sDetails.getAddress().getStu_add_street() + ", " + sDetails.getAddress().getStu_add_city()+ ", " + sDetails.getAddress().getStu_add_state() + ", " + sDetails.getAddress().getStu_add_country());
            System.out.println("sDetails.toString() = " + sDetails.toString());
            System.out.println("-----------------------------------");
        }
    }

    // return one student by email
    @Test
    public void findStudentByEmail(){
        String email = "ethan.williams@hotmail.com";
        Student sDetails = studentRepository.findStudentByEmail(email);
        System.out.println("Name: " + sDetails.getFirstName() + " " + sDetails.getLastName());
        System.out.println("Address: " + sDetails.getAddress().getStu_add_street() + ", " + sDetails.getAddress().getStu_add_city()+ ", " + sDetails.getAddress().getStu_add_state() + ", " + sDetails.getAddress().getStu_add_country());
        System.out.println("-----------------------------------");
    }

    // return students by same first name
    @Test
    public void findStudentsByFirstName(){
        String fName = "Ethan";
        List<Student> studentDetails = studentRepository.findStudentByFirstName(fName);

        for (Student sDetails : studentDetails) {
            System.out.println("Name: " + sDetails.getFirstName() + " " + sDetails.getLastName());
            System.out.println("Address: " + sDetails.getAddress().getStu_add_street() + ", " + sDetails.getAddress().getStu_add_city()+ ", " + sDetails.getAddress().getStu_add_state() + ", " + sDetails.getAddress().getStu_add_country());
            System.out.println("-----------------------------------");
        }

    }

    // return students by same last name
    @Test
    public void findStudentsByLastName(){
        String lName = "Doe";
        List<Student> studentDetails = studentRepository.findStudentByLastName(lName);

        for (Student sDetails : studentDetails) {
            System.out.println("Name: " + sDetails.getFirstName() + " " + sDetails.getLastName());
            System.out.println("Address: " + sDetails.getAddress().getStu_add_street() + ", " + sDetails.getAddress().getStu_add_city()+ ", " + sDetails.getAddress().getStu_add_state() + ", " + sDetails.getAddress().getStu_add_country());
            System.out.println("-----------------------------------");
        }

    }*/

  /*  // return students by same last name using DTO
    @Test
    public void findStudentsByLastNameWithDto(){
        String lName = "Doe";
        List<StudentDetailsDto> studentDetails = studentRepository.findStudentByLastNameWithDto(lName);

        for (StudentDetailsDto sDetails : studentDetails) {
            System.out.println("Name: " + sDetails.getFirstName() + " " + sDetails.getLastName());
            System.out.println("Address: " + sDetails.getStreet() + ", " + sDetails.getCity() + ", " + sDetails.getState() + ", " + sDetails.getCountry());
            System.out.println("-----------------------------------");
        }

    }

    // return students by same first and last name using DTO
    @Test
    public void findStudentWithSameFirstAndLastNameWithDto(){
        String fName = "Alexander";
        String lName = "Doe";
        List<StudentDetailsDto> studentDetails = studentRepository.findStudentWithSameFirstAndLastNameWithDto(fName,lName);

        for (StudentDetailsDto sDetails : studentDetails) {
            System.out.println("Name: " + sDetails.getFirstName() + " " + sDetails.getLastName());
            System.out.println("Address: " + sDetails.getStreet() + ", " + sDetails.getCity() + ", " + sDetails.getState() + ", " + sDetails.getCountry());
            System.out.println("-----------------------------------");
        }

    }

*/


}