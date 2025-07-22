package sa.jinlogbe.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sa.jinlogbe.common.ExceptionDetailCode;
import sa.jinlogbe.common.ExceptionTypeCode;

import java.util.*;

public class ResponseBodyDto {

    @Getter
    @Setter
    @NoArgsConstructor
    public abstract static class basic {
        protected String bizStatusCode =
                new StringBuilder(ExceptionTypeCode.SUCCESS.getCode())
                        .append(ExceptionDetailCode.SUCCESS_DEFAULT.getCode())
                        .toString();
        protected String bizStatusMessage = ExceptionDetailCode.SUCCESS_DEFAULT.getMessage();
        public basic(Object data){

        }
    }

    @Getter
    @NoArgsConstructor
    public static class object<T> extends basic {
        private T results;

        public object(T data){
            super(data);
            this.results = data;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class collection<T> extends basic {
        private List<T> results = new ArrayList<>();

        public collection(Collection<T> data){
            super(data);
            this.results = new ArrayList<>(data);
        }
    }

    @Getter
    @NoArgsConstructor
    public static class primitive<T> extends basic {
        private Map<String, T> results = new HashMap<String, T>();

        public primitive(T data) {
            super(data);
            this.results.put("successCount", data);
        }

    }
}
