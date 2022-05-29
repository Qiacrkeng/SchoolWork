public class l4_2022_5_24 {
    public static void main(String[] args) {
        String words = "Hello World Java 11!";
        String[] result = new String[words.length()];
        int count = 0, left = 0;
        for (int right = 0; right < words.length(); right++) {
            if (words.charAt(right) == ',' || words.charAt(right) == ' ' || words.charAt(right) == '!') {
                result[count] = words.substring(left, right);
                count++;
                left = right + 1;
            }
        }
        /**
         * JAVA的內置String字典比較方法
         * compareTo(String anotherString)
         * 按字典顺序比较两个字符串。
         */
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (result[j].codePointAt(0) > result[j + 1].codePointAt(0)) {
                    String temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.println(result[i]);
        }
    }
}
