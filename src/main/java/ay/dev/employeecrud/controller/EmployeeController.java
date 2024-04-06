package ay.dev.employeecrud.controller;

import ay.dev.employeecrud.model.Employee;
import ay.dev.employeecrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping({"/showEmployees", "/", "/list"})
    public ModelAndView showEmployees() {
        ModelAndView mAv = new ModelAndView("list-employees");
        List<Employee> list = employeeRepository.findAll();
        mAv.addObject("employees", list);

        return mAv;
    }

    @GetMapping("/addEmployeeForm")
    public ModelAndView addEmployeeForm() {
        ModelAndView mAv = new ModelAndView("add-employee-form");
        Employee employee = new Employee();
        mAv.addObject("employee", employee);
        mAv.getModel().put("pageTitle", "Add Employee" );

        return mAv;
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView updateEmployeeForm(@RequestParam Long employeeId) {
        ModelAndView mAw = new ModelAndView("add-employee-form");
        Employee employee = employeeRepository.findById(employeeId).get();
        mAw.addObject("employee", employee);
        mAw.getModel().put("pageTitle", "Update Employee (ID: " + employeeId + ")" );
        return mAw;
    }
}
