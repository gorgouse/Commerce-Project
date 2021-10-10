package xmt.item;

public class Person {

    public String beautiful = "789";

    public String argue;

    public String getBeautiful() {
        return beautiful;
    }

    public void setBeautiful(String beautiful) {
        this.beautiful = beautiful;
    }

    public String getArgue() {
        return argue;
    }

    public void setArgue(String argue) {
        this.argue = argue;
    }

    Person(){
//        this.speak();
//        this.walk();
    }

    private void speak(){
        System.out.println("我在说话");
    }

    public void walk(){
        System.out.println("我在走路");
    }
}
