package kr.ac.dgist.surey;

import kr.ac.dgist.surey.controller.MmsekController;

public class test_MmsekJson {

    public static void main(String[] args) {

        System.out.println("[HttpURLConnection 사용해 GET body is json 방식 데이터 요청 및 응답 값 확인]");

        MmsekController mmsekjson = new MmsekController();

        mmsekjson.setURL("http://210.104.190.225:42502/jsonto/MmsekJsonTo");
        System.out.println("URL : " + mmsekjson.getURL());
        String token = "2f48f241-9d64-4d16-bf56-70b9d4e0e79a";

        /**
         * GET_LIST
         * */
//        mmsekjson.drp_get_list(token, mmsekjson.getURL());

        /**
         * GET_ID
         * */
        String primary_key = "testUser";
        mmsekjson.drp_get(token, mmsekjson.getURL(), primary_key);

    }
}
