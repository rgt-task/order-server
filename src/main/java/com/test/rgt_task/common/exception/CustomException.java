package com.test.rgt_task.common.exception;

import com.test.rgt_task.common.enums.ReturnCode;

public class CustomException extends RuntimeException {
	private ReturnCode returnCode;
	private String returnMessage;
	public CustomException(ReturnCode returnCode) {
		super(returnCode.getReturnMessage());
		this.returnCode = returnCode;
		this.returnMessage = returnCode.getReturnMessage();
	}
}



