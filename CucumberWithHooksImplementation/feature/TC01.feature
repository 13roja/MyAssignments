Feature: Login functionality of Leaftaps Application


@functional
Scenario: Login with positive credentials

And Enter the username as 'democsr2'
And Enter the password as 'crmsfa'
And click on login button
And Homepage is displayed
Then Close the browser

@Smoke
Scenario: Login with negative credentials

And Enter the username as 'democs'
And Enter the password as 'crmsf'
And click on login button
But Error message displayed
Then Close the browser