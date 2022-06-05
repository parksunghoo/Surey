package kr.ac.dgist.surey;

import kr.ac.dgist.surey.controller.SmcqController;

public class test_SmcqJson {

    public static void main(String[] args) {
        System.out.println("[HttpURLConnection 사용해 GET body is json 방식 데이터 요청 및 응답 값 확인]");

        SmcqController smcqjson = new SmcqController();

        smcqjson.setURL("http://210.104.190.225:42502/jsonto/SmcqJsonTo");
        System.out.println("URL : " + smcqjson.getURL());
        String token = "2f48f241-9d64-4d16-bf56-70b9d4e0e79a";

        /**
         * GET_LIST
         * */
//        smcqjson.drp_get_list(token, smcqjson.getURL());

        /**
         * GET_ID
         * */
        String primary_key = "kim40";
        smcqjson.drp_get(token, smcqjson.getURL(), primary_key);

    }
}
