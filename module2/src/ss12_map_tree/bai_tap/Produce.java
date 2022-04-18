package ss12_map_tree.bai_tap;

public class Produce {
    private String id;
    private String nameProduce;
    private double giaCa;

    public Produce() {
    }

    public Produce(String id, String nameProduce, double giaCa) {
        this.id = id;
        this.nameProduce = nameProduce;
        this.giaCa = giaCa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameProduce() {
        return nameProduce;
    }

    public void setNameProduce(String nameProduce) {
        this.nameProduce = nameProduce;
    }

    public double getGiaCa() {
        return giaCa;
    }

    public void setGiaCa(double giaCa) {
        this.giaCa = giaCa;
    }

    @Override
    public String toString() {
        return "Produce{" +
                "id='" + id + '\'' +
                ", nameProduce='" + nameProduce + '\'' +
                ", giaCa=" + giaCa +
                '}';
    }
}
