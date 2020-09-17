package oop.calc.dto;

public class CalcWithCounter2 {

    private long counter = 0;
    private final CalcWithOperator calc1;
    private final CalcWithCopy calc2;

    public CalcWithCounter2(CalcWithOperator calc){
        this.calc1 = calc;
        this.calc2 = null;
    }

    public CalcWithCounter2(CalcWithCopy calc){
        this.calc1 = null;
        this.calc2 = calc;
    }

    public CalcWithCounter2(CalcWithExtends calc){
        this.calc1 = null;
        this.calc2 = null;
    }

    public double plus(double a, double b){
        this.counter++;
        if(this.calc1 != null){
            return this.calc1.plus(a, b);
        } else {
            return this.calc2.plus(a, b);
        }
    }

    public double minus(double a, double b){
        this.counter++;
        if(this.calc1 != null){
            return this.calc1.minus(a, b);
        } else {
            return this.calc2.minus(a, b);
        }
    }

    public double div(double a, double b){
        this.counter++;
        if(this.calc1 != null){
            return this.calc1.div(a, b);
        } else {
            return this.calc2.div(a, b);
        }
    }

    public double add(double a, double b){
        this.counter++;
        if(this.calc1 != null){
            return this.calc1.add(a, b);
        } else {
            return this.calc2.add(a, b);
        }
    }

    public double abs(double a){
        this.counter++;
        if(this.calc1 != null){
            return this.calc1.abs(a);
        } else {
            return this.calc2.abs(a);
        }
    }

    public double power(double a, int b){
        this.counter++;
        if(this.calc1 != null){
            return this.calc1.power(a, b);
        } else{
            return this.calc2.power(a, b);
        }
    }

    public double sqrt(double a){
        this.counter++;
        if(this.calc1 != null){
            return this.calc1.sqrt(a);
        } else {
            return this.calc2.sqrt(a);
        }
    }
}
