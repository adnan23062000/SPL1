package sample;

public class ArrayList_Data {

    private String name;
    private double math, physics, ict, studyHour, gpa, cse101, discrete, calculus, sociology, se, stat;

    public ArrayList_Data(String name, double math, double physics, double ict, double studyHour, double gpa, double cse101, double discrete, double calculus, double stat, double sociology, double se) {
        this.name = name;
        this.math = math;
        this.physics = physics;
        this.ict = ict;
        this.studyHour = studyHour;
        this.gpa = gpa;
        this.cse101 = cse101;
        this.discrete = discrete;
        this.calculus = calculus;
        this.stat = stat;
        this.sociology = sociology;
        this.se = se;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMath() {
        return this.math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysics() {
        return this.physics;
    }

    public void setPhysics(double physics) {
        this.physics = physics;
    }



    public double getIct() {
        return ict;
    }

    public void setict(double ict) {
        this.ict = ict;
    }

    public double getStudyHour() {
        return studyHour;
    }

    public void setStudyHour(double studyHour) {
        this.studyHour = studyHour;
    }

    public double getGPA() {
        return gpa;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    public double getCSE101()
    {
        return this.cse101;
    }
    public double getDiscrete()
    {
        return this.discrete;
    }
    public double getCalculus()
    {
        return this.calculus;
    }
    public double getStat()
    {
        return this.stat;
    }
    public double getSociology()
    {
        return this.sociology;
    }
    public double getSe()
    {
        return this.se;
    }

}
