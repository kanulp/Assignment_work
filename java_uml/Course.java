package java_uml;
import java.util.ArrayList;
import java.util.List;

class Course{

    private int courseID;
    private String description;
    private Professor professor;	
    private String courseName;
    private String dept;
    private int year;
    private char semester;
    private List<Student> studentList= new ArrayList<Student>();


	public List<Student> getStudentList() {
		return this.studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}


    public Course(){
    }

	//checking same course students with course id and counting average marks.
    public double getAverageMarksByCourseID(int courseID){
		int marks=0;
		int count=0;
        for (var st : this.studentList) {
			if(courseID==st.getCourse().getCourseID()){
				marks += st.getMarks();
				count++;
			}
        }
        return marks/count;
    }

    public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}


    public void addStudent(Student student){
        studentList.add(student);
    }

    public int studentCount(){
        return this.studentList.size();
    }

	public int getCourseID() {
		return this.courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public char getSemester() {
		return this.semester;
	}

	public void setSemester(char semester) {
		this.semester = semester;
	}


   





}