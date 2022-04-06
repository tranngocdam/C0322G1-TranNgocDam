package ss4_lop_doi_tuong_trong_java.bai_tap;
public class StopWatch {
    private long startTime;
    private long endTime;
    public StopWatch(){
        this.startTime=System.currentTimeMillis();
    }
    public long getStartTime(){
        return this.startTime;
    }
    public long getStopTime(){
        return this.endTime;
    }
    public void getStart(){
        this.startTime=System.currentTimeMillis();
    }
    public void getStop(){
        this.endTime=System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return (this.endTime-this.startTime);
    }

}
