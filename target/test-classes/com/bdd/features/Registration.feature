Feature: Registration and login into demowebshop

Scenario: Registring user account in webshop portal

Given user landed registration page "Demo Web Shop. Register"
Then click on the option male
And Enter the data for the below fields 
|firstname|lastname|emailid|password|confirmpassword|
|test1|test1|test_12345@test.in|1234567890|1234567890|
When click on the register button
Then validate the resgitration success msg
And click continue
Then validate current userinformation "test_12345@test.in"
And Logout the application
