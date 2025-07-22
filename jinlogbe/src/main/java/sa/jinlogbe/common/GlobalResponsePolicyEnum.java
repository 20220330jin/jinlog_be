package sa.jinlogbe.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sa.jinlogbe.model.ResponseBodyDto;

import java.util.*;
import java.util.function.Predicate;

@Getter
@AllArgsConstructor
public enum GlobalResponsePolicyEnum {
    IS_VOID(target -> target == null) {
        @Override
        public ResponseBodyDto.basic returnModel(Object target) {
            return new ResponseBodyDto.object<>(target);
        }
    },
    IS_COLLECTION(target -> target instanceof Collection<?>) {
        @Override
        public ResponseBodyDto.basic returnModel(Object target) {
            return new ResponseBodyDto.collection<>((Collection<?>) target);
        }
    },
    IS_PRIMITIVE(target -> isPrimitiveType(target)) {
        @Override
        public ResponseBodyDto.basic returnModel(Object target) {
            return new ResponseBodyDto.primitive<>(target);
        }
    },

    IS_OBJECT(target -> true){
        @Override
        public ResponseBodyDto.basic returnModel(Object target) {
            return new ResponseBodyDto.object<>(target);
        }
    };

    private Predicate<Object> predicate;

    public abstract ResponseBodyDto.basic returnModel(Object target);

    private static final Map<Class<?>, Class<?>> WRAPPER_TYPE_MAP;
    static {
        WRAPPER_TYPE_MAP = new HashMap<Class<?>, Class<?>>(16);
        WRAPPER_TYPE_MAP.put(Integer.class, int.class);
        WRAPPER_TYPE_MAP.put(Byte.class, byte.class);
        WRAPPER_TYPE_MAP.put(Character.class, char.class);
        WRAPPER_TYPE_MAP.put(Boolean.class, boolean.class);
        WRAPPER_TYPE_MAP.put(Double.class, double.class);
        WRAPPER_TYPE_MAP.put(Float.class, float.class);
        WRAPPER_TYPE_MAP.put(Long.class, long.class);
        WRAPPER_TYPE_MAP.put(Short.class, short.class);
        WRAPPER_TYPE_MAP.put(Void.class, void.class);
    }

    public static List<GlobalResponsePolicyEnum> getFilter() {
        return Arrays.asList(GlobalResponsePolicyEnum.values());
    }

    public static boolean isPrimitiveType(Object source) {
        return WRAPPER_TYPE_MAP.containsKey(source.getClass());
    }

    public boolean check(Object body) {
        return this.predicate.test(body);
    }
}

