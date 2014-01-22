package edu.memphis.cardinal;
import java.util.Vector;


public class test {
	public static void main(String args[])
	{
		Dao dao=new Dao();
		
		Vector <Grade> grade=new Vector<Grade>();
		grade=dao.selectGrade(2);
		//grade=dao.selectGradeByUserName("yang");
		for(int i=0;i<grade.size();i++)
		{
			System.out.println(grade.get(i).getStudentID());
			System.out.println(grade.get(i).getStudentName());
			System.out.println(grade.get(i).getCourseID());
			System.out.println(grade.get(i).getCourseName());
			System.out.println(grade.get(i).getGrade());
			System.out.println(grade.get(i).getStatus());
		}
		/*dao.comfirmGrade(1,1, 0);
		grade=dao.selectGrade(1);
		for(int i=0;i<grade.size();i++)
		{
			System.out.println(grade.get(i).getStudentID());
			System.out.println(grade.get(i).getStudentName());
			System.out.println(grade.get(i).getCourseID());
			System.out.println(grade.get(i).getCourseName());
			System.out.println(grade.get(i).getGrade());
			System.out.println(grade.get(i).getStatus());
		}*/
	}

}
