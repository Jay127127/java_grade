package com.java.task.java_grade.util;

import lombok.Getter;

@Getter
public enum POMErrorCode {


    P_200(200, "[POM] Success"),

    //=======================================
    //  인증 관련 에러 1000 ~ 1999
    //=======================================
    P_1000(1000, "[POM] Authentication Header Error"),
    P_1001(1001, "[POM] License Error"),
    P_1002(1002, "[POM] License Not Found"),
    P_1003(1003, "[POM] Authentication Expired"),
    P_1004(1004, "[POM] Authentication Parse Error"),
    P_1005(1005, "[POM] Authentication Validation Error"),
    P_1050(1050, "[POM] Authentication Unkown Error"),


    //=======================================
    //  JSON,Mapping 관련 에러 2000 ~ 2999
    //=======================================
    P_2000(2000, "[POM] Param Mapping Error"),
    P_2001(2001, "[POM] Json Parse Error"),
    P_2002(2002, "[POM] Json Mapping Error"),
    P_2003(2003, "[POM] Json Parameter Error"),

    //=======================================
    //  사용자 관련 에러 3000 ~ 3999
    //=======================================
    P_3000(3000, "[POM] User Not Found"),


    //=======================================
    //  DB 관련 에러 4000 ~ 4999
    //=======================================
    P_4000(4000, "[POM] DB Error"),
    P_4001(4001, "[POM] DB No Data"),
    P_4002(4002, "[POM] DB DuplicateKey"),
    P_4003(4003, "[POM] DB Update Error"),
    P_4004(4004, "[POM] DB Insert Error"),
    P_4005(4005, "[POM] DB Delete Error"),
    P_4006(4006, "[POM] DB VA Preset XML No Data"),
    //=======================================
    //  서버,기타 관련 에러 5000 ~ 5999
    //=======================================
    P_5000(5000, "[POM] Internel Exception Error"),
    P_5001(5001, "[POM] Spring Bind Error"),
    P_5002(5002, "[POM] Unknwon Group Type"),
    P_5003(5003, "[POM] Page Error"),

    P_5004(5004, "[POM] Server Not Found"),
    P_5005(5005, "[POM] EDS websocket find error"),
    P_5007(5007, "[POM] CameraGroup Not Found"),

    P_5009(5009, "[POM] Service Register Error"),
    P_5010(5010, "[POM] Service Update Error"),
    P_5011(5011, "[POM] Service Delete Error"),
    P_5012(5012, "[POM] Service Execution Error"),

    P_5013(5013, "[POM] Service Running"),
    P_5014(5014, "[POM] Service Server Assign Duplicate"),
    P_5015(5015, "[POM] Service CameraGroup Assign Duplicate"),

    P_5016(5016, "[POM] Service Server Assign Error"),
    P_5017(5017, "[POM] Service CameraGroup Assign Error"),

    P_5020(5020, "[POM] Service Execution Error"),

    P_5021(5021, "[POM] Service Control Scenario Not Found"),
    P_5022(5022, "[POM] Service Control Scenario Register Error"),
    P_5023(5023, "[POM] Service Control Scenario Update Error"),
    P_5024(5024, "[POM] Service Control Scenario Delete Error"),
    P_5025(5025, "[POM] Service Control Scenario User Assign Error"),

    P_5026(5026, "[POM] Service Not Found"),
    P_5027(5027, "[POM] Camera Not Found"),

    P_5030(5030, "[POM] IoT Device Name Duplicate"),

    P_5040(5040, "[POM] PresetGroup Name Duplicate"),
    P_5041(5041, "[POM] Preset Name Duplicate"),

    P_5042(5042, "[POM] Not Support Event"),

    P_6000(6000, "[POM] Unknown error"),

    //=======================================
    //  DM 연동 관련 에러 7000 ~ 7099
    //=======================================
    P_7000(7000, "[POM] DM Interface Success"),
    P_7001(7001, "[POM] DM Interface Error"),
    P_7002(7002, "[POM] %s PTZ Running "),
    P_7003(7003, "[POM] PTZ Camera Not Found"),
    P_7004(7004, "[POM] PTZ WebSocket Connection Error"),
    P_7005(7005, "[POM] There are already connected users"),
    P_7006(7006, "[POM] CLIENT-TYPE Bad Request Header(VA-00, PV, POM_WEB"),

    //=======================================
    //  NVR 연동 관련 에러 7100 ~ 7199
    //=======================================
    P_7100(7100, "[POM] NVR Interface Success"),
    P_7101(7101, "[POM] NVR Interface Error"),

    //=======================================
    //  VA 연동 관련 에러 7200 ~ 7299
    //=======================================
    P_7200(7200, "[POM] VA Analysis Settings Not Found"),
    P_7201(7201, "[POM] VA Touring Preset Not Found"),

    P_7204(7204, "[POM] VA Invalid Data"),



    P_8000(8000, "[POM] Custom Error"),
    P_8001(8001, "[POM] Service Camera Assign Error"),

    //=======================================
    //  DM , NVR , EDS , VA 서버 에러
    //=======================================
    P_8100(8100, "[POM] VA Server Error"),
    P_8101(8101, "[POM] NVR Server Error"),
    P_8102(8102, "[POM] DM Server Error");

    final int _code;
    final String _message;

    POMErrorCode(int code, String message) {
        _code = code;
        _message = message;
    }
}
