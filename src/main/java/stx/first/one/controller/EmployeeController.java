package stx.first.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import stx.first.one.dao.EmployeeDao;
import stx.first.one.pojo.Employee;

import java.util.Collection;

@Controller
public class EmployeeController
{
    @Autowired
    EmployeeDao employeeDao;
    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String  list(Model model)
    {
        Collection<Employee> collection=employeeDao.getAll();
        model.addAttribute("emps",collection);
        return "emp/list";
    }
}
