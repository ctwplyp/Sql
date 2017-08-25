package com.nytimes.star;

import java.math.BigDecimal;

public interface ItemProcessor {
	
	BigDecimal process(BigDecimal x, BigDecimal y, BigDecimal z);

}
