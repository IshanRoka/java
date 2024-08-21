// /MVCPatternDemo.java
import controller.EmployeeController;
import model.Employee;
import view.EmployeeView;

public class MVCPatternDemo {
    public static void main(String[] args) {
        // Fetch employee record based on the model
        Employee model = retrieveEmployeeFromDatabase();

        // Create a view to write employee details on the console
        EmployeeView view = new EmployeeView();

        // Create the controller
        EmployeeController controller = new EmployeeController(model, view);

        // Display the initial details
        controller.updateView();

        // Update the model data
        controller.setEmployeeName("Ishan Roka");
        controller.setEmployeeEmail("ishanroka.@gmail.com");
        controller.setEmployeeAddress("kathmandu, Nepal");

        // Display the updated details
        controller.updateView();
    }

    private static Employee retrieveEmployeeFromDatabase() {
        // Simulate database access
        return new Employee("Ishan Roka", "ishanroka.@gmail.com", "kathmandu, Nepal");
    }
}
