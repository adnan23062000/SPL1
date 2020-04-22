package sample;

public class ArrayList_Data {

    private String name;
    private double math, physics, ict, studyHour, gpa;

    public ArrayList_Data(String name, double math, double physics, double ict, double studyHour, double gpa) {
        this.name = name;
        this.math = math;
        this.physics = physics;
        this.ict = ict;
        this.studyHour = studyHour;
        this.gpa = gpa;
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



}
