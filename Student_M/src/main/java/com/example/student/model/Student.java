package com.example.student.model;



import jakarta.persistence.*;

@Entity
@Table(name = "StudentsM")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String roll_No;
    private String name;
    private String course;
    private String status;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRoll_No() {
		return roll_No;
	}
	public void setRoll_No(String roll_No) {
		this.roll_No = roll_No;
	}
	
	

    
}

