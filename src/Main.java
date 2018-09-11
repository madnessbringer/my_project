import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        /**WindowsExecs class object to use its methods*/
        WindowsExecs exec = new WindowsExecs();

        /**String which contain system type*/
        String systemType = System.getProperty("os.name");
        if (systemType.toLowerCase().equals("windows xp")){
            exec.winXPExec();
        } else {
            exec.winOtherExec();
        }
    }
}
