# ShopFlow Roadmap

ShopFlow is an order-management backend in Java, built in 21 days (Mon Oct 26 to Sun Nov 15, 2026) after a 3-day warm-up. Tick each box (`[x]`) when you finish it.

| Period | Dates | Hours per day |
|---|---|---|
| Warm-up | Fri Oct 23 to Sun Oct 25 | 2 (Fri), 4 (Sat, Sun) |
| Week 1 | Mon Oct 26 to Sun Nov 1 | 5 |
| Week 2 | Mon Nov 2 to Sun Nov 8 | 6 |
| Week 3 | Mon Nov 9 to Sun Nov 15 | 6 |

Rules: commit every day; if a day runs over, finish it on that week's Sunday instead of skipping it.

## Warm-up (not counted in the 21 days)
- [ ] **Fri Oct 23:** Java 21 is the default (`java -version`, `mvn -v`); Docker Desktop and Postman installed; `order-service` generated from start.spring.io (Maven, Java 21, Spring Web, Actuator); `GET /api/ping` returns 200; pushed to GitHub
- [ ] **Sat Oct 24:** Core Java refresh: collections, how `HashMap` works, exceptions, lambdas, streams, `Optional`, records. Solve 15 stream exercises in a `java-practice/` folder
- [ ] **Sun Oct 25:** Multithreading (`ExecutorService`, `CompletableFuture`, race conditions, `AtomicInteger`) and Maven basics (pom, scopes, lifecycle, wrapper)

## Week 1: order-service with JPA, PostgreSQL and tests
- [ ] **Day 1 (Mon Oct 26):** Spring Boot core (DI, beans, profiles); layered structure; Product CRUD with an in-memory list
- [ ] **Day 2 (Tue Oct 27):** PostgreSQL in Docker; Spring Data JPA; Product as an `@Entity`
- [ ] **Day 3 (Wed Oct 28):** Customer, Order, OrderItem relationships; lazy vs eager; N+1 fix; Flyway migrations
- [ ] **Day 4 (Thu Oct 29):** DTOs, `@Valid`, global error handler, pagination and sorting, Swagger UI
- [ ] **Day 5 (Fri Oct 30):** `POST /orders` in one transaction; JPQL; index + `EXPLAIN ANALYZE` on 10,000 seeded orders
- [ ] **Day 6 (Sat Oct 31):** JUnit 5 and Mockito unit tests; `@WebMvcTest` controller tests (15+ tests)
- [ ] **Day 7 (Sun Nov 1):** Testcontainers integration test; JaCoCo coverage; README run steps; buffer

## Week 2: security, Redis, Docker and CI/CD
- [ ] **Day 8 (Mon Nov 2):** Spring Security filter chain; register with BCrypt; 401 without a token
- [ ] **Day 9 (Tue Nov 3):** JWT login; ADMIN and CUSTOMER roles; `@PreAuthorize`; 401 and 403 tests
- [ ] **Day 10 (Wed Nov 4):** Redis cache with `@Cacheable` and `@CacheEvict`
- [ ] **Day 11 (Thu Nov 5):** `Idempotency-Key` on `POST /orders` stored in Redis; request id in every log line
- [ ] **Day 12 (Fri Nov 6):** Multi-stage Dockerfile; `docker-compose.yml` with app, PostgreSQL and Redis
- [ ] **Day 13 (Sat Nov 7):** GitHub Actions (build, test, image to GHCR); Jenkins in Docker with a `Jenkinsfile`
- [ ] **Day 14 (Sun Nov 8):** Revision and buffer

## Week 3: Kafka, microservices, monitoring and Kubernetes
- [ ] **Day 15 (Mon Nov 9):** Maven multi-module; Kafka in Compose (KRaft); `order-service` publishes `OrderPlaced`
- [ ] **Day 16 (Tue Nov 10):** `notification-service` consumes `OrderPlaced` and saves to MongoDB
- [ ] **Day 17 (Wed Nov 11):** Retries, dead-letter topic, idempotent consumer; Kafka Testcontainers test
- [ ] **Day 18 (Thu Nov 12):** `api-gateway` (Spring Cloud Gateway); `RestClient` call with a Resilience4j circuit breaker
- [ ] **Day 19 (Fri Nov 13):** Actuator, Prometheus and Grafana dashboard
- [ ] **Day 20 (Sat Nov 14):** Kubernetes basics with kind or minikube; deploy `order-service` and PostgreSQL
- [ ] **Day 21 (Sun Nov 15):** README with architecture diagram and screenshots; tag `v1.0`; 2-minute demo; resume bullets

## Repo layout by Nov 15
```
shopflow/
├── pom.xml                  (parent, from Day 15)
├── order-service/
├── notification-service/
├── api-gateway/
├── docker-compose.yml
├── Jenkinsfile
├── k8s/
└── .github/workflows/
```

## Tools
JDK 21 (Temurin), IntelliJ IDEA, Maven, Docker Desktop, Postman, TablePlus (PostgreSQL, Redis, MongoDB), Git and GitHub CLI.
