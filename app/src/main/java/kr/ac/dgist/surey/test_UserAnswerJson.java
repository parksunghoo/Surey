package kr.ac.dgist.surey;

import kr.ac.dgist.surey.controller.UserAnswerController;

public class test_UserAnswerJson {

    public static void main(String[] args) {
        System.out.println("[HttpURLConnection 사용해 GET body is json 방식 데이터 요청 및 응답 값 확인]");

        UserAnswerController userAnswerjson = new UserAnswerController();

        userAnswerjson.setURL("http://210.104.190.225:42502/jsonto/UserAnswerJsonTo");
        System.out.println("URL : " + userAnswerjson.getURL());
        String token = "2f48f241-9d64-4d16-bf56-70b9d4e0e79a";

        /**
         * GET_LIST
         * */
//        userAnswerjson.drp_get_list(token, userAnswerjson.getURL());

        /**
         * GET_ID
         * */
        String primary_key = "csson";
        String survey = "mmsek";
        String seq = "1";
        userAnswerjson.drp_get(token, userAnswerjson.getURL(), primary_key, survey, seq);

    }
}
