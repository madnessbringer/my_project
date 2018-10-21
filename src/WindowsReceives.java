/**
 * Class WindowsReceives
 * Contains methods that read logfiles and than write result in result file.
 * @author Ushakov Ilya Vladimirovich
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class WindowsReceives {

    /**Field that contains line separator*/
    private String lineSeparator = System.getProperty("line.separator");

    /**WindowsProcessing class object to use it's methods*/
    private WindowsProcessings processings = new WindowsProcessings();


    /**
     * Method for getting first title string for SYSINFO.txt and replacing file if it exist
     * */
    void statusGet(){
        try (BufferedWriter writer =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     new FileOutputStream(WindowsPaths.RESULT_FILE_PATH, false), "Unicode"))){
            String status = "Sysinfo: Информация о системе.";
            writer.write(status);
            writer.write(lineSeparator);
            writer.write(lineSeparator);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    /**
     * Method for getting information about OS and put it in SYSINFO.txt.
     * in form of "System version(xp, vista, 7, 8, 10) - distributive version - system type (x64 or x32)
     * */
    void osGet(){
        try(BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(WindowsPaths.OS_INFO_PATH), "Unicode"));
            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(WindowsPaths.RESULT_FILE_PATH, true), "Unicode"))) {
            String line = reader.readLine();
            int count = 0;
            String os = "";
            String distributiveVersion = "";
            while (line != null){
                if (count == 1){
                    //in the logfile system os version separates from the rest of the string by '|'
                    int index = line.indexOf("|");
                    os = line.substring(0,index).trim();
                    //get the rest of the string
                    distributiveVersion = line.substring(index, line.length());
                    index = distributiveVersion.indexOf(" ");
                    //get the end of this string with distributive version
                    distributiveVersion = distributiveVersion.substring(index, distributiveVersion.length()).trim();
                    break;
                }
                else {
                    line = reader.readLine();
                    count++;
                }
            }
            //write information about os in SYSINFO.txt
            writer.write("Операционная система:");
            writer.write(lineSeparator);
            writer.write("Версия системы: " + os);
            writer.write(lineSeparator);
            writer.write("Версия дистрибутива: " + distributiveVersion);
            writer.write(lineSeparator);
            writer.write("Разрядность системы: " + osTypeGet());
            writer.write(lineSeparator);
            writer.write(lineSeparator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for checking OS type (x32 or x64) via existence of "program files (x86)" folder
     * @return type of the OS as String "x64" or "x86"
     * @see WindowsReceives#osGet()
     * */
    private String osTypeGet(){
        String result;
        Path check = Paths.get(WindowsPaths.PROGRAM_FILES_PATH);
        if (Files.exists(check)){
            result = "x64";
        }
        else result = "x32";
        return result;
    }


    /**
     * Method defining notebook model and put result in SYSINFO.txt
     * @exception IOException
     * */
    void notebookModelGet(){
        try(BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(WindowsPaths.NOTEBOOK_MODEL_INFO_PATH), "Unicode"));
            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(WindowsPaths.RESULT_FILE_PATH, true), "Unicode"))) {
            String line = reader.readLine();
            int count = 0;
            while (line != null){
                if (count == 1){
                    break;
                }
                else {
                    line = reader.readLine();
                    count++;
                }
            }
            if (line.contains("To be filled by O.E.M.") || line.contains("All Series") || line.contains("System Product Name"))
                line = "Неизвестно.";
            writer.write("Ноутбук:");
            writer.write(lineSeparator);
            writer.write(line);
            writer.write(lineSeparator);
            writer.write(lineSeparator);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * Method defining motherboard model and put result in SYSINFO.txt
     * @exception IOException
     * */
    void motherboardGet() {
        try(BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(WindowsPaths.MOTHERBOARD_INFO_PATH), "Unicode"));
            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(WindowsPaths.RESULT_FILE_PATH, true), "Unicode"))) {
            String line = reader.readLine();
            int count = 0;
            while (line != null){
                if (count == 1){
                    break;
                }
                else {
                    line = reader.readLine();
                    count++;
                }
            }
            writer.write("Материнская плата:");
            writer.write(lineSeparator);
            writer.write(line);
            writer.write(lineSeparator);
            writer.write(lineSeparator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Method defining CPU model and put result in SYSINFO.txt
     * @exception IOException
     * */
    void cpuGet() {
        try(BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(WindowsPaths.CPU_INFO_PATH), "Unicode"));
            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(WindowsPaths.RESULT_FILE_PATH, true), "Unicode"))) {
            String line = reader.readLine();
            int count = 0;
            while (line != null){
                if (count == 1){
                    break;
                }
                else {
                    line = reader.readLine();
                    count++;
                }
            }
            writer.write("Процессор:");
            writer.write(lineSeparator);
            writer.write(line);
            writer.write(lineSeparator);
            writer.write(lineSeparator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Method defines RAM info and put it in SYSINFO.txt
     * in form of "Manufacturer - Model - Capacity - Speed"
     * @exception IOException
     * */
    void ramGet() {
        StringBuilder result = new StringBuilder();
        String line;
        try(BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(WindowsPaths.RAM_INFO_PATH), "Unicode"));
            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(WindowsPaths.RESULT_FILE_PATH, true), "Unicode"))) {
            line = reader.readLine();
            line = reader.readLine();
            while (line != null){
                if (line.length() > 1){
                    line = processings.ramProcessing(line);
                    result.append(line);
                    result.append(lineSeparator);
                }
                line = reader.readLine();
            }
            writer.write("Оперативная память:");
            writer.write(lineSeparator);
            writer.write(result.toString());
            writer.write(lineSeparator);
            writer.write(lineSeparator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Method defines RAM info in XP and put it in SYSINFO.txt
     * in form of Capacity only
     * @exception IOException
     * */
    void ramGetXP() {
        StringBuilder result = new StringBuilder();
        String line;
        try(BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(WindowsPaths.RAM_INFO_PATH), "Unicode"));
            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(WindowsPaths.RESULT_FILE_PATH, true), "Unicode"))) {
            line = reader.readLine();
            line = reader.readLine();
            while (line != null){
                if (line.length() > 1){
                    line = processings.ramProcessingXP(line);
                    result.append(line);
                    result.append(lineSeparator);
                }
                line = reader.readLine();
            }
            writer.write("Оперативная память:");
            writer.write(lineSeparator);
            writer.write(result.toString());
            writer.write(lineSeparator);
            writer.write(lineSeparator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Method defining video card model and put result in SYSINFO.txt
     * @exception IOException*/
    void videocardGet() {
        StringBuilder result = new StringBuilder();
        String line;
        try(BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(WindowsPaths.VIDEO_CARD_INFO_PATH), "Unicode"));
            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(WindowsPaths.RESULT_FILE_PATH, true), "Unicode"))) {
            line = reader.readLine();
            line = reader.readLine();
            while (line != null){
                if (line.length() > 1){
                    result.append(line);
                    result.append(lineSeparator);
                }
                line = reader.readLine();
            }
            writer.write("Видеокарта:");
            writer.write(lineSeparator);
            writer.write(result.toString());
            writer.write(lineSeparator);
            writer.write(lineSeparator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Method defining HD info and puts result in SYSINFO.txt
     * in form of "Model - Capacity"
     * @exception IOException*/
    void harddiskGet() {
        StringBuilder result = new StringBuilder();
        String line;
        try(BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(WindowsPaths.HARD_DISK_INFO_PATH), "Unicode"));
            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(WindowsPaths.RESULT_FILE_PATH, true), "Unicode"))) {
            line = reader.readLine();
            line = reader.readLine();
            while (line != null){
                if (line.length() > 1){
                    line = processings.harddiskProcessing(line);
                    result.append(line);
                    result.append(lineSeparator);
                }
                line = reader.readLine();
            }
            writer.write("Жесткие диски:");
            writer.write(lineSeparator);
            writer.write(result.toString());
            writer.write(lineSeparator);
            writer.write(lineSeparator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Method defining Network adapters info and puts result in SYSINFO.txt
     * in form of "Adapter name - MAC address"
     * @exception IOException
     * */
    void networkAdapterGet() {
        StringBuilder result = new StringBuilder();
        String line;
        try(BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(WindowsPaths.NETWORK_ADAPTER_INFO_PATH), "Unicode"));
            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(WindowsPaths.RESULT_FILE_PATH, true), "Unicode"))){
            line = reader.readLine();
            while (line != null){
                if (line.length() > 1){
                    line = processings.networkAdapterProcessing(line);
                    if (!line.equals("")){
                        result.append(line);
                        result.append(lineSeparator);
                    }
                }
                line = reader.readLine();
            }
            writer.write("Сетевые устройства:");
            writer.write(lineSeparator);
            writer.write(result.toString());
            writer.write(lineSeparator);
            writer.write(lineSeparator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Method defining printers and puts result in SYSINFO.txt
     * @exception IOException
     * */
    void printerGet() {
        StringBuilder result = new StringBuilder();
        String line;
        try(BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(WindowsPaths.PRINTER_INFO_PATH), "Unicode"));
            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(WindowsPaths.RESULT_FILE_PATH, true), "Unicode"))) {
            line = reader.readLine();
            line = reader.readLine();
            while (line != null){
                if (line.length() > 1){
                    result.append(line);
                    result.append(lineSeparator);
                }
                line = reader.readLine();
            }
            writer.write("Принтеры:");
            writer.write(lineSeparator);
            writer.write(result.toString());
            writer.write(lineSeparator);
            writer.write(lineSeparator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}