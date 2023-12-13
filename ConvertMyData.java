import java.util.ArrayList;

public class ConvertMyData {

    public static void main(String[] args) {
        String inputFile = "InputData.txt";
        String outputFile = "MyData.txt";

        int numOfRewDates = convertDate(inputFile, outputFile);
        System.out.println("\nNumber of rewritten dates: " + numOfRewDates);
    }

    public static int convertDate(String inputFile, String outputFile) {
        ArrayList<String> dates = new ArrayList<>();
        ArrayList<String> correctDates = new ArrayList<>();

        dates = MyDataFile.readDataFromFile(inputFile);

        int numOfFormat;
        int datesInFile;
        for (String date : dates) {
            try {
                numOfFormat = MyData.matchedPattern(date);
                if (!correctDates.contains(date)) {
                    correctDates.add(date);
                } else {
                    throw new IllegalArgumentException("Date already converted");
                }
                MyData convertedDate = MyData.getDate(date, numOfFormat);
                convertedDate.printMyData();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        datesInFile = correctDates.size();
        MyDataFile.saveDataToFile(correctDates, outputFile);

        return datesInFile;
    }
}
