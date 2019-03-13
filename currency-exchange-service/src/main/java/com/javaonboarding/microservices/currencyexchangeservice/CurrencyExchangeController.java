package com.javaonboarding.microservices.currencyexchangeservice;

import java.math.BigDecimal;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class CurrencyExchangeController {
	
	
	@Autowired
	private  Environment environment ;
	
	@Autowired
	private ExchangeValueRepository repository;
//localhost:8000/currency-exchange/from/aus/to/ind
	//localhost:8000/currency-exchange/from/AUS/to/INR
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from,@PathVariable String to)
	{
		//Hard coded initially before connecting H2 DB
		/*ExchangeValue exchangeValue =  new ExchangeValue(100L,from,to,BigDecimal.valueOf(65));*/
		
		ExchangeValue exchangeValue =repository.findByFromAndTo(from,to);
		exchangeValue.setPort((Integer.parseInt(environment.getProperty("local.server.port"))));
		
		return exchangeValue;
	}
}
