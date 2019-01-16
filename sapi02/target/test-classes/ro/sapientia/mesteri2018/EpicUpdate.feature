Feature: Check if the epic update works
	As Sapientia scrum tool user I want to be able to update an epic

   Scenario: UpdateFirstEpic
   Given I edit the scrum list's first epic
   When I enter "updatefirstnew" in  the title textbox and I push the update button
   Then I should get result "updatefirstnew" in new epics list