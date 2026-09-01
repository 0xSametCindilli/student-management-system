[🇹🇷 Türkçe](README_TR.md) | [🇬🇧 English](README_EN.md)

# Student Management System

Java, Spring Boot, Spring Data JPA ve MySQL kullanılarak geliştirilmiş basit bir konsol tabanlı öğrenci yönetim sistemi.

Bu proje, Spring Boot ile geliştirdiğim ilk proje olarak database işlemleri, CRUD işlemleri, Service-Repository mimarisi ve JPA kullanımını öğrenmek ve pekiştirmek amacıyla hazırlanmıştır.

## Özellikler

* Öğrenci ekleme
* Tüm öğrencileri listeleme
* ID ile öğrenci arama
* Öğrenci bilgilerini güncelleme
* Öğrenci silme
* Öğrenci bilgilerinin MySQL'de saklanması
* Otomatik ID oluşturma
* Konsol tabanlı menü sistemi

## Kullanılan Teknolojiler

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven

## Proje Yapısı

Proje, ilk Spring Boot projem olduğu için özellikle basit tutulmuştur.

```text
src/main/java/com/samet/studentmanagement/
│
├── StudentManagementSystemApplication.java
├── Student.java
├── StudentRepository.java
├── StudentService.java
└── StudentMenu.java
```

### Student.java

Öğrenci entity'sini temsil eder ve şu bilgileri içerir:

* ID
* Ad
* Soyad
* Email

### StudentRepository.java

Spring Data JPA kullanılarak database işlemlerini gerçekleştirir.

### StudentService.java

CRUD işlemlerini içerir ve menü ile repository arasında Service katmanı olarak görev yapar.

### StudentMenu.java

Konsol menüsünü yönetir ve kullanıcıdan giriş alır.

### StudentManagementSystemApplication.java

Spring Boot uygulamasını başlatır.

---

# Gereksinimler

Projeyi çalıştırmadan önce aşağıdakilerin bilgisayarınızda kurulu olması gerekir:

* Java JDK 17 veya üzeri
* MySQL Server
* MySQL Workbench (isteğe bağlı ancak önerilir)
* IntelliJ IDEA veya başka bir Java IDE'si
* Maven (IntelliJ ve Spring projeleriyle genellikle birlikte gelir)

## 1. MySQL Kurulumu

Bilgisayarınıza MySQL Server kurun.

Kurulum sırasında bir MySQL kullanıcı adı ve şifre oluşturun.

Projede database tablolarını manuel olarak oluşturmanıza gerek yoktur. Hibernate, entity yapısına göre tabloyu otomatik olarak oluşturabilir ve güncelleyebilir.

## 2. Database Oluşturma

MySQL Workbench'i açın ve MySQL Server'a bağlanın.

Aşağıdaki SQL komutunu çalıştırın:

```sql
CREATE DATABASE student_management_system;
```

Daha sonra database'i seçin:

```sql
USE student_management_system;
```

Database'in oluşturulduğunu kontrol etmek için:

```sql
SHOW DATABASES;
```

komutunu kullanabilirsiniz.

`student` tablosunu manuel olarak oluşturmanıza gerek yoktur.

Hibernate, `Student` entity'sinden yola çıkarak tabloyu oluşturacak veya güncelleyecektir.

---

# Database Ayarları

Database kullanıcı adı ve şifresinin proje içerisinde doğrudan tutulmaması için environment variable kullanılmaktadır.

`application.properties`:

```properties
spring.application.name=student-management-system

spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Bilgisayarınızda aşağıdaki environment variable'ları tanımlamanız gerekir:

```text
DB_URL=jdbc:mysql://localhost:3306/student_management_system
DB_USERNAME=root
DB_PASSWORD=your_mysql_password
```

`your_mysql_password` kısmını kendi MySQL şifreniz ile değiştirin.

Gerçek MySQL şifrenizi GitHub'a kesinlikle yüklemeyin.

---

# Projeyi Çalıştırma

Gereksinimleri kurduktan ve database'i oluşturduktan sonra:

1. Projeyi klonlayın veya indirin.
2. Projeyi IntelliJ IDEA ile açın.
3. MySQL Server'ın çalıştığından emin olun.
4. Gerekli database environment variable'larını tanımlayın.
5. Maven'ın gerekli dependency'leri indirmesini bekleyin.
6. Aşağıdaki sınıfı çalıştırın:

```text
StudentManagementSystemApplication.java
```

Uygulama başarılı şekilde başladığında konsolda menü ekranı açılacaktır.

---

# Konsol Menüsü

Uygulama aşağıdaki seçenekleri sunar:

```text
========================================
       STUDENT MANAGEMENT SYSTEM
