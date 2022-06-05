package kr.ac.dgist.surey;

import kr.ac.dgist.surey.controller.KmocaController;

public class test_KmocaXML {

    public static void main(String[] args) {
        System.out.println("[HttpURLConnection 사용해 GET body is XML 방식 데이터 요청 및 응답 값 확인]");

        KmocaController kmocaxml = new KmocaController();

        kmocaxml.setURL("http://210.104.190.225:42502/xmlto/KmocaXmlTo");
        System.out.println("URL : " + kmocaxml.getURL());
        String token = "2f48f241-9d64-4d16-bf56-70b9d4e0e79a";

        /**
         * GET_LIST
         * */
//        kmocaxml.xml_drp_get_list(token, kmocaxml.getURL());

        /**
         * GET_ID
         * */
        String primary_key = "kim51";
        kmocaxml.xml_drp_get(token, kmocaxml.getURL(), primary_key);
    }
}
