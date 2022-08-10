import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Hos{
    Scanner sc = new Scanner(System.in);
    ArrayList<int[]> human = new ArrayList<int[]>();
    ArrayList<int[]> hospital = new ArrayList<int[]>();
    ArrayList<int[]> list = new ArrayList<int[]>();

    int[][] table;
    int n, m, cal;
    int value=0;
    int sum=0;
    int min = 0;
    int[] address = new int[2];
    int[] count;

    Hos(){
        n = sc.nextInt();
        m = sc.nextInt();
        table = new int[n][n];
    }
    void set(){
        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j]=sc.nextInt();
            }
        }
    }

    void division() { //사람과 병원 나누기
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(table[i][j]==1) {
                    address[0]=i;
                    address[1]=j;
                    human.add(address);
                }else if(table[i][j]==2) {
                    address[0]=i;
                    address[1]=j;
                    hospital.add(address);
                }
            }
        }
    }

    void check() { //최솟값 구하기
        for(int[] i : human) {
            for(int[] j : list) {
                cal = (Math.abs(i[0]-j[0])) + (Math.abs(i[1]-j[1]));
                if(value==0) {value=cal;}
                else if (value>cal) {value=cal;}
            }
            sum+=value;
            value=0;
        }
    }

    int[] change(int[] table) {
        for(int i=0; i<COUNT; i++) {
            if(table[i]>MAX) {
                try {
                    table[i]=0;
                    table[i+1]++;
                }catch(ArrayIndexOutOfBoundsException e){bl=false;}
            }
        }
        for(int j=COUNT-1; j>=0; j--){
            if(table[j]==0){
                try{
                    table[j]=table[j+1]+1;
                }catch(ArrayIndexOutOfBoundsException e){}
            }
        }
        return table;
    }

    void cal(){
        int[] table = new int[COUNT];
        table=set(table);

        while(bl){
            System.out.println(Arrays.toString(table));
            table[0]++; //1씩 증가
            table=change(table);
            while(table[0]>MAX){
                table=change(table);
            }
        }
    }

	/*void pick() {

	}*/
}

public class Hospital {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Hos hos = new Hos();
        hos.division();
        hos.pick();
        System.out.println(hos.min);
    }

}