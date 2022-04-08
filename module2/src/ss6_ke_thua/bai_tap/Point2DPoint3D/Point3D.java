package ss6_ke_thua.bai_tap.Point2DPoint3D;

public class Point3D extends Point2D{
    private float z=0.0f;
    public Point3D(){

    }
    public Point3D(float x, float y, float z){
        super(x, y);
        this.z=z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        this.setXY(x,y);
        this.z=z;
    }

    public float[] getXYZ() {
         float arr[]=new float[3];
        arr[0]=super.getX();
        arr[1]=super.getY();
        arr[2]=z;
         return arr;
    }

    @Override
    public String toString() {
        return "Point3D=["+getXYZ()[0]+", "+getXYZ()[1]+", "+getXYZ()[2]+']';
    }
}
