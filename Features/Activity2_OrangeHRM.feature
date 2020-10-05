@HRM_activity
Feature: Orange HRM Activities

Scenario: Create Vacancies 
	Given User is on Orange HRM the Login Page 
	When User Navigates to vacancies page and adds Job vacency
	Then Verify the vacancies was created

@HRM_activity	
Scenario: Create candidates 
	Given User is on Orange HRM the Login Page 
	When User Navigates to Candidates page and adds new Candidate
	Then Verify the Candidate was created

@HRM_activity
Scenario: Create multiple Employees
	Given User is on Orange HRM the Login Page
	When Create employee with following firstname and lastname
	|	FirstName	|	LastName	|
	|	FirstName21	|	LastName1	|
	|	FirstName31	|	LastName2	|
	|	FirstName41	|	LastName3	|
	Then Verify employee with following firstname and lastname
	|	FirstName	|	LastName	|
	|	FirstName21	|	LastName1	|
	|	FirstName31	|	LastName2	|
	|	FirstName41	|	LastName3	|

@HRM_activity
Scenario: Create multiple Vacancies
	Given User is on Orange HRM the Login Page
	When Create vacancies with following job tiltle vacancies and hiring manager
	|	Tiltle						|	Vacancies		|	HiringMGr		|
	|	Automation Test Engineer	|	Test Vacency41	|	Test Employee	|
	|	Automation Test Engineer	|	Test Vacency51	|	Test Employee	|
	|	Automation Test Engineer	|	Test Vacency61	|	Test Employee	|
	Then Verify vacancies with following job tiltle vacancies and hiring manager
	|	Tiltle						|	Vacancies		|	HiringMGr		|
	|	Automation Test Engineer	|	Test Vacency41	|	Test Employee	|
	|	Automation Test Engineer	|	Test Vacency51	|	Test Employee	|
	|	Automation Test Engineer	|	Test Vacency61	|	Test Employee	|