package java_uml;
import java.util.ArrayList;
import java.util.List;

class Professor{
    private int empId;
    private String name;
    private String officeNumber;
    private int ext;
    private List<Course> courseList=new ArrayList<Course>();

    Professor(){

    }
	public int getEmpId() {
		return this.empId;
    }
    public void addCourse(Course course){
        this.courseList.add(course);
    }

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOfficeNumber() {
		return this.officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}

	public int getExt() {
		return this.ext;
	}

	public void setExt(int ext) {
		this.ext = ext;
	}

	public List<Course> getCourseList() {
		return this.courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

}