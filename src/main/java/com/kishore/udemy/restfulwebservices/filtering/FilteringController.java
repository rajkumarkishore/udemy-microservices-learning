package com.kishore.udemy.restfulwebservices.filtering;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping(path = "/filtering")
	public SomeBean getSomeBean() {
		return new SomeBean("attr1", "attr2");
	}

	@GetMapping(path = "/filtering-list")
	public List<SomeBean> listAllSomeBeans() {

		List<SomeBean> list = new ArrayList<>();
		list.add(new SomeBean("attr1", "attr2"));
		list.add(new SomeBean("attr3", "attr4"));
		list.add(new SomeBean("attr5", "attr6"));

		return list;
	}

	@GetMapping(path = "/dynamic-filtering")
	public MappingJacksonValue getSomeBeanDynamically() {
		
		SomeBeanDynamic someBean = new SomeBeanDynamic("attr1", "attr2");

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("attr2");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		
		return mapping;
	}

	@GetMapping(path = "/dynamic-filtering-list")
	public List<SomeBean> listAllSomeBeansDynamically() {

		List<SomeBean> list = new ArrayList<>();
		list.add(new SomeBean("attr1", "attr2"));
		list.add(new SomeBean("attr3", "attr4"));
		list.add(new SomeBean("attr5", "attr6"));

		return list;
	}

}
