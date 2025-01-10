package com.test.rgt_task.common.dto;

import static com.test.rgt_task.common.enums.ReturnCode.*;
import com.test.rgt_task.common.enums.ReturnCode;
import lombok.Getter;


@Getter
public class ApiResponse<T> {

	private String returnCode;
	private String returnMessage;
	private T data;

	public static <T> ApiResponse of(T data) {
		ApiResponse<T> response = new ApiResponse<>();
		response.returnCode = SUCCESS.getReturnCode();
		response.returnMessage = SUCCESS.getReturnMessage();
		response.data = data;

		return response;
	}

	public static <T> ApiResponse of(ReturnCode returnCode) {
		ApiResponse<T> response = new ApiResponse<>();
		response.returnCode = returnCode.getReturnCode();
		response.returnMessage = returnCode.getReturnMessage();

		return response;
	}

}
