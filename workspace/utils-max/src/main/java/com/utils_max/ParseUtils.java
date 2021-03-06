package com.utils_max;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


public class ParseUtils {
	/**
	 * @Title:isEmpty
	 * @Description:集合是否为空
	 * @param @param s
	 * @param @return
	 * @return boolean-
	 * @throws
	 * @author xiehz
	 * @date 2015年4月27日
	 */
	public static boolean isEmpty(Collection<?> s) {
		if (null == s) {
			return true;
		}
		return s.isEmpty();
	}

	/**
	 * @Title:isEmpty
	 * @Description:map是否为空
	 * @param @param s
	 * @param @return
	 * @return boolean
	 * @throws
	 * @author xiehz
	 * @date 2015年4月27日
	 */
	public static boolean isEmpty(Map<?, ?> s) {
		if (null == s) {
			return true;
		}
		return s.isEmpty();
	}

	/**
	 * @Title:isEmpty
	 * @Description:字符串是否为空
	 * @param @param s
	 * @param @return
	 * @return boolean
	 * @throws
	 * @author xiehz
	 * @date 2015年4月27日
	 */
	public static boolean isEmpty(String s) {
		if (null == s) {
			return true;
		}
		return s.toString().trim().length() <= 0;
	}

	/**
	 * @Title:isEmpty
	 * @Description:对象是否为空
	 * @param @param s
	 * @param @return
	 * @return boolean
	 * @throws
	 * @author xiehz
	 * @date 2015年4月27日
	 */
	public static <T> boolean isEmpty(T s) {
		if (null == s) {
			return true;
		}
		return false;

	}

	/**
	 * @Title:isEmpty
	 * @Description:对象是否为空
	 * @param @param s
	 * @param @return
	 * @return boolean
	 * @throws
	 * @author xiehz
	 * @date 2015年4月27日
	 */
	public static <T> boolean isEmpty(T[] s) {
		if (null == s) {
			return true;
		}
		return Array.getLength(s) < 1;
	}

	/**
	 * @Title:isNotEmpty
	 * @Description:集合不为空
	 * @param @param s
	 * @param @return
	 * @return boolean
	 * @throws
	 * @author xiehz
	 * @date 2015年4月27日
	 */
	public static boolean isNotEmpty(Collection<?> s) {
		if (null == s) {
			return false;
		}
		return !s.isEmpty();
	}

	/**
	 * @Title:isNotEmpty
	 * @Description:map不为空
	 * @param @param s
	 * @param @return
	 * @return boolean
	 * @throws
	 * @author xiehz
	 * @date 2015年4月27日
	 */
	public static boolean isNotEmpty(Map<?, ?> s) {
		if (null == s) {
			return false;
		}
		return !s.isEmpty();
	}
	
	/**
	 * double 加运算
	 * @param first
	 * @param second
	 * @return
	 */
	public static double doubleAdd(Double first,Double second){
		  BigDecimal b1 = new BigDecimal(Double.toString(first));
		  BigDecimal b2 = new BigDecimal(Double.toString(second));
		  return b1.add(b2).doubleValue();
	}


	/**
	 * double 减运算
	 * @param first
	 * @param second
	 * @return
	 */
	public static double doubleSub(Double first,Double second){
		  BigDecimal b1 = new BigDecimal(Double.toString(first));
		  BigDecimal b2 = new BigDecimal(Double.toString(second));
		  return b1.subtract(b2).doubleValue();
	}
	/**
	 * double 乘运算
	 * @param first
	 * @param second
	 * @return
	 */
	public static double doubleMul(Double first, Double second) {
		BigDecimal b1 = new BigDecimal(Double.toString(first));
		BigDecimal b2 = new BigDecimal(Double.toString(second));
		return b1.multiply(b2).doubleValue();
	}
	/**
	 * 字符串不为空 ***********************************
	 * 
	 * @author xiehz
	 * @create_date 2013-10-11 下午10:03:09
	 * @param t
	 * @return ***********************************
	 */
	public static boolean isNotEmpty(String s) {
		if (null == s) {
			return false;
		}
		return s.toString().trim().length() > 0;
	}

