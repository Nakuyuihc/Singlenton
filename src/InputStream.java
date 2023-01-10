import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputStream {

    public static void main(String[] args){
        try(InputStreamReader fren = new InputStreamReader(new FileInputStream("D:\\1.txt"), "UTF-8");
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("D:\\2.txt"), "UTF-8");
            BufferedWriter bw = new BufferedWriter(out)) {
            BufferedReader bfen = new BufferedReader(fren);
            String stren = null;
            List<Integer> categorys = Arrays.asList(
                    6001,
                    6002,
                    6003,
                    6004,
                    6005,
                    6007,
                    6008,
                    6009,
                    6020,
                    6021,
                    6101,
                    6102
            );
            int i = 0;
            while ((stren = bfen.readLine()) != null) {
                System.out.println(++i + ":" + stren);
                for(Integer category:categorys) {
                    String[] strs = stren.split(",");
                    bw.write("select f_initialize_user_list_by_category('"+strs[0] +"','"+strs[1]+"','"+strs[2]+"'channel','107000283','1',"+category+",'1');");
                    bw.newLine();
                }
                bw.newLine();
            }
            bw.flush();
        }catch (Exception e){
e.printStackTrace();
        }
    }
}
