import java.util.*;

class Student {


    String name;
    String ID;
    int age;
    static int eligibleVoters;
    

    Student(String name, String ID, int age) {
        this.name = name;
        this.ID = ID;
        this.age = age;
        if(age >= 18) {
            eligibleVoters++;
        }
    }

    public static int studentsOfVotingAge() {
	return eligibleVoters;
    }

}

/* DO NOT EDIT ANYTHING BELOW THIS LINE */

class Solution {
    public static void main(String args[]) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String ID = sc.nextLine();
            int age = Integer.parseInt(sc.nextLine());
            Student s = new Student(name, ID, age);
        }
        System.out.println(Student.studentsOfVotingAge());
    }
}
