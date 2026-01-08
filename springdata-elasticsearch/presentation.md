# Spring Data Elasticsearch
Powering Search with the Spring Data Programming Model

---

## Why Spring Data?
- Common programming model for data access
- Repository abstraction
- Convention over configuration
- Reduces boilerplate — increases productivity

---

## What is Elasticsearch?
- Distributed search and analytics engine
- Full-text search
- JSON documents
- High speed and scalability

---

## What is Spring Data Elasticsearch?
- Spring Data module for Elasticsearch
- Works with:
  - Repositories
  - Templates
  - Derived query methods
- Integrates naturally with Spring Boot

---

## Core Spring Data Concepts
| Concept         | Meaning                             |
|-----------------|-------------------------------------|
| @Document       | Marks an Elasticsearch index entity |
| Repository      | Interface for CRUD + queries        |
| Derived Queries | Methods generate queries            |
| Template API    | Lower-level control                 |

---

## Comparison vs Spring Data JPA
| Feature      | Spring Data JPA       | Spring Data Elasticsearch |
|--------------|-----------------------|---------------------------|
| Data Model   | Relational            | Documents                 |
| Query Type   | SQL / Structured      | Full-text search          |
| Transactions | Yes                   | No                        |
| Best Use     | Business Data & Rules | Search & Analytics        |

---

## Pros & Cons of Spring Data Elasticsearch
✅ **Pros**
- Familiar Spring Data model
- Less boilerplate
- Fast search performance
- Scales horizontally

⚠️ **Cons**
- No strong ACID transactions
- Requires cluster infra
- Mapping can break if schema drifts
- Debugging queries sometimes tricky

---

## When to Use It
**Great for:**
- Search bars & autocomplete
- E-commerce search
- Observability & logs
- Recommendation engines

**Avoid for:**
- Core financial systems
- Highly relational data
- Strong consistency needs

---

## Summary
- Spring Data standardizes data access
- Elasticsearch enables fast search
- Spring Data Elasticsearch combines both
- Best used alongside traditional databases