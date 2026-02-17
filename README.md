# 🎬 BookMyShow Backend System

A RESTful Movie Ticket Booking Backend Application built using **Spring Boot, JPA, and MySQL**.

This project simulates a real-world ticket booking system including seat locking, booking lifecycle management, and payment simulation.

---

## 🚀 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- REST APIs

---

## 🏗️ Architecture

Layered Architecture:

Controller → Service → Repository → Database

Entities:
- Movie
- Theatre
- Show
- Seat
- Booking
- Payment
- User

---

## 🔐 Authentication (Basic Implementation)

- User Registration API
- Manual Login Validation (Email & Password Check)
- Booking allowed only for existing users
- Can be extended with Spring Security for production-level security

---

## 🔥 Features

- Create Movies, Theatres, Shows
- Generate seats per show
- Seat locking mechanism (AVAILABLE → LOCKED → BOOKED)
- Booking creation (PENDING state)
- Payment simulation (SUCCESS / FAILED)
- Booking confirmation & cancellation
- Transaction management using `@Transactional`
- Get booking details by ID
- Get movie details by ID

---

## 🎯 Booking Flow

1. User registers
2. User logs in
3. User selects seats
4. Seats become **LOCKED**
5. Booking created with **PENDING** status
6. On payment success → Booking CONFIRMED & Seats BOOKED
7. On payment failure → Booking CANCELLED & Seats AVAILABLE

---

## 🛠️ How To Run

1. Clone repository:
   git clone https://github.com/sayelabbash/bookmyshow-backend.git
2.
2. Configure MySQL in `application.properties`

3. Run the application:
4.
4. Test APIs using Postman.

---

## 👨‍💻 Author

**Sk Sayel Abbash**  
B.Tech CSE (3rd Year)  
Spring Boot Backend Enthusiast



