# 🧪 Assignment on JUnit

## 📘 Topic Name: JUnit Automation

This project contains two automated test cases implemented using **JUnit** and **Selenium WebDriver** in **Java**.  
The assignment focuses on automating a web form submission and scraping table data from a live website.

---

## 📂 Project Overview

### 🔹 #1. Automate Digital Unite Webform

**Website:**  
[https://www.digitalunite.com/practice-webform-learners](https://www.digitalunite.com/practice-webform-learners)

#### 🧭 Steps for Automation:
1. Input all required fields in the form (Name, Phone, Date, Email, Message, and Upload Document).  
2. Accept the terms checkbox.  
3. Submit reCAPTCHA.  
4. Click the **Submit** button.  
5. Assert that registration is successful by verifying the success message:  
   > “Thank you for your submission!”

#### 🧰 Technologies Used:
- Java  
- JUnit  
- Selenium WebDriver  
- ChromeDriver

#### 🖼️ Report Screenshot:
<img width="1288" height="645" alt="Screenshot 2025-10-31 145123" src="https://github.com/user-attachments/assets/eba58840-7fda-42d7-97f1-e526c3fe079a" />


#### 🎥 Demonstration Video:


https://github.com/user-attachments/assets/48c3a140-e37b-4ca3-a0a7-8e051333f949



---

### 🔹 #2. Scrape Table Data from DSE Website

**Website:**  
[https://dsebd.org/latest_share_price_scroll_by_value.php](https://dsebd.org/latest_share_price_scroll_by_value.php)

#### 🧭 Steps for Automation:
1. Navigate to the above URL.  
2. Extract and print all cell values from the table.  
3. Save all scraped data into a `text` file.  

#### 🧰 Technologies Used:
- Java  
- Selenium WebDriver  
- File Handling (I/O)  

#### 🖼️ Report Screenshot:
<img width="1032" height="596" alt="Screenshot 2025-10-31 183903" src="https://github.com/user-attachments/assets/d9199e0e-2a18-4937-9538-a0258a62489c" />


#### 🎥 Demonstration Video:


https://github.com/user-attachments/assets/a494e085-179f-4b1f-bb92-bacb1615742e



---

## ⚙️ How to Run the Project

### 🪜 Prerequisites:
- Java 17 or later  
- Gradle  

### 🏃 Steps to Execute:
1. Clone the repository:
   ```bash
   git clone https://github.com/Mashruran/Junit_Project
