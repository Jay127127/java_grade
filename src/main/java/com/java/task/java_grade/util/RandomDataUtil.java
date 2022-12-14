package com.java.task.java_grade.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;

public class RandomDataUtil {

    private final static Random random = new Random();
    private final static Calendar cal = Calendar.getInstance();
//    public final static String ALL_KOREAN_LAST_NAME = "김이박최정강조윤장임한오서신권황안송류전홍고문양손배백허유남심지노하곽성차주우구라민진엄채원천방공현함변염여추도소석선설마길연위표명기반왕금옥육인맹제모탁국어은편용예경봉사부가복태목형계피두감음빈동온호범좌팽승간상시갈단견당화창";
    public final static String ALL_KOREAN_LAST_NAME = "김이박최정";
    public final static String ALL_KOREAN_NAMABLE_KOR = "가각간갈감갑강개객갱갹거건걸검겁게격견결겸경계고곡곤골공곶과곽관괄광괘괴괵굉교구국군굴궁권궐궤귀규균귤극근글금급긍기긴길김끽나낙난날남납낭내녀녁년념녑녕노농뇌뇨누눈눌뉴뉵능니닉닐다단달담답당대댁덕도독돈돌동두둔둘득등라락란랄람랍랑래랭"
            +"략량려력련렬렴렵령례로록론롱뢰료룡루류륙륜률륭륵름릉리린림립마막만말망매맥맹멱면멸명몌모목몰몽묘무묵문물미민밀박반발방배백번벌범법벽변별병보복본볼봉부북분불붕비빈빙사삭산살삼삽상새색생서석선설섬섭성세소속손솔송쇄쇠수숙순술숭쉬슬습승시"
            +"식신실심십쌍씨아악안알암압앙애액앵야약양어억언얼엄업에엔여역연열염엽영예오옥온올옹와완왈왕왜외요욕용우욱운울웅원월위유육윤율융은을음읍응의이익인일임입잉자작잔잠잡장재쟁저적전절점접정제조족존졸종좌죄주죽준줄중즉즐즙증지직진질짐집징차착"
            +"찬찰참창채책처척천철첨첩청체초촉촌총촬최추축춘출충췌취측층치칙친칠침칩칭쾌타탁탄탈탐탑탕태택탱터토톤통퇴투퉁특틈파판팔패팽퍅편폄평폐포폭표품풍피픽필핍하학한할함합항해핵행향허헌헐험혁현혈혐협형혜호혹혼홀홍화확환활황회획횡효후훈훌훙훤훼휘휴휼흉흑흔흘흠흡흥희히힐";
    public final static String ALPABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public final static String ALPABET_LOWER = "abcdefghijklmnopqrstuvwxyz";
    public final static String ALPABET = ALPABET_UPPER + ALPABET_LOWER;
    public final static String NUMRIC = "0123456789";
    public final static String ALPABET_NUMRIC = ALPABET + NUMRIC;

    /**
     * 유니코드 내 랜덤 한글 가져오기
     * @param size
     * @return
     * @throws Exception
     */
    public static String randomKoreanUnicode(int size) throws Exception {

        if (size < 1) {
            throw new Exception();
        }

        char[] rtn = new char[size];
        for(int i = 0; i < size; i++) {
            rtn[i] = (char) ((Math.random() * 11172) + 0xAC00);
        }

        return String.valueOf(rtn);

    }

    /**
     * 인명용한자 중 랜덤한글자 가져오기
     * @param size
     * @return
     * @throws Exception
     */
    public static String randomKoreanFirstName(int size) throws Exception {
        return randomChoice(ALL_KOREAN_NAMABLE_KOR, size);
    }

    /**
     * 국내 성씨 목록 중 랜덤한 성 가져오기
     * @param size
     * @return
     * @throws Exception
     */
    public static String randomKoreanLastName(int size) throws Exception {
        return randomChoice(ALL_KOREAN_LAST_NAME, size);
    }


    /**
     * 국내 랜덤한 성과이름 가져오기
     * @return
     * @throws Exception
     */
    public static String randomKoreanFullName() throws Exception {
        return randomKoreanLastName(random.nextInt(2)) + randomKoreanFirstName(random.nextInt(4));
    }

    /**
     * 국내 랜덤한 성과이름 가져오기
     * @return
     * @throws Exception
     */
    public static String randomKoreanFullName(int lastNameSize, int firstNameSize) throws Exception {
        return randomKoreanLastName(lastNameSize) + randomKoreanFirstName(firstNameSize);
    }

