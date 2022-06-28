package com.example.teamprojeect.service;

import com.example.teamprojeect.domain.dao.artist.ArtistReplyDAO;
import com.example.teamprojeect.domain.dao.show.ShowReplyDAO;
import com.example.teamprojeect.domain.dao.user.LikeDAO;
import com.example.teamprojeect.domain.dao.user.UserDAO;
import com.example.teamprojeect.domain.dao.user.UserFileDAO;
import com.example.teamprojeect.domain.vo.artist.ArtistReplyVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.list.UserListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.show.ShowReplyVO;
import com.example.teamprojeect.domain.vo.user.LikeVO;
import com.example.teamprojeect.domain.vo.user.UserFileVO;
import com.example.teamprojeect.domain.vo.user.UserVO;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.ContinueResponseTiming;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDAO userDAO;
    private final UserFileDAO userFileDAO;
    private final LikeDAO likeDAO;
    private final ShowReplyDAO showReplyDAO;
    private final ArtistReplyDAO artistReplyDAO;

    // 마이페이지 : 유저 정보 조회
    public UserVO read(Long userNumber){return userDAO.read(userNumber);}

    // 마이페이지 : 유저 정보 수정
    public boolean modify(UserVO userVO){
        return userDAO.modify(userVO);
    }

    // 마이페이지 : 비밀번호 수정
    public boolean modifyPw(Long userNumber, String password){
        return userDAO.modifyPw(userNumber, password);
    }

    // 마이페이지 : 회원탈퇴
    public boolean remove(Long userNumber){
        return userDAO.remove(userNumber);
    }

    // 마이페이지 : 내가 남긴 댓글 - 아티스트
    public List<ArtistReplyVO> getUserReplyList(Criteria criteria, Long userNumber) {return artistReplyDAO.getUserReplyList(criteria, userNumber);}

    // 마이페이지 : 내가 남긴 댓글 - 쇼
    public List<ShowReplyVO> getUserShowReply(Criteria criteria, Long userNumber) { return showReplyDAO.getUserShowReply(criteria, userNumber);}

    // 마이페이지 : 내가 남긴 댓글 수 - 아티스트
    public int getTotalUserReply(Long userNumber) {return artistReplyDAO.getTotalUserReply(userNumber);}

    // 마이페이지 : 내가 남긴 댓글 수 - 쇼
    public int getTotalUserShowReply(Long userNumber) {return showReplyDAO.getTotalUserShowREply(userNumber); }
    // 로그인
    public Long login(String userId, String userPw) {return userDAO.login(userId,userPw);}

    // 좋아요 등록 (아티스트)
    public void registerArtistLike(LikeVO likeVO) {likeDAO.registerArtistLike(likeVO);}

    // 좋아요 등록 (작품)
    public void registerWorkLike(LikeVO likeVO) {likeDAO.registerWorkLike(likeVO);}

    // 좋아요 취소
    public boolean removeLike(Long userNumber, ListDTO listDTO, Long number) { return likeDAO.removeLike(userNumber, listDTO, number); }

    // 좋아요 아티스트 목록
    public List<LikeVO> getLikeArtistList(Criteria criteria, Long userNumber, ListDTO listDTO) { return likeDAO.getLikeArtistList(criteria, userNumber, listDTO); }

    // 좋아요 작품 목록
    public List<LikeVO> getLikeWorkList(Criteria criteria, Long userNumber) { return likeDAO.getLikeWorkList(criteria, userNumber); }

    // 좋아요한 아티스트 수
    public int getTotalArtist(Long userNumber, ListDTO listDTO) { return likeDAO.getTotalArtist(userNumber, listDTO); }

    // 좋아요한 작품 수
    public int getTotalWork(Long userNumber) { return likeDAO.getTotalWork(userNumber); }

    //회원가입
    public void join(UserVO userVO) {userDAO.join(userVO);}

    public List<UserVO> getUserList(Criteria criteria, boolean isArtist) {
        return userDAO.getUserList(criteria, isArtist);
    }

    // 카카오 회원가입
    public void kakaoJoin(UserVO userVO) { userDAO.kakaoJoin(userVO);}

    // 카카오 로그인
    public Long kakaoLogin(String userId) { return userDAO.kakaoLogin(userId);}

    //아이디 중복확인
    public String searchId(String userId) { return  userDAO.searchId(userId);}

    // 총 유저 수
    public int getTotal() {
        return userDAO.getTotal();
    }

    // 아티스트로 등록한 유저 수
    public int getArtistTotal() {
        return userDAO.getArtistotal();
    }

    // 총 검색 결과 개수
    public int getSearchTotal(Criteria criteria) {
        return userDAO.getSearchTotal(criteria);
    }

    public UserVO find(String text) {
        return userDAO.find(text);
    }

    // ID, PW 찾기
    public Long findCount(String text) {
        return userDAO.findCount(text);
    }

    public Long findPwCount(UserVO userVO) { return userDAO.findPwCount(userVO); };


    public String getKaKaoAccessToken(String code){
        String access_Token="";
        String refresh_Token ="";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try{
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //POST 요청을 위해 기본값이 false인 setDoOutput을 true로
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=9ac138945c16d418c246d1af4dc646a8"); // TODO REST_API_KEY 입력
            sb.append("&redirect_uri=http://localhost:10007/user/kakaoLogin"); // TODO 인가코드 받은 redirect_uri 입력
            sb.append("&code=" + code);
            bw.write(sb.toString());
            bw.flush();

            //결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            log.info("responseCode : " + responseCode);
            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            log.info("response body : " + result);

            //Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

            log.info("access_token : " + access_Token);
            log.info("refresh_token : " + refresh_Token);

            br.close();
            bw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

        return access_Token;
    }

    public void getKakaoInfo(String token) throws Exception {

        String reqURL = "https://kapi.kakao.com/v2/user/me";

        //access_token을 이용하여 사용자 정보 조회
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization", "Bearer " + token); //전송할 header 작성, access_token전송

            //결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            log.info("responseCode : " + responseCode);

            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            log.info("response body : " + result);

            //Gson 라이브러리로 JSON파싱
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            int id = element.getAsJsonObject().get("id").getAsInt();
            boolean hasEmail = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("has_email").getAsBoolean();
            String email = "";
            if(hasEmail){
                email = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("email").getAsString();
            }

            log.info("id : " + id);
            log.info("email : " + email);

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logoutKakao(String token){
        String reqURL ="https://kapi.kakao.com/v1/user/logout";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");

            conn.setRequestProperty("Authorization", "Bearer " + token);
            int responseCode = conn.getResponseCode();
            log.info("responseCode : " + responseCode);

            if(responseCode ==400)
                throw new RuntimeException("카카오 로그아웃 도중 오류 발생");

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String br_line = "";
            String result = "";
            while ((br_line = br.readLine()) != null) {
                result += br_line;
            }
            log.info("결과");
            log.info(result);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
