package oop.calc.dto;

public class CalcWithCounter1_1 {

    private long counter = 0;
    private final CalcWithOperator calc1;
    private final CalcWithCopy calc2;
    private final CalcWithExtends calc3;

    public CalcWithCounter1_1(CalcWithOperator calc){
        this(calc, null, null);
        System.out.println("asdasd");
    }

    public CalcWithCounter1_1(CalcWithCopy calc){
        this(null, calc, null);
    }

    public CalcWithCounter1_1(CalcWithExtends calc){
        this(null, null, calc);
    }

    private CalcWithCounter1_1(CalcWithOperator calc1, CalcWithCopy calc2, CalcWithExtends calc3){
        this.calc1 = calc1;
        this.calc2 = calc2;
        this.calc3 = calc3;
    }

    public double plus(double a, double b){
        this.counter++;
        if(this.calc1 != null){
            return this.calc1.plus(a, b);
        } else if(this.calc2 != null){
            return this.calc2.plus(a, b);
        } else {
            return this.calc3.plus(a, b);
        }
    }

    public double minus(double a, double b){
        this.counter++;
        if(this.calc1 != null){
            return this.calc1.minus(a, b);
        } else if(this.calc2 != null){
            return this.calc2.minus(a, b);
        } else {
            return this.calc3.minus(a, b);
        }

    }

    public double div(double a, double b){
        this.counter++;
        if(this.calc1 != null){
            return this.calc1.div(a, b);
        } else if(this.calc2 != null){
            return this.calc2.div(a, b);
        } else {
            return this.calc3.div(a, b);
        }
    }

    public double add(double a, double b){
        this.counter++;
        if(this.calc1 != null){
            return this.calc1.add(a, b);
        } else if(this.calc2 != null){
            return this.calc2.add(a, b);
        } else {
            return this.calc3.add(a, b);
        }
    }

    public double abs(double a){
        this.counter++;
        if(this.calc1 != null){
            return this.calc1.abs(a);
        } else if(this.calc2 != null){
            return this.calc2.abs(a);
        } else {
            return this.calc3.abs(a);
        }
    }

    public double power(double a, int b){
        this.counter++;
        if(this.calc1 != null){
            return this.calc1.power(a, b);
        } else if(this.calc2 != null){
            return this.calc2.power(a, b);
        } else {
            return this.calc3.power(a, b);
        }
    }

    public double sqrt(double a){
        this.counter++;
        if(this.calc1 != null){
            return this.calc1.sqrt(a);
        } else if(this.calc2 != null){
            return this.calc2.sqrt(a);
        } else {
            return this.calc3.sqrt(a);
        }
    }
}
