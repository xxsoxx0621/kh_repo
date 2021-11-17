package utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateUtils {
	// 공통 메서드로 만들기
	public static Date stringToSQLDate(String str, String format) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return new Date (sdf.parse(str).getTime());
		
	}
}
