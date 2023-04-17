from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver import Edge
from time import sleep
import time
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Chrome(ChromeDriverManager().install())

# Task 1 

driver.get("https://the-internet.herokuapp.com/")
# find the element by its text using XPath
element = driver.find_element(By.XPATH, "//*[contains(text(),'Welcome to the-internet')]")
# print the text of the element
print(element.text)
print("Task 1 is done")

# Task 2 
driver.get("https://the-internet.herokuapp.com/login")
username_field = driver.find_element(By.ID, "username")
username_field.send_keys("Jhon Lloyd")
print("TASK 2 done")

# Task 3 
driver.get("https://the-internet.herokuapp.com/")
footer = driver.find_element(By.ID, "page-footer")
print(footer.text)
print("TASK 3 done")

# Task 4
# # navigate to the website
driver.get("https://the-internet.herokuapp.com/")
# find all the links on the page and print their href attribute values
links = driver.find_elements_by_tag_name("a")
for link in links:
    print(link.get_attribute("href"))
print("TASK 4 done")

# Task 5
driver.get("https://the-internet.herokuapp.com/login")
username_field = driver.find_element(By.ID, "password")
username_field.send_keys("SuperSecretPassword!")
print("Task 5 is done")

# Task 6 
driver.get("https://the-internet.herokuapp.com/login")
login_button = driver.find_element(By.CLASS_NAME, "radius")
print(login_button.get_attribute("innerHTML"))

# login user
driver.get("https://the-internet.herokuapp.com/login")
username_field = driver.find_element(By.ID, "username")
username_field.send_keys("tomsmith")


password_field = driver.find_element(By.ID, "password")
password_field.send_keys("SuperSecretPassword!")


login_button = driver.find_element(By.CLASS_NAME, "radius")
login_button.click()

print("Task 6 is done")

time.sleep(10) # Delay for 10 seconds
driver.close()

