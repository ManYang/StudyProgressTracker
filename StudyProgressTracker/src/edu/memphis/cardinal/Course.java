package edu.memphis.cardinal;

public class Course {
	
	String number;
	String name;
	String grade;
	String prereq;
	String dept;
	
	public Course(String num, String nam, String g, String p)
	{
		number = num;
		name = nam;
		grade = g;
		prereq = p;
	}
	
	public Course(String num, String nam, String g, String p, String d)
	{
		number = num;
		name = nam;
		grade = g;
		prereq = p;
		dept = d;
	}
	
	public String[] getInfo()
	{
		String[] ret = {number, name, grade, prereq, dept};
		return ret;
	}
	
	public String[] getBasicInfo()
	{
		String[] ret = {number, name, prereq, dept};
		return ret;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getNumber()
	{
		return number;
	}
}
