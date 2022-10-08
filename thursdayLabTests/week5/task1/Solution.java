public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        switch (in) {
            case "E" -> System.out.println(new Employee(sc.nextLine(), sc.nextDouble()));
            case "P" -> {
                String name = sc.nextLine();
                double s = sc.nextDouble();
                double k = sc.nextDouble();
                sc.nextLine();
                String spe = sc.nextLine();
                System.out.println(new Programmer(name, s, k, spe));
            }
        }
    }
}
