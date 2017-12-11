package com.mycompany.camel.spring;

import org.apache.camel.builder.RouteBuilder;

public class TestRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		from("file:src/data")
		.log("final : ${body}");
		
	}

}
