# Product Management Web Application

This is a simple **Java-based web application** for managing products. It allows an administrator to **add products**, **view a single product**, or **view all products** using JSP, Servlets, and an Oracle database.

---

## Features

1. **Add Product**
   - Enter product details: name, category, price, stock, added date, remarks.
   - Generates a **unique product ID** automatically.
   - Validates inputs:
     - Product name must be at least 2 characters.
     - Price must be greater than 0.
     - Stock cannot be negative.
     - Duplicate product (same name and added date) is not allowed.
   - On success, shows `success.html`, otherwise `error.html`.

2. **View Product**
   - Search by product name and added date.
   - Displays the details of the **specific product**.
   - If not found, shows a message: "No matching records exists! Please try again!"

3. **View All Products**
   - Displays all products in the database.
   - Shows a message `"No records available!"` if no products exist.

**Project Structure**

<img width="500" height="500" alt="image" src="https://github.com/user-attachments/assets/44d16d34-6d8d-48e0-b1dd-4642009a826c" />


**Output:**


<img width="250" height="250" alt="image" src="https://github.com/user-attachments/assets/655fbe76-5338-431d-afb2-46f421d336ae" />
<img width="250" height="250" alt="image" src="https://github.com/user-attachments/assets/99df11e8-2375-46e0-a844-e21a26b94151" />
<img width="250" height="250" alt="image" src="https://github.com/user-attachments/assets/1598ff83-82b7-437f-8303-5e5ad47863fa" />
<img width="250" height="250" alt="image" src="https://github.com/user-attachments/assets/8ab4572c-143a-4c92-b201-5075a60364a3" />
<img width="250" height="250" alt="image" src="https://github.com/user-attachments/assets/66012de6-10c0-4998-9b31-9f4c62fe2564" />
<img width="250" height="250" alt="image" src="https://github.com/user-attachments/assets/a7eb6702-c9d5-436d-82c3-5e933ff2cbdd" />
<img width="500" height="500" alt="image" src="https://github.com/user-attachments/assets/21312bb8-7612-47af-8f8f-85f794e4da35" />








