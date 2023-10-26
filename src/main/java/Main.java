import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void showMenu(){
        System.out.println("---------- QUAN LY SINH VIEN ----------\n" +
                "1. Xem tất cả sinh viên.\n" +
                "2. Cập nhật thông tin sinh viên theo mã (gồm tên và điểm gpa)\n" +
                "3. Xem tất cả reminders\n" +
                "4. Xem 10 bản ghi thay đổi gần nhất students\n" +
                "0. Thoát");
    }
    public static void main(String[] args) throws SQLException {
        int option = -1;
        Scanner scanner = new Scanner(System.in);
        StudentDB studentDB = new StudentDB();
        do{
            showMenu();
            System.out.print("Nhap lua chon: ");
            option = Integer.parseInt(scanner.nextLine());
            switch (option){
                case 0:
                    System.out.println("Thoat chuong trinh!");
                    break;
                case 1:
                    studentDB.printStudents();
                    break;
                case 2:
                    System.out.print("Nhap ma sinh vien: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    // Cap nhat cho id tren
                    System.out.print("Nhap ho ten moi: ");
                    String newFullName = scanner.nextLine();
                    System.out.print("Nhap diem gpa moi: ");
                    float newGpa = Float.parseFloat(scanner.nextLine());
                    // Truyen vao
                    studentDB.updateStudent(id, newFullName, newGpa);

                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
        while (option != 0);
        scanner.close();

    }
}
