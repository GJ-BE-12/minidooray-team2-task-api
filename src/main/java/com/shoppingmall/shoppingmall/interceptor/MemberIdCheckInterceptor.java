package com.shoppingmall.shoppingmall.interceptor;

import com.shoppingmall.shoppingmall.exception.interceptor.MissingHeaderException;
import com.shoppingmall.shoppingmall.exception.interceptor.NotAllowedException;
import com.shoppingmall.shoppingmall.exception.notfound.ProjectNotFoundException;
import com.shoppingmall.shoppingmall.repository.ProjectMemberRepository;
import com.shoppingmall.shoppingmall.repository.ProjectRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Map;

@Component
public class MemberIdCheckInterceptor implements HandlerInterceptor {

    @Autowired
    private ProjectMemberRepository projectMemberRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String memberId = request.getHeader("memberId");

        if (memberId == null) {
            throw new MissingHeaderException("header가 존재하지 않습니다.");
        }

        Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(
                HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE
        );

        if (pathVariables != null && pathVariables.containsKey("projectId")) {
            String projectId = pathVariables.get("projectId");

            System.out.println("추출된 ID: " + projectId);

            if(projectRepository.findById(Long.parseLong(projectId)) == null){
                throw new ProjectNotFoundException(Long.parseLong(projectId));
            }
            else if(projectMemberRepository.existsByProjectIdAndMemberId(Long.parseLong(projectId), Long.parseLong(memberId))){
                return true;
            }
            else {
                throw new NotAllowedException("당신은 해당 프로젝트의 멤버가 아닙니다.");
            }
        }
        return true;
    }
}
