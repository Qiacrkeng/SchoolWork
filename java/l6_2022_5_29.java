import java.util.HashSet;
import java.util.Scanner;

public class l6_2022_5_29 {
    public static void main(String[] args) {
        HashSet<String> stringSet1 = new HashSet<>();
        HashSet<String> stringSet2 = new HashSet<>();
        Scanner input = new Scanner(System.in);

        System.out.println("输入第1个学生的讯息：姓名 性别 生日（年月日）");
        stringSet1.add(input.nextLine());
        stringSet1.add(input.nextLine());
        stringSet1.add(input.nextLine());
        stringSet1.add(input.nextLine());

        System.out.println("输入第2个学生的讯息：姓名 性别 生日（年月日）");
        stringSet2.add(input.nextLine());
        stringSet2.add(input.nextLine());
        stringSet2.add(input.nextLine());
        stringSet2.add(input.nextLine());

        System.out.println(stringSet1);
        System.out.println(stringSet2);
    }
}
