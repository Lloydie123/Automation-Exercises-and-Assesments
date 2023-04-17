from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support.expected_conditions import visibility_of_element_located
from time import sleep

driver = webdriver.Edge()
driver.implicitly_wait(10)

# Locators and WebElements
driver.get("https://www.saucedemo.com/")

def findElement(by, value):
    return driver.find_element(by, value)

# Login Logo 
login_logo = findElement(By.CLASS_NAME, "login_logo")
print("Text of Logo:", login_logo.text)
# Username
username = findElement(By.ID, "user-name")
print("Text of Username Input:", username.get_attribute("value"))
# Login Button
login_button = findElement(By.ID, "login-button")
print("Text of Login Button :", login_button.text)

# Interacting with WebElements
# Input Username
username.send_keys("standard_user")
password_input = findElement(By.ID, "password")
# Input Password
print("Password input text:", password_input.get_attribute("value"))
password_input.send_keys("secret_sauce")
login_button.click()

# Display Inventory List
inventory_list = WebDriverWait(driver, 10).until(
    visibility_of_element_located((By.CLASS_NAME, "inventory_list"))
)
print("Inventory list text:", inventory_list.text)

# Locate title link, go to "inventory_details_name"
inventory_item = findElement(By.ID, "item_4_title_link")
inventory_item.click()

# Print details name
inventory_details_name = findElement(By.CLASS_NAME, "inventory_details_name")
print(inventory_details_name.text)

# Clicks add-to-cart button
btn_primary = findElement(By.CLASS_NAME, "btn_primary")
btn_primary.click()

# Clicks cart 
shopping_cart_link = findElement(By.CLASS_NAME, "shopping_cart_link")
shopping_cart_link.click()

# Locate the cart quantity
cart_quantity = findElement(By.CLASS_NAME, "cart_quantity")
print(cart_quantity.text)

# Close the browser
sleep(10)
driver.close()