/*
ID: davidzh3
LANG: JAVA
TASK: ride
*/

import java.io.*;
import java.util.*;

public class ride {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        String comet = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String group = st.nextToken();
        
        int icomet = 1;
        for(int i=0; i<comet.length(); i++) {
            icomet *= comet.charAt(i) - 'A' + 1;
        }
        icomet %= 47;

        int igroup = 1;
        for(int i=0; i<group.length(); i++) {
            igroup *= group.charAt(i) - 'A' + 1;
        }
        igroup %= 47;
        
        if(icomet==igroup)
            out.println("GO");
        else
            out.println("STAY");
        out.close();
        System.exit(0);
    }
}
