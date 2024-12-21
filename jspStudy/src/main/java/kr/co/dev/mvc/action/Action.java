package kr.co.dev.mvc.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dev.mvc.control.ActionForward;

public interface Action {
	//추상메서드
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException;

}
