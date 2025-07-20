package sa.jinlogbe.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 전체 타임존 관련 유틸
 */
public class DateTimeUtils {
    /**
     * 한국 시간
     */
    public static LocalDateTime now(){
      return ZonedDateTime.now(ZoneId.of("Asia/Seoul")).toLocalDateTime();
    }
}
