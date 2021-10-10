package xmt.item;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOClass {
    public static void main(String[] args) throws IOException {
//        File file = new File("F:\\我的简历\\javaIo\\xmt\\czxcxz\\b1.png");
//        System.out.println("name："+file.getName());
//        System.out.println("path："+file.getPath());
//        System.out.println("absolutePat："+file.getAbsolutePath());
//        System.out.println("canonicalFile："+file.getCanonicalFile());
//        System.out.println("lastModified："+file.lastModified());
//        FileInputStream fileInputStream = new FileInputStream(file);
//        System.out.println(fileInputStream.get());

        int a = 1,
        b= a + 5;
        System.out.println(a);
        System.out.println(b);
        a = a +2;
        System.out.println(a);
        System.out.println(b);
    }
}
