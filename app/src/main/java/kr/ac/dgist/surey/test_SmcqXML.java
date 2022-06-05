package kr.ac.dgist.surey;

import kr.ac.dgist.surey.controller.SmcqController;

public class test_SmcqXML {

    public static void main(String[] args) {
        System.out.println("[HttpURLConnection 사용해 GET body is json 방식 데이터 요청 및 응답 값 확인]");

        SmcqController smcqxml = new SmcqController();

        smcqxml.setURL("http://210.104.190.225:42502/xmlto/SmcqXmlTo");
        System.out.println("URL : " + smcqxml.getURL());
        String token = "2f48f241-9d64-4d16-bf56-70b9d4e0e79a";

        /**
         * GET_LIST
         * */
//        smcqxml.xml_drp_get_list(token, smcqxml.getURL());

        /**
         * GET_ID
         * */
        String primary_key = "csson";
        smcqxml.xml_drp_get(token, smcqxml.getURL(), primary_key);
    }
}
