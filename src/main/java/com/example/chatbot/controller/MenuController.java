package com.example.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatbot.entity.Menu;
import com.example.chatbot.service.MenuServices;

@RestController
@RequestMapping("/company")
public class MenuController {
	
	@Autowired
	MenuServices menuservice;
	
	@GetMapping("/menu/{id}")
	public ResponseEntity<Menu> getMenu(@PathVariable Integer id){
		return ResponseEntity.ok(menuservice.getMenuById(id));
	}
	
	
	
	
	/*
	 * @GetMapping("/generalinformation")
	 * 
	 * public String getInformation() { return
	 * "Company Name: TechGenius Solutions\n" +
	 * "Location: Silicon Valley, California, USA\n" +
	 * "Industry: Software Development and IT Services\n" + "Founded: 2005\n" +
	 * "CEO: Alexandra Johnson\n" + "\n" + "Overview:\n" +
	 * "TechGenius Solutions is a leading software development company based in the heart of Silicon Valley. With a team of highly skilled engineers and innovative thinkers, we specialize in creating cutting-edge software solutions for businesses across various industries.\n"
	 * + "\n" + "Products and Services:\n" +
	 * "- Custom Software Development: We create tailored software solutions that cater to the unique needs of our clients, helping them streamline their operations and improve efficiency.\n"
	 * +
	 * "- Mobile App Development: Our team designs and develops mobile applications for both Android and iOS platforms, offering intuitive and user-friendly experiences.\n"
	 * +
	 * "- Web Development: We build responsive and dynamic websites that provide engaging online experiences for users.\n"
	 * +
	 * "- Cloud Services: TechGenius offers cloud-based solutions to enable seamless data storage, scalability, and accessibility.\n"
	 * +
	 * "- AI and Machine Learning: We harness the power of artificial intelligence and machine learning to deliver intelligent software applications.\n"
	 * + "\n" + "Technologies:\n" +
	 * "- Programming Languages: Java, Python, JavaScript, C#\n" +
	 * "- Frameworks: Spring Boot, Django, Angular, React\n" +
	 * "- Databases: MySQL, MongoDB, PostgreSQL\n" +
	 * "- Cloud Platforms: Amazon Web Services (AWS), Microsoft Azure\n" + "\n" +
	 * "Clientele:\n" +
	 * "Our diverse clientele includes startups, enterprises, and organizations from various sectors, such as finance, healthcare, e-commerce, and more. We pride ourselves on delivering solutions that drive growth and success for our clients.\n"
	 * + "\n" + "Innovation and Future Goals:\n" +
	 * "At TechGenius Solutions, we are committed to staying at the forefront of technological advancements. Our future goals include expanding our AI capabilities, delving into IoT (Internet of Things), and continuing to provide exceptional software services to our clients worldwide."
	 * ; }
	 * 
	 * 
	 * 
	 * @GetMapping("/policies")
	 * 
	 * public String getPolicies() {
	 * 
	 * return "TechGenius Solutions Company Policies:\n" + "\n" +
	 * "1. Equal Opportunity and Diversity:\n" +
	 * "   TechGenius Solutions is committed to providing equal employment opportunities and a diverse and inclusive workplace for all employees, regardless of their race, gender, age, religion, or background.\n"
	 * + "\n" + "2. Anti-Harassment and Respectful Workplace:\n" +
	 * "   We maintain a zero-tolerance policy for any form of harassment, discrimination, or bullying within the workplace. All employees are expected to treat each other with respect and professionalism.\n"
	 * + "\n" + "3. Code of Conduct:\n" +
	 * "   All employees are expected to adhere to our company's code of conduct, which includes maintaining ethical behavior, honesty, and integrity in all business dealings.\n"
	 * + "\n" + "4. Remote Work and Flexibility:\n" +
	 * "   TechGenius Solutions supports a flexible work environment, allowing employees to work remotely when necessary. Clear communication and accountability are essential for remote work arrangements.\n"
	 * + "\n" + "5. Intellectual Property and Confidentiality:\n" +
	 * "   Employees are required to respect the company's intellectual property and maintain strict confidentiality regarding sensitive business information, proprietary software, and client data.\n"
	 * + "\n" + "6. Data Security and Privacy:\n" +
	 * "   We prioritize the security and privacy of data. All employees must follow security protocols, protect sensitive information, and comply with data protection regulations.\n"
	 * + "\n" + "7. Professional Development:\n" +
	 * "   TechGenius Solutions encourages continuous learning and professional growth. We provide opportunities for skill enhancement, training, and attending relevant conferences.\n"
	 * + "\n" + "8. Health and Safety:\n" +
	 * "   Employee health and safety is a top priority. We ensure a safe and comfortable work environment and comply with all health and safety regulations.\n"
	 * + "\n" + "9. Anti-Corruption and Gifts:\n" +
	 * "   We prohibit any form of bribery, corruption, or unethical behavior. Employees must avoid conflicts of interest and refrain from giving or receiving inappropriate gifts.\n"
	 * + "\n" + "10. Social Responsibility:\n" +
	 * "    TechGenius Solutions is committed to social responsibility. We encourage employees to participate in community service initiatives and environmental conservation efforts.\n"
	 * + "\n" + "11. Dress Code:\n" +
	 * "    We promote a business-casual dress code for regular workdays. However, appropriate attire may vary based on the nature of the work and client interactions.\n"
	 * + "\n" + "12. Employee Benefits:\n" +
	 * "    Employees are eligible for a comprehensive benefits package, including health insurance, retirement plans, and wellness programs.\n"
	 * + ""; }
	 * 
	 * 
	 * @GetMapping("/protocol") public String getProtocol() {
	 * 
	 * return "TechGenius Solutions Company Protocols:\n" + "\n" +
	 * "1. Project Development Protocol:\n" +
	 * "   - Projects will follow Agile methodologies to ensure iterative development, regular feedback, and adaptability to changing requirements.\n"
	 * +
	 * "   - Each project will have a designated project manager responsible for tracking progress, managing resources, and ensuring timely delivery.\n"
	 * + "\n" + "2. Code Review and Version Control:\n" +
	 * "   - All code changes must undergo thorough peer code reviews to maintain code quality and consistency.\n"
	 * +
	 * "   - Version control using Git will be utilized for efficient collaboration, tracking changes, and managing codebase history.\n"
	 * + "\n" + "3. Quality Assurance and Testing:\n" +
	 * "   - A comprehensive testing strategy will be implemented, including unit testing, integration testing, and end-to-end testing.\n"
	 * +
	 * "   - Automated testing tools will be employed to catch defects early and ensure reliable software.\n"
	 * + "\n" + "4. Deployment and Continuous Integration:\n" +
	 * "   - Continuous integration and continuous deployment (CI/CD) pipelines will automate code integration, testing, and deployment to production environments.\n"
	 * + "\n" + "5. Change Management:\n" +
	 * "   - Any changes to production environments, systems, or software must follow a change management process to minimize risks and disruptions.\n"
	 * + "\n" + "6. Incident Response and Resolution:\n" +
	 * "   - An incident response protocol will be in place to address system outages, security breaches, and critical issues promptly and efficiently.\n"
	 * + "\n" + "7. Client Communication Protocol:\n" +
	 * "   - Regular client communication will be maintained to provide updates on project progress, address concerns, and gather feedback.\n"
	 * + "\n" + "8. Security Protocol:\n" +
	 * "   - Security best practices will be followed, including regular security audits, vulnerability assessments, and adherence to OWASP guidelines.\n"
	 * +
	 * "   - Data encryption and secure authentication mechanisms will be employed to protect sensitive information.\n"
	 * + "\n" + "9. Documentation and Knowledge Sharing:\n" +
	 * "   - Comprehensive documentation will be maintained for projects, codebase, and processes to facilitate knowledge sharing and onboarding.\n"
	 * +
	 * "   - Knowledge sharing sessions will be conducted regularly to promote cross-team learning and skill enhancement.\n"
	 * + "\n" + "10. Performance Monitoring and Optimization:\n" +
	 * "    - Real-time monitoring tools will be used to track system performance, identify bottlenecks, and optimize software for efficiency.\n"
	 * + "\n" + "11. Client Onboarding Protocol:\n" +
	 * "    - A structured onboarding process will be followed for new clients, including requirements gathering, project scope definition, and expectations alignment.\n"
	 * + "\n" + "12. DevOps and Infrastructure Protocol:\n" +
	 * "    - DevOps practices will be adopted to enhance collaboration between development and operations teams and automate infrastructure management."
	 * ; }
	 */
	
	
	
	
	

}
