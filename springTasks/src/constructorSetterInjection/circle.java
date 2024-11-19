package constructorSetterInjection;
public class circle implements shap {
    private double radius;
    private Draw2d d2;
    private Draw3d d3;
    public circle(){}
    public circle(Draw2d d2, Draw3d d3){
        this.d2 = d2;
        this.d3 = d3;
    }



    public void draw2dCircle (){
        d2.draw2dShap("circle");
}
public void draw3dCircle (){
        d3.draw3dShap("circle");
}
    @Override
    public  double getArea (){
        return Math.PI*radius*radius;
    }
}
