package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Utils {
	public static final Random RANDOM = new Random();

	public static int getRowStart(String rows, String page) {

		int rowStart = Integer.parseInt(rows) * (Integer.parseInt(page) - 1)
				+ 1;
		return rowStart;
	}

	public static int getRowEnd(String rows, String page) {

		int rowEnd = Integer.parseInt(rows) * (Integer.parseInt(page) - 1)
				+ Integer.parseInt(rows);
		return rowEnd;
	}

	public static int getRandom(final int min, final int max) {
		if (min >= max) {
			return min > 0 ? min : 1;
		}
		return RANDOM.nextInt(max - min + 1) + min;
	}

	/**
	 * String转Date
	 * 
	 * @param count
	 * @return
	 */
	public static Date StringToDate(String s) {
		Date date = null;
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 参数为你要格式化时间日期的模式

			date = df.parse(s);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * String转Date
	 * 
	 * @param count
	 * @return
	 */
	public static Date StringToDate2(String s) {
		Date date = null;
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 参数为你要格式化时间日期的模式

			date = df.parse(s);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * String转Date
	 * 
	 * @param count
	 * @return
	 */
	public static Date StringToDate3(String s) {
		Date date = null;
		try {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");// 参数为你要格式化时间日期的模式

			date = df.parse(s);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * Date转String
	 * 
	 * @param count
	 * @return
	 */
	public static String dateToString(Date d) {
		String dateString = "";
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 参数为你要格式化时间日期的模式

			dateString = df.format(d);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dateString;
	}
	/**
	 * Date转String
	 * 
	 * @param count
	 * @return
	 */
	public static String dateToString2(Date d) {
		String dateString = "";
		try {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");// 参数为你要格式化时间日期的模式

			dateString = df.format(d);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dateString;
	}

	/**
	 * 毫秒数转Date
	 * 
	 * @param t
	 * @return
	 */
	public static String LongToDate(long t) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date(t));
	}

	/**
	 * 获取两个日期相差的天数 yyyy-mm-dd
	 * 
	 * @param date
	 *            日期字符串
	 * @param otherDate
	 *            另一个日期字符串
	 * @return 相差天数
	 */
	public static int getIntervalDays(String date, String otherDate) {
		return getIntervalDays(StringToDate2(date), StringToDate2(otherDate));
	}

	/**
	 * @param date
	 *            日期 yyyy-mm-dd
	 * @param otherDate
	 *            另一个日期
	 * @return 相差天数
	 */
	public static int getIntervalDays(Date date, Date otherDate) {
		long time = Math.abs(date.getTime() - otherDate.getTime());
		return (int) time / (24 * 60 * 60 * 1000);
	}

	public static String visit(String a) throws Exception {
		URL url = null;
		// String a =
		// "http://192.168.0.202:18088/invoke?operation=loadBulletin&objectname=TLOL%3Aname%3DTLOL+MANAGER";
		url = new URL(a);

		URLConnection connection = url.openConnection();// 打开连接
		connection.connect();
		InputStream urlStream = connection.getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				urlStream, "UTF-8"));
		String rrr = "";
		String sCurrentLine = "";
		String[] resultUnDo = new String[3];
		while ((sCurrentLine = reader.readLine()) != null) {
			// HTTP协议返回三个空行
			if (!"".equals(sCurrentLine)) {
				rrr += sCurrentLine;
			}
		}
		resultUnDo = rrr.split("huoyunxieshen");
		urlStream.close();
		return resultUnDo[1];
	}

	public static String visitVoid(String a) throws Exception {
		URL url = null;
		String result = null;
		// String a =
		// "http://192.168.0.202:18088/invoke?operation=loadBulletin&objectname=TLOL%3Aname%3DTLOL+MANAGER";
		url = new URL(a);

		URLConnection connection = url.openConnection();// 打开连接

		connection.connect();

		InputStream urlStream = connection.getInputStream();
		// 获取返回网页代码
		Scanner sc = new Scanner(urlStream);
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (s.indexOf("clearline") > 0) {
				result = s;
				break;
			}
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				urlStream, "UTF-8"));
		String sCurrentLine = "";
		while ((sCurrentLine = reader.readLine()) != null) {
			// HTTP协议返回三个空行
			if (!"".equals(sCurrentLine)) {
			}
		}
		urlStream.close();

		System.out.println(((HttpURLConnection) connection).getResponseCode()
				+ "," + result);
		return ((HttpURLConnection) connection).getResponseCode() + ","
				+ result;
	}

	public static String visitStateAndResult(String a) throws Exception {
		URL url = null;
		String result = " ";
		// String a =
		// "http://192.168.0.202:18088/invoke?operation=loadBulletin&objectname=TLOL%3Aname%3DTLOL+MANAGER";
		url = new URL(a);

		URLConnection connection = url.openConnection();// 打开连接
		// 设置超时
		connection.setConnectTimeout(50000); // 设置连接主机超时（单位：毫秒）
		connection.setReadTimeout(50000);// 设置从主机读取数据超时（单位：毫秒）

		connection.connect();

		InputStream urlStream = connection.getInputStream();
		// 获取返回网页代码
		Scanner sc = new Scanner(urlStream);
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (s.indexOf("clearline") > 0) {
				result = s;
				break;
			}
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				urlStream, "UTF-8"));
		String sCurrentLine = "";
		while ((sCurrentLine = reader.readLine()) != null) {
			// HTTP协议返回三个空行
			if (!"".equals(sCurrentLine)) {
			}
		}
		urlStream.close();

		System.out.println(((HttpURLConnection) connection).getResponseCode()
				+ "," + result);
		return ((HttpURLConnection) connection).getResponseCode() + "@@"
				+ result;
	}

	/**
	 * 取得date之后的第几天
	 * 
	 * @param date
	 * @param next
	 *            第几天
	 * @return
	 */
	public static Date getNextDay(Date date, int next) {
		if (date == null)
			return null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.add(Calendar.DATE, next);
		return calendar.getTime();
	}

	/**
	 * 检验imei所在机型
	 * 
	 * @param a
	 * @return
	 * @throws Exception
	 */
	public static String visitStateAndResultImei(String a) throws Exception {
		URL url = null;
		String result = " ";
		// String a =
		// "http://192.168.0.202:18088/invoke?operation=loadBulletin&objectname=TLOL%3Aname%3DTLOL+MANAGER";
		url = new URL("http://www.numberingplans.com/?page=analysis&sub=imeinr");

		// 打开和URL之间的连接
		URLConnection connection = url.openConnection();// 打开连接

		HttpURLConnection conn = (HttpURLConnection) connection;
		conn.setRequestMethod("POST");

		// 设置超时
		connection.setConnectTimeout(50000); // 设置连接主机超时（单位：毫秒）
		connection.setReadTimeout(50000);// 设置从主机读取数据超时（单位：毫秒）

		// 设置通用的请求属性

		// 发送POST请求必须设置如下两行
		conn.setDoInput(true);
		conn.setDoOutput(true);

		conn.setRequestProperty("connection", "Keep-Alive");
		conn.setRequestProperty("Charsert", "UTF-8");
		conn.setInstanceFollowRedirects(true);
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		conn.connect();

		// 注意这里需要用缓存写入器进行写入不然到另外一端收不到
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				conn.getOutputStream(), "utf-8"));
		// 发送请求参数
		out.write("i=" + a);
		// flush输出流的缓冲
		out.flush();

		out.close();

		InputStream is = conn.getInputStream();

		InputStreamReader reader = new InputStreamReader(is, "utf-8");
		// 获取返回网页代码
		Scanner sc = new Scanner(reader);
		boolean flag = false;
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (flag) {
				result += s;
				flag = false;
			}
			if (s.indexOf("Type Allocation Holder") > 0
					|| s.indexOf("Mobile Equipment Type") > 0) {
				flag = true;
			}
		}

		BufferedReader reader1 = new BufferedReader(new InputStreamReader(is,
				"UTF-8"));
		String sCurrentLine = "";
		while ((sCurrentLine = reader1.readLine()) != null) {
			// System.out.println(sCurrentLine);
			// HTTP协议返回三个空行
			if (!"".equals(sCurrentLine)) {
			}
		}
		is.close();

		System.out.println(((HttpURLConnection) connection).getResponseCode()
				+ "," + result);
		return ((HttpURLConnection) connection).getResponseCode() + ","
				+ result;
	}

	public static void main(String[] args) {
		try {
			visitStateAndResultImei("i=357457043940213");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
