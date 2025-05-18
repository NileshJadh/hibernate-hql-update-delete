# Hibernate CRUD Operations - Update and Delete

This project demonstrates the use of Hibernate ORM to perform update and delete operations on a database table (`students`) using HQL (Hibernate Query Language).

---

## **Overview**

- **Update Operation**: Updates a student's city in the database using their `sid`.
- **Delete Operation**: Deletes a student's record from the database using their `sid`.
- **HQL**: Uses Hibernate's query language for safe and efficient operations.
- **Entity Mapping**: The `Student` class is mapped to the `students` table in the database.

---

## **Technologies Used**

- Java
- Hibernate ORM
- JPA Annotations
- Relational Database (MySQL/PostgreSQL)
- Maven (optional)

---

## **How It Works**

1. **Entity Mapping**:
   - The `Student` entity is mapped to the `students` table using JPA annotations.

2. **Update Operation**:
   - The `LaunchUpdate` class contains an HQL query to update a specific student's city.
   - Uses parameterized queries for dynamic and secure data updates.

3. **Delete Operation**:
   - The `LaunchDelete` class contains an HQL query to delete a specific student record.
   - Also uses parameterized queries to enhance security.

4. **Transaction Management**:
   - Transactions are started, and queries are executed. If successful, the transaction is committed; otherwise, it is rolled back.

5. **Session Closure**:
   - Ensures the Hibernate session and session factory are closed to release resources.
