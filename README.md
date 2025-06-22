🔐 Online Banking Management System (Web-Based)
Technologies Used: HTML, JSP, Servlets, Hibernate (with Annotations), MySQL
Type: Web Application

✅ Project Overview:
This project is a web-based online banking system designed using advanced Java technologies.
It allows users to securely manage their bank accounts with real-time interaction with the database using Hibernate ORM and Servlets. 
It is divided into two modules:

1. User Authentication Module
2.Account Management Module

🧑‍💼 Module 1: User Authentication (Security Layer)
This module ensures that only authenticated users can access banking services.

🔹 Features:
User Registration: New users can sign up.
Login Validation: Secure login using credentials stored in MySQL.
Forgot Password: Users can recover passwords.
Update Password: Change password functionality.
Delete Account: Remove user details from the database.
All operations are backed by Hibernate ORM using annotations (@Entity, @Id, @Column, etc.) for seamless mapping between Java classes and database tables.

🏦 Module 2: Account Management
Accessible only after successful login.
This module handles all banking transactions and account-related activities.

🔹 Features:
Open Account: Create new account with account type and initial balance.
Deposit Amount: Add money to user account.
Withdraw Amount: Withdraw funds with balance validation.
Balance Enquiry: Show current account balance.
Delete Account: Permanently close the bank account.
All services directly interact with the MySQL database using Hibernate for ORM and Servlets for controller logic.
JSP and HTML are used to design interactive frontend forms.
