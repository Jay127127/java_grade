package com.java.task.java_grade.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.annotation.Generated;
import java.time.LocalDateTime;

@Data
public class ResponseVO {

    private Integer code;
    private String message;
    private String exceptionMessage;
    private String serverType;
    private String serverVersion;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    @JsonFormat(pattern = Define.POM_DATE_FORMAT_MSEC, timezone = Define.POM_DATE_TIME_ZONE)
    private LocalDateTime serverTime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object result;

    public ResponseVO() {
        this.code       = POMErrorCode.P_6000.get_code();
        this.message    = POMErrorCode.P_6000.get_message();

        this.serverTime = LocalDateTime.now();
    }

    public void _setPOMErrorCode(POMErrorCode code){
        this.code = code.get_code();
        this.message = code.get_message();
    }

    public void _setPOMErrorCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public String _toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }
}

