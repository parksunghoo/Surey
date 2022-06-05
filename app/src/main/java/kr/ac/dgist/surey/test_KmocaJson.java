package kr.ac.dgist.surey;

import kr.ac.dgist.surey.controller.KmocaController;

public class test_KmocaJson {

    public static void main(String[] args) {
        System.out.println("[HttpURLConnection 사용해 GET body is json 방식 데이터 요청 및 응답 값 확인]");

        KmocaController jsonkmoa = new KmocaController();

        jsonkmoa.setURL("http://210.104.190.225:42502/jsonto/KmocaJsonTo");
        System.out.println("URL : " + jsonkmoa.getURL());
        String token = "2f48f241-9d64-4d16-bf56-70b9d4e0e79a";

        /**
         * GET_LIST
         * */
        jsonkmoa.drp_get_list(token, jsonkmoa.getURL());

        /**
         * GET_ID
         * */
//        String primary_key = "kim52";
//        jsonkmoa.drp_get(token, jsonkmoa.getURL(), primary_key);

    }

}
