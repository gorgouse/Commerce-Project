package xmt.item;
import java.util.List;
import java.util.ArrayList;

public class NameList {
    private List names = new ArrayList<>();
    public synchronized void add(String name){
        names.add(name);
    }
    public synchronized void printAll(){
        for(int i = 0;i < names.size();i++){
            System.out.println(names.get(i)+" ");
        }
    }

    public static void main(String[] args) {
        final NameList s1 = new NameList();
        for (int i = 0;i<2; i++){
            new Thread(){

                public void run() {
                    s1.add("A");
                    s1.add("B");
                    s1.add("C");
                    s1.printAll();
                }
            }.start();
        }
    }
}
