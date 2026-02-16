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

## 📂 Project Architecture

Layered Architecture:

Controller → Service → Repository → Database

Entities:
- Movie
- Theatre
- Show
- Seat
- Booking
- Payment

---

## 🔥 Features

- Create Movies, Theatres, Shows
- Seat generation per show
- Seat locking mechanism
- Booking creation (PENDING state)
- Payment simulation (SUCCESS / FAILED)
- Booking confirmation & cancellation
- Transaction management using `@Transactional`

---

## 🎯 Booking Flow

1. User selects seats
2. Seats become **LOCKED**
3. Booking created with **PENDING** status
4. On payment success → Booking CONFIRMED & Seats BOOKED
5. On payment failure → Booking CANCELLED & Seats AVAILABLE

---

## 🛠️ How To Run

1. Clone repository:
   git clone https://github.com/sayelabbash/bookmyshow-backend.git
2.
2. Configure MySQL in `application.properties`

3. Run the application:

4. Test APIs using Postman.

---

## 👨‍💻 Author

**Sk Sayel Abbash**  
B.Tech CSE | Spring Boot Enthusiast

