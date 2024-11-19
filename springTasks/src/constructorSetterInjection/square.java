package constructorSetterInjection;
public class square implements shap {
    private double length;

private Draw2d d2;
private Draw3d d3;
    @Override
    public double getArea() {
        return length*length;
    }
    public void drawSquare2d(){
            d2.draw2dShap("Square");
    }
    public void drawSquare3d(){
        d3.draw3dShap("Square");
    }

    public void setDrawSquare2d(Draw2d d2) {
        this.d2 = d2;
    }

    public Draw2d getDrawSquare2d() {
        return d2;
    }

    public void setDrawSquare3d(Draw3d d3) {
        this.d3 = d3;
    }

    public Draw3d getDrawSquare3d() {
        return d3;
    }
}
