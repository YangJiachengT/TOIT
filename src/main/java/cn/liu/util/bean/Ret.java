package cn.liu.util.bean;
import java.util.HashMap;

import java.util.Map;

/**
 * Ret 用于返回值封装，也用于服务端与客户端的 json 数据通信
 * 一、主要应用场景：
 * 业务层需要返回多个返回值，例如要返回业务状态以及数据
 * 二、实例
 * 服务端：
 * Ret ret = service.justDoIt(paras);
 * return ret;
 * 客户端：
 * 	success: function(ret) {
 *  	if(ret.state == "ok") {
 *       	...
 *  	}
 *       
 *  	if (ret.state == "fail") {
 *       	...
 *  	}
 *  }
 * @author liu
 */
@SuppressWarnings({ "serial", "rawtypes","unchecked" })
public class Ret extends HashMap {
	
	private static final String STATE = "state";
	private static final String STATE_OK = "ok";
	private static final String STATE_FAIL = "fail";
	private static final String MESSAGE = "message";
	public Ret() {}
	
	public static Ret ok() {
		return new Ret().setOk();
	}
	
	public static Ret ok(Object key, Object value) {
		return ok().set(key, value);
	}
	
	public static Ret fail() {
		return new Ret().setFail();
	}
	
	public static Ret fail(Object key, Object value) {
		return fail().set(key, value);
	}
	
	public Ret setOk() {
		super.put(STATE, STATE_OK);
		return this;
	}
	
	public Ret setFail() {
		super.put(STATE, STATE_FAIL);
		return this;
	}
	
	public Ret setMessage(Object value) {
		super.put(MESSAGE, value);
		return this;
	}
	public Object getMessage() {
		return super.get(MESSAGE);
	}
	
	public boolean isOk() {
		Object state = get(STATE);
		if (STATE_OK.equals(state)) {
			return true;
		}
		if (STATE_FAIL.equals(state)) {
			return false;
		}
		throw new IllegalStateException("调用 isOk() 之前，必须先调用 ok()、fail() 或者 setOk()、setFail() 方法");
	}
	
	public boolean isFail() {
		Object state = get(STATE);
		if (STATE_FAIL.equals(state)) {
			return true;
		}
		if (STATE_OK.equals(state)) {
			return false;
		}
		throw new IllegalStateException("调用 isFail() 之前，必须先调用 ok()、fail() 或者 setOk()、setFail() 方法");
	}
	
	public Ret set(Object key, Object value) {
		super.put(key, value);
		return this;
	}
	
	public Ret set(Map map) {
		super.putAll(map);
		return this;
	}
	
	public Ret set(Ret ret) {
		super.putAll(ret);
		return this;
	}
	
	public Ret delete(Object key) {
		super.remove(key);
		return this;
	}
	
	public <T> T getAs(Object key) {
		return (T)get(key);
	}
	
	public String getStr(Object key) {
		Object s = get(key);
		return s != null ? s.toString() : null;
	}
	
	public Integer getInt(Object key) {
		Number n = (Number)get(key);
		return n != null ? n.intValue() : null;
	}
	
	public Long getLong(Object key) {
		Number n = (Number)get(key);
		return n != null ? n.longValue() : null;
	}
	
	public Number getNumber(Object key) {
		return (Number)get(key);
	}
	
	public Boolean getBoolean(Object key) {
		return (Boolean)get(key);
	}
	
	/**
	 * key 存在，并且 value 不为 null
	 */
	public boolean notNull(Object key) {
		return get(key) != null;
	}
	
	/**
	 * key 不存在，或者 key 存在但 value 为null
	 */
	public boolean isNull(Object key) {
		return get(key) == null;
	}
	
	/**
	 * key 存在，并且 value 为 true，则返回 true
	 */
	public boolean isTrue(Object key) {
		Object value = get(key);
		return (value instanceof Boolean && ((Boolean)value == true));
	}
	
	/**
	 * key 存在，并且 value 为 false，则返回 true
	 */
	public boolean isFalse(Object key) {
		Object value = get(key);
		return (value instanceof Boolean && ((Boolean)value == false));
	}
	
	public boolean equals(Object ret) {
		return ret instanceof Ret && super.equals(ret);
	}
}
