/**
 * 
 */
package com.clschina.common.sms;

/**
 * 短信调用的结果
 * 
 * @author Wu Xiao Fei
 * 
 */
public class SMSResult {

	public static SMSResult createSuccessResult() {
		SMSResult result = new SMSResult();
		result.setCode(CODE_SUCCESS);
		return result;
	}
	public static SMSResult createFailtrueResult(String msg) {
		return createFailtrueResult(msg, null);
	}
	public static SMSResult createFailtrueResult(String msg, Exception e) {
		SMSResult result = new SMSResult();
		result.setCode(CODE_FAILTRUE);
		result.setMessage(msg);
		result.setException(e);
		return result;
	}

	public static final int CODE_SUCCESS = 0;// 成功
	public static final int CODE_FAILTRUE = 1;// 失败
	public static final int CODE_NO_RESULT = -1;// 表示没有结果

	private int code = CODE_NO_RESULT;// 返回代码,必须要有返回值
	private String message;// 中文说明
	private Exception exception;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return CODE_SUCCESS == code;
	}

	public boolean isNotSuccess() {
		// 不成功，不一定是失败
		return CODE_SUCCESS != code;
	}
	
	public Exception getException(){
		return exception;
	}
	public void setException(Exception e){
		this.exception = e;
	}
	
	public String toString(){
		return this.getClass().getName() + " [code=" + this.code + "]; [message=" + this.message +
				"] [exception=" + (exception == null ? "null" : exception.getMessage()) + "]";
	}
}
