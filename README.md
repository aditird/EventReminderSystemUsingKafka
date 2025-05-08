# Event Reminder System Using Kafka

This is a simple event-driven reminder system implemented in Java using Apache Kafka. It consists of a producer that sends scheduled reminder messages and a consumer that processes and displays them in real time.

## 📌 Overview

The system simulates a microservices environment where events (e.g., reminders) are sent to a Kafka topic and asynchronously consumed by another component.

## 📁 Project Structure

```
EventReminderSystem/
├── Producer.java        # Sends reminder messages to Kafka
├── Consumer.java        # Listens to Kafka topic and processes messages
├── KafkaListener.java   # Implements the Kafka listener interface
```

## ⚙️ Prerequisites

- Java 8+
- Apache Kafka and Zookeeper running locally or via Docker
- Kafka topic named `reminder-events` (or update it in code)

## 🚀 How to Run

### 1. Start Kafka & Zookeeper

If using Docker:

```bash
docker-compose up -d
```

Or manually via local Kafka installation.

### 2. Compile Java classes

```bash
javac *.java
```

### 3. Run Producer

```bash
java Producer
```

### 4. Run Consumer

In a separate terminal:

```bash
java Consumer
```

## 📦 Technologies Used

- Java
- Apache Kafka
- Kafka Producer & Consumer APIs

## ✨ Features

- Event-driven architecture
- Real-time reminder delivery
- Modular Kafka integration

## 🛡️ License

This project is open-source under the MIT License.
