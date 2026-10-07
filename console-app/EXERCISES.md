# Phase 1 — Core Java Exercises

You'll grow `Main.java` into a small shop that runs in the terminal. Each step teaches a few Java topics and adds one feature.

**How to work**
- Learn the topic first, then do the task. Good free sources: [java-programming.mooc.fi](https://java-programming.mooc.fi) (use its table of contents to find the topic) and [dev.java/learn](https://dev.java/learn/).
- Type the code yourself instead of copy-pasting. That's how it sticks.
- Commit to Git after every step.
- Stuck for more than 30 minutes? Ask Claude for a **hint**, not the answer. When a step is done, ask Claude to **review** your code.
- A "day" here means about 2–3 hours. Going slower is fine.

---

## Step 0 — Open the project and save it with Git
1. In IntelliJ: **File → Open…** → choose the `console-app` folder. If IntelliJ asks for a JDK, pick **temurin-21**.
2. In Terminal, inside the `shopflow` folder, run once:
   ```bash
   git config --global user.name "Your Name"
   git config --global user.email "you@example.com"
   git init
   git add .
   git commit -m "Start ShopFlow"
   ```
3. Later this week: make a free GitHub account, create a public repo called `shopflow`, and follow GitHub's instructions to push an existing repository.

## Step 1 — Your first program (Day 1)
**Learn:** what the JDK, the JVM and bytecode are (`.java` → `javac` → `.class` → JVM), the `main` method, `System.out.println`.

**Task:**
1. Open `src/main/java/com/shopflow/Main.java` and click the green ▶ next to `main`. You should see `Welcome to ShopFlow!`.
2. Change it to print this menu:
   ```
   === ShopFlow ===
   1. List products
   2. Add product
   0. Exit
   ```

**Done when:** your menu appears in IntelliJ's Run window.

## Step 2 — Read input and repeat (Days 2–3)
**Learn:** variables and primitive types (`int`, `double`, `boolean`, `char`), `String`, `if`/`else`, `while`, `switch`, reading input with `Scanner`.

**Task:** keep showing the menu until the user types `0`. For `1` and `2`, just print `Coming soon`. Anything else prints `Invalid choice`.

**Hint:** `new Scanner(System.in)` and `scanner.nextLine()`. Turn text into a number with `Integer.parseInt(...)`.

**Try this:** type `abc`. The program crashes. You'll fix that in Step 8.

**Done when:** the app only stops when you type `0`.

## Step 3 — Your first class: `Product` (Day 4)
**Learn:** classes vs objects, fields, constructors, `private` fields with getters (encapsulation), `toString()`.

**Task:** create a `Product` class with an id, name, price and stock quantity. In `main`, create three products and print them.

**Money tip:** run `System.out.println(0.1 + 0.2);` and look at the result. That's why money should use `BigDecimal`, not `double`.

**Done when:** printing a product shows something readable, like `#1 Laptop - ₹55,000.00 (12 in stock)`. (`String.format` can add the commas.)

## Step 4 — Many products: `ArrayList` (Days 5–6)
**Learn:** arrays vs `ArrayList`, generics (`List<Product>`), the for-each loop, packages.

**Task:**
1. Create a `ProductCatalog` class that keeps a `List<Product>` and has methods like `addProduct(...)` and `getAllProducts()`.
2. Menu option `1` lists all products. Option `2` asks for a name, price and stock, then adds the product. Ids are given out automatically: 1, 2, 3…
3. Organise your classes into packages: `com.shopflow.model` for data classes like `Product`, and `com.shopflow.service` for classes with logic like `ProductCatalog`.

**Why a separate class?** `Main` should only talk to the user (menu, input, output). The shop's logic lives in other classes. You'll keep this split all the way to Spring Boot.

**Done when:** you can add a product and see it in the list.

## Step 5 — Fast lookups and the collections family (Days 7–8)
**Learn:** `HashMap` (key → value), why looking up by key is fast (O(1)) while searching a list is slow (O(n)), `equals()` and `hashCode()`, and how `HashMap` works inside (a top interview question). Also `HashSet`, `TreeMap` and `PriorityQueue`.

**Task:**
1. Change `ProductCatalog` to store products in a `Map<Integer, Product>` keyed by id.
2. Add a menu option **Find product by id**. An unknown id prints `Product not found`.
3. Use a `HashSet` to reject a new product whose name already exists, ignoring upper/lower case.
4. Add a menu option **List products A–Z** using a `TreeMap` keyed by name.

**Done when:** all four work, and you can explain what happens inside a `HashMap` when you call `put`.

## Step 6 — Cart and orders (Days 9–10)
**Learn:** objects that contain other objects, `record`, `enum`, `LocalDateTime`.

**Task:**
- `CartItem`: a `record` holding a product and a quantity
- `Cart`: add an item, remove an item, get the total price
- `OrderStatus`: an `enum` with `PLACED`, `PAID`, `CANCELLED` (Phase 6 adds more)
- `Order`: id, items, total, status, time created
- New menu options: **Add to cart**, **View cart**, **Place order**, **My orders**. Placing an order reduces stock and empties the cart.

**Done when:** you buy two different products and see the order, with the right total, under **My orders**.

## Step 7 — Your first tests (Day 11)
**Learn:** why tests matter, JUnit (`@Test`, `assertEquals`, `assertTrue`), the arrange–act–assert pattern. This project uses JUnit 6, which you write exactly like the "JUnit 5" in tutorials and interviews.

**Task:** create a `CartTest` class under `src/test/java/com/shopflow/`, in the same package as `Cart`, with tests for:
- an empty cart's total is 0
- adding 2 × ₹100 gives ₹200
- removing an item lowers the total

Run a test with the green ▶ next to it, or run all tests in Terminal with `mvn test`.

**Hint:** compare `BigDecimal`s with `compareTo`, not `equals`. Find out why; it's a classic gotcha.

**Done when:** all tests are green. From now on, add a test whenever you add logic.

## Step 8 — Handle errors properly (Day 12)
**Learn:** `try`/`catch`/`finally`, checked vs unchecked exceptions, writing your own exception.

**Task:**
1. Create `OutOfStockException`. Throw it when someone adds more of a product than is in stock. The menu catches it and prints a friendly message. Decide whether it should be checked or unchecked, and be ready to explain why.
2. Typing `abc` at the menu must no longer crash the app.
3. Add a test using `assertThrows`.

**Done when:** nothing a user types can crash the app.

## Step 9 — Streams, lambdas and `Optional` (Days 13–14)
**Learn:** lambdas, method references, `Comparator`, the Stream API (`filter`, `map`, `sorted`, `collect`, `groupingBy`), `Optional`.

**Task:** add a **Reports** menu showing:
- products sorted by price, cheapest first
- products with fewer than 5 in stock
- total money spent across all orders
- how many orders are in each status (`Collectors.groupingBy`)

Also change "find product by id" to return `Optional<Product>` instead of `null`.

**Done when:** every report uses streams, with no hand-written `for` loops.

## Step 10 — Interfaces and design patterns (Days 15–16)
**Learn:** interfaces vs abstract classes (and when to pick which), polymorphism, and the Strategy, Factory and Observer patterns. Read about Builder and Singleton too.

**Task:**
1. **Strategy:** a `DiscountStrategy` interface with three versions: no discount, 10% off, and ₹500 off orders above ₹5,000. Write a test for each.
2. **Factory:** `DiscountFactory.fromCoupon("SAVE10")` returns the right strategy. Ask for a coupon code when placing an order.
3. **Observer:** an `OrderListener` interface. When an order is placed, every listener is told. For example, one prints `Email sent to customer`, and another prints `Stock alert` when a product drops below 5.

**Why Observer matters:** "something happened, so others react" is exactly how Kafka works in Phase 6.

**Done when:** adding a new discount type means adding one new class, without editing `Cart` or `Order`.

## Step 11 — Payment methods: sealed types (Day 17)
**Learn:** sealed interfaces, records, and pattern matching in `switch` (modern Java 21 features).

**Task:** create `sealed interface PaymentMethod permits Card, Upi, CashOnDelivery`, each one a `record` (for example, `Card` holds the last 4 digits and `Upi` holds an ID like `name@bank`). When placing an order, ask how to pay, then use a `switch` with pattern matching to work out the fee: card 2%, UPI free, cash on delivery ₹50.

**Try this:** add a new payment type to the `permits` list without handling it in the `switch`. What does the compiler say?

**Done when:** the order summary shows the payment method and fee.

## Step 12 — Save to files (Day 18)
**Learn:** `Path` and `Files` from `java.nio.file`, try-with-resources, the CSV format.

**Task:** when the app exits, save products to `data/products.csv` and orders to `data/orders.csv` (one line per order item is easiest). Load them when the app starts.

**Hint:** `Files.readAllLines(...)`, `Files.write(...)`, `String.split(",")`.

**Done when:** you restart the app and your products and orders are still there.

## Step 13 — Multithreading: the last-item problem (Days 19–20)
**Learn:** threads, `ExecutorService`, race conditions, `synchronized`, `AtomicInteger`, `ReentrantLock`, `ConcurrentHashMap`, virtual threads. Read about `volatile` and `CompletableFuture` too.

**Task:** make a separate class `CheckoutSimulation` with its own `main`. A product has 5 in stock, and 100 customers each try to buy one at the same time through an `ExecutorService`. Count the successful sales.
1. Run it with no protection. You'll likely see more than 5 sales or negative stock. That's a race condition.
2. Fix it so exactly 5 succeed. Do it twice: once with `synchronized`, once with `AtomicInteger` or `ReentrantLock`.
3. Run it again with virtual threads: `Executors.newVirtualThreadPerTaskExecutor()`.

**Hint:** if the bug doesn't show up, add `Thread.sleep(1)` between checking the stock and reducing it.

**Done when:** every run gives exactly 5 sales, and you can explain why the first version oversold.

## Step 14 — How Java works inside (Day 21)
Be able to answer each of these in 2–3 sentences, using your own ShopFlow code as examples:
- JDK vs JRE vs JVM: what does `javac` produce?
- Stack vs heap: where do your `Product` objects live? Where do local variables live?
- Garbage collection: when does an old `Cart` get cleaned up?
- Why are `String`s immutable? What is the String pool?
- `==` vs `.equals()`
- `final`, `static`, and the four access levels
- Checked vs unchecked exceptions: which did you use, and why?
- What happens inside a `HashMap` on `put` and `get`?
- What is a race condition, and how did you fix yours?

**Done when:** you can answer all of them without notes. Then tick Phase 1 in `ROADMAP.md`. Next is Phase 2 (Oracle).
