#SLogo Team 8 Design

###User Interface
Our user interface will be composed of several parts: a console for the user to enter commands, a prompt that displays error messages when the user inputs bad data, a Turtle Scene that displays the movements of the turtle, an area to set turtle properties, a menu panel to save and open SLogo files and create new SLogo files, an area displaying history of commands executed, and an area for displaying available variables and commands. The latter two components will be interactive, clickable text areas to easily input into the console. Below is a model of how we will design our user interface:

![This is cool, too bad you can't see it](SlogoUI.JPG "Main Screen")


###Design Considerations
One of our main design considerations includes communication between the front-end view and the back-end model. Ultimately, we decided that our Parser would act as part of our controller, since this is what we would need to parse commands in the console and translate into information for the Turtle movement and positions in the back-end. Then, we also considered how we would pass back information back from the model to the controller and then to update the view/GUI. We will have a separate class as part of the Controller package to handle this. We will also need to consider how we will design the back-end to execute user-inputted commands. We decided to include the abstract Commands class inside our controller package which will then be passed on to the turtle in the model.
