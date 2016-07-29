/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.parentalControl.controller.Application;
import com.parentalControl.exceptions.TechnicalFailureException;
import com.parentalControl.exceptions.TitleNotFoundException;
import com.parentalControl.service.ParentalControlService;

/**
 * 
 * @author Mauricio Moreira de Aguilar 28/07/2016 21:53:21
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ParentalControlControllerTests {

	@Autowired
	private ParentalControlService parentalControlService;

	@Test
	public void testLevelUniversalEqualOrLessThanCustomersPreference() {
		boolean result = basicTest("U", "1");
		Assert.assertTrue(result);
	}

	@Test
	public void testLevelUniversalLessThanCustomersPreference()  {
		boolean result = basicTest("U", "2");
		Assert.assertFalse(result);
	}
	
	@Test
	public void testLevelFifteenLessThanCustomersPreference()  {
		boolean result = basicTest("15", "5");
		Assert.assertFalse(result);
	}
	
	@Test
	public void testNoLevel() {
		boolean result = basicTest("", "5");
		Assert.assertFalse(result);
	}
	
	@Test
	public void testNoMovieId(){
		boolean result = basicTest("18", "");
		Assert.assertFalse(result);
	}

	public boolean basicTest(String level1, String level2) {
		boolean result = false;
		try {
			result = parentalControlService.checkParentalControlLevel(level1, level2);
		} catch (TitleNotFoundException | TechnicalFailureException e) {
			e.printStackTrace();
		}
		return result;
	}
}
