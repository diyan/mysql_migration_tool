
package com.mysql.grt.modules;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.mysql.grt.Grt;

import junit.framework.TestCase;
import junit.framework.Assert;

public class MigrationMssqlTest extends TestCase {
	public static void testMigrateMssqlTable() {
		
		Timestamp value2 = Timestamp.valueOf("2011-11-04 11:43:17.0000000");
		
		Timestamp value = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String f = dateFormat.format(value);
		
		int a = 1;
		assertEquals(1, a);
	}
}