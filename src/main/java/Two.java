import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Two {
    public static void main (String args[]){
        StringArrayList directory[] = new StringArrayList[15];
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        initialize(directory, hm);
        String s = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введите ФИО : ");
            s = br.readLine();
        } catch (IOException e){
            System.out.println("Произошла ошибка ввода-вывода");
        }
        ArrayList<String> a = hm.get(s);
        String n[] = new String[a.size()];
        n = a.toArray(n);
        for (int i = 0; i < a.size(); i++) System.out.println(i + 1 + ". " + n[i]);
    }
    static void initialize (StringArrayList d[], HashMap<String, ArrayList<String>> h){
        d[0] = new StringArrayList();
        d[1] = new StringArrayList();
        d[0].addElement("+8 800 200 500 345");
        d[0].addElement("+8 800 200 500 567");
        d[0].addElement("+8 800 200 500 568");
        d[1].addElement("+8 800 222 500 500");
        d[1].addElement("+8 800 222 500 560");
        h.put("Иванов И.И.", d[0].base);
        h.put("Петров П.П.", d[1].base);
    }
}
class StringArrayList extends ArrayList<String>{
    ArrayList<String> base;
    StringArrayList (){
        base = new ArrayList<>();
    }
    void addElement (String s){
        base.add(s);
    }
}
