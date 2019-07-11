package ca.sheridancollege;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.DAO.DAO;
import ca.sheridancollege.beans.Student;

@Controller
public class HomeController {

	
	@GetMapping("/")
	public String goHome() {
		return "addStudent.html";
	}
	
	@GetMapping("/add")
	public String addStudent(
					@RequestParam String name) {
		
		Student s = new Student( name);
		System.out.println(s);
		DAO.addStudent(s);
		return "addStudent.html";
	}
	
	
	@GetMapping("/view")
	public String viewStudents(Model model) {
		model.addAttribute("stuList", DAO.getStudents());
		return "viewStudent.html";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(
			@PathVariable int id,Model model) {
		DAO.deleteStudent(id);
		model.addAttribute("stuList", DAO.getStudents());
		return "viewStudent.html";
		
	}	
	
	@GetMapping("/edit/{id}")
	public String editStudent(
			@PathVariable int id,Model model) {
		Student s =DAO.getStudentByID(id);
		model.addAttribute("stu", s);
		
		
		
		return "modify.html";
		
	}	
	
	
	@GetMapping("/modify")
	public String myEditStudent(
			@RequestParam int id,
			@RequestParam String name,
			Model model) {
		
		Student s = new Student(id, name);
		DAO.modifyStudent(s);
		model.addAttribute("stuList", DAO.getStudents());
		return "viewStudent.html";
	}
	
	
}
