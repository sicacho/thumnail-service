import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 10/30/2016.
 */
public class Main {

  private static final String filename = "C:\\Users\\Administrator\\Downloads\\Video\\FAX-093.MP4";

  public static void main(String[] args) {
//        JsonRpcHttpClient client = null;
//        try {
//            client = new JsonRpcHttpClient(
//                    new URL("http://192.168.79.128:6800/jsonrpc"));
//            DownloadDTO[] downloadDTO = client.invoke("aria2.tellStopped",new Object[]{0,10,new String[]{"gid","status","files"}}, DownloadDTO[].class);
//            Stream.of(downloadDTO).forEach(downloadDTO1 -> System.out.println(downloadDTO1.files[0].path));
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }

    String path = args[0];
    String mtnExePath = args[1];
    String command = " -c 4 -z -h 50 -w 480 -i -t -s 40 -N ";

    try {
      final Process p;
      p = Runtime.getRuntime().exec("cmd.exe /c C:\\mtn\\mtn.exe  C:\\Users\\Administrator\\Downloads\\Video\\FAX-093.MP4");

      new Thread(new Runnable() {
        public void run() {
          BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
          String line = null;
          input.lines().forEach(s -> System.out.println(s));
          try {
            while ((line = input.readLine()) != null)
              System.out.println(line);
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }).start();
      p.waitFor();


    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


  }
}
