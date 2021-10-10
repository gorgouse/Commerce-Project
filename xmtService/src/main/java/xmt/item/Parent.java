package xmt.item;

public class Parent extends Person{
    public String father;

    public String mother;

    Parent(){
        work();
    }
    public void work(){
        System.out.println("我在工作");
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }
}
