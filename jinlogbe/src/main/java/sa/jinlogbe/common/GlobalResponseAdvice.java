package sa.jinlogbe.common;

import org.springframework.core.MethodParameter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import sa.jinlogbe.model.ResponseBodyDto;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Order(Ordered.LOWEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice<Object> {

    private final List<Class<?>> notAllowedFilter = Arrays.asList(
            ResponseBodyDto.object.class,
            ResponseBodyDto.collection.class,
            ResponseEntity.class,
            Resource.class
    );

    private final Predicate<Class<?>> isNeedToMapping = target -> !notAllowedFilter.contains(target);
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        final Optional<Method> methodOptional = Optional.ofNullable(returnType.getMethod());
        return methodOptional.isPresent() ? isNeedToMapping.test(methodOptional.get().getReturnType()) : false;
    }

    @Override
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return GlobalResponsePolicyEnum
                .getFilter()
                .stream()
                .filter(policy -> policy.check(body))
                .findFirst()
                .orElseGet(() -> GlobalResponsePolicyEnum.IS_OBJECT)
                .returnModel(body);
    }
}
