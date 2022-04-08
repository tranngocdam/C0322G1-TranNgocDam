package ss6_ke_thua.bai_tap.PointMoveablePoint;

public class Point {
        protected float x =0.0f;
        protected float y =0.0f;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x, float y){
        this.x=x;
        this.y=y;
    }
    public float[] getXY(){
        float arr[]=new float[2];
        arr[0]=x;
        arr[1]=y;
        return arr;
    }

    @Override
    public String toString() {
        return "Point=("+ getXY()[0] +", " +getXY()[1]+")";
    }
}
