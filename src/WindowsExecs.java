/**
 * Class WindowsExecs
 * Contains methods that contains sequence of method to start on each OS
 * and also methods to execute .bat files
 * @author Ushakov Ilya Vladimirovich
 */
import java.io.IOException;


public class WindowsExecs {
    /**WindowsPaths class object to use paths*/
    private WindowsPaths paths = new WindowsPaths();


    /**WindowsGets class object to use it's methods*/
    private WindowsGets processings = new WindowsGets();


    /**
     * Method launches file create_windows.bat
     * @throws IOException
     * @throws InterruptedException
     * */
    private void startingExecWin() throws IOException, InterruptedException {
        ProcessBuilder startingProcBuilder = new ProcessBuilder(paths.WINDOWS_CREATE_PATH);
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
        ProcessBuilder startingProcBuilder = new ProcessBuilder(paths.WINDOWS_XP_CREATE_PATH);
        startingProcBuilder.redirectErrorStream( true );
        Process process = startingProcBuilder.start();
        process.waitFor();
    }


    /**
     * Method launches file delete_windows.bat
     * @throws IOException
     * @throws  InterruptedException*/
    private void quitExec() throws IOException, InterruptedException {
        ProcessBuilder startingProcBuilder = new ProcessBuilder(paths.WINDOWS_DELETE_PATH);
        startingProcBuilder.redirectErrorStream( true );
        Process process = startingProcBuilder.start();
        process.waitFor();
    }

    /**Method that launch sequence for Windows XP*/
    void winXPExec() throws IOException, InterruptedException {
        startingExecWinXP();
        processings.statusGet();
        processings.osGet();
        processings.notebookModelGet();
        processings.motherboardGet();
        processings.cpuGet();
        processings.ramGetXP();
        processings.videocardGet();
        processings.harddiskGet();
        processings.networkAdapterGet();
        processings.printerGet();
        quitExec();
    }


    /**Method that launch sequence for Windows newer than XP*/
    void winOtherExec() throws IOException, InterruptedException {
        startingExecWin();
        processings.statusGet();
        processings.osGet();
        processings.notebookModelGet();
        processings.motherboardGet();
        processings.cpuGet();
        processings.ramGet();
        processings.videocardGet();
        processings.harddiskGet();
        processings.networkAdapterGet();
        processings.printerGet();
        quitExec();
    }
}
