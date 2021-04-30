<style>
    th a {
        color: black;
        text-decoration: underline;
    }

    .review, .capstone, .matchmaking {
        background-color: #dddddd;
    }
</style>

# 14-week Full-Stack Bootcamp Curriculum

This repository contains all the modules for Tech Elevator's 14-week, full-stack web development bootcamp curriculum. 

Inside each module, you'll find a folder for each day of the module. Inside that day, you'll find the following folder structure:

* **lecture-notes:** The lecture notes used by instructors.
* **lecture-final:** The final lecture code that will be used by instructors.
* **lecture-student:** Any code or documentation needed for the student to go though the lecture.
* **tutorial-final:** The final solution for the tutorial.
* **tutorial-student:** Any code or documentation needed for the students to follow along with the tutorial.
* **exercise-final:** The final solution for the exercise that the students will go through.
* **exercise-student:** The starting code and documentation for student exercises.
* **exercise-pair:** Student pair-programming exercises.
* **review-final:** The final solution for weekly review exercises.
* **review-student:** The starting code and documentation for student weekly review exercises.

>**Note**: Any folder that ends with `-student` or `-pair` must be copied over to the campus-cohort-track (ex: CLE-Cohort-10-Java) repository.

## Module 1: Intro to Programming

Module 1 covers an introduction to either Java or C#, depending on the language track of the class. Included in the material are Datatypes, Expressions and Statements, Object-Oriented Programming Principles, Exception Handling, File I/O, and Testing using TDD.

[Module 1: Intro to Programming](module-1/)

## Module 2: Database Programming

The first two weeks of this module introduce SQL as a query language and then leverage C# and Java to issue SQL commands against databases.

The third and fourth weeks cover writing client-server applications using Web Services. This includes both implementing web service clients using either Java or C# and writing server-side code that implements a RESTful web service API.

[Module 2: Client-Server](module-2)

## Module 3: Web Applications

Module 3 covers an introduction to front-end web application development using HTML, CSS, and JavaScript. This includes the fundamentals of JavaScript and a framework called Vue.js that students can use to build applications.

[Module 3: Web Applications](module-3)

---

## 14-Week Syllabus
The following table describes the schedule of the curriculum. (**Note:** this table does not render through the Bitbucket web interface and is best viewed in VS Code)

