package com.whatthefork.communicationandalarm.common.resolver;

import com.whatthefork.communicationandalarm.common.exception.ErrorCode;
import com.whatthefork.communicationandalarm.common.exception.GlobalException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class UserIdArgumentResolver implements HandlerMethodArgumentResolver {

    private static final String USER_ID_HEADER = "X-User-Id";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(UserId.class)
                && parameter.getParameterType().equals(Long.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        String userIdHeader = request.getHeader(USER_ID_HEADER);

        if (userIdHeader == null || userIdHeader.isBlank()) {
            throw new GlobalException(ErrorCode.INVALID_INPUT_VALUE, "X-User-Id 헤더가 필요합니다.");
        }

        try {
            return Long.valueOf(userIdHeader);
        } catch (NumberFormatException e) {
            throw new GlobalException(ErrorCode.INVALID_TYPE_VALUE, "X-User-Id는 숫자여야 합니다.");
        }
    }
}
