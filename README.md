# Git-API
## 1. Introduction
This API provides all user repositories whith repo name, login, array of all branches and commit sha of every branch only for non fork 
repo https://api.github.com/users/{username}/repos. Before returning data to user application does some manipulation with fetched data.
Then provides consumer only requested data.
***
## 2. Installation
In order to install this app please click "Code" button and copy link. Then open any IDE which supports Java. Choose clone and put the given link.
project folder will be initialzed. Then open **"gitApi\src\main\java\com.gitApi"** folder and run GitApiApplication.java file.
Before running it make sure that JDK installed on given machine. 
After successful running you will see this nformatin on the terminal, see below:
![Снимок экрана (3)](https://user-images.githubusercontent.com/57500808/234324060-e5001060-05c8-4dda-bfa8-b5787191503a.png)
***
## 3. Usage
Above java file will run local server on Tomcat, and by default it runs on port:8080. Base url of this api is "api/repositories/". With port number it  is **http://localhost:8080/api/repositories/**. 
***
## 4. Endpoints
Below on the schema you can see  method and endpoint with exampels. 
-{username} is github user login;
Example: 
http://localhost:8080/api/repositories/nyu , on the Header insert Key: 'Accept', Value: 'application/json'

**nyu** is user who has 3 repos with several branches, and only 2 of them are non forked, so we need to see 2 repos in array
  ![Снимок экрана (6)](https://github.com/TemirlanBasitov/Git-API/assets/57500808/b1c12d0a-374e-4f59-848f-9b9ef5808853)
  
  
And here is result:
  Two repos with array of branches:
  ![Снимок экрана (7)](https://github.com/TemirlanBasitov/Git-API/assets/57500808/9a4ad645-1660-4f53-b0e0-927c5c77b04f)
  
## 5. Error handling
Applcation checks correctness of Header and accepts only application/json type. Below  you can see incorrect input and error messages.
for incorrect username it respond with 404 error, for incorrect media type it shows 406 error with message
Error example 1:
Pay attention for the username 

![Снимок экрана (8)](https://github.com/TemirlanBasitov/Git-API/assets/57500808/bcaa50ff-c033-4e7e-a461-1d571e0c5f58)

Error example 2: 
Pay attention for the Header

![Снимок экрана (9)](https://github.com/TemirlanBasitov/Git-API/assets/57500808/6cfe893d-dd0f-450c-942b-7a1dfa6e84f1)

