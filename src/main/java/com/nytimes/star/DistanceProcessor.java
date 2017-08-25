package com.nytimes.star;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DistanceProcessor implements ItemProcessor{
	
	private static final Logger log = LoggerFactory.getLogger(DistanceProcessor.class);

	public BigDecimal process(BigDecimal x, BigDecimal y, BigDecimal z) {
		//Needs to sqrted for accuracy but will work for ordering.
		return x.multiply(y.multiply(z));
	}
}
