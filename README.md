# Petshelter
 
Hello There!

This is a Pet shelter.

I decided to make this project after some thoughts in the enterpreurship class. ahah:)
So the point of the project is to keep track of pets in the shelter.

For the project stucture I follewed next stucture:

entity -> dao -> service -> controller

In this case:

entity -> Pet
dao -> PetDao
service -> PetService
controller -> MainController


I did not make this project difficult since we have no ability to discuss it in person. I simplified project as much as possible.

Pet class is a concreate class that will show table it self as entity.

in PetDao you can see al the queries that is being executed after calling them from service class.
Connection to the database is made by Database class in the database package.


Since we do not have beans.xml we have to make the through anotations such as : @Component, @AutoWired, @Scope, @PreConstruct, @Value and etc.

Some classes are not beans such as entity.

PetService as it says, after caling DAO makes some logic in itself and returns them in console.
Controller is made for intercation.

I used a Facade to make main class clean.

in the facade we cll context and then we call al the functionality from the MainController.

# Note:
 The backup file is in the root called shelterBackup.sql. Please restore it in the pgadmin 4 and name database "shelter" please.









