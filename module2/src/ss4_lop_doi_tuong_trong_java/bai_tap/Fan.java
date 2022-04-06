package ss4_lop_doi_tuong_trong_java.bai_tap;

public class Fan {
        final int SLOW=1;
        final int MEDIUM=2;
        final int FAST=3;
        private int speed=SLOW;
        private boolean on = false;
        private double radius=5;
        private String color="blue";
        public Fan(){
        }
        public Fan(int speed, double radius, String color){
            this.speed=speed;
            this.radius=radius;
            this.color=color;
        }
        public int getSpeed() {
            return speed;
        }
        public void setSpeed(int speed) {
            this.speed = speed;
        }
        public void setOn(boolean on) {
            this.on = on;
        }
        public void setOff(boolean off){
            this.on = off;
        }
        public double getRadius() {
            return radius;
        }
        public void setRadius(double radius) {
            this.radius = radius;
        }
        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.color = color;
        }
        public String toString(){
        if (this.on) {
            return "quạt đang bật: " +
                    "speed=" + speed+
                    "     radius:" + radius+
                    "     color:"+ color +"\t";

        }else {
            return "quạt đang tắt: " +
                    "speed=" + speed+
                    "     radius:" + radius+
                    "     color:"+ color +"\t";

        }
    }
}
