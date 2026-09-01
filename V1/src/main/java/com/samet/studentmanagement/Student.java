package com.samet.studentmanagement;

import jakarta.persistence.*;


@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;


    // Consturactor
    public Student() {}

    // Setter
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setEmail(String email) {this.email = email;}

    // Getter
    public String getEmail() {return email;}
    public String getLastName() {return lastName;}
    public String getFirstName() {return firstName;}
    public Long getId() {return id;}

}
