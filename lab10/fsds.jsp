<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details</title>
    <style>
        table {
            width: 50%;
            border-collapse: collapse;
            margin: 20px auto;
        }
        table, th, td {
            border: 1px solid black;
            text-align: center;
            padding: 10px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2 style="text-align: center;">Student Details</h2>

    <%
        // Create a list to hold student details
        class Student {
            String name;
            int rollNumber;
            String course;

            Student(String name, int rollNumber, String course) {
                this.name = name;
                this.rollNumber = rollNumber;
                this.course = course;
            }

            public String getName() {
                return name;
            }

            public int getRollNumber() {
                return rollNumber;
            }

            public String getCourse() {
                return course;
            }
        }

        // Sample data
        List<Student> students = new ArrayList<>();
        students.add(new Student("John Doe", 101, "Computer Science"));
        students.add(new Student("Jane Smith", 102, "Mathematics"));
        students.add(new Student("Michael Brown", 103, "Physics"));

    %>

    <table align="center">
        <tr>
            <th>Roll Number</th>
            <th>Name</th>
            <th>Course</th>
        </tr>
        <%
            // Display the student details in the table
            for (Student student : students) {
        %>
        <tr>
            <td><%= student.getRollNumber() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getCourse() %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
