package org.qidian.dto;



/**
 * 返回值
   * 
   * @Project: smartKit-api   
   * @Description: TODO
   * @author 骆峰
   * @date 2018年3月26日 下午2:18:55
 */
public class BaseDto {
	
	/**
	 * 状态吗
	 */
	private Integer code;
	
	/**	返回值  */
	private Object msg;


	public BaseDto(Integer code , Object msg){
		this.code = code;
		this.msg = msg;
	}
	
	public Integer getCode() {
		return code;
	}


	public void setCode(Integer code) {
		this.code = code;
	}


	public Object getMsg() {
		return msg;
	}


	public void setMsg(Object msg) {
		this.msg = msg;
	}
		
}
