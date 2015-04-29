# WebToolsAssignment2
Assignment 2 for the course "Web Development Tools and Methods (INFO 6250)"

Title - Java Servlet Application with Google Maps and Session Management

Objective: Learn how servlet applications are put together and build your own. Begin to get
comfortable with using external services (Google Maps) within your own applications.
Understand and use Session objects for session management/persisting state.
Requirements: The basic requirement is to create a web application that allows a user to
create new maps and then add locations to each map. Since we haven't discussed databases
for persistent storage, use session objects to store data across multiple server
request/response round trips (round trips result when creating a new map and adding a
location to a map). You might think binding objects to the ServletContext by name makes
more sense since they would be global instead of per-session when bound into the
HttpSession, but I'd like you to work with sessions here as a learning exercise. You could also
try binding to the context as it is the same idea as a learning exercise also. Your user
interface doesn't have to be exactly like this, just make sure you complete required features.
