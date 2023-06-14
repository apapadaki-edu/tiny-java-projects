import java.util.ArrayList;

public class Accomondation {
    private String code;
    private int price;
    private double avg;

    public Accomondation(String code, int price, double avg){
        this.code = code;
        this.price = price;
        this.avg = avg;
    }
    public String getCode(){
        return this.code;
    }
    public int getPrice(){
        return this.price;
    }
    public static void main(String args[]){
        ArrayList<Accomondation> list = new ArrayList<>();
        ArrayList.add(new Accomondation("A",12,12.4));

    }

}

