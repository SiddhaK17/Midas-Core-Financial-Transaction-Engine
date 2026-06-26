# Midas Core Financial Transaction Engine

> **An event-driven financial transaction processing platform engineered to ingest, validate, persist, and distribute transaction events within a scalable fintech ecosystem.**

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.5-green)
![Apache Kafka](https://img.shields.io/badge/Apache_Kafka-Event_Streaming-black)
![Maven](https://img.shields.io/badge/Maven-Build_Automation-blue)
![H2 Database](https://img.shields.io/badge/H2-Database-lightgrey)

---

## Overview

Midas Core is a distributed backend service designed to serve as the central transaction-processing engine within a modern financial technology architecture. The platform is responsible for receiving transaction events, enforcing validation rules, coordinating business workflows, persisting transactional data, and exposing processed information to downstream consumers.

Built upon enterprise Java technologies and event-driven design principles, the system leverages Apache Kafka for asynchronous message ingestion, Spring Boot for application orchestration, and a persistence layer for maintaining transactional integrity throughout the processing lifecycle.

Rather than functioning as a simple CRUD-based application, Midas Core is being developed as a production-inspired transaction processing platform that mirrors architectural patterns commonly found within high-throughput financial systems, payment infrastructures, and institutional trading environments.

The repository documents the progressive implementation of the platform, beginning with infrastructure provisioning and evolving toward a fully integrated transaction-processing workflow consisting of event ingestion, validation, persistence, and service exposure layers.

---

## Key Objectives

* Establish a scalable event-driven processing architecture.
* Simulate real-world financial transaction ingestion workflows.
* Implement robust validation and business rule enforcement mechanisms.
* Persist transactional data while maintaining consistency and integrity.
* Expose processed information through service-oriented interfaces.
* Demonstrate enterprise backend engineering practices using the Spring ecosystem.

---

## Architectural Vision

The platform is designed around a modular event-driven workflow that separates message ingestion, business validation, persistence, and service exposure into clearly defined architectural layers.

```text
                        ┌─────────────────────┐
                        │ Transaction Source  │
                        └──────────┬──────────┘
                                   │
                                   ▼
                      ┌──────────────────────────┐
                      │      Apache Kafka        │
                      │     Event Streaming      │
                      └────────────┬─────────────┘
                                   │
                                   ▼
                 ┌───────────────────────────────────┐
                 │          Midas Core Service       │
                 │                                   │
                 │  • Event Consumption              │
                 │  • Transaction Validation         │
                 │  • Business Rule Enforcement      │
                 │  • Persistence Management         │
                 └─────────────────┬─────────────────┘
                                   │
                                   ▼
                        ┌──────────────────────┐
                        │    Database Layer    │
                        │  Transaction Storage │
                        └──────────┬───────────┘
                                   │
                                   ▼
                        ┌──────────────────────┐
                        │      REST APIs       │
                        │  External Consumers  │
                        └──────────────────────┘
```

---

## Technology Stack

### Backend Framework

* Spring Boot 3.2.5

### Programming Language

* Java 17

### Event Streaming

* Apache Kafka
* Spring Kafka

### Persistence Layer

* Spring Data JPA
* H2 Database

### Testing Infrastructure

* Spring Boot Test
* Spring Kafka Test
* Testcontainers

### Build System

* Maven

### Development Environment

* IntelliJ IDEA
* Git
* Maven Wrapper

---

# Development Progress

## Phase 1 — Infrastructure Initialization & Environment Provisioning

The initial phase focused on transforming the provided project scaffold into a fully operational enterprise Java development environment capable of supporting future transaction processing workflows.

At the start of development, the repository contained only the foundational project structure. Core backend dependencies, messaging infrastructure, persistence components, and testing frameworks had not yet been configured.

The objective of this phase was to establish a stable and reproducible foundation upon which the remaining transaction-processing architecture could be implemented.

### Java Environment Standardization

The application was standardized on Java 17 to ensure compatibility with Spring Boot 3.2.5 and modern enterprise backend development practices.

Environment validation included successful verification of:

* Java Runtime Environment
* Java Compiler
* JAVA_HOME configuration
* Maven Wrapper integration
* IDE compatibility

### Spring Boot Foundation

Spring Boot was configured as the primary application framework to provide:

* Dependency Injection
* Application Configuration Management
* Embedded Runtime Support
* Auto Configuration
* Enterprise Service Development Capabilities

This establishes the framework responsible for orchestrating all future application components.

### Persistence Infrastructure

Database support was introduced through:

* Spring Data JPA
* H2 Database

The persistence layer establishes the foundation for:

* Transaction storage
* Account validation
* Data access abstraction
* Entity lifecycle management
* Repository-driven database interaction

### Event Streaming Foundation

Apache Kafka support was integrated to establish an event-driven communication model.

A dedicated application topic was configured:

```yaml
general:
  kafka-topic: trader-updates
```

This topic will serve as the primary entry point for transaction-related events throughout the remainder of the project.

### Testing Infrastructure

A dedicated testing environment was established using:

* Spring Boot Test
* Spring Kafka Test
* Testcontainers Kafka

This configuration enables isolated, repeatable, and production-inspired testing workflows without requiring external infrastructure dependencies.

### Build Validation

Following dependency integration and configuration, the application lifecycle was validated through:

* Dependency resolution
* Project compilation
* Application startup verification
* Automated test execution

Successful validation confirmed that the development environment is fully operational and ready for implementation of business logic in subsequent phases.

---

## Phase 2 — Event-Driven Transaction Ingestion & Kafka Integration

With the foundational infrastructure successfully established, the next phase focused on introducing an event-driven communication model capable of supporting high-volume financial transaction workflows. Rather than allowing transaction producers and backend services to communicate directly, the architecture was extended with Apache Kafka, creating a resilient messaging layer that separates event generation from event processing.

In modern financial platforms, transaction traffic is rarely predictable. User activity, market fluctuations, batch operations, and system integrations can generate sudden bursts of events that would quickly overwhelm a tightly coupled architecture. To address this challenge, Midas Core adopts a message-driven approach where transactions are first published to a distributed event stream before being consumed and processed by backend services.

This architectural transition represents a significant milestone in the evolution of the platform, transforming the application from a static backend scaffold into an actively event-driven transaction processing service.

### Why Kafka?

Apache Kafka was selected as the messaging backbone due to its proven ability to handle large-scale event streams while maintaining reliability, durability, and horizontal scalability.

Introducing Kafka provides several important architectural advantages:

* **Service Decoupling** — Transaction producers and consumers can evolve independently without introducing direct dependencies between systems.
* **Asynchronous Processing** — Events can be stored and processed independently of the rate at which they are produced, improving resilience during traffic spikes.
* **Scalability** — Multiple producers and consumers can interact with the same event stream, simplifying horizontal scaling strategies.
* **Fault Tolerance** — Events remain available within the broker even when downstream services experience temporary interruptions.
* **Operational Flexibility** — Future services can subscribe to the same transaction stream without requiring changes to existing producers.

By introducing a dedicated messaging layer, the platform establishes a foundation capable of supporting significantly more sophisticated transaction workflows in future development phases.

### Event Ingestion Architecture

The newly implemented ingestion layer enables Midas Core to subscribe to transaction events published to a Kafka topic and transform those events into strongly typed domain objects suitable for application-level processing.

The resulting communication workflow follows the architecture below:

```text
External Transaction Producer
                │
                ▼
      ┌─────────────────────┐
      │    Apache Kafka     │
      │   trader-updates    │
      └──────────┬──────────┘
                 │
                 ▼
      ┌─────────────────────┐
      │  Kafka Listener     │
      │ Transaction Consumer│
      └──────────┬──────────┘
                 │
                 ▼
      ┌─────────────────────┐
      │ Transaction Domain  │
      │      Object         │
      └─────────────────────┘
```

This architecture ensures that every transaction entering the system first passes through a centralized event stream before becoming available to downstream business processes.

### Kafka Consumer Implementation

A dedicated Spring Kafka listener was implemented to subscribe dynamically to the configured transaction topic defined within the application configuration.

```yaml
general:
  kafka-topic: trader-updates
```

By externalizing topic management through configuration, the application remains environment-agnostic and avoids hardcoded infrastructure dependencies.

The listener is responsible for receiving every transaction event published to the configured topic and converting the incoming payload into the platform's Transaction domain model. Each transaction contains the information required to support future validation and processing workflows, including sender identifiers, recipient identifiers, and transaction amounts.

### Serialization & Domain Mapping

Message-driven architectures require a standardized mechanism for transmitting structured data across distributed systems. To facilitate this, JSON serialization and deserialization were integrated into the Kafka messaging pipeline.

The event lifecycle now follows the flow:

```text
Transaction Object
        │
        ▼
JSON Serialization
        │
        ▼
Apache Kafka Event Stream
        │
        ▼
JSON Deserialization
        │
        ▼
Transaction Object
```

This process ensures that complex domain objects can be transmitted reliably through Kafka while preserving type safety and application-level consistency.

### Validation & Testing

To verify the correctness of the implementation, the consumer pipeline was tested using the embedded Kafka infrastructure provided within the project scaffold.

Validation confirmed:

* Successful topic subscription and consumer initialization.
* Reliable consumption of transaction events from Kafka.
* Accurate deserialization of incoming event payloads.
* Correct conversion of event data into Transaction domain objects.
* Successful execution of automated integration tests.

Sample transaction events successfully consumed during verification included:

```text
Transaction {senderId=6, recipientId=7, amount=122.86}
Transaction {senderId=5, recipientId=2, amount=42.87}
Transaction {senderId=7, recipientId=4, amount=161.79}
Transaction {senderId=8, recipientId=7, amount=22.22}
```

### Engineering Outcome

The completion of this phase establishes the first operational processing layer within the Midas Core ecosystem. The platform is now capable of receiving and interpreting transaction events through a distributed messaging architecture, laying the groundwork for the next stages of development involving transaction validation, account verification, persistence management, balance reconciliation, and end-to-end financial transaction processing.

With asynchronous event ingestion now fully operational, Midas Core possesses the messaging infrastructure necessary to evolve into a scalable, production-inspired financial transaction processing platform.

---

# Phase 3 — Transaction Validation, H2 Persistence & Financial Processing Engine

## Objective

With asynchronous message ingestion successfully established through Apache Kafka, the next milestone was to transform Midas Core into a functional transaction processing engine capable of validating, persisting, and maintaining financial data integrity.

Receiving transaction events alone is insufficient for any production-grade financial platform. Every transaction must first undergo strict business validation before modifying account balances or being permanently recorded within the system.

This phase introduces the persistence layer of the application by integrating an H2 in-memory relational database through Spring Data JPA and implementing the core business workflow responsible for processing financial transactions safely and consistently.

---

## Engineering Challenge

Each incoming Kafka event now represents a potential financial operation between two users.

Before any modification to the database is permitted, the application must guarantee that the transaction satisfies all predefined business constraints.

Every incoming transaction is validated against three mandatory conditions:

- The sender account must exist.
- The recipient account must exist.
- The sender must possess sufficient funds to complete the transfer.

If any validation fails, the transaction is immediately discarded without altering account balances or generating database records.

Only transactions satisfying every business rule are allowed to proceed through the processing pipeline.

This validation-first approach mirrors how real-world financial systems prioritize consistency, integrity, and protection against invalid state transitions.

---

## Solution Architecture

To support persistent financial processing, the application architecture was expanded beyond simple event consumption into a complete transactional workflow.

```text
                   Apache Kafka
                         │
                         ▼
            KafkaTransactionListener
                         │
                         ▼
                 DatabaseConduit
                         │
        ┌────────────────┴────────────────┐
        ▼                                 ▼
 UserRepository                 TransactionRepository
        │                                 │
        ▼                                 ▼
    UserRecord                 TransactionRecord
                │
                ▼
          H2 In-Memory Database
```

Rather than embedding business logic directly inside the Kafka listener, responsibility is delegated to a dedicated processing component.

This separation ensures that messaging infrastructure remains isolated from domain logic while improving maintainability, extensibility, and overall architectural clarity.

---

## Core Financial Processing Workflow

Every incoming transaction now follows a deterministic validation and persistence pipeline.

```text
Kafka Transaction Received
            │
            ▼
Deserialize Transaction
            │
            ▼
Locate Sender & Recipient
            │
            ▼
Validate User Existence
            │
            ▼
Validate Available Balance
            │
            ▼
Reject Invalid Transactions
            │
            ▼
Update Account Balances
            │
            ▼
Persist Updated Users
            │
            ▼
Create Transaction Record
            │
            ▼
Store Transaction History
```

This workflow ensures that financial state changes occur only after successful validation, preventing inconsistent account balances and preserving transactional correctness.

---

## Relational Data Modeling

To accurately represent financial transactions within a relational database, a dedicated `TransactionRecord` entity was introduced.

Unlike the Kafka `Transaction` object—which represents a transient message travelling through the event stream—the new entity models a permanent database record capable of maintaining relationships with participating users.

Each transaction maintains:

- A many-to-one relationship with the sender account.
- A many-to-one relationship with the recipient account.
- The transferred monetary amount.
- A unique generated identifier.

This normalized data model allows multiple transactions to reference the same user while preserving a complete and queryable transaction history.

---

## Business Validation Engine

The transaction processing engine now enforces the application's financial rules before committing any database changes.

Implemented validation logic includes:

- Verification of sender account existence.
- Verification of recipient account existence.
- Balance sufficiency checks before every transfer.
- Immediate rejection of invalid transactions.
- Prevention of unauthorized balance modifications.
- Guaranteed persistence only for valid financial operations.

This validation layer forms the foundation of the application's financial integrity model.

---

## Persistence Layer

Spring Data JPA repositories were introduced to abstract all database interaction.

Two dedicated repositories now manage the application's persistence layer:

| Repository | Responsibility |
|------------|----------------|
| UserRepository | Retrieves and updates account information |
| TransactionRepository | Persists validated financial transactions |

By leveraging Spring Data JPA, the application avoids manual SQL while maintaining a clean repository-driven architecture that can later be migrated to production-grade databases with minimal changes.

---

## Key Engineering Enhancements

During this phase, the platform gained several significant architectural capabilities:

- Integrated H2 as an embedded relational database for development and automated testing.
- Implemented Spring Data JPA persistence across user and transaction entities.
- Designed a normalized transaction data model using entity relationships.
- Developed the complete transaction validation engine.
- Implemented automated balance reconciliation for sender and recipient accounts.
- Persisted financial transaction history after successful validation.
- Extended the existing processing layer while preserving compatibility with the original project scaffold.
- Maintained a clear separation between event ingestion, business logic, and persistence responsibilities.

---

## Outcome

At the conclusion of this milestone, Midas Core evolves beyond an event consumer into a fully functional backend transaction processor.

The platform is now capable of:

- Receiving financial events through Apache Kafka.
- Validating every transaction against business rules.
- Rejecting invalid financial operations.
- Updating account balances atomically.
- Persisting users and transaction history within a relational database.
- Maintaining transactional consistency across the application.

This phase establishes the application's financial persistence layer and provides the architectural foundation required for future capabilities such as REST APIs, reporting services, transaction querying, audit trails, and production database integration.

---

## Repository Structure

```text
Midas-Core-Financial-Transaction-Engine
│
├── src
│   ├── main
│   │   └── java
│   │       └── com.jpmc.midascore
│   │
│   └── test
│       └── java
│           └── com.jpmc.midascore
│
├── pom.xml
├── application.yml
├── mvnw
└── mvnw.cmd
```

---

## Current Configuration

```yaml
general:
  kafka-topic: trader-updates
```

---

## Roadmap

### Completed

* Infrastructure Initialization
* Environment Provisioning
* Dependency Integration
* Kafka Configuration
* Testing Framework Setup
* Build Validation

### Upcoming

* Transaction Event Processing
* Business Rule Validation
* Persistence Layer Implementation
* Event Driven Workflow Integration
* REST API Exposure
* End-to-End System Validation

---

## Build & Execution

### Clone Repository

```bash
git clone https://github.com/SiddhaK17/Midas-Core-Financial-Transaction-Engine.git
```

### Build Project

```bash
./mvnw clean install
```

### Execute Test Suite

```bash
./mvnw test
```

### Run Application

```bash
./mvnw spring-boot:run
```

---

## Engineering Focus Areas

This project explores several concepts commonly found in large-scale financial technology systems:

* Event-Driven Architecture
* Distributed Messaging
* Transaction Processing Systems
* Enterprise Java Development
* Service-Oriented Design
* Data Persistence Strategies
* Automated Integration Testing
* Backend Infrastructure Engineering

---

## Acknowledgements

Developed as part of the JPMorgan Chase Software Engineering Virtual Experience Program delivered through Forage.

The project serves as a practical exploration of backend engineering principles commonly employed within modern financial transaction processing platforms.
