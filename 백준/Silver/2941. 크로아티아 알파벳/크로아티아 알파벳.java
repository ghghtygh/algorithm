import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    /*
č	c=
ć	c-
dž	dz=
đ	d-
lj	lj
nj	nj
š	s=
ž	z=
     */
    public static void main(String[] args){
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ){
            String str = br.readLine().replaceAll("dz=","D")
                    .replaceAll("z=","Z")
                    .replaceAll("lj","L")
                    .replaceAll("nj","N")
                    .replaceAll("s=","S")
                    .replaceAll("c=","C")
                    .replaceAll("c-","C")
                    .replaceAll("d-","D");
            char[] arr = str.toCharArray();
            System.out.println(arr.length);
        }catch(IOException e1){

        }
    }
}
