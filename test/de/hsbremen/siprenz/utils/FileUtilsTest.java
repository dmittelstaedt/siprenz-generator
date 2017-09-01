package de.hsbremen.siprenz.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileUtilsTest {
	
	@Before
	public void setup() {
	}

	@Test
	public void testIsFileTrue() {
		Assert.assertTrue(FileUtils.isFile("/home/david/Documents/test"));
	}
	
	@Test
	public void testIsFileFalse() {
		Assert.assertFalse(FileUtils.isFile("/home/david/Documents/tests"));
	}

}
