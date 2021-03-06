Feature: Registration and login into demowebshop

Scenario: userlogin with authorized user

Given user in the loginpage
Then enter username "test14.test@test.com"
And enter password "1234567890" 
And click Login
Then Validate TitleofThePage "Demo Web Shop"
Then validate current userinformation "test14.test@test.com"

Scenario: userlogin with unauthorized user

Given user in the loginpage
Then enter username "test15.test@test.com"
And enter password "1234567890" 
And click Login
Then Validate TitleofThePage "Demo Web Shop"
Then validate current userinformation "test14.test@test.com"

