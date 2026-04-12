package tower;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Demo: Solve height-3 tower ===");
        TowerModel model = new TowerModel(3);
        model.print();
        TowerSolver solver = new TowerSolver();
        solver.solve(model);
        model.print();
        System.out.println();

        System.out.println("=== Running TestSuite ===");
        TestSuite test = new TestSuite();
        test.run();

    }
}
