package controller;

import java.io.*;
import java.util.*;

public class IOFile {

    public static <T> List<T> doc(String fname) {
        List<T> list = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
            list = (List<T>) ois.readObject();
            ois.close();
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return list;
    }

    public static <T> void viet(String fname, List<T> arr) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
            oos.writeObject(arr);
            oos.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

