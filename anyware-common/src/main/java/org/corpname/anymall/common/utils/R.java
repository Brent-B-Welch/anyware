package org.corpname.anymall.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Result Data
 *
 * @Author: Beiji Ma beiji.ma@outlook.com
 */
public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public R setData(Object data) {
		put("data",data);
		return this;
	}

	// Deserilise by fastjson
	public <T> T getData(TypeReference<T> typeReference) {
		Object data = get("data");	// default type is Map
		String jsonString = JSON.toJSONString(data);
		T t = JSON.parseObject(jsonString, typeReference);
		return t;
	}

	// Serialize by fastjson
	public <T> T getData(String key,TypeReference<T> typeReference) {
		Object data = get(key);	// default type is Map
		String jsonString = JSON.toJSONString(data);
		T t = JSON.parseObject(jsonString, typeReference);
		return t;
	}	
	public R() {
		put("code", 0);
		put("msg", "success");
	}
	
	public static R error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "UNKNOW exception, please contact Administrator");
	}
	
	public static R error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
	
	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}
	
	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}
	
	public static R ok() {
		return new R();
	}

	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}

	public Integer getCode() {

		return (Integer) this.get("code");
	}
}
