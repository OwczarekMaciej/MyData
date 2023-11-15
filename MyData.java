public class MyData {
    int day;
    int month;
    int year;
    String weekday;
    private static String[] dateFormats = new String[] {
            "\\d{4}-\\d{2}-\\d{2} \\w+",
            "\\d{2}/\\d{2}/\\d{4} \\w+",
            "\\d{2}/\\d{1}/\\d{4} \\w+",
            "\\w+ \\d{2}\\.\\d{2}\\.\\d{4}"
    };

    MyData(int day, int month, int year, String weekday) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.weekday = weekday;
    }

    public static int matchedPattern(String date) throws IllegalArgumentException {
        int patternIndex = 0;
        for (String dateFormat : dateFormats) {
            if (date.matches(dateFormat)) {
                return patternIndex;
            }
            patternIndex++;
        }
        throw new IllegalArgumentException("Incorrect date format");
    }

    public static MyData getDate(String line, int numOfFormat) {
        String[] parts = line.split(" ");
        String datePart;
        String weekdayPart;
        if (numOfFormat != 3) {
            datePart = parts[0];
            weekdayPart = parts[1];
        } else {
            weekdayPart = parts[0];
            datePart = parts[1];
        }
        int day;
        int month;
        int year;
        String[] dateParts = datePart.split("[/\\-.]");
        if (numOfFormat == 0) {
            day = Integer.parseInt(dateParts[2]);
            month = Integer.parseInt(dateParts[1]);
            year = Integer.parseInt(dateParts[0]);

            return new MyData(day, month, year, weekdayPart);
        } else {
            day = Integer.parseInt(dateParts[0]);
            month = Integer.parseInt(dateParts[1]);
            year = Integer.parseInt(dateParts[2]);

            return new MyData(day, month, year, weekdayPart);
        }
    }

    public void printMyData() {
        System.out.println("day=" + day + ", month=" + month + ", year=" + year + ", weekday= " + weekday);
    }
}