	/**
	 * int 大于等于0 ***********************************
	 * 
	 * @author xiehz
	 * @create_date 2013-10-11 下午10:03:09
	 * @param t
	 * @return ***********************************
	 */
	public static boolean isNotEmpty(Integer s) {
		if (null == s) {
			return false;
		}
		return s >= 0;
	}

	/**
	 * 对象是否为空 ***********************************
	 * 
	 * @author xiehz
	 * @create_date 2013-10-11 下午10:03:09
	 * @param t
	 * @return ***********************************
	 */
	public static <T> boolean isNotEmpty(T s) {
		if (null == s) {
			return false;
		}
		return !isEmpty(s);
	}

	/**
	 * 转换list为 id列表 ***********************************
	 * 
	 * @author xiehz
	 * @create_date 2013-10-11 下午10:03:18
	 * @param t
	 * @return ***********************************
	 */
	public static <T> String listToString(Collection<T> t, String keyName) {
		String methodName = "";
		StringBuilder keys = new StringBuilder();
		try {
			for (T t2 : t) {
				methodName = "get" + keyName.substring(0, 1).toUpperCase() + keyName.substring(1);
				Method method = t2.getClass().getDeclaredMethod(methodName);
				Object res = method.invoke(t2);
				if (null != res) {
					keys.append(res);
					keys.append(",");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (keys.length() > 0) {
			return keys.substring(0, keys.length() - 1);
		} else {
			return "";
		}
	}

	/**
	 * 转换list为 id列表 ***********************************
	 * 
	 * @author xiehz
	 * @create_date 2013-10-11 下午10:03:18
	 * @param t
	 * @return ***********************************
	 */
	public static <T> String arrayToString(T[] t) {
		StringBuilder keys = new StringBuilder();
		for (T t2 : t) {
			keys.append(t2);
			keys.append(",");
		}
		if (keys.length() > 0) {
			return keys.substring(0, keys.length() - 1);
		} else {
			return "";
		}
	}

	/**
	 * 转换list为 id列表 ***********************************
	 * 
	 * @author xiehz
	 * @create_date 2013-10-11 下午10:03:18
	 * @param t
	 * @return ***********************************
	 */
	public static <T> String listToString(Collection<T> t) {
		StringBuilder keys = new StringBuilder();
		for (T t2 : t) {
			keys.append(t2);
			keys.append(",");
		}
		if (keys.length() > 0) {
			return keys.substring(0, keys.length() - 1);
		} else {
			return "";
		}
	}

	public static String toFirstLetterUpperCase(String str) {
		if (str == null || str.length() < 2) {
			return str;
		}
		String firstLetter = str.substring(0, 1).toUpperCase();
		return firstLetter + str.substring(1, str.length());
	}

	/**
	 * 整型转换为4位字节数组
	 * 
	 * @author xiehz
	 * @create_date 2015-1-27 下午5:11:58
	 * @param intValue
	 * @return
	 */
	public static byte[] int2Byte(int intValue) {
		byte[] b = new byte[4];
		for (int i = 0; i < 4; i++) {
			b[i] = (byte) (intValue >> 8 * (3 - i) & 0xFF);
			// System.out.print(Integer.toBinaryString(b[i])+" ");
			// System.out.print((b[i] & 0xFF) + " ");
		}
		return b;
	}

	/**
	 * 4位字节数组转换为整型
	 * 
	 * @author xiehz
	 * @create_date 2015-1-27 下午5:11:47
	 * @param b
	 * @return
	 */
	public static int byte2Int(byte[] b) {
		int intValue = 0;
		// int tempValue = 0xFF;
		for (int i = 0; i < b.length; i++) {
			intValue += (b[i] & 0xFF) << (8 * (3 - i));
			// System.out.print(Integer.toBinaryString(intValue)+" ");
		}
		return intValue;
	}

	/**
	 * @author xiehz
	 * @create_date 2014-8-7 上午10:16:59
	 * @param score
	 * @return
	 */
	public static Float parseFloat(String score) {
		if (isNotEmpty(score)) {
			if (isDouble(score)) {
				return Float.valueOf(score);
			}
		}
		return 0f;
	}
	
	public static Double parseDouble(String score) {
		if (isNotEmpty(score)) {
			if (isDouble(score)) {
				return Double.valueOf(score);
			}
		}
		return 0d;
	}

	/**
	 * @author xiehz
	 * @create_date 2014-8-7 上午10:16:59
	 * @param score
	 * @return
	 */
	public static Integer parseInt(String score) {
		if (isNotEmpty(score)) {
			if (isDouble(score)) {
				return Integer.valueOf(score);
			}
		}
		return 0;
	}

	public static Long parseLong(String score) {
		if (isNotEmpty(score)) {
			if (isDouble(score)) {
				return Long.valueOf(score);
			}
		}
		return 0l;
	}

	public static final Pattern integerPattern = Pattern.compile("^[-\\+]?[\\d]*$");

	/**
	 * 
	 * @author xiehz
	 * @create_date 2014-8-7 上午10:23:15
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str) {
		return integerPattern.matcher(str).matches();
	}

	/*
	 * 
	 * @param str
	 * 
	 * @return
	 */
	public static final Pattern floatPattern = Pattern.compile("^[-\\+]?[.\\d]*$");

	/**
	 * 判断是否为浮点数，包括double和float
	 * 
	 * @author xiehz
	 * @create_date 2014-8-7 上午10:22:54
	 * @param str传入的字符串
	 * @return是浮点数返回true,否则返回false
	 */
	public static boolean isDouble(String str) {
		return floatPattern.matcher(str).matches();
	}

	/**
	 * @author xiehz
	 * @create_date 2014-8-8 上午11:26:33
	 * @param difficulty
	 * @return
	 */
	public static byte stringToByte(String difficulty) {

		if (isNotEmpty(difficulty)) {
			if (difficulty.length() == 1) {
				return Byte.valueOf(difficulty);
			}
		}
		return (byte) 0;
	}

	/**
	 * @author xiehz
	 * @create_date 2014-9-1 下午5:26:29
	 * @param paperIdSb
	 * @return
	 */
	public static String setToString(Set<Integer> set) {
		if (isEmpty(set)) {
			return "";
		}
		String ids = set.toString();
		return ids.substring(1, ids.length() - 1);
	}

	/**
	 * 判断 a 是否在【a,b,c】集合中
	 * 
	 * @author xiehz
	 * @create_date 2015-1-27 下午5:12:27
	 * @param org
	 * @param compArray
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> boolean isIn(T org, T... compArray) {
		for (T t : compArray) {
			if (t.equals(org)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	* @param regex
	* 正则表达式字符串
	* @param str
	* 要匹配的字符串
	* @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
	*/
	private static boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	/**
	* 验证数字输入
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsNumber(String str) {
		String regex = "^[0-9]*$";
		return match(regex, str);
	}
	
	/**
	* 验证非零的正整数
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsIntNumber(String str) {
		String regex = "^\\+?[1-9][0-9]*$";
		return match(regex, str);
	}

	
	/**
	 * 数字和字母混合
	 */
	public static final Pattern numberAlphaPattern = Pattern.compile("^[A-Za-z0-9]+$");

	public static boolean isNumberAlphaFix(String str) {
		return numberAlphaPattern.matcher(str).matches();
	}

	/**
	 * 
	 * @Title: getPropertyValue
	 * @Description: 读取实体bean属性值
	 * @param @param bean
	 * @param @param propertyName
	 * @param @return
	 * @return Object
	 * @throws
	 */
	@SuppressWarnings("finally")
	public static Object getPropertyValue(Object bean, String propertyName) {
		Object result = null;
		if (propertyName.equals("serialVersionUID")) {
			return result;
		}
		PropertyDescriptor pd;
		try {
			pd = new PropertyDescriptor(propertyName, bean.getClass());
			Method m = pd.getReadMethod();
			result = m.invoke(bean);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			return result;
		}
	}

	/**
	 * 
	 * @Title: setProperty
	 * @Description: 设置实体bean的属性值
	 * @param @param bean
	 * @param @param propertyName
	 * @param @param value
	 * @return void
	 * @throws
	 */
	public static void setProperty(Object bean, String propertyName, Object value) {
		PropertyDescriptor pd;
		try {
			pd = new PropertyDescriptor(propertyName, bean.getClass());
			Method m = pd.getWriteMethod();
			// 设置属性值
			m.invoke(bean, value);
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将父类 值cope到子类 父类属性 需public
	 * 
	 * @param father
	 * @param child
	 * @return
	 * @throws Exception
	 */
	public static Object fatherToChild(Object father, Object child) throws Exception {
		if (!(child.getClass().getSuperclass() == father.getClass())) {
			throw new Exception("child不是father的子类");
		}
		@SuppressWarnings("rawtypes")
		Class fatherClass = father.getClass();
		Field ff[] = fatherClass.getDeclaredFields();
		for (int i = 0; i < ff.length; i++) {
			Field f = ff[i];// 取出每一个属性，如deleteDate
			@SuppressWarnings({ "unused", "rawtypes" })
			Class type = f.getType();
			String nameString = upperHeadChar(f.getName());
			if (!"SerialVersionUID".equals(nameString)) {
				@SuppressWarnings("unchecked")
				Method m = fatherClass.getMethod("get" + upperHeadChar(f.getName()));// 方法getDeleteDate
				Object obj = m.invoke(father);// 取出属性值
				f.set(child, obj);
			}
		}
		return child;
	}

	/**
	 * 首字母大写，in:deleteDate，out:DeleteDate
	 */
	private static String upperHeadChar(String in) {
		String head = in.substring(0, 1);
		String out = head.toUpperCase() + in.substring(1, in.length());
		return out;
	}

	// 过滤 ‘
	// ORACLE 注解 -- /**/
	// 关键字过滤 update ,delete
	static String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|" + "(\\b(select|update|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";

	static Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);

	/***************************************************************************
	 * 参数校验 URLDecoder.decode(param,"UTF-8")
	 * 
	 * @param str  
	 * @return true没有危险，false有风险
	 */
	public static boolean validSqlStr(String str) {
		if (sqlPattern.matcher(str).find()) {
			// logger.error("未能通过过滤器：p=" + p);
			return false;
		}
		return true;
	}

	/**
	 * 有空格
	 * 
	 * @param s
	 * @return
	 */
	public static boolean hasKongge(String s) {
		int i = s.indexOf(" ");
		if (i == -1)
			return true;
		return false;
	}
	
	
	
	/**
	 * 手机号码验证
	 * 
	 * @param phoneNum
	 * @return
	 */
	public static boolean isMobile(String mobiles){  
		if(isChinaPhoneLegal(mobiles))
			return true;
		return isHKPhoneLegal(mobiles);
	}  
	
	/**
	 * 大陆手机号
	 * @param str
	 * @return
	 */
	public static boolean isChinaPhoneLegal(String str) {  
        String regExp = "^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-8])|(147))\\d{8}$";  
        Pattern p = Pattern.compile(regExp);  //
        Matcher m = p.matcher(str);  
        return m.matches();  
    }  
  
    /** 
     * 香港手机号码8位数，5|6|8|9开头+7位任意数 
     */  
    public static boolean isHKPhoneLegal(String str) {  
        String regExp = "^(5|6|8|9)\\d{7}$";  
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(str);  
        return m.matches();  
    }  
	
	
	/**
	 * 微信emoji表情过滤
	 * @param source
	 * @return
	 */
	public static String filterEmoji(String source) { 
		if (source != null) {
			Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
			Matcher emojiMatcher = emoji.matcher(source);
			if (emojiMatcher.find()) {
				source = emojiMatcher.replaceAll("*");
				return source;
			}
			return source;
		}
		return source;
    }
	
	/**
     * 过滤emoji 或者 其他非文字类型的字符
     * @param source  需要过滤的字符串
     * @return
     */
	public static String filterEmojiNew(String source) {
		if (!containsEmoji(source)) {
			return source;// 如果不包含，直接返回
		}
		StringBuilder buf = null;// 该buf保存非emoji的字符
		int len = source.length();
		for (int i = 0; i < len; i++) {
			char codePoint = source.charAt(i);
			if (notisEmojiCharacter(codePoint)) {
				if (buf == null) {
					buf = new StringBuilder(source.length());
				}
				buf.append(codePoint);
			}
		}

		if (buf == null) {
			return "";// 如果没有找到非emoji的字符，则返回无内容的字符串
		} else {
			if (buf.length() == len) {
				buf = null;
				return source;
			} else {
				return buf.toString();
			}
		}
	}
	
	/**
     * 非emoji表情字符判断
     * @param codePoint
     * @return
     */
	private static boolean notisEmojiCharacter(char codePoint) {
		return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) || (codePoint == 0xD) || ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
	}

	/**
	 * 检测是否有emoji字符
	 * 
	 * @param source  需要判断的字符串
	 * @return 一旦含有就抛出
	 */
	public static boolean containsEmoji(String source) {
		int len = source.length();
		for (int i = 0; i < len; i++) {
			char codePoint = source.charAt(i);
			if (!notisEmojiCharacter(codePoint)) {
				// 判断确认有表情字符
				return true;
			}
		}
		return false;
	}
	
    
	
	public static String filterUtf8Mb4(String text)  {
		try {
			byte[] bytes = text.getBytes("UTF-8");
			ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
			int i = 0;
			while (i < bytes.length) {
				short b = bytes[i];
				if (b > 0) {
					buffer.put(bytes[i++]);
					continue;
				}
				b += 256;
				if ((b ^ 0xC0) >> 4 == 0) {
					buffer.put(bytes, i, 2);
					i += 2;
				} else if ((b ^ 0xE0) >> 4 == 0) {
					buffer.put(bytes, i, 3);
					i += 3;
				} else if ((b ^ 0xF0) >> 4 == 0) {
					i += 4;
				}
			}
			buffer.flip();
			return new String(buffer.array(), "utf-8");
		} catch (Exception e) {
			
		}
		return filterEmoji(text);
	} 
	
	/**
	 * 获取url中的参数 
	 * @param URL
	 * @return
	 */
	public static Map<String, String> getUrlParam(String URL) {
		Map<String, String> mapRequest = new HashMap<String, String>();

		String[] arrSplit = null;

		String strUrlParam = TruncateUrlPage(URL);
		if (strUrlParam == null) {
			return mapRequest;
		}
		// 每个键值为一组 www.2cto.com
		arrSplit = strUrlParam.split("[&]");
		for (String strSplit : arrSplit) {
			String[] arrSplitEqual = null;
			arrSplitEqual = strSplit.split("[=]");
			// 解析出键值
			if (arrSplitEqual.length > 1) {
				// 正确解析
				mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);

			} else {
				if (arrSplitEqual[0] != "") {
					// 只有参数没有值，不加入
					mapRequest.put(arrSplitEqual[0], "");
				}
			}
		}
		return mapRequest;
	}

	private static String TruncateUrlPage(String strURL) {
		String strAllParam = null;
		String[] arrSplit = null;

		strURL = strURL.trim().toLowerCase();

		arrSplit = strURL.split("[?]");
		if (strURL.length() > 1) {
			if (arrSplit.length > 1) {
				if (arrSplit[1] != null) {
					strAllParam = arrSplit[1];
				}
			}
		}
		return strAllParam;
	}
	
	
	/**
	 * xmlStr 转化成map
	 * 
	 * @param xml
	 * @return
	 */
	public static Map<String, Object> xml2Map(String xml) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			Document document = DocumentHelper.parseText(xml);
			Element root = document.getRootElement();
			List<Element> list = root.elements();
			if (list != null && list.size() > 0) {
				for (Element element : list) {
					map.put(element.getName(), element.getText());
				}
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 将 xmlStr 转成 hashMap 
	 * @param xml
	 * @return
	 */
	public static Map<String, String> xmlToMap(String xml) {
		try {
			Map<String, String> map = new TreeMap<String, String>();
			Document document = DocumentHelper.parseText(xml);
			Element root = document.getRootElement();

			List<Element> list = root.elements();
			if (list != null && list.size() > 0) {
				for (Element element : list) {
					map.put(element.getName(), element.getText());
				}
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static SortedMap<String, String> xmlToStoedMap(String xml) {
		try {
			SortedMap<String, String> sortedMap = new TreeMap<String, String>();
			Document document = DocumentHelper.parseText(xml);
			Element root = document.getRootElement();
			List<Element> list = root.elements();
			if (list != null && list.size() > 0) {
				for (Element element : list) {
					sortedMap.put(element.getName(), element.getText());
				}
			}
			return sortedMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
