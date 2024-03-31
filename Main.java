import java.util.ArrayList;
import java.util.Scanner;

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Input Student Name :");
        String studentName = scanner.nextLine();
        System.out.println("Input Student Address:");
        String studentAddress = scanner.nextLine();
        Student student = new Student(studentName, studentAddress);

        String numCoursesStudent;
        do {
        	System.out.println("Input Student Courses Amount :");
            while (!scanner.hasNextInt()) {
                System.out.println("Error Input : The Input result must be an Integer");
                scanner.next();
            }
            int convertInteger = Integer.parseInt(scanner.nextLine());
            numCoursesStudent = String.valueOf(convertInteger);
        } while (Integer.parseInt(numCoursesStudent) <= 0);
        
        for (int i = 1; i <= Integer.parseInt(numCoursesStudent); i++) {
            System.out.println("Input Courses Name "+i+" :");
            String course = scanner.nextLine();
            System.out.println("Input Grade Scores :");
            int grade = Integer.parseInt(scanner.nextLine());
            student.addCourseGrade(course, grade);
        }
        
        student.printGrades();
        System.out.println("Average grade: " + student.getAverageGrade());

        System.out.println("\nInput Teacher Name :");
        String teacherName = scanner.nextLine();
        System.out.println("Input Teacher Address :");
        String teacherAddress = scanner.nextLine();
        Teacher teacher = new Teacher(teacherName, teacherAddress);

        System.out.println("Input Teacher Courses Amount :");
        int numCoursesTeacher = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numCoursesTeacher; i++) {
            System.out.println("Input Course name to add:");
            String course = scanner.nextLine();
            boolean added = teacher.addCourse(course);
            if (!added) {
                System.out.println("Course already exists. (False)");
            }
        }

        System.out.println("Delete Teacher Courses Amount :");
        int numCoursesToRemove = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numCoursesToRemove; i++) {
            System.out.println("Input Courses to be deleted:");
            String course = scanner.nextLine();
            boolean removed = teacher.removeCourse(course);
            if (!removed) {
                System.out.println("Course does not exists. (False)");
            }
        }

        System.out.println(student);
        System.out.println(teacher);

        scanner.close();
    }
}
