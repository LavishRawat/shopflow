# ShopFlow Roadmap

Learning Java by building an online-shop backend, one phase at a time, until it covers everything in a Java Developer job description: Core Java, SQL and Oracle, Spring Boot, REST APIs, caching, microservices and Kafka.

Tick each box (`[x]`) when you finish it. Total time: about 3 months.

| Phase | Focus | Time |
|---|---|---|
| 0 | Setup | 1 day |
| 1 | Core Java console app | 2–3 weeks |
| 2 | SQL + Oracle (JDBC) | 1 week |
| 3 | Spring Boot REST API | 2 weeks |
| 4 | Caching + first React UI | 1.5 weeks |
| 5 | Microservices | 2 weeks |
| 6 | Kafka + event-driven | 2–2.5 weeks |
| 7 | Production-readiness | 1 week |
| 8 | CI/CD + polish | 3–4 days |

## Phase 0 — Setup (1 day)
- [ ] Install Homebrew, Java 21 (Temurin), Maven and IntelliJ IDEA
- [ ] Open `console-app` in IntelliJ and run `Main`
- [ ] Set your Git name and email, and make your first commit
- [ ] Create a free GitHub account and push this repo as a public repo
- Later: Docker Desktop and DBeaver (Phase 2), Bruno (Phase 3), Node.js (Phase 4)

## Phase 1 — Core Java console app (2–3 weeks)
Work in `console-app/` and follow [console-app/EXERCISES.md](console-app/EXERCISES.md).
- [ ] Basics: data types, control flow, methods, arrays, Strings
- [ ] OOP: classes, encapsulation, inheritance, polymorphism, abstraction, interfaces, `equals`/`hashCode`
- [ ] Collections and generics: `ArrayList`, `HashMap` (and how it works inside), `HashSet`, `TreeMap`, `PriorityQueue`
- [ ] Exceptions: checked vs unchecked, custom exceptions, try-with-resources
- [ ] Modern Java: lambdas, Streams, `Optional`, records, enums, sealed types, pattern matching in `switch`
- [ ] Design patterns: Strategy, Factory, Observer, Builder, Singleton
- [ ] Files with `java.nio.file`
- [ ] Concurrency: `ExecutorService`, race conditions, `synchronized`, atomics, locks, virtual threads
- [ ] JVM: JDK vs JRE vs JVM, heap vs stack, garbage collection, String pool
- [ ] JUnit tests
- [ ] **Done when:** 100 customers buying the last 5 items at once never oversell, and your cart has passing tests

## Phase 2 — SQL + Oracle (1 week)
Same `console-app/`, now saving to Oracle instead of files.
- [ ] Oracle Database Free running in Docker (`gvenzl/oracle-free`), viewed with DBeaver
- [ ] Tables `users`, `products`, `orders`, `order_items` with keys, constraints and indexes
- [ ] JDBC: `PreparedStatement`, transactions, connection pool (HikariCP)
- [ ] SQL practice: joins, `GROUP BY`/`HAVING`, subqueries, window functions, `EXPLAIN PLAN`
- [ ] Oracle specifics: sequences, `FETCH FIRST`, one PL/SQL procedure
- [ ] ACID, isolation levels, `SELECT ... FOR UPDATE`
- [ ] **Done when:** placing an order saves it and reduces stock in one transaction, and a failure halfway rolls everything back

## Phase 3 — Spring Boot REST API (2 weeks)
- [ ] Spring core: dependency injection, beans, profiles, `application.yml`
- [ ] REST endpoints: `/api/auth`, `/api/products`, `/api/cart`, `/api/orders`
- [ ] DTOs, validation, `@ControllerAdvice` error handling, pagination and sorting
- [ ] Spring Data JPA and Hibernate, the N+1 problem, `@Transactional`, Flyway
- [ ] Spring Security with JWT, USER and ADMIN roles
- [ ] Tests: Mockito, `@WebMvcTest`, `@SpringBootTest`, Testcontainers
- [ ] Swagger/OpenAPI docs; call every endpoint from Bruno or Postman
- [ ] **Done when:** register → log in → browse → order works through the API, with tests passing
- [ ] **Start applying for jobs**

## Phase 4 — Caching + first React UI (1.5 weeks)
- [ ] Redis cache: `@Cacheable`, `@CacheEvict`, TTL, invalidation, cache stampede
- [ ] Bonus: write an LRU cache with `LinkedHashMap`
- [ ] React app (Vite, JavaScript, MUI, Axios, React Router): login/register, product list, cart and checkout, admin
- [ ] CORS, JWT on every request, one error format, a "Place order" that can't create duplicates
- [ ] **Done when:** you can shop end-to-end in the browser, and the second product-list load skips the database

## Phase 5 — Microservices (2 weeks)
- [ ] Split into `api-gateway`, `user-service`, `product-service`, `order-service`, `inventory-service`, `payment-service`, `notification-service`
- [ ] One database schema per service
- [ ] Spring Cloud Gateway, Eureka, Config Server, OpenFeign
- [ ] Resilience4j: circuit breaker, retry, timeout, fallback
- [ ] Docker Compose for everything
- [ ] **Done when:** `docker compose up` starts it all, and stopping `inventory-service` doesn't crash `order-service`

## Phase 6 — Kafka + event-driven (2–2.5 weeks)
- [ ] Order flow as events: `OrderPlaced` → `StockReserved` → `PaymentCompleted`
- [ ] Topics, partitions, keys, consumer groups, offsets, KRaft
- [ ] Delivery guarantees, idempotent consumers, retries, dead-letter topics
- [ ] Saga with compensation (payment fails → stock released → order cancelled)
- [ ] Outbox pattern
- [ ] "My Orders" screen with live status through Server-Sent Events
- [ ] Optional: one flow with RabbitMQ, to compare
- [ ] **Done when:** an order placed in the browser reaches CONFIRMED live, and a forced payment failure shows CANCELLED and restores stock

## Phase 7 — Production-readiness (1 week)
- [ ] Correlation IDs in logs; tracing with Micrometer Tracing and Zipkin
- [ ] Actuator health checks; Prometheus and Grafana dashboard
- [ ] Load test with k6 or JMeter; tune indexes, cache and pools
- [ ] Rate limiting at the gateway
- [ ] **Done when:** you have a before/after performance number to quote

## Phase 8 — CI/CD + polish (3–4 days)
- [ ] GitHub Actions: build → test → Docker images
- [ ] Multi-stage Dockerfiles; React UI served by nginx
- [ ] Work tracked on a GitHub Projects board
- [ ] README: architecture diagram, one-command setup, screenshots or GIF, design decisions
- [ ] Demo video (Cmd+Shift+5, uploaded to YouTube as unlisted)
- [ ] **Done when:** a stranger can clone the repo and run everything with `docker compose up`

## Every day, alongside
- 1–2 DSA problems (NeetCode 150 or Striver's SDE Sheet)
- A bug diary: every bug you hit and how you fixed it
- After each phase, explain out loud what you built, why, and the trade-offs

## Free resources
- Java from zero: [java-programming.mooc.fi](https://java-programming.mooc.fi), [dev.java/learn](https://dev.java/learn/)
- Spring Boot: [spring.io/guides](https://spring.io/guides), [baeldung.com](https://www.baeldung.com)
- Kafka: [developer.confluent.io](https://developer.confluent.io) (Kafka 101)
- SQL: LeetCode "SQL 50"
- Video courses: freeCodeCamp on YouTube
