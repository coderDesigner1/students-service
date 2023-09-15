package com.springboot.studentservice.entity;

import com.springboot.studentservice.dto.StudentDetailsDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NamedNativeQueries({
        @NamedNativeQuery(
                name="Student.findStudentWithSameFirstName",
                query = "select student_id, first_name,  last_name ,birth_date, enter_year, email, s.address_id,  street, city, state, country from student s, address a\n" +
                        "where s.address_id = a.stu_address_id and s.first_name = ?1",
                resultClass = Student.class
                //resultSetMapping = "StudentsFirstNameMapping"
        ),
        @NamedNativeQuery(
                name="Student.findStudentWithSameLastName",
                query = "select student_id, first_name,  last_name ,birth_date, enter_year, email, s.address_id,  street, city, state, country from student s, address a\n" +
                        "where s.address_id = a.stu_address_id and s.last_name = ?1",
                resultClass = Student.class
                //resultSetMapping = "StudentsLastNameMapping"
        ),
        @NamedNativeQuery(
                name="Student.findStudentWithSameLastNameWithDto",
                query = "select s.first_name,  s.last_name , street, city, state, country from student s, address a\n" +
                        "where s.student_id = a.student_id and s.last_name = ?1",
                //resultClass = StudentDetailsDto.class,
                resultSetMapping = "StudentsLastNameMapping"
        ),
        @NamedNativeQuery(
                name="Student.findStudentWithSameFirstAndLastName",
                query = "select s.student_id,s.first_name,  s.last_name ,birth_date, enter_year, email,s.address_id, street, city, state, country from student s, address a\n" +
                        "where s.address_id = a.stu_address_id and s.first_name = ?1 and s.last_name = ?2",
                resultClass = Student.class
                //resultSetMapping = "StudentsFirstAndLastNameMapping"
        )

})
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "StudentsLastNameMapping",
                classes = @ConstructorResult(
                        targetClass = StudentDetailsDto.class,
                        columns = {
                                @ColumnResult(name = "first_name", type = String.class),
                                @ColumnResult(name = "last_name", type = String.class),
                                @ColumnResult(name = "street", type = String.class),
                                @ColumnResult(name = "city", type = String.class),
                                @ColumnResult(name = "state", type = String.class),
                                @ColumnResult(name = "country", type = String.class)
                        }
                )

        ),
        @SqlResultSetMapping(
                name = "StudentsFirstAndLastNameMapping",
                classes = @ConstructorResult(
                        targetClass = StudentDetailsDto.class,
                        columns = {
                                @ColumnResult(name = "first_name", type = String.class),
                                @ColumnResult(name = "last_name", type = String.class),
                                @ColumnResult(name = "street", type = String.class),
                                @ColumnResult(name = "city", type = String.class),
                                @ColumnResult(name = "state", type = String.class),
                                @ColumnResult(name = "country", type = String.class)
                        }
                )

        )
}

)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
        name="student",
        uniqueConstraints = @UniqueConstraint(
                name="email_unique",
                columnNames = "email"
        )
)
public class Student {
    @Id
    @Column( name="student_id")
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long studentId;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(name="birth_date", nullable = false)
    private Date birthDate;

    @Column(name="enter_year")
    private int enterYear;

    @OneToOne(
            cascade = CascadeType.ALL
//            orphanRemoval = true
//            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name="address_id", // from database
            referencedColumnName = "stu_address_id" // from entity
    )
    private Address address;

//    @OneToMany(mappedBy = "student")
//    private List<Results> results = new ArrayList<>();



}
