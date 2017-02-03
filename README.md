# scala-play2-messing
Messing about with scala play 2.5+

A simple scala project to Learn more about the Play framework.

Version 1
---------
Following the tutorial from the Guardian site just create a simple one page example

This should introduce handling simple GET / POST methods, have chosen User data but maybe need to think of a test domain so I can create an example 
application. list will be held in memory to begin with and be preloaded with dummy data eventually it should be persistant somehow
MongoDB ? simple flat file? 

Version 2
---------
Look to introduce something like Twitter bootstrap to front end


Goals 
------

make simple CRUD webservice in a few stages:-

1) Have a simple domain object of say Forename, Surname, DOB

2) Create a form / page for creating domain object, have a simple Service for saving domain object, using say a collection eg List for storage rather than a db

3) Create a 2nd page for list all created domain object say in a table, with a back buton

4) Extract service into its own microservice with a REST endpoint that takes a JSON payload and still store in a List, and also an endpoint that gets the list for display


Things to Add later = Logging, Metrics, Authentication , Role based Auth?, Token Based Auth for Standalone backend Service?:-

Authentication -> username password stored somewhere? Simple login form 

###Links

This tutorial was very useful but was using play 2.4
https://www.theguardian.com/info/developer-blog/2015/dec/30/how-to-add-a-form-to-a-play-application

Latest play docs 
https://www.playframework.com/documentation/2.5.x/ScalaForms



// routing http://stackoverflow.com/questions/15864957/dynamic-routes-on-play-framework-2-1-templates
https://dzone.com/refcardz/getting-started-play-framework