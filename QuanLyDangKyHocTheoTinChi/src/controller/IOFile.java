
package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class IOFile {
    public static <T> List<T> doc(String fname){
        List<T> list = new ArrayList<>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
            list = (List<T>) ois.readObject();
            ois.close();
        }
        catch(IOException ex){
            System.out.println(ex);
        }
        catch(ClassNotFoundException ex){
            System.out.println(ex);
        }
        return list;
    }
    
    public static <T> void viet(String fname, List<T> arr){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
            oos.writeObject(arr);
            oos.close();
        }
        catch(IOException ex){
            System.out.println(ex);
        }
    }
}
