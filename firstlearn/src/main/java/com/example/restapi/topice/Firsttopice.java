package com.example.restapi.topice;

import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Firsttopice {

	@Autowired
	Pojaservice pojaservice;
	Poja poja;

	@RequestMapping("/topice")
	List<Poja> da() {
		return pojaservice.alltopice();
	}

	@RequestMapping("/topice/{id}")
	Poja gettopice(@PathVariable String id) {
		return pojaservice.gettopice(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = ("/topice"))
	void posttopice(@RequestBody Poja a) {
		pojaservice.posttopice(a);
	}

	@RequestMapping(method = RequestMethod.PUT, value = ("/topice/{id}"))
	public Poja putMethodName(@PathVariable String id, @RequestBody Poja poja) {
		Poja A=pojaservice.gettopice(id);
		
		if(A != null) {
			A.setName(poja.getName());
			A.setDes(poja.getDes());
			return pojaservice.posttopice(A);
		}
		else {
			return null;
		}
	}
	@RequestMapping(method= RequestMethod.DELETE, value=("/topice/{id}"))
	void deletmethod(@PathVariable String id) {
			pojaservice.deletemathod(id);
	}
}
