public class l5_2022_5_24 {
    public static void main(String[] args) {
        String thisDate = "2022/4/14";
        System.out.println(usingString(thisDate));
        System.out.println(usingStringBuffer(thisDate).toString());
    }

    public static String usingString(String date) {
        String year = "";
        String moth = "";
        String day = "";
        int indexCount = 0;
        for (int i = 0; i < date.length(); i++) {
            if (date.charAt(i) == '/') {
                indexCount++;
                continue;
            }
            if (indexCount == 0) {
                year += date.charAt(i);
            } else if (indexCount == 1) {
                moth += date.charAt(i);
            } else {
                day += date.charAt(i);
            }
        }
        String result = year + "年" + moth + "月" + day + "日";
        return result;
    }

    public static StringBuffer usingStringBuffer(String date) {
        StringBuffer buffer = new StringBuffer();
        String year = "";
        String moth = "";
        String day = "";
        int indexCount = 0;
        for (int i = 0; i < date.length(); i++) {
            if (date.charAt(i) == '/') {
                indexCount++;
                continue;
            }
            if (indexCount == 0) {
                year += date.charAt(i);
            } else if (indexCount == 1) {
                moth += date.charAt(i);
            } else {
                day += date.charAt(i);
            }
        }
        buffer.append(year);
        buffer.append("年");
        buffer.append(moth);
        buffer.append("月");
        buffer.append(day);
        buffer.append("日");
        return buffer;
    }
}
