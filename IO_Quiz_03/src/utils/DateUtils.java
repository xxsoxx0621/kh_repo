package utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateUtils {

	
	public static Date dateSQLUtil (String write_date, String format) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return new Date(sdf.parse(write_date).getTime());
	}
}
