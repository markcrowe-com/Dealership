# Readme 
How to install and run the project.

## Requirements

1. MySQL 8.22
2. Apache Netbeans 12.1
3. Apache Tomcat Server  
4. Node.js x.xx
5. VS Code

## Install Database

Open assets/dealership.mysql

and run the scriupt in MysQL workbench

## Netbeans

Open Dealership.RestAPI.jsp as a project in NetBeans

Create a persistanceunit linkecd to the dATABASE

<div style="text-align: justify">See Dealership\Dealership.RestAPI.jsp\src\main\resources\META-INF\persistence.xml.sample as a n example template and asjust your username, password, port and database name accordiingly</div>

Clean and build
Run the project

## React.js

After cloning the projcet in the terminal enter, run once
 `npm install`

 To start the react app

 `npm start`


# React.js Build History
Open the repository in VS Code

Open a Terminal 

Run `npx create-react-app dealership.react`

This creates a directory 'dealership.react' for the react app and clones down the react javascript files

In the terminal `cd .\dealership.react\`