package kr.co.dev.student.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.dev.student.control.ActionForward;
import kr.co.dev.student.model.StudentDAO;
import kr.co.dev.student.model.StudentVO;

public class ModifyFormAction implements Action {

	@Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        StudentVO svo = new StudentVO();
        svo.setId(id);
        StudentDAO dao = StudentDAO.getInstance();
        svo = dao.selectOneDB(svo);
        request.setAttribute("svo", svo);
        return new ActionForward("/mvcmem/modifyForm.jsp",false);
    }

}
