/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author paditya
 *
 */
public class Student implements Serializable{
	
	private String studentFirstName;
	private String studentSecondName;
	private String studentDOB;
	private String studentBranch;
	
	public String getStudentFirstName() {
		return studentFirstName;
	}
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}
	public String getStudentSecondName() {
		return studentSecondName;
	}
	public void setStudentSecondName(String studentSecondName) {
		this.studentSecondName = studentSecondName;
	}
	public String getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(String studentDOB) {
		this.studentDOB = studentDOB;
	}
	public String getStudentBranch() {
		return studentBranch;
	}
	public void setStudentBranch(String studentBranch) {
		this.studentBranch = studentBranch;
	}
}
