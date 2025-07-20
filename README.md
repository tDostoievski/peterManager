# Production Scheduling System

This is a Java desktop application designed to manage, schedule, and display production orders. It integrates data imported from an ERP system (MariaDB) and stores them in a local database. The application uses JavaFX for the graphical interface and Spring Boot for dependency injection. Maven is used for project management.

## Features

- ERP Order Import (planned): Load production orders such as OP number, product code, description, batch, load, and scheduled date from a local MariaDB server.
- Local Persistence: Orders are saved to a local database for independent tracking and updates.
- Interactive Table View: Displays a list of orders with editable fields like Status and Machine.
- Weekly Calendar View: Visual representation of scheduled orders by day and status.
- Real-time Update: User changes are immediately saved to the local database.

## Technology Stack

- Java 17
- JavaFX and FXML
- Spring Boot 3
- Spring Data JPA
- MariaDB (external database)
- SQLite or H2 (local database)
- Maven

## Project Structure


src/
├── config/                   # Database configurations
├── controller/               # JavaFX controllers and helper classes
├── dto/                      # Data Transfer Objects
├── javafx/                   # JavaFX application entry point
├── model/
│   ├── primary/              # Local database entities
│   └── secondary/            # ERP-imported entities
├── repository/
│   ├── primaryDataSource/    # JPA repositories for local data
│   └── secondaryDataSource/  # JPA repositories for ERP data
├── service/                  # Business logic and persistence
└── Main.java                 # Main Spring Boot class


## Database Configuration

The application connects to two databases:

- `ConfigPrimaryDb.java`: Configuration for the local database.
- `ConfigSecondaryDb.java`: Configuration for the ERP (MariaDB) database.

Each configuration defines its own `EntityManagerFactory` and `TransactionManager`.


## Data Flow

1. Data is imported from the ERP system (`ProdutoExterno`) — **to be tested**.
2. It is converted into a DTO using `PedidosHelper`.
3. The data is stored locally as `ProdutoLocal`.
4. Orders are displayed in a table and calendar layout.
5. Any updates made via the interface are saved to the local database.

## Next Steps

- Test database import from ERP (MariaDB)
- Add filtering by status and machine
- Enable schedule export to Excel or Power BI
- Improve UI for inline editing and feedback
- Integrate barcode scanning for tracking (planned)

## Author

Developed by Matheus Fagundes as part of a real-world production planning system for a pigment manufacturing facility.