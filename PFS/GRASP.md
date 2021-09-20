# GRASP Design Documentation

## Creator

How is The Creator Pattern used in this project analysis?

A class should be assigned the responsibility of instantiating another class object if one or more of the following conditions holds true:

- That class contains the class object.
- That class records the class object.
- That class closely uses the class object.
- That class holds the data necessary for creating the class object.

If we take a look at the class diagram related to the server side of the system, we see that the System class contains the Printer class. Therefore the System class instantiates the Printer object.

Another example is the ErrorHandler. Since the ErrorHandler records errors, it makes sense to make the ErrorHandler responsible for the Error object instantiation.

There are many more examples of the contains condition being met and object instantiation being used as a result of that.

## Information Expert

How is The Information Expert Pattern used in this project analysis?

The pattern Information Expert is a core principle in object design. How should responsibility be assigned between objects? The objects with all the information required to fulfill a responsibility should be responsible for fulfilling that responsibility. This pattern supports low coupling, another GRASP principle in object design.

Let us take a look at the responsibility of checking for missing recipients. The server side System class holds all recipients, therefore the system class is assigned the responsibility of checking for missing recipients.

## Low Coupling

If we see elements relying on or being connected to a lot of other elements, we call that high coupling. To achieve low coupling, we want the elements in our design to be as independent as possible and we want information flowing through as few objects as possible.

Let's take a look at the Printer and Template class. The printer class has been assigned the responsibility of printing documents needed by Evil Corp. The printer class relies on templates to know how it should style a sheet of paper. The printer is the only class that needs to know about the template class, therefore it is directly coupled to the printer class.

## Controller

A controller is an object controlling the flow of data between the User Interface and the rest of the system. The server does not have a user interface, but uses the printer to display its data.

The PlexoPuter however does use a user interface, but the system is too small for a dedicated controller to make sense. Therefore the System class acts as the controller.

## High Cohesion

An element with low cohesion has too many unrelated responsibilities. A system with High cohesion on the other hand has entrusted each responsibility to their own object or subsystem.

The system I have designed is lacking in this area. It does have some elements of responsibility delegation, like the printer object being responsible for printing and the errorHandler being responsible for selecting and passing errors. The System class however (in both systems) is very bloated and the responsibilities could have been delegated differently. For instance, it is possible to create a class with the responsibility of updating the system created and deleted at every cron and even that class could have been broken down into objects responsible for sending the fines and fetching the data.
