Feature: CreteLead functionaliity for Leaftap application 


@Sanity
Scenario Outline: create lead with Multiple data 

When Enter the username as 'democsr2'
When Enter the password as 'crmsfa'
And click on Login
And Click on crmsfa link
And click on Leads
And Click on CreateLeads link
And Enter the company Name <companyName>
And enter the firstName <firstName>
And enter the LastName <lastName>
And click on Submit button
Then viewLeads page is displayed

Examples:
|companyName|firstName|lastName|
|Amazon|Roja|P|
|Siemens|Pooja|S|
