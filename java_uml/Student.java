package java_uml;
import java.util.ArrayList;
import java.util.List;

class Student{
    private int studentID;
    private double marks;
    private String studentName;
	private Course course;

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

    public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
    }
	
	


    public Student( int studentID,
    double marks,
    String studentName
){
    this.studentID=studentID;
    this.marks=marks;
    this.studentName=studentName;

    }

	

	public int getStudentID() {
		return this.studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	
	public double getMarks() {
		return this.marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
    }
    private String name;


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



    
}