
/**
 * Class WindowsProcessings
 * Contains methods that processing strings read with WindowsGets methods.
 * @author Ushakov Ilya Vladimirovich
 */

public class WindowsProcessings {

    /**
     * Method for cut first word from string (divide words with space characters)
     * @param string - String, from which we need to get first word
     * @return return first word from the string
     * */
    private String stringTrim(String string){
        int endIndex = string.indexOf(" ");
        String result = string.substring(0, endIndex + 1);
        result = result.trim();
        return result;
    }


    /**
     * Method for processing Strings of ramGet() method
     * @param string - String readed from RAM.txt file by ramGet()
     * @return return String result in form of manufacture-model-capacity-speed
     * */
    String ramProcessing (String string){
        String tmpResult = stringTrim(string);
        String tmpString = string.substring(tmpResult.length() + 1).trim();
        double tmp = (Double.parseDouble(tmpResult)) / (1024 * 1024);
        String capacity;
        if (tmp < 1024) {
            capacity = "Объем: " + Double.toString(tmp) + "Мб";
        } else
            capacity = "Объем: " + Double.toString(tmp / 1024) + "Гб";
        tmpResult = stringTrim(tmpString);
        tmpString = tmpString.substring(tmpResult.length() + 1).trim();
        String manufacture = "Производитель: " + tmpResult;
        tmpResult = stringTrim(tmpString);
        tmpString = tmpString.substring(tmpResult.length() + 1).trim();
        String model = "Модель: " + tmpResult;
        String frequency = "Частота: " + tmpString + "МГц";
        return manufacture + " ," + model + " ," + capacity + ", " + frequency;
    }


    /**
     * Method for processing Strings of ramGet() method
     * @param string - String read from RAM.txt file by ramGet() on windows XP
     * @return return String result that contains only capacity of RAM
     * */
    String ramProcessingXP (String string){
        String capacity = string.trim();
        double tmp = (Double.parseDouble(capacity)) / 1024;
        if (tmp < 1024) {
            capacity = "Объем: " + Double.toString(tmp) + "Мб";
        } else
            capacity = "Объем: " + Double.toString(tmp / 1024) + "Гб";
        return capacity;
    }


    /**
     * Method for processing Strings of harddiskGet() method
     * @param string - String read from HD.txt file by harddiskGet()
     * @return return String result in form of model-capacity
     * */
    String harddiskProcessing (String string) {
        String tmpResult = stringTrim(string);
        String tmpString = string.substring(tmpResult.length() + 1).trim();
        String model = tmpResult;
        tmpResult = stringTrim(tmpString);
        tmpString = string.substring(tmpResult.length() + 1).trim();
        model = "Модель: " + model + " " + tmpResult;
        char[] tmpChars = tmpString.toCharArray();
        int count = 0;
        for (int index = tmpChars.length - 1; index >= 0 ; index--) {
            if (Character.isDigit(tmpChars[index]))
                count = index;
            if (!Character.isDigit(tmpChars[index]))
                break;
        }
        String tmpCapacity = tmpString.substring(count);
        double capacityDouble = Double.parseDouble(tmpCapacity)/(1024 * 1024 * 1024);
        String capacity = "Объем: " +  String.format("%.1f", capacityDouble) + "Гб";
        return model + ", " + capacity;
    }


    /**
     * Method for processing String of networkAdapterGet() method
     * @param string - String read from NA.txt file
     * @return return String result in form of adapter name - MAC address
     * */
    String networkAdapterProcessing (String string) {
        String tmpResult = stringTrim(string);
        String tmpString = string.substring(tmpResult.length() + 1).trim();
        if (tmpResult.equals("Ethernet")){
            tmpResult = stringTrim(tmpString);
            tmpString = tmpString.substring(tmpResult.length() + 1).trim();
            tmpResult = stringTrim(tmpString);
            tmpString = tmpString.substring(tmpResult.length() + 1).trim();
            String macAddress = "Mac Adress: " + tmpResult;
            String adapter = "Имя адаптера: " + tmpString;
            return adapter + ", " + macAddress;}
        else
            return "";
    }


}
