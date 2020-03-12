/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class objectList {
    
    private String name;
    private double math, physics, ict;

    public objectList(String name, double math, double physics, double ict) {
        this.name = name;
        this.math = math;
        this.physics = physics;
        this.ict = ict;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }
    
    public double getPhysics() {
        return physics;
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
    
}
