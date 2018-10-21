/**
 * Class WindowsExecs
 * Contains methods that contains sequence of method to start on each OS
 * and also methods to execute .bat files
 * @author Ushakov Ilya Vladimirovich
 */
import java.io.IOException;


public class WindowsExecs {


    /**WindowsReceives class object to use it's methods*/
    private WindowsReceives receives = new WindowsReceives();


    /**
     * Method launches file create_windows.bat
     * @throws IOException
     * @throws InterruptedException
     * */
    private void startingExecWin() throws IOException, InterruptedException {
        ProcessBuilder startingProcBuilder = new ProcessBuilder(WindowsPaths.WINDOWS_CREATE_PATH);
        startingProcBuilder.redirectErrorStream( true );
        Process process = startingProcBuilder.start();
        process.waitFor();
    }

    /**
     * Method launches file create_windows_xp.bat
     * @throws IOException
     * @throws InterruptedException
     * */
    private void startingExecWinXP() throws IOException, InterruptedException {
        ProcessBuilder startingProcBuilder = new ProcessBuilder(WindowsPaths.WINDOWS_XP_CREATE_PATH);
        startingProcBuilder.redirectErrorStream( true );
        Process process = startingProcBuilder.start();
        process.waitFor();
    }


    /**
     * Method launches file delete_windows.bat
     * @throws IOException
     * @throws  InterruptedException*/
    private void quitExec() throws IOException, InterruptedException {
        ProcessBuilder startingProcBuilder = new ProcessBuilder(WindowsPaths.WINDOWS_DELETE_PATH);
        startingProcBuilder.redirectErrorStream( true );
        Process process = startingProcBuilder.start();
        process.waitFor();
    }

    /**Method that launch sequence for Windows XP*/
    void winXPExec() throws IOException, InterruptedException {
        startingExecWinXP();
        receives.statusGet();
        receives.osGet();
        receives.notebookModelGet();
        receives.motherboardGet();
        receives.cpuGet();
        receives.ramGetXP();
        receives.videocardGet();
        receives.harddiskGet();
        receives.networkAdapterGet();
        receives.printerGet();
        quitExec();
    }


    /**Method that launch sequence for Windows newer than XP*/
    void winOtherExec() throws IOException, InterruptedException {
        startingExecWin();
        receives.statusGet();
        receives.osGet();
        receives.notebookModelGet();
        receives.motherboardGet();
        receives.cpuGet();
        receives.ramGet();
        receives.videocardGet();
        receives.harddiskGet();
        receives.networkAdapterGet();
        receives.printerGet();
        quitExec();
    }
}