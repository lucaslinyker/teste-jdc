# teste-jdc

A Java console application for managing video games (CRUD operations) backed by an Oracle Database. The application uses the Data Access Object (DAO) pattern to separate data access logic from business logic.

---

## Tech Stack

- **Language:** Java 21
- **Build & Dependency Management:** Apache Maven
- **Database Driver:** Oracle JDBC Driver (`ojdbc11` v23.26.3.0.0)
- **Database:** Oracle Database Free (`container-registry.oracle.com/database/free:latest-lite` via Docker Compose)
- **Architecture:** DAO (Data Access Object) Pattern

---

## Requirements

Ensure you have the following installed locally:

- **JDK 21** or later
- **Apache Maven 3.8+**
- **Docker** and **Docker Compose** (for running the Oracle Database instance)

---

## Environment & Configuration

### Database Settings
Currently, database connection settings are configured in `src/main/java/br/com/lucas/games/factory/ConnectionFactory.java`:

- **Host:** `localhost`
- **Port:** `1521`
- **Service Name (SID):** `FREE`
- **User:** `C##DB_GAME_USER`
- **Password:** `426970`
- **JDBC URL:** `jdbc:oracle:thin:@localhost:1521:FREE`

Docker container environment variables configured in `docker-compose.yaml`:
- `ORACLE_PWD`: `4269701` (Oracle SYS/SYSTEM password)
- `APP_USER`: `C##DB_GAME_USER` (Application user)
- `APP_USER_PWD`: `42697` (Application user password)

> **TODO:**
> - [ ] Externalize database connection parameters (host, port, SID, user, password) to environment variables or an `application.properties`/`config.properties` file.
> - [ ] Sync the password in `ConnectionFactory.java` and `docker-compose.yaml`.

---

## Setup & Running

### 1. Start the Oracle Database
Start the Oracle Free database container using Docker Compose:

```bash
docker compose up -d
```

Wait until the container is healthy and ready to accept connections.

### 2. Initialize Database Schema
Connect to your Oracle database using SQL*Plus, SQL Developer, DBeaver, or another database client, and execute the SQL script located at `src/main/java/br/com/lucas/games/database/db.sql`:

```sql
CREATE SEQUENCE sq_tb_game
    START WITH 1
    INCREMENT BY 1
    NOCACHE;

CREATE TABLE tb_game (
    cd_game NUMBER(10) PRIMARY KEY,
    nm_game VARCHAR2(80) NOT NULL,
    nr_nota NUMBER(3,1),
    nr_ano NUMBER(4),
    dt_compra DATE,
    st_finalizado NUMBER(1) -- Oracle does not have boolean
);
```

### 3. Build the Project
Compile the application using Maven:

```bash
mvn clean compile
```

Package the application into a JAR:

```bash
mvn package
```

---

## Entry Points & Scripts

The application provides multiple CLI entry points located in `br.com.lucas.games.view`:

| Entry Point Class | Description | Run Command |
|---|---|---|
| `br.com.lucas.games.view.TestConnection` | Verifies database connection | `mvn exec:java -Dexec.mainClass="br.com.lucas.games.view.TestConnection"` |
| `br.com.lucas.games.view.RegisterView` | Interactive CLI to register a new game | `mvn exec:java -Dexec.mainClass="br.com.lucas.games.view.RegisterView"` |
| `br.com.lucas.games.view.ListView` | Lists all registered games | `mvn exec:java -Dexec.mainClass="br.com.lucas.games.view.ListView"` |
| `br.com.lucas.games.view.SearchView` | Searches for a game by ID | `mvn exec:java -Dexec.mainClass="br.com.lucas.games.view.SearchView"` |
| `br.com.lucas.games.view.UpdateView` | Updates an existing game's information | `mvn exec:java -Dexec.mainClass="br.com.lucas.games.view.UpdateView"` |
| `br.com.lucas.games.view.DeleteView` | Deletes a game by ID | `mvn exec:java -Dexec.mainClass="br.com.lucas.games.view.DeleteView"` |

### Common Maven Scripts / Commands
- `mvn clean compile` - Clean and compile source code.
- `mvn test` - Run automated tests.
- `mvn package` - Build project JAR file into `target/`.

---

## Tests

- Currently, there are no automated unit or integration test suites configured under `src/test/java`.
- Manual connection testing can be executed via `br.com.lucas.games.view.TestConnection`.

> **TODO:**
> - [ ] Add JUnit 5 and AssertJ dependencies to `pom.xml`.
> - [ ] Add unit tests for domain models (`Game`) and exception handling.
> - [ ] Add integration tests for `GameDAO` using Testcontainers (Oracle-XE / Oracle Free container) or an in-memory database (H2).

---

## Project Structure

```text
teste-jdc/
├── docker-compose.yaml         # Docker Compose configuration for Oracle Free DB
├── pom.xml                     # Maven project configuration and dependencies
├── README.md                   # Project documentation
└── src/
    └── main/
        └── java/
            └── br/com/lucas/games/
                ├── dao/
                │   └── GameDAO.java                      # Data access operations for Game
                ├── database/
                │   └── db.sql                            # DDL and seed scripts for Oracle DB
                ├── exception/
                │   └── EntidadeNaoEncontradaException.java # Entity not found exception
                ├── factory/
                │   └── ConnectionFactory.java            # JDBC connection manager
                ├── model/
                │   └── Game.java                         # Game domain model
                └── view/
                    ├── DeleteView.java                   # CLI view: Delete game
                    ├── ListView.java                     # CLI view: List games
                    ├── RegisterView.java                 # CLI view: Register new game
                    ├── SearchView.java                   # CLI view: Search game by ID
                    ├── TestConnection.java               # CLI view: Test DB connectivity
                    └── UpdateView.java                   # CLI view: Update game
```

---

## License

No license specified.

> **TODO:**
> - [ ] Add a license file (e.g., MIT, Apache 2.0).
