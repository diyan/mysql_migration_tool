package com.mysql.grt.modules;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.SortedMap;
import com.mysql.grt.Grt;
import junit.framework.TestCase;
import junit.framework.Assert;
import java.sql.*;

public class MigrationMssqlTest extends TestCase {
	public static void testMigrateMssqlTable() {
		String b = "�";
		String c = "\u0027";
		String c2 = "\uFFFD";
				
		boolean z = b.contains(c2);
		
		//b.contains(new CharSequence(d));
		
		Timestamp value = Timestamp.valueOf("2011-11-04 11:43:17.0000000");
		
		//Timestamp value = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String f = dateFormat.format(value);
		
		int a = 1;
		assertEquals(1, a);
	}
	
	public static void testReadAnsiAsUtf8TextFromDatabase() throws IOException
	{
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=master;user=sa;password=sa;");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT some_table_name FROM some_column_name WHERE id = '1';");
		
			String name;
			while(resultSet.next())
			{
				byte[] a = resultSet.getBytes(1);
				//InputStream asciiStream = resultSet. getAsciiStream(1);
				//BufferedReader br = new BufferedReader(new InputStreamReader(asciiStream));
				//BufferedReader br = new BufferedReader(new InputStreamReader(asciiStream, Charset.defaultCharset()));
				String str = new String(a);
				String str2 = new String(a, "utf8");
				String str3 = new String(a, "UTF-8");
				

		        //while ((name = br.readLine()) != null) {
		        //  System.out.println(name);
		        //}
				
				
				//Reader reader = new InputStreamReader(asciiStream, Charset.forName("ascii"));
				//String a = reader.toString();
				

				//InputStream a = resultSet.getUnicodeStream(1);
				
				//Blob contentBlob = resultSet.getBlob(1);
				//byte[] contentByteArray = contentBlob.getBytes(1, (int) contentBlob.length());
				//String contentString = contentByteArray.toString();
				
				
				
				//String contentString = resultSet.getString(1);
				
				//InputStream contentAsciiStream = resultSet.getAsciiStream(1);
				
				// com.microsoft.sqlserver.jdbc.SQLServerException: The conversion from varchar to NCHAR is unsupported.
				// String contentNString = resultSet.getNString(1);
				
				System.out.print("");
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}