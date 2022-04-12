package ss6_ke_thua.bai_tap.PointMoveablePoint;

public class MoveablePoint extends Point {
    private float xSpeed=0.0f;
    private float ySpeed=0.0f;

    public MoveablePoint() {
    }

    public MoveablePoint(float x, float y,float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }

    public float[] getSpeed() {
        float arr[]=new float[2];
        arr[0]=getXSpeed();
        arr[1]=getYSpeed();
        return arr;
    }

    @Override
    public String toString() {
        return "MoveablePoint:" + super.toString()+ ",speed=(" + getSpeed()[0] + ", "+ getSpeed()[1]+")";
    }
    MoveablePoint move(){
        super.x+=xSpeed;
        super.y+=ySpeed;
        return this;
    }
}
