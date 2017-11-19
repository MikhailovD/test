import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.*;

public class Two {
    public static void main (String args[]){
        //ArrayList<String> array[] = new ArrayList[10];
        StringArrayList directory[] = new StringArrayList[15];
        /*StringArrayList directory[] = new StringArrayList[15];
        directory[0] = new StringArrayList();
        directory[1] = new StringArrayList();
        directory[0].addElement("+8 800 2000 500 345");
        directory[0].addElement("+8 800 2000 500 567");
        directory[1].addElement("+8 800 2000 500 568");
        ArrayList<String> a1 = new ArrayList<>();
        System.out.println(a1.size());
        a1.add("+8 800 2000 500");
        a1.add("+8 800 200 600");
        System.out.println(a1.size());
        System.out.println(a1);*/

        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        StringArrayList.initialize(directory, hm);
        java.lang.String s = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введите : ");
            s = br.readLine();
        } catch (IOException e){
            System.out.println("Произошла ошибка ввода-вывода");
        }
        ArrayList<String> a = hm.get(s);
        String n[] = new String[a.size()];
        n = a.toArray(n);
        for (int i = 0; i < a.size(); i++) System.out.println(i + 1 + ". " + n[i]);
        //for (String st : n) System.out.print(st);
        //hm.put("Иванов И.И.", directory[0].base);
        //directory[0].display();
        //directory[1].display();
        //System.out.println(hm.get("Иванов И.И."));

        /*Set<Map.Entry<String, ArrayList<String>>> set = hm.entrySet();
        for (Map.Entry<String, ArrayList<String>> me : set){
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }*/
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
    /*void display (String s, HashMap<String, ArrayList<String>> h){
        //base.toArray();
        //System.out.println(base);

        ArrayList<String> a = h.get(s);
        String n[] = new String[a.size()];
        n = a.toArray(n);
        for (String st : n) System.out.print(st);
    }*/

    static void initialize (StringArrayList d[], HashMap<String, ArrayList<String>> h){
        //StringArrayList directory[] = new StringArrayList[15];
        d[0] = new StringArrayList();
        d[1] = new StringArrayList();
        d[0].addElement("+8 800 200 500 345");
        d[0].addElement("+8 800 200 500 567");
        d[0].addElement("+8 800 200 500 568");
        d[1].addElement("+8 800 222 500 500");
        d[1].addElement("+8 800 222 500 560");

        //HashMap<String, ArrayList<String>> hm = new HashMap<>();
        h.put("Иванов И.И.", d[0].base);
        h.put("Петров П.П", d[1].base);
    }
}
