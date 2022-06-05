package kr.ac.dgist.surey;

import kr.ac.dgist.surey.controller.UserAnswerController;

public class test_UserAnswerXML {

    public static void main(String[] args) {
        System.out.println("[HttpURLConnection 사용해 GET body is json 방식 데이터 요청 및 응답 값 확인]");

        UserAnswerController useranswerxml = new UserAnswerController();

        useranswerxml.setURL("http://210.104.190.225:42502/xmlto/UserAnswerXmlTo");
        System.out.println("URL : " + useranswerxml.getURL());
        String token = "2f48f241-9d64-4d16-bf56-70b9d4e0e79a";

        /**
         * GET_LIST
         * */
//        useranswerxml.xml_drp_get_list(token, useranswerxml.getURL());

        /**
         * GET_ID
         * */
        String primary_key = "kim52";
        String survey = "mmsek";
        String seq = "3";
        useranswerxml.xml_drp_get(token, useranswerxml.getURL(), primary_key, survey, seq);
    }
}
