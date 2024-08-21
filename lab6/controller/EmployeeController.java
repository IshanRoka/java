// /controller/EmployeeController.java
package controller;

import model.Employee;
import view.EmployeeView;

public class EmployeeController {
    private Employee model;
    private EmployeeView view;

    public EmployeeController(Employee model, EmployeeView view) {
        this.model = model;
        this.view = view;
    }

    public void setEmployeeName(String name) {
        model.setName(name);
    }

    public String getEmployeeName() {
        return model.getName();
    }

    public void setEmployeeEmail(String email) {
        model.setEmail(email);
    }

    public String getEmployeeEmail() {
        return model.getEmail();
    }

    public void setEmployeeAddress(String address) {
        model.setAddress(address);
    }

    public String getEmployeeAddress() {
        return model.getAddress();
    }

    public void updateView() {
        view.printEmployeeDetails(model.getName(), model.getEmail(), model.getAddress());
    }
}
