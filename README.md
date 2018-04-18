# HR App

HR App is a simple application that should serve as a tool for recruiters. 
It is a PIK semester project. 
The aim of the project is to learn how to produce applications for corporations. 
For this reason we will try to work out some rules and will try to stick to them.

## Getting Started

To get started just clone this repository : 
```
git clone https://github.com/pik694/HR_App
```
We develop this code using IntelliJ IDE, this is why we recommend doing so.

### Prerequisites


```
maven
IntelliJ
```

### Installing
TODO
A step by step series of examples that tell you have to get a development env running

## Running the tests
TODO
Explain how to run the automated tests for this system

## Deployment
TODO
Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Contributing

Please read [CONTRIBUTING.md](https://github.com/pik694/HR_App/blob/master/docs/CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Virtual machine

We have a virtual machine at our disposition. In order to connect to it please read [this file](https://github.com/pik694/HR_App/blob/master/docs/Tunneling%20to%20PIK10.md)

### Websites

Links work only from the inside of elka network.

* [http://pik10.ii.pw.edu.pl](http://pik10.ii.pw.edu.pl) - our application
* [http://jenkins.pik10.ii.pw.edu.pl](http://jenkins.pik10.ii.pw.edu.pl) - Jenkins
* [http://artifactory.pik10.ii.pw.edu.pl](http://artifactory.pik10.ii.pw.edu.pl) - Artifactory

VM's IP address ``192.168.162.230``

## System requirements

We use Github Issues to manage system requirements. All of them are properly labeled and can be found [here](https://github.com/pik694/HR_App/labels/functional%20requirement).

### User stories

User stories are maintained in the following file [user-stories.md](https://github.com/pik694/HR_App/blob/master/docs/user-stories.md) 

## System architecture

#### Used technologies 
Our system is a simple web application. <br/>
We use:
- __Spring MVC__ - framework  that fastens our controllers with requests from a client.
- __AngularJS__ - user interface on the client side
- __Hibernate__ - connection with the database
- __Tomcat__ - servlet engine
- __MariaDB__ - MySQL database
- __Nginx__ - talks with a web browser on port ``80``. Can be used as a load balancer. 

We use __Docker__ containers. One for DB and one for the server application itself.

#### Requests' flow
1. Client requests specific data or an action (eg. delete data)- request to Nginx server
1. HTTP server moves request to Tomcat
1. Tomcat, on behalf of, invokes method of a controller.
1. Controller requests data from its model.
1. Model processes the request.
1. Model talks to the db.
1. Model returns the answer all the way up.

## Authors

* **Bartosz Kołodziejski** - [BKolodziejski](https://github.com/BKolodziejski)
* **Daniel Bigos** - [bidzyyys](https://github.com/bidzyyys)
* **Piotr Żelazko** - [pik694](https://github.com/pik694)


See also the list of [contributors](https://github.com/pik694/HR_App/contributors) who participated in this project.

## License

TODO

