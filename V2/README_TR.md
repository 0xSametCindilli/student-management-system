# 🆕 Yeni Versiyonda Yapılan Güncellemeler

🇹🇷 **Türkçe** | 🇬🇧 **English**

---

# 🇹🇷 Türkçe

Bu versiyonda proje, önceki konsol tabanlı yapının geliştirilmesiyle birlikte **REST API mimarisine** geçirilmiştir.

Önceki versiyonda öğrenciler ile gerçekleştirilen CRUD işlemleri konsol üzerinden yapılırken, yeni versiyonda bu işlemler **HTTP istekleri üzerinden REST API aracılığıyla** gerçekleştirilmektedir.

## 🌐 REST API Eklendi

Projeye `StudentRestController` sınıfı eklenerek REST API desteği getirildi.

### API Endpoint'leri

| HTTP Method | Endpoint | Açıklama |
|------------|----------|----------|
| GET | `/api/students` | Tüm öğrencileri getirir |
| GET | `/api/students/{id}` | ID'ye göre öğrenci getirir |
| POST | `/api/students` | Yeni öğrenci oluşturur |
| PUT | `/api/students/{id}` | Öğrenci bilgilerini günceller |
| DELETE | `/api/students/{id}` | Öğrenciyi siler |

Böylece öğrenci işlemleri artık **Postman gibi API test araçları** veya bir **frontend uygulaması** üzerinden gerçekleştirilebilir.

## 🏗️ Katmanlı Mimari Geliştirildi

Proje yapısı daha düzenli, sürdürülebilir ve geliştirilebilir bir mimariye taşındı.

Yeni yapıda temel olarak:

```text
Entity
   ↓
Repository
   ↓
Service
   ↓
REST Controller