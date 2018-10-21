/**
 * Class WindowsPaths
 * Contains String fields for Path values used in program.
 * @author Ushakov Ilya Vladimirovich
 */
class WindowsPaths {
    /**Field for main catalog*/
    static private final String MAIN_PATH_FOLDER = "C://tmp//";

    /**Field for CPU logfile from wmic program*/
    static final String CPU_INFO_PATH = MAIN_PATH_FOLDER + "CPU.txt";

    /**Field for HD logfile from wmic program*/
    static final String HARD_DISK_INFO_PATH = MAIN_PATH_FOLDER + "HD.txt";

    /**Field for Motherboard logfile from wmic program*/
    static final String MOTHERBOARD_INFO_PATH = MAIN_PATH_FOLDER + "MB.txt";

    /**Field for Network adapters logfile from wmic program*/
    static final String NETWORK_ADAPTER_INFO_PATH = MAIN_PATH_FOLDER + "NA.txt";

    /**Field for Notebook model logfile from wmic program*/
    static final String NOTEBOOK_MODEL_INFO_PATH = MAIN_PATH_FOLDER + "NB.txt";

    /**Field for OS logfile from wmic program*/
    static final String OS_INFO_PATH = MAIN_PATH_FOLDER + "OS.txt";

    /**Field for Printer logfile from wmic program*/
    static final String PRINTER_INFO_PATH = MAIN_PATH_FOLDER + "P.txt";

    /**Field for RAM logfile from wmic program*/
    static final String RAM_INFO_PATH = MAIN_PATH_FOLDER + "RAM.txt";

    /**Field for Video card logfile from wmic program*/
    static final String VIDEO_CARD_INFO_PATH = MAIN_PATH_FOLDER + "VC.txt";

    /**Field for "program files (x86)"*/
    static final String PROGRAM_FILES_PATH = "C://Program Files (x86)//";

    /**Field for create_windows.bat path*/
    static final String WINDOWS_CREATE_PATH = "bats\\create_windows.bat";

    /**Field for create_windows_xp.bat path*/
    static final String WINDOWS_XP_CREATE_PATH = "bats\\create_windows_xp.bat";

    /**Field for delete_windows.bat path*/
    static final String WINDOWS_DELETE_PATH = "bats\\delete_windows.bat";

    /**Field for Result logfile*/
    static final String RESULT_FILE_PATH = System.getProperty("user.home") + "/Desktop/SYSINFO.txt";

}