package cn.liu.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class DateUtil {
	
	private static Log  log = LogFactory.getLog(DateUtil.class);
	private static final String DEFAULT_DATE_PATTERN = "yyyyMMdd";
	private static final String DEFAULT_DATETIME_PATTERN = "yyyyMMddHHmmss";
	private static final String DEFAULT_YEAE_PATTERN = "yyyy";
	private static final String DEFAULT_YEAE_MONTH_PATTERN = "yyyyMM";;

	private static final long ONE_MINUTE = 60;
	private static final long ONE_HOUR = 3600;
	private static final long ONE_DAY = 86400;
	private static final long ONE_MONTH = 2592000;
	private static final long ONE_YEAR = 31104000;

	public static String getDatePattern() {
		return DEFAULT_DATE_PATTERN;
	}

	public static String getYearMonthPattern() {
		return DEFAULT_YEAE_MONTH_PATTERN;
	}
	//获取当前日期
	//以 yyyy-mm-dd 形式
	public static Date currentDate(){
		return strToDate(dateToStr(new Date(),DEFAULT_DATE_PATTERN),DEFAULT_DATE_PATTERN);
	}
	public static Date currentDateTime(){
		return strToDate(dateToStr(new Date(),DEFAULT_DATETIME_PATTERN),DEFAULT_DATETIME_PATTERN);
	}

	//获取当前日期
	public static String currentDate2Str() {
		return dateToStr(new Date(),DEFAULT_DATE_PATTERN);
	}

	//获取当月
	public static String currentMonth(){
		return dateToStr(new Date(),DEFAULT_YEAE_MONTH_PATTERN);
	}
	//获取当年
	public static String currentYear(){
		return dateToStr(new Date(),DEFAULT_YEAE_PATTERN);
	}
	public static String getDateTimePattern() {
		return DateUtil.getDatePattern() + " HH:mm:ss.S";
	}

	//日期转字符串 ，使用的默认 pattern
	public static String dateToStr(Date date) {
		if(date == null){
			return StringUtils.EMPTY;
		}
		SimpleDateFormat df = new SimpleDateFormat(getDatePattern());
		return df.format(date);
	}
	//日期转字符串 ，可自定义 pattern
	public static String dateToStr(Date aDate,String pattern) {
		if(aDate == null){
			return StringUtils.EMPTY;
		}
		if(StringUtils.isEmpty(pattern)){
			pattern = DEFAULT_DATE_PATTERN;
		}
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(aDate);
	}

	/**
	 * datetime to string 
	 * @param aDate
	 * @return yyyy-MM-dd HH:mm 的格式
	 */
	public static String dateTimeToStr(Date aDate) {
		if(aDate == null){
			return StringUtils.EMPTY;
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm");
		return df.format(aDate);
	}

	/**
	 * datetime to string
	 * @param aDate
	 * @return
	 */
	public static String dateTimeToStrWithSecond(Date aDate) {
		if(aDate == null){
			return StringUtils.EMPTY;
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		return df.format(aDate);
	}


	//字符串转日期
	public static Date strToDate(String strDate,String pattern){
		if(StringUtils.isEmpty(strDate)){
			return null;
		}
		if(StringUtils.isEmpty(pattern)){
			pattern = DEFAULT_DATE_PATTERN;
		}
		try {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			return df.parse(strDate);
		} catch (ParseException pe) {
			log.error("字符串转日期出错："+ pe.getMessage());
			return null;
		}
	}
	//字符串转日期
	public static Date strToDate(String strDate){
		return strToDate(strDate,DEFAULT_DATE_PATTERN);
	}

	/**
	 * 根据日期获取星期几
	 * @param date java.util.Date对象,不能为null
	 * @return
	 */
	public static int getDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK) - 1;
	}

	/**
	 * 统计两个时间差，返回的是天数(即24小时算一天，少于24小时就为0，用这个的时候最好把小时、分钟等去掉)
	 * @param beginDate 开始时间  不能为空
	 * @param endDate 结束时间 不能为空
	 * @return
	 */
	public static int getDays(String beginDate, String endDate) {
		return getDays(beginDate, endDate, DEFAULT_DATE_PATTERN);
	}
	/**
	 * 统计两个时间差，返回的是天数(即24小时算一天，少于24小时就为0，用这个的时候最好把小时、分钟等去掉)
	 * @param begin 开始时间
	 * @param end
	 * @return
	 */
	public static int getDays(String beginDate, String endDate,String pattern) {
		return getDays(strToDate(beginDate, pattern),strToDate(endDate, pattern));
	}


	/**
	 * 统计两个时间差，返回的是天数(即24小时算一天，少于24小时就为0，用这个的时候最好把小时、分钟等去掉)
	 * @param beginDate 开始时间  不能为空 Date 类型
	 * @param endDate 结束时间 不能为空 Date 类型
	 * @return
	 */
	public static int getDays(Date beginDate, Date endDate) {
		long times = endDate.getTime() - beginDate.getTime();
		return (int) (times / 60 / 60 / 1000 / 24);
	}

	/**
	 * 验证日期：是否为 yyyy-mm-dd 的格式
	 * @param str_date
	 * @return
	 */
	public static boolean isValidDate(String str_date){
		String eL = "^((19|20)\\d\\d)(0?[1-9]|1[012])(0?[1-9]|[12][0-9]|3[01])$";
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(str_date);
		return m.matches();
	}
	

	/**
	 * 验证日期：是否为 yyyy-MM 的格式
	 * @param str_date
	 * @return
	 */
	public static boolean validate4YearMonth(String str_date){
		String eL = "^((19|20)\\d\\d)(0?[1-9]|1[012])$";
		Pattern p = Pattern.compile(eL);         
		Matcher m = p.matcher(str_date);
		return m.matches();
	}

	public static int getAgeByBirthday(Date birthday) {
		if(birthday == null){
			return 0;
		}
		Calendar cal = Calendar.getInstance();
		if (cal.before(birthday)) {
			throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthday);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
		int age = yearNow - yearBirth;
		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				// monthNow==monthBirth 
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				// monthNow>monthBirth 
				age--;
			}
		}
		return age;
	}

	/**
	 * unix timestamp to date unixtimestamp 转日期
	 * @param unixtimestamp
	 * @return
	 */
	public static Date unixTimestampToDate(Integer unixtimestamp){
		long timestamp = unixtimestamp*1000l;
		Date date = new Date(timestamp); 
		return date;
	}


	/**
	 * unix timestamp to date unixtimestamp 转日期
	 * @param unixtimestamp
	 * @return
	 */
	public static Date unixTimestampToDate(String unixtimestamp){
		long timestamp = Integer.parseInt(unixtimestamp)*1000l;
		Date date = new Date(timestamp); 
		return date;
	}

	/**
	 * date to unitimestamp 日期转 unixtimestamp
	 * @param date
	 * @return
	 */
	public static Integer dateToUnixTimestamp(Date date){
		if(date == null){
			return null;
		}
		return Integer.parseInt(String.valueOf(date.getTime() / 1000l));
	}

	/** 
	 * 将一个时间戳转换成提示性时间字符串，如刚刚，1秒前 
	 *  
	 * @param timeStamp 
	 * @return 
	 */ 
	public static String convertTimeToFormat(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		long time = date.getTime() / 1000;
		long now = new Date().getTime() / 1000;
		long ago = now - time;
		if(ago <= ONE_MINUTE){
			return "刚刚";
		}else if (ago <= ONE_HOUR)
			return (ago / ONE_MINUTE) + "分钟前";
		else if (ago <= ONE_DAY)
			return ago / ONE_HOUR + "小时前";
		else if (ago <= ONE_DAY * 2)
			return "昨天" + calendar.get(Calendar.HOUR_OF_DAY) + "点";
		else if (ago <= ONE_DAY * 3)
			return "前天" + calendar.get(Calendar.HOUR_OF_DAY) + "点";
		else if (ago <= ONE_MONTH) {
			long day = ago / ONE_DAY;
			return day + "天前";
		} else if (ago <= ONE_YEAR) {
			long month = ago / ONE_MONTH;
			//long day = ago % ONE_MONTH / ONE_DAY;
			return month + "个月前";
		} else {
			long year = ago / ONE_YEAR;
			//int month = calendar.get(Calendar.MONTH) + 1;// JANUARY which is 0 so month+1
			return year + "年前";
		}

	}




	public static void  main(String a[]){
	}

}
