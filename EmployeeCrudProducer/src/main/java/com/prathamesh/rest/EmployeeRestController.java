package com.prathamesh.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prathamesh.exception.EmployeeNotFoundException;
import com.prathamesh.model.Employee;
import com.prathamesh.repo.EmployeeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/employee")
@Api("This is for Employee operations")
public class EmployeeRestController {

	/**
	 * post--save---string
	 * get----getone---object. recommended to use ?
	 * get---getall---List<Object>
	 * delete---string
	 * put--update---string
	 */
	
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeRestController.class);
	
	@Autowired
	private EmployeeRepository repo;
	
	
	@ApiOperation("This is to save one employee")
	@PostMapping("/saveoneemployee")
	public ResponseEntity<String> saveOneEmployee(@RequestBody Employee employee) 
	{
	
		LOG.info("Entered into saveoneemployee method");
		
		ResponseEntity<String> responseEntity = null;
		
		try 
		{
			Integer id = repo.save(employee).getEmpId();
			//201-created
			responseEntity = new ResponseEntity<String>("Employee with id : "+id+" saved successfully", HttpStatus.CREATED);
			LOG.info("EMPLOYEE SAVED WITH ID {} ", id);
		}
		
		catch(Exception e) 
		{
			LOG.error("UNABLE TO SAVE EMPLOYEE {} ", e.getMessage());
			//500-internal server error
			responseEntity = new ResponseEntity<String>("Unable to process saveoneemployee", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		LOG.info("ABOUT TO LEAVE SAVEONEEMPLOYEE METHOD ");
		
		return responseEntity;
		
	}
	
	
	
	@ApiOperation("This is to get all employees")
	@GetMapping("/getallemployees")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> listOfEmployees = repo.findAll();
		ResponseEntity<List<Employee>> responseEntity = new ResponseEntity<List<Employee>>(listOfEmployees,HttpStatus.OK);
		return responseEntity;
	}
	
	
	
	
	
	@ApiOperation("This is to get one employee")
	@GetMapping("/getoneemployee/{id}")
	public ResponseEntity<?> getOneEmployee(@PathVariable Integer id)
	{
		ResponseEntity<?> responseEntity = null;
		
		Employee emp = null;
		
		try
		{
			Optional<Employee> e = repo.findById(id);
			if(e.isPresent()) {
				emp = e.get();
			}
			
			responseEntity = new ResponseEntity<Employee>(emp,HttpStatus.OK);
		}
		
		catch(EmployeeNotFoundException enfe)
		{
			throw enfe;
		}
		catch(Exception e)
		{
			responseEntity = new ResponseEntity<String>("Unable to fetch Employee", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		
		return responseEntity;

	}

	@ApiOperation("This is to delete one employee")
	@DeleteMapping("/deleteoneemployee/{id}")
	public ResponseEntity<String> deleteOneEmployee(@PathVariable Integer id)
	{
	    ResponseEntity<String> responseEntity = null;
	    
	    try 
	    {
	      repo.deleteById(id);
	      responseEntity = new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
	    }
	    
	    catch(Exception e)
	    {
	      responseEntity = new ResponseEntity<String>("Unable to delete employee", HttpStatus.INTERNAL_SERVER_ERROR);
	      e.printStackTrace();
	    }
	    
	    return responseEntity;
	}
	
	@ApiOperation("This is to update employee")
	@PutMapping("/updateoneemployee/{id}")
	public ResponseEntity<String> updateOneEmployee(@PathVariable Integer id, @RequestBody Employee employee)
	{
		Employee emp = null;
		Optional<Employee> opt = repo.findById(id);
		if(opt.isPresent()) {
			emp = opt.get();
		}
		
		if(repo.existsById(id)) {
			emp.setEmpId(id);
			
		}
		
		return null;
	}
}
