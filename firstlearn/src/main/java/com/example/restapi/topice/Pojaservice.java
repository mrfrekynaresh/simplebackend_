package com.example.restapi.topice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Pojaservice {
	
	@Autowired
	Userdao userdao;

		List<Poja> alltopice() {
		return userdao.findAll();
	}

	Poja gettopice(String id) {
		return userdao.findById(id).orElse(null);
	}

       Poja posttopice(Poja a) {
		return userdao.save(a);
	}
	
	public void deletemathod(String id) {
		userdao.deleteById(id);
		
	}
}
