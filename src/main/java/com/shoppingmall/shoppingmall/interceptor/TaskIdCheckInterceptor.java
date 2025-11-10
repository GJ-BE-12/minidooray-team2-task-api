package com.shoppingmall.shoppingmall.interceptor;

import com.shoppingmall.shoppingmall.exception.notfound.TaskNotFoundException;
import com.shoppingmall.shoppingmall.repository.TaskRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Map;

@Component
public class TaskIdCheckInterceptor implements HandlerInterceptor {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(
                HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE
        );

        if (pathVariables != null && pathVariables.containsKey("taskId")) {
            String taskId = pathVariables.get("taskId");

            System.out.println("추출된 ID: " + taskId);


            if(taskRepository.findById(Long.parseLong(taskId)) == null){
                throw new TaskNotFoundException(Long.parseLong(taskId));
            }
        }
        return true;
    }
}
