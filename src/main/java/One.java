import java.io.*;
public class One {
    public static void main(String args[]){
        String sOne = "";
        String sTwo = "";
        Integer ipOne[] = new Integer[4];
        Integer ipTwo[] = new Integer[4];
        Integer ipDiff[] = new Integer[4];
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введите первый IP адрес: ");
            sOne = br.readLine();
            System.out.print("Введите второй IP адрес: ");
            sTwo = br.readLine();
        } catch (IOException e){
            System.out.println("Произошла ошибка ввода-вывода");
        }
        for (int i=0; i<4; i++){
            int t = sOne.indexOf(46);
            if (t != -1){
                ipOne[i] = Integer.parseInt(sOne.substring(0,t));
                sOne = sOne.substring(t+1);
            } else ipOne[3] = Integer.parseInt(sOne);
        }
        for (int i=0; i<4; i++){
            int t = sTwo.indexOf(46);
            if (t != -1){
                ipTwo[i] = Integer.parseInt(sTwo.substring(0,t));
                sTwo = sTwo.substring(t+1);
            } else ipTwo[3] = Integer.parseInt(sTwo);
        }
        ////////////////////////////////////////
        difference(ipOne, ipTwo, ipDiff);
        System.out.println("Start");
        display(ipOne, ipDiff);


        /*for (int i=0; i<4; i++){
            if ((ipOne[i].compareTo(ipTwo[i])) <= 0){
                ipDiff[i] = String.valueOf(Integer.parseInt(ipTwo[i]) - Integer.parseInt(ipOne[i]));
            }
        }*/
        //int l, p;
        //if (ipOne[3] == ipTwo[3]) l = ipOne[3] + 1;

        /*for (int i = ipOne[0], w = 0; w <= ipDiff[1]; i++, w++){
            if (ipDiff[0] == 0) i = ipOne[0];
            if (i == 256) i = 0;
            for (int j = ipOne[1] + 1, n = 0; n <= ipDiff[1]; j++, n++){
                if (ipDiff[1] == 0) j = ipOne[1];
                if (j == 256) j = 0;
                for (int k = ipOne[2] + 1, o = 0; o <= ipDiff[2]; k++, o++){
                    if (ipDiff[2] == 0) k = ipOne[2];
                    if (k == 256) k = 0;
                    for (int l = ipOne[3] + 1, p = 1; p < ipDiff[3]; l++, p++){
                        if (l == 256) l = 0;
                        System.out.println(i + "." + j + "."+ k + "."+ l);
                    }
                }
            }
        }*/

        for (int i=0; i<4; i++){
            System.out.print(ipDiff[i]+" ");
        }
        //System.out.println(Integer.parseInt(ipTwo[3]) + (255 - (Integer.parseInt(ipOne[3]))));
        System.out.println(ipOne[3].compareTo(ipTwo[3]));
        //dis();

        /*for (int l = ipOne[3]+1, p = 0; p < ipDiff[3]; l++, p++){
            if (l == 256) l = 0;
            System.out.print(l + " ");
        }*/
    }
    private static void difference (Integer a[], Integer b[], Integer c[]){
        if ((a[0].compareTo(b[0])) <= 0){
            //c[0] = String.valueOf(Integer.parseInt(b[0]) - Integer.parseInt(a[0]));
            c[0] = b[0] - a[0];
        }

        if ((a[1].compareTo(b[1])) <= 0){
            //c[1] = String.valueOf(Integer.parseInt(b[1]) - Integer.parseInt(a[1]));
            c[1] = b[1] - a[1];
        } else {
            //c[1] = String.valueOf(Integer.parseInt(b[1]) + (255 - (Integer.parseInt(a[1]))));
            c[1] = b[1] + (256 - a[1]);
            if ((a[2].compareTo(b[2])) <= 0) {
                //c[2] = String.valueOf(Integer.parseInt(b[2]) - Integer.parseInt(a[2]));
                c[2] = b[2] - a[2];
            } else {
                //c[2] = String.valueOf(Integer.parseInt(b[2]) + (255 - (Integer.parseInt(a[2]))));
                c[2] = b[2] + (256 - a[2]);
                if ((a[3].compareTo(b[3])) <= 0) {
                    //c[3] = String.valueOf(Integer.parseInt(b[3]) - Integer.parseInt(a[3]));
                    c[3] = b[3] - a[3];
                } else {
                    //c[3] = String.valueOf(Integer.parseInt(b[3]) + (255 - (Integer.parseInt(a[3]))));
                    c[3] = b[3] + (256 - a[3]);
                }
            }
            return;
        }

        if ((a[2].compareTo(b[2])) <= 0) {
            //c[2] = String.valueOf(Integer.parseInt(b[2]) - Integer.parseInt(a[2]));
            c[2] = b[2] - a[2];
        } else {
            //c[2] = String.valueOf(Integer.parseInt(b[2]) + (255 - (Integer.parseInt(a[2]))));
            c[2] = b[2] + (256 - a[2]);
            if ((a[3].compareTo(b[3])) <= 0) {
                //c[3] = String.valueOf(Integer.parseInt(b[3]) - Integer.parseInt(a[3]));
                c[3] = b[3] - a[3];
            } else {
                //c[3] = String.valueOf(Integer.parseInt(b[3]) + (255 - (Integer.parseInt(a[3]))));
                c[3] = b[3] + (256 - a[3]);
            }
            return;
        }

        if ((a[3].compareTo(b[3])) <= 0) {
            //c[3] = String.valueOf(Integer.parseInt(b[3]) - Integer.parseInt(a[3]));
            c[3] = b[3] - a[3];
        } else {
            //c[3] = String.valueOf(Integer.parseInt(b[3]) + (255 - (Integer.parseInt(a[3]))));
            c[3] = b[3] + (256 - a[3]);
        }
    }

    private static void display (Integer a[], Integer c[]){
        int i = a[0], w = 0;
        int j = a[1], n = 0;
        int k = a[2], o = 0;
        int l = a[3] + 1, p = 1;
        for ( ; w <= c[1]; i++, w++){
            //if (c[0] == 0) i = a[0];
            if (i == 256) i = 0;
            for ( ; n <= c[1]; j++, n++){
                //if (c[1] == 0) j = a[1];
                if (j == 256){j = 0; break;}
                for ( ; o <= c[2]; k++, o++){
                    //if (c[2] == 0) k = a[2];
                    if (k == 256){k = 0; break;}
                    for ( ; p < c[3]; l++, p++){
                        if (l == 256){l = 0; break;}
                        System.out.println(i + "." + j + "."+ k + "."+ l);
                    }
                }
            }
        }
    }
    public static void dis(){System.out.println("Assume");}
}