<table>
    <tbody>
        <!-- MODULE 1 -->
        <!-- WEEK 1 -->
        <tr>
            <th rowspan="20" style="background-color: #00ADEE;"><a href="module-1/README.md">Module 1</a></th>
            <td rowspan="5">Week 1</td>
            <td>Day 1</td>
            <td>Introduction to Tools</td>
        </tr>
        <tr>
            <td>Day 2</td>
            <td>Variables and Datatypes</td>
        </tr>
        <tr>
            <td>Day 3</td>
            <td>Expressions, Statements, and Logical Branching</td>
        </tr>
        <tr>
            <td>Day 4</td>
            <td>Loops and Arrays</td>
        </tr>
        <tr>
            <td>Day 5</td>
            <td>Command-line Programs</td>
        </tr>
        <!-- WEEK 2 -->
        <tr>
            <td rowspan="5">Week 2</td>
            <td>Day 1</td>
            <td>Intro to Objects (Strings)</td>
        </tr>
        <tr>
            <td>Day 2</td>
            <td>Collections - Part 1</td>
        </tr>
        <tr>
            <td>Day 3</td>
            <td>Collections - Part 2</td>
        </tr>
        <tr>
            <td>Day 4</td>
            <td>Encapsulation</td>
        </tr>
        <tr class="review">
            <td>Day 5</td>
            <td>Review</td>
        </tr>
        <!-- WEEK 3 -->
        <tr>
            <td rowspan="5">Week 3</td>
            <td>Day 1</td>
            <td>Inheritance - Part 1</td>
        </tr>
        <tr>
            <td>Day 2</td>
            <td>Polymorphism</td>
        </tr>
        <tr>
            <td>Day 3</td>
            <td>Inheritance - Part 2</td>
        </tr>
        <tr>
            <td>Day 4</td>
            <td>Unit Testing</td>
        </tr>
        <tr class="review">
            <td>Day 5</td>
            <td>Review</td>
        </tr>
        <!-- WEEK 4 -->
        <tr>
            <td rowspan="5">Week 4</td>
            <td>Day 1</td>
            <td>Exception Handling & File I/O - Part 1</td>
        </tr>
        <tr>
            <td>Day 2</td>
            <td>File I/O - Part 2</td>
        </tr>
        <tr class="review">
            <td>Day 3</td>
            <td>Review</td>
        </tr>
        <tr class="capstone">
            <td>Day 4</td>
            <td>Capstone</td>
        </tr>
        <tr class="capstone">
            <td>Day 5</td>
            <td>Capstone</td>
        </tr>
        <!-- MODULE 2 -->
        <!-- WEEK 5 -->
        <tr>
            <th rowspan="20" style="background-color: #8CC63F;"><a href="module-2/README.md">Module 2</a></th>
            <td rowspan="5">Week 5</td>
            <td>Day 1</td>
            <td>Intro to SQL (SELECT, FROM, WHERE)</td>
        </tr>
        <tr>
            <td>Day 2</td>
            <td>Aggregate Functions and GROUP BY</td>
        </tr>
        <tr>
            <td>Day 3</td>
            <td>JOIN</td>
        </tr>
        <tr>
            <td>Day 4</td>
            <td>INSERT, UPDATE, DELETE</td>
        </tr>
        <tr class="review">
            <td>Day 5</td>
            <td>Review</td>
        </tr>
        <!-- WEEK 6 -->
        <tr>
            <td rowspan="5">Week 6</td>
            <td>Day 1</td>
            <td>Database Design</td>
        </tr>
        <tr>
            <td>Day 2</td>
            <td>DAO Pattern</td>
        </tr>
        <tr>
            <td>Day 3</td>
            <td>Integration Testing</td>
        </tr>
        <tr>
            <td>Day 4</td>
            <td>Data Security</td>
        </tr>
        <tr class="review">
            <td>Day 5</td>
            <td>Review</td>
        </tr>
        <!-- WEEK 7 -->
        <tr>
            <td rowspan="5">Week 7</td>
            <td>Day 1</td>
            <td>HTTP and Consuming APIs - Part 1</td>
        </tr>
        <tr>
            <td>Day 2</td>
            <td>Consuming APIs - Part 2</td>
        </tr>
        <tr>
            <td>Day 3</td>
            <td>Server-Side APIs - Part 1</td>
        </tr>
        <tr>
            <td>Day 4</td>
            <td>Server-Side APIs - Part 2</td>
        </tr>
        <tr class="review">
            <td>Day 5</td>
            <td>Review</td>
        </tr>
        <!-- WEEK 8 -->
        <tr>
            <td rowspan="5">Week 8</td>
            <td>Day 1</td>
            <td>Authentication</td>
        </tr>
        <tr class="review">
            <td>Day 2</td>
            <td>Review</td>
        </tr>
        <tr class="capstone">
            <td>Day 3</td>
            <td>Capstone</td>
        </tr>
        <tr class="capstone">
            <td>Day 4</td>
            <td>Capstone</td>
        </tr>
        <tr class="capstone">
            <td>Day 5</td>
            <td>Capstone</td>
        </tr>
        <!-- MODULE 3 -->
        <!-- WEEK 9 -->
        <tr>
            <th rowspan="20" style="background-color: #FFCB48;"><a href="module-4/README.md">Module 3</a></th>
            <td rowspan="5">Week 9</td>
            <td>Day 1</td>
            <td>Intro to HTML and CSS</td>
        </tr>
        <tr>
            <td>Day 2</td>
            <td>CSS Selectors & Layouts</td>
        </tr>
        <tr>
            <td>Day 3</td>
            <td>CSS Grid & Responsive Design</td>
        </tr>
        <tr>
            <td>Day 4</td>
            <td>CSS Flexbox</td>
        </tr>
        <tr class="review">
            <td>Day 5</td>
            <td>Review</td>
        </tr>
        <!-- WEEK 10 -->
        <tr>
            <td rowspan="5">Week 10</td>
            <td>Day 1</td>
            <td>Intro to Javascript</td>
        </tr>
        <tr>
            <td>Day 2</td>
            <td>Javascript Functions</td>
        </tr>
        <tr>
            <td>Day 3</td>
            <td>DOM</td>
        </tr>
        <tr>
            <td>Day 4</td>
            <td>Event Handling</td>
        </tr>
        <tr class="review">
            <td>Day 5</td>
            <td>Review</td>
        </tr>
        <!-- WEEK 11 -->
        <tr>
            <td rowspan="5">Week 11</td>
            <td class="matchmaking">Day 1</td>
            <td class="matchmaking">Matchmaking</td>
        </tr>
        <tr>
            <td>Day 2</td>
            <td>Intro to Vue</td>
        </tr>
        <tr>
            <td>Day 3</td>
            <td>Event Handling with Vue</td>
        </tr>
        <tr>
            <td>Day 4</td>
            <td>Component Communication</td>
        </tr>
        <tr class="review">
            <td>Day 5</td>
            <td>Review</td>
        </tr>
        <!-- WEEK 12 -->
        <tr>
            <td rowspan="5">Week 12</td>
            <td class="matchmaking">Day 1</td>
            <td class="matchmaking">Matchmaking</td>
        </tr>
        <tr>
            <td>Day 2</td>
            <td>Routing</td>
        </tr>
        <tr>
            <td>Day 3</td>
            <td>Calling Web Services (GET)</td>
        </tr>
        <tr>
            <td>Day 4</td>
            <td>Calling Web Services (PUT,POST,DELETE)</td>
        </tr>
        <tr class="review">
            <td>Day 5</td>
            <td>Review</td>
        </tr>
        <!-- FINAL CAPSTONE -->
        <!-- Week 13 - 14 -->
        <tr>
            <th style="background-color: #363E8B; color: white;">Final Capstone</th>
            <td>Week 13 - 14</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
    </tbody>
</table>
