package com.samet.studentmanagement;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class StudentMenu {

    private final StudentService studentService;

    public StudentMenu(StudentService studentService) {
        this.studentService = studentService;
    }

    public void LoginMenu(){
        Scanner scan = new Scanner(System.in);

        while(true){
            try {
            System.out.print("=== STUDENT MANAGEMENT SYSTEM ===\n");
            System.out.print("1 -> Ogreci Ekle\n");
            System.out.print("2 -> Ogrencileri Listele\n");
            System.out.print("3 -> Ogreci Ara\n");
            System.out.print("4 -> Ogrenci Guncelle\n");
            System.out.print("5 -> Ogrenci Sil\n");
            System.out.print("0 -> Cikis\n");
            System.out.print("Seciminiz : ");
            String secim = scan.nextLine();
                switch (secim){
                    case "1":
                        System.out.println("Yonlendiriliyorsunuz...");
                        addStudent(scan);
                        break;
                    case "2":
                        System.out.println("Yonlendiriliyorsunuz...");
                        listStudents();
                        break;
                    case "3":
                        System.out.println("Yonlendiriliyorsunuz...");
                        searchStudent(scan);
                        break;
                    case "4":
                        System.out.println("Yonlendiriliyorsunuz...");
                        updateStudent(scan);
                        break;
                    case "5":
                        System.out.println("Yonlendiriliyorsunuz...");
                        deleteStudent(scan);
                        break;
                    case "0":
                        System.out.println("Cikis Yapiliyor...");
                        return;
                    default:
                        System.out.println("Gecersiz İslem Tekrar Deneyin!");
                }
            }
            catch (Exception e){
                System.out.println("Lutfen Gecerli Tuslama Yapiniz !");
            }

        }
    }




    private void addStudent(Scanner scan){
        for (int i = 0; i < 100; i++) {System.out.println();} // Clear Screen
        System.out.print("=== STUDENT MANAGEMENT SYSTEM ===\n");
        System.out.print("Ogrenci İsim : ");
        String firstName = scan.nextLine();
        System.out.print("Ogrenci Soyad : ");
        String lastName = scan.nextLine();
        System.out.print("Ogrenci Email : ");
        String email = scan.nextLine();

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        studentService.addStudent(student);

        for (int i = 0; i < 100; i++) {System.out.println();} // Clear Screen
        System.out.println("Ogrenci Basarili Sekilde Eklendi.");
    }

    private void listStudents() {
        List<Student> students = studentService.getAllStudents();
        for (int i = 0; i < 100; i++) {System.out.println();} // Clear Screen

        if (students.isEmpty()) {
            System.out.print("Liste Bos!");
            return;
        }

        for (Student student : students) {
            System.out.println("Ogrenci Id :"+student.getId());
            System.out.println("Ogrenci İsim :"+student.getFirstName());
            System.out.println("Ogrenci Soyad :"+student.getLastName());
            System.out.println("Ogrenci Email :"+student.getEmail());
            System.out.println("------------------------------------------");

        }
    }


    private void searchStudent(Scanner scan){
        System.out.print("=== STUDENT MANAGEMENT SYSTEM ===\n");
        System.out.print("Ogrenci Id : ");
        Long id = scan.nextLong();
        scan.nextLine();
        Student student = studentService.getStudentById(id);
        if (student == null) {
            System.out.println("Ogrenci Bulunamadi!");
            return;
        }
        System.out.println("Ogrenci Id :"+student.getId());
        System.out.println("Ogrenci İsim :"+student.getFirstName());
        System.out.println("Ogrenci Soyad :"+student.getLastName());
        System.out.println("Ogrenci Email :"+student.getEmail());


    }

    private void updateStudent(Scanner scan){
        System.out.print("=== STUDENT MANAGEMENT SYSTEM ===\n");
        System.out.print("Guncellenecek Ogrenci Id : ");
        Long id = scan.nextLong();
        scan.nextLine();
        Student student = studentService.getStudentById(id);

        if (student == null) {
            System.out.println("Ogrenci Bulunamadi!");
            return;

        }
        System.out.print("Ogrenci Yeni İsim :");
        String firstName = scan.nextLine();
        System.out.print("Ogrenci Yeni Soyad :");
        String lastName = scan.nextLine();
        System.out.print("Ogrenci Yeni Email :");
        String email = scan.nextLine();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        studentService.updateStudent(id, student);
        for (int i = 0; i < 100; i++) {System.out.println();} // Clear Screen
        System.out.println("Ogrenci Basarili Sekilde Guncellendi.");
    }

    private void deleteStudent(Scanner scan){
        System.out.print("=== STUDENT MANAGEMENT SYSTEM ===\n");
        System.out.print("Silenecek Ogrenci Id : ");
        Long id = scan.nextLong();
        scan.nextLine();
        Student student = studentService.getStudentById(id);
        if (student == null) {
            System.out.println("Ogrenci Bulunamadi!");
            return;
        }
        studentService.deleteStudentById(id);
        for (int i = 0; i < 100; i++) {System.out.println();} // Clear Screen
        System.out.println("Ogrenci Basarili Sekilde Silindi.");
    }
}