========================================
1 -> Öğrenci Ekle
2 -> Öğrencileri Listele
3 -> Öğrenci Ara
4 -> Öğrenci Güncelle
5 -> Öğrenci Sil
0 -> Çıkış
========================================
Seçiminiz:
```

## 1 - Öğrenci Ekle

Program sizden şu bilgileri ister:

```text
Ad:
Soyad:
Email:
```

Girilen bilgiler kullanılarak yeni bir öğrenci oluşturulur ve MySQL'e kaydedilir.

Öğrencinin ID değeri database tarafından otomatik olarak oluşturulur.

## 2 - Öğrencileri Listele

Database'de kayıtlı olan tüm öğrencileri listeler.

Örnek:

```text
ID         : 1
First Name : Samet
Last Name  : Cindilli
Email      : samet@example.com
----------------------------------------
```

## 3 - Öğrenci Ara

Öğrencinin ID'sini ister ve bulunan öğrencinin bilgilerini ekrana yazdırır.

Girilen ID database'de bulunmuyorsa:

```text
Student not found.
```

mesajı gösterilir.

## 4 - Öğrenci Güncelle

Güncellenecek öğrencinin ID'sini ister.

Daha sonra yeni:

* Ad
* Soyad
* Email

bilgileri alınır.

Mevcut öğrenci database üzerinde güncellenir.

## 5 - Öğrenci Sil

Silinecek öğrencinin ID'sini ister ve ilgili öğrenci database'den silinir.

## 0 - Çıkış

Konsol menüsünü kapatır ve uygulamadan çıkış yapar.

---

# Database Tablosu

Database tablosu `Student` entity'sine göre Hibernate tarafından oluşturulur.

Tablonun temel yapısı:

```text
student
├── id
├── first_name
├── last_name
└── email
```

`id` alanı otomatik olarak oluşturulur.

Java sınıfındaki alanlar JPA annotation'ları kullanılarak database sütunlarıyla eşleştirilir.

Örneğin:

```java
@Column(name = "first_name")
private String firstName;
```

Burada Java tarafındaki `firstName` alanı database'deki `first_name` sütununa bağlanır.

---

# Önemli Notlar

Projede aşağıdaki ayar kullanılmaktadır:

```properties
spring.jpa.hibernate.ddl-auto=update
```

Bu ayar, Hibernate'in entity yapısına göre database tablo yapısını oluşturmasına ve güncellemesine izin verir.

Proje özellikle bir ilk Spring Boot projesi olarak basit tutulmuştur. Bu nedenle şu anda konsol tabanlı bir arayüze sahiptir.

Projede şu özellikler henüz bulunmamaktadır:

* Authentication / Authorization
* Frontend
* REST API
* Spring Security
* Web arayüzü

Bu özellikler projenin ilerleyen aşamalarında eklenebilir.

---

# Sorun Giderme

## Database bağlantı hatası

Aşağıdakileri kontrol edin:

* MySQL Server çalışıyor mu?
* `student_management_system` database'i oluşturuldu mu?
* `DB_URL` doğru mu?
* `DB_USERNAME` doğru mu?
* `DB_PASSWORD` doğru mu?

Projede kullanılan varsayılan bağlantı adresi:

```text
jdbc:mysql://localhost:3306/student_management_system
```

## Tablo oluşmadı

Aşağıdaki ayarın `application.properties` içerisinde olduğundan emin olun:

```properties
spring.jpa.hibernate.ddl-auto=update
```

Ayrıca uygulamanın MySQL'e başarılı şekilde bağlandığını kontrol edin.

## Uygulama başlamıyor

Konsoldaki hata mesajlarını kontrol edin.

Aşağıdakilerin doğru olduğundan emin olun:

* Java sürümü uygun mu?
* Maven dependency'leri indirildi mi?
* MySQL Server çalışıyor mu?
* Database bilgileri doğru mu?

---

# Bu Projede Öğrendiklerim

Bu proje, Spring Boot ve database geliştirme temellerini öğrenmek için hazırlanmıştır.

Projede kullanılan ve öğrenilen başlıca konular:

* Spring Boot
* Dependency Injection
* `@Component`
* `@Service`
* `@Entity`
* `@Id`
* `@GeneratedValue`
* `@Column`
* Spring Data JPA
* `JpaRepository`
* CRUD işlemleri
* MySQL bağlantısı
* Hibernate
* `Scanner` ile konsol girdisi alma
* Service ve Repository katmanları

Bu proje, ileride REST API, web arayüzü ve daha gelişmiş Spring Boot özelliklerine geçmeden önce sağlam bir temel oluşturmak amacıyla özellikle basit tutulmuştur.
