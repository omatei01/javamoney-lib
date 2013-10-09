/*
 * Copyright (c) 2012, 2013, Credit Suisse (Anatole Tresch), Werner Keil.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.javamoney.calc.common;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.money.MonetaryAdjuster;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.MonetaryRoundings;
import org.junit.Test;

public class PresentValueTest {

	@Test
	public void test() {
		PresentValue f = new PresentValue(new Rate(0.05), 1);
		Money money = Money.of("CHF", 100);
		MonetaryAdjuster rounding = MonetaryRoundings.getRounding(2,
				RoundingMode.HALF_EVEN);
		assertEquals(Money.of("CHF", BigDecimal.valueOf(95.24)), f.adjustInto(money)
				.with(rounding));
		f = new PresentValue(new Rate(0.05), 2);
		assertEquals(Money.of("CHF", new BigDecimal("90.70")),
				f.adjustInto(money).with(rounding));
		f = new PresentValue(new Rate(0.05), 3);
		assertEquals(Money.of("CHF", BigDecimal.valueOf(86.38)),
				f.adjustInto(money).with(rounding));
	}
}
