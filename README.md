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
