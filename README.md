## Introduction
This project will be a discovery of Springframework from a person who spends most of his time in the Front-end development landscape, wanting to discover **again** the horizon of wild-wilderness Back-end landscape via **Spring framework**.

It will start from the very beginning (**Bean factory** - although deprecated today) and going slowly up to the surface (**Spring Boot**).

The repo will be updated in a slow pace - **preferably one day at a time**.

### Setting up Spring framework on IntelliJ (CE)


Download the latest Spring Framework using this url - https://repo.spring.io/release/org/springframework/spring/ 

Choose the zip file and download it (in my case, it's spring-5.2.7.RELEASE-dist.zip). Once you unzipped it, you'll find a **libs** folder where it'll have all the JAR files of Spring framework.

```
- Create a new Java project
- Click File -> Project Structure
- Click Dependencies (right panel) and down there's '+' icon
- Click the '+' icon and choose *JAR or directories...' and select all the JAR files from the Spring lib folder

```
Reference: https://www.jetbrains.com/help/idea/spring-support.html

**Note**: I'm not using a *maven* project because the goal is to focus on the Spring framework and wanted to avoid introducing multiple technology (yeah concept of abstraction: avoid revealing unnecessary details!). However, there's the *pom.xml* file in this branch that you can refer to, if you're familiar (or interested) in building maven project (i.e. you don't want the hassle of following the steps to install Spring framework; rather you want maven to do it for you).

