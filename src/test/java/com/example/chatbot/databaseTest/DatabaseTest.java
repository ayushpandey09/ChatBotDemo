package com.example.chatbot.databaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.example.chatbot.entity.User;
import com.example.chatbot.repo.UserRepo;



@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
class DatabaseTest
{	
	@Autowired
	UserRepo urepo;
	
	@Test
//@Rollback(false)
	public void addEmployeeTestName() {	
		User u	=new User(100,"Vasu","Dev","vasu100@gmail.com","9812278688");
		
		urepo.save(u);
		
		Optional<User> foundEmp = urepo.findById(u.getId());
		assertNotNull(u);
		assertEquals("Vasu",foundEmp.get().getEmpName());
	}
	
	@Test
	public void addEmployeeTestId() {
		
		User u1 = new User(110,"Kushagra","SDE","kush44@gmail.com","9998888999");
		
		urepo.save(u1);
		
		Optional<User> foundEmp1 = urepo.findById(u1.getId());
		assertNotNull(u1);
		assertEquals(110,foundEmp1.get().getId());
		
		
		
		
	}

}