package com.faten.parfums;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.faten.parfums.entities.Parfum;
import com.faten.parfums.repos.ParfumRepository;
import com.faten.parfums.service.ParfumService;

@SpringBootTest
class Sprint1ApplicationTests {

	@Autowired
	private ParfumRepository parfumRepository;

	@Test
	public void testCreateParfum() {
		Parfum pars = new Parfum("Black opuim",2200.500,new Date());
		parfumRepository.save(pars);
		}
	@Test
	public void testFindParfum()
	{
	Parfum p = parfumRepository.findById(6L).get(); 
	System.out.println(p);
	}
	@Test
	public void testUpdateParfum()
	{
	Parfum p = parfumRepository.findById(6L).get();
	p.setPrixParfum(2000.0);
	parfumRepository.save(p);
	System.out.println(p);
	}
	
	@Test
	public void testDeleteParfum()
	{
	parfumRepository.deleteById(4L);;
	}
	@Test
	public void testListerTousParfums()
	{
	List<Parfum> pars = parfumRepository.findAll();
	for (Parfum p : pars)
	{
	System.out.println(p);
	}
	}
	
	 @Autowired
	    private ParfumService parfumService;
	@Test
	public void testFindByNomParfumContains()
	{
	Page<Parfum> pars = parfumService.getAllParfumsParPage(0,2);
	System.out.println(pars.getSize());
	System.out.println(pars.getTotalElements());
	System.out.println(pars.getTotalPages());
	pars.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	}

	
}
