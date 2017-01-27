package by.bsuir.movierating.command.impl.comment;

import by.bsuir.movierating.service.factory.ServiceFactory;
import by.bsuir.movierating.service.CommentService;
import by.bsuir.movierating.command.Command;
import by.bsuir.movierating.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Services the request to deleting the comment.
 *
 * @author Kostevich Vladislav
 * @version 1.0
 */
public class DeleteCommentCommand implements Command {
    private static final int SERVER_ERROR = 500;

    private static final String USER_ID_SESSION_ATTRIBUTE = "userId";

    private static final String SESSION_TIMEOUT_PAGE = "/Controller?command=login&cause=timeout";
    private static final String WELCOME_PAGE = "/Controller?command=welcome";
    private static final String SUCCESS_REDIRECT_PAGE = "/Controller?command=user&id=";

    private static final String REQUEST_ID_PARAM = "id";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter(REQUEST_ID_PARAM);
        int id = (idStr == null) ? -1 : Integer.parseInt(idStr);

        if(id == -1){
            response.sendRedirect(WELCOME_PAGE);
            return;
        }

        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            CommentService commentService = serviceFactory.getCommentService();
            commentService.deleteComment(id);

            HttpSession session = request.getSession(false);
            if(session == null){
                response.sendRedirect(SESSION_TIMEOUT_PAGE);
            }
            else {
                Integer userId = (Integer) session.getAttribute(USER_ID_SESSION_ATTRIBUTE);
                if(userId == null){
                    response.sendRedirect(WELCOME_PAGE);
                }
                else {
                    response.sendRedirect(SUCCESS_REDIRECT_PAGE + userId);
                }
            }
        } catch (ServiceException e) {
            response.sendError(SERVER_ERROR);
        }
    }
}
