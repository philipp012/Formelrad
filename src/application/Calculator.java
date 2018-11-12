package application;

import javax.print.DocFlavor;

/**
 * Berechnet das Formelrad
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
    private double current;
    private double tension;
    private double power;
    private double ressistence;

    public Calculator(double current, double tension, double power, double ressistence) {
        super();
        this.current = current;
        this.tension = tension;
        this.power = power;
        this.ressistence = ressistence;
    }

    public double getLeistung() {
        return current;
    }

    public double getSpannung() {
        return tension;
    }

    public double getStrom() {
        return power;
    }

    public double getWiderstand() {
        return ressistence;
    }

    @Override
    public String toString() {
        return "Calculator [leistung=" + current +
                ", spannung=" + tension +
                ", strom=" + power +
                ", widerstand=" + ressistence + "]";
    }

    public void calculate() {
        if (ressistence == 0){
            calculateRessistence(tension, current, power);
        }else if (current == 0){
            calculateCurrent(tension, power, ressistence);
        }else if(tension == 0){
            calculateTension(power, current, ressistence);
        }else if(power == 0){
            calculatePower(tension, current, ressistence);
        }
    }

    /* Hier die Methoden mit den Formlen hinzufügen
     */
    private void calculatePower(double tension, double current, double ressistence) {
        if (ressistence == 0) {
            power = tension * current;
        } else if (tension == 0) {
            power = ressistence * (current * current);
        } else {
            power = (tension * tension) / ressistence;
        }
    }

    private void calculateTension(double current, double power, double ressistence) {
        if (ressistence == 0) {
            tension = power / current;
        } else if (power == 0) {
            tension = ressistence * current;
        } else {
            tension = Math.sqrt(power * ressistence);
        }
    }

    private void calculateCurrent(double tension, double power, double ressistence) {
        if (power == 0) {
            current = tension / ressistence;
        } else if (ressistence == 0) {
            current = power / tension;
        } else {
            current = Math.sqrt(power / ressistence);
        }
    }

    private void calculateRessistence(double tension, double power, double current) {
        if (current == 0){
            ressistence = (tension * tension) / power;
    }else if (tension == 0){
            ressistence = power / (current * current);
        }else{
            ressistence = current * tension;
        }

}
}