    /**
     * 랜덤한 숫자열 가져오기
     * @param size
     * @return
     * @throws Exception
     */
    public static String randomNumric(int size) throws Exception {
        return randomChoice(NUMRIC, size);
    }

    /**
     * 랜덤한 숫자 가져오기
     * @return
     * @throws Exception
     */
    public static int randomNumber() throws Exception {
        return random.nextInt();
    }

    /**
     * 범위 내 랜덤한 숫자 가져오기
     * @param bound
     * @return
     * @throws Exception
     */
    public static int randomNumber(int bound) throws Exception {
        return random.nextInt(bound);
    }

    /**
     * 랜덤한 String형 숫자 가져오기
     * @param bound
     * @return
     * @throws Exception
     */
    public static String randomStringNumber(int bound) throws Exception {
        return String.valueOf(random.nextInt(bound));
    }

    /**
     * 랜덤한 대문자 알파벳 가져오기
     * @param size
     * @return
     * @throws Exception
     */
    public static String randomUpperAlpabet(int size) throws Exception {
        return randomChoice(ALPABET_UPPER, size);
    }

    /**
     * 랜덤한 소문자 알파벳 가져오기
     * @param size
     * @return
     * @throws Exception
     */
    public static String randomLowerAlpabet(int size) throws Exception {
        return randomChoice(ALPABET_LOWER, size);
    }

    /**
     * 랜덤한 대소문자 알파벳 가져오기
     * @param size
     * @return
     * @throws Exception
     */
    public static String randomAlpabet(int size) throws Exception {
        return randomChoice(ALPABET, size);
    }

    /**
     * 랜덤한 대소문자 알파벳와 숫자 가져오기
     * @param size
     * @return
     * @throws Exception
     */
    public static String randomAlpaNumric(int size) throws Exception {
        return randomChoice(ALPABET_NUMRIC, size);
    }

    /**
     * 랜덤한 CI스러운 값 가져오기
     * @param size
     * @return
     * @throws Exception
     */
    public static String randomCi() throws Exception {
        final String CI_ABLE_CHARS = ALPABET_NUMRIC + "^_=+\\/";
        return randomChoice(CI_ABLE_CHARS, 88);
    }

    /**
     * 랜덤한 휴대폰 값 가져오기
     * @param size
     * @return
     * @throws Exception
     */
    public static String randomCellPhone() throws Exception {
        return "010" + randomNumric(8);
    }

    /**
     * 랜덤한 이메일 값 가져오기
     * @param size
     * @return
     * @throws Exception
     */
    public static String randomEmail() throws Exception {
        return randomChoice(ALPABET_NUMRIC, 10) + "@test.com";
    }

    /**
     * 랜덤한 차량번호 가져오기
     * @return
     * @throws Exception
     */
    public static String randomCarNo() throws Exception {
        return randomKoreanUnicode(2) + randomNumric(2) + randomKoreanUnicode(2) + randomNumric(4);
    }

    /**
     * 랜덤한 생년월일 가져오기
     * @param startYear
     * @param endYear
     * @return
     * @throws Exception
     */
    public static String randomBirthday(int startYear, int endYear) throws Exception {

        if (startYear > endYear) {
            throw new Exception();
        }

        int randYear = startYear + randomNumber(endYear - startYear);
        int randMonth = randomNumber(12) + 1;
        cal.set(randYear, randMonth, 1);

        int randDate = randomNumber(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return LocalDate.of(randYear, randMonth, randDate == 0 ? 1 : randDate)
                .format(DateTimeFormatter.BASIC_ISO_DATE);
    }

    /**
     * 가용 인덱스 내에서 랜덤한 값 가져오기
     * @param size
     * @return
     * @throws Exception
     */
    public static String randomChoice(String strIdxs, int size) throws Exception {

        if (size < 1) {
            throw new Exception();
        }

        StringBuilder rtnStr = new StringBuilder();

        int i=0;
        while(i++ < size) {
            int random_idx = random.nextInt(strIdxs.length());
            rtnStr.append(strIdxs.substring(random_idx, random_idx+1));
        }

        return rtnStr.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(randomKoreanFirstName(2));
        System.out.println(randomKoreanLastName(2));
        System.out.println(randomNumric(10));
        System.out.println(randomKoreanUnicode(4));
        System.out.println(randomCellPhone());
        System.out.println(randomCi());
        System.out.println(randomEmail());
        System.out.println(randomBirthday(2000, 2014));
    }
}